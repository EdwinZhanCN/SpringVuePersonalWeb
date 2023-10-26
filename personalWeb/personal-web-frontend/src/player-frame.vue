<script>
import {ref} from "vue";
import {Document, Location, Setting} from "@element-plus/icons-vue";
import Dock from "@/components/dock.vue";
import {get} from "@/net";

export default {
  name:"player-frame",
  components: {Dock, Setting, Document, Location},
  setup(){
    const customColor = ref("background: gray")
    const magicNumber = ref(0);
    const activeIndex = ref(0);
    const songInfo = ref([{}]);//artist:"", genre:"", title:"", url:"", lrc: ""
    const currentSongLyric = ref([{time:"0", lyric:"请欣赏"}]);
    const audioRef = ref(null);

    function timestampToMilliseconds(timestamp) {
      const pattern1 = /(\d{2}):(\d{2})\.(\d{3})/;  // [00:00.000]
      const pattern2 = /(\d{2}):(\d{2})\.(\d{2})/;  // [00:00.00]
      const pattern3 = /(\d{2}):(\d{2})/;           // [00:00]

      let result;

      if ((result = pattern1.exec(timestamp))) {
        return Number(result[1]) * 60 * 1000 + Number(result[2]) * 1000 + Number(result[3]);
      } else if ((result = pattern2.exec(timestamp))) {
        return Number(result[1]) * 60 * 1000 + Number(result[2]) * 1000 + Number(result[3]) * 10;
      } else if ((result = pattern3.exec(timestamp))) {
        return Number(result[1]) * 60 * 1000 + Number(result[2]) * 1000;
      } else {
        console.log("时间戳解析失败！");  // 修正了 console 的调用，添加了 log 方法
        return -1;  // 无法匹配的时间戳格式
      }
    }

    function processLyrics(lyrics) {
      const lines = lyrics.split('\n');
      for (let line of lines) {
        const pattern = /\[(\d{2}:\d{2}(?:\.\d{2,3})?)\](.+)/;  // 更新了正则表达式以匹配新的时间戳格式
        const match = pattern.exec(line);
        if (match && match[1] && match[2]) {  // 更新了数组索引以匹配新的正则表达式
          const time = timestampToMilliseconds(match[1]);
          const lyric = match[2].trim();  // 更新了数组索引以匹配新的正则表达式
          if (time !== -1) {
            currentSongLyric.value.push({
              time,
              lyric,
            });
          }
        }
      }
    }



    const fetchSongs = (callback) => {
      get('/api/songs/get',
          (message) => {  // success回调
            songInfo.value = message.map(song => ({  // 假设message直接返回歌曲数组
              artist: song.artist,
              genre: song.genre,
              title: song.title,
              url: song.blobUrl,
              lrc: song.lrcUrl
            }));
            if (callback) callback();
          },
          (errorMessage, status) => {  // failure回调
            console.error(`Error with status ${status}: ${errorMessage}`);
          },
          (error) => {  // axios catch回调
            console.error('Axios error:', error);
          }
      );
    }



    const fetchLyrics = async (url) => {
      try {
        const response = await fetch(url);
        if (response.ok) {
          const text = await response.text();
          console.log("success")
          processLyrics(text)
        } else {
          console.error('Failed to fetch lyrics:', response.statusText);
        }
      } catch (error) {
        console.error('Error fetching lyrics:', error);
      }
    };

    fetchSongs(() => {
      console.log(songInfo.value[0])
      fetchLyrics(songInfo.value[0].lrc)
    });

    const scrollLyrics = () => {
      magicNumber.value--;
      activeIndex.value++;
    };

    const togglePlay = () => {
      const video = audioRef.value;
      if (video.paused) {
        video.play();
      } else {
        video.pause();
      }
    }

    return {
      customColor,
      activeIndex,
      magicNumber,
      currentSongLyric,
      scrollLyrics,
      songInfo,
      togglePlay,
      audioRef
    }
  }
}

</script>

<template>
  <video v-if = "songInfo.length > 0"
         preload="auto"
         hidden="hidden"
         autoplay
         :src = songInfo[0].url
          >
  </video>
  <div class="background" :style= customColor>
    <div class="player-background">
      <div class = "interface-manager">
        <el-menu
            default-active="2"
            class="menu-wrapper"
        >
          <el-menu-item class="el-menu-item" index="1">
            <svg viewBox="0 0 38 48" focusable="false">
              <path fill-rule="evenodd" d="M36.15 0c-.18.02-1.76.3-1.95.33l-19.7 3.7c-.58.13-1.03.32-1.37.6a2.1 2.1 0 0 0-.74 1.36c-.02.12-.05.36-.05.72v26.81c0 1.18-.9 2.16-2.1 2.38l-5.27.86A6 6 0 0 0 0 42.57C0 45.63 2.6 48 5.64 48c.37 0 .74-.04 1.11-.1l1.82-.36a7.13 7.13 0 0 0 5.8-7.08V17.25c0-1.22.4-1.54 1.42-1.78 0 0 17.52-3.52 18.37-3.68.22-.04.43-.07.61-.07.78 0 1.17.4 1.17 1.36v15.47c0 1.18-.89 2.16-2.1 2.39l-4.86.95c-3.1.55-5.35 2.97-5.35 5.77 0 3.04 2.8 5.4 6.08 5.4.4 0 .8-.03 1.2-.1l1.96-.35c4.23-1.2 5.13-5.07 5.13-7.75v-33C38 .74 37.41 0 36.36 0h-.2z"/>
            </svg>
            <span>Favorites</span>
          </el-menu-item>
          <el-menu-item class="el-menu-item" index="2">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 64 64" focusable="false">
              <path d="M61.576 45.838V7.155C61.613 4.25 59.663 2.3 56.715 2.3l-38.723.083c-2.777.042-4.727 2.117-4.727 4.525 0 2.45 2.117 4.44 4.607 4.44h12.576l17.017-.663-7.222 6.39-35.568 35.61c-.955.955-1.495 2.16-1.495 3.28 0 2.45 2.2 4.69 4.69 4.69 1.203 0 2.325-.457 3.32-1.452l35.568-35.57 6.432-7.263-.665 16.31v13.283c-.04 2.49 1.993 4.65 4.483 4.65 2.45 0 4.482-2.075 4.565-4.775h.003z"></path>
            </svg>
            <span>Get the music</span>
          </el-menu-item>
          <el-menu-item class="el-menu-item" index="3">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 28 28" focusable="false">
              <path fill-rule="evenodd" d="M8 16a2 2 0 1 1 0-4 2 2 0 0 1 0 4zm6 0a2 2 0 1 1 0-4 2 2 0 0 1 0 4zm6 0a2 2 0 1 1 0-4 2 2 0 0 1 0 4z"/>
            </svg>
            <span>About</span>
          </el-menu-item>
          <dock/>
        </el-menu>
        <div class="player-main">
          <div class="top">
            <div class="album-cover-view">
              <div class="album-cover-view-header">
                <div class="rating">
                  <font-awesome-icon :icon="['fas', 'star']" />
                  <font-awesome-icon :icon="['fas', 'star']" />
                  <font-awesome-icon :icon="['fas', 'star']" />
                  <font-awesome-icon :icon="['fas', 'star-half-stroke']" />
                  <font-awesome-icon :icon="['far', 'star']" />
                </div>
                <button @click = scrollLyrics()> 滚动</button>
                <font-awesome-icon icon="comments" style="width: 30px; height: 30px;"/>
              </div>
              <div class="album-cover">
              </div>
            </div>
            <div class="lyrics">
              <div class="scroll-view">
                <p v-for="(lyric, index) in currentSongLyric" :key="index"
                   :class="{ 'active': index === activeIndex, 'blur': index < activeIndex, 'blur': index > activeIndex}"
                   :style="{ '--i': index,
                    '--active-index': activeIndex,
                    top: (index + magicNumber) * 4 + 'em'}">
                  {{ lyric.lyric }}
                </p>
              </div>
            </div>
          </div>
          <div class="bottom">
            <font-awesome-icon icon="shuffle" style="color: #000000; width: 30px; height: 30px;" />
            <div style="display:flex; justify-content: center; width: 30%">
              <font-awesome-icon :icon="['fas', 'backward']" style="color: #000000; padding: 10px 0 10px 0; width: 30px; height: 30px; cursor: pointer" />
              <svg viewBox="0 0 32 28" xmlns="http://www.w3.org/2000/svg">
                <path d="M10.345 23.287c.415 0 .763-.15 1.22-.407l12.742-7.404c.838-.481 1.178-.855 1.178-1.46 0-.599-.34-.972-1.178-1.462L11.565 5.158c-.457-.265-.805-.407-1.22-.407-.789 0-1.345.606-1.345 1.57V21.71c0 .971.556 1.577 1.345 1.577z" fill-rule="nonzero"/></svg>
              <font-awesome-icon icon="forward" style="color: #000000; padding: 10px 0 10px 0;width: 30px; height: 30px; cursor: pointer" />
            </div>
            <font-awesome-icon icon="repeat" style="color: #000000; width: 30px; height: 30px;" />
          </div>
        </div>
      </div>

    </div>
  </div>

</template>

<style scoped>
.background{
  height: 100vh;
  width: 100vw;
  align-items: center;
  display: flex;
  justify-content: space-around;
}
.player-background{
  width: 80vw;
  height: 80vh;
  max-height: 900px;
  max-width: 1600px;
  min-width: 970px;
  background: rgba(255, 255, 255, 0.2);
  -webkit-backdrop-filter: blur(8px);
  backdrop-filter: blur(8px);
  box-shadow:inset 0 0 6px rgba(255, 255, 255, 0.2);
  border-bottom-left-radius: 20px;
  border-top-left-radius: 20px;
}
.interface-manager{
  height: 100%;
  display: grid;
  grid-template-columns: 3fr 8fr;
}
.menu-wrapper{
  border-bottom-left-radius: 20px;
  border-top-left-radius: 20px;
  height: 100%;
}

svg{
  width:15px;
  height:15px;
}
.el-menu-item {
  font-size: 16px;
  gap: 10px;
  display: flex;
  border-radius: 20px;
  font-family: Futura,sans-serif;
}

.player-main{
  display: block;
  height: 100%;
  width: 100%;
}

.album-cover-view{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.album-cover-view-header{
  width: 100%;
  height: 10%;
  display: flex;
  justify-content: space-around;
  align-items: center;
}

.rating{
  width: 30%;
}
.album-cover{
  width: 300px;
  height: 300px;
  border-radius: 10px;
  background-size: cover;
  background-repeat: no-repeat;
}

.top{
  width: 100%;
  height: 85%;
  background: #bdc2d5;
  display: grid;
  grid-template-columns: 1fr 1fr;
}


.bottom{
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  height: 15%;
  background: rgb(80,94,123);
}

.bottom svg{
  width: 50px;
  height: 50px;
}

.blur{
  color: #181818;
  opacity: calc(0.6 - (var(--i) - var(--active-index)) * 0.1);
}

.scroll-view {
  margin: 0;
  z-index: 0;
  left: 0;
  top: 30%;
  width: auto;
  position: relative;
  height: 70%;
  overflow: hidden;
}

p {
  font-family: Helvetica,serif;
  font-weight: bold;
  text-align: start;
  font-size: 35px;
  word-wrap: break-word;
  line-height: 40px;
  width: 80%;
  position: absolute;
  margin: 0;
  transition: all .7s ease-in-out;
}

p.active{
  color: #181818;
}


p.active ~ p {
  transition-delay: calc(var(--i) * 0.02s - var(--active-index) * 0.016s);
}

</style>