<template>
  <div style="background-color: rgb(229,229,234);">
    <navigation-bar></navigation-bar>
    <div class = "album-view">
      <h1>
        Love songs,   love pop.
      </h1>
      <seamless-scroll/>
      <button @click = toMusic() class="button">
        <el-icon size="large" ><ArrowRightBold /></el-icon>
      </button>
      <div id = "text-container" class="text-container">
        Listen my playlist
      </div>
    </div>

    <div class = "visual-cliff">
      <visual-cliff/>
    </div>
  </div>

</template>

<script setup>
  import navigationBar from "@/components/IDea-NavigationBar.vue";
  import {ArrowRightBold} from "@element-plus/icons-vue";
  import router from "@/router";
  import VisualCliff from "@/components/IDea-VisualCliff.vue";
  import SeamlessScroll from "@/components/IDea-SeamlessScroll.vue";
  const toMusic = () =>{
    router.push('/music-player')
  }

</script>

<style scoped>
.album-view{
  position: relative;
  background: black;
  text-align: center;
}

.album-view h1{
  color: #f8f8f8;
  padding-top: 20px;
}
#text-container{
  font-family: "Helvetica Neue",serif;
  color: #e2e2d7;
  display: flex;
  justify-content: center;
  font-size: 24px;
  background: rgba(255, 255, 255, 0.2);
  -webkit-backdrop-filter: blur(8px);
  backdrop-filter: blur(8px);
  box-shadow:inset 0 0 6px rgba(255, 255, 255, 0.2);
  position: absolute;
  border-radius: 40px;
  padding: 5px 15px;
  height: 36px;
  opacity: 0;
  width: 0;
  z-index: 1;
  bottom: 20px;   /* 调整为距离底部20px */
  left: 50%;     /* 使其在水平方向上居中 */
  transform: translateX(-40%);
  overflow: hidden;
  white-space: nowrap;
  transition: all 0.4s ease;
  transform-origin: center;
}

.button{
  color: #e2e2d7;
  text-align: center;
  cursor: pointer;
  background: rgba(255, 255, 255, 0.2);
  -webkit-backdrop-filter: blur(8px);
  backdrop-filter: blur(8px);
  border-radius: 25px;
  box-shadow:inset 0 0 6px rgba(255, 255, 255, 0.2);
  width: 50px;
  height: 50px;
  margin-bottom: 20px;
  position: absolute;
  z-index: 2;
  bottom: 0;
  left: calc(50% - 10px);
  border-color: rgba(255, 255, 255, 0.2);
  transition: all 0.4s ease;
}

.button:hover {
  transition: 0.4s ease-in-out;
  opacity: 0;
}

.button:hover ~ #text-container {
  transition: 0.4s ease-in-out;
  width: 220px;
  opacity: 1;
}

.visual-cliff{
  position: static;
  height: auto;
}



</style>