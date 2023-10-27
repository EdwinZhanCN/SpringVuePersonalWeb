<script setup>
import {ref, onMounted} from "vue";
import {get} from "@/net";
import {ElMessage} from "element-plus";

const response = ref(false)

const images1 = ref([])
const images2 = ref([])
const images3 = ref([])
function compress(base64, rate, callback) {
  // 处理缩放，转格式
  const _img = new Image();
  _img.src = base64;
  _img.onload = function () {
    const _canvas = document.createElement("canvas");
    const w = this.width / rate;
    const h = this.height / rate;
    _canvas.setAttribute("width", w);
    _canvas.setAttribute("height", h);
    _canvas.getContext("2d").drawImage(this, 0, 0, w, h);
    const compressedBase64 = _canvas.toDataURL("image/jpeg");
    callback(compressedBase64);
  }
}

function fetchImage() {
  for (let i = 1; i <= 41; i++) {
    get(`api/image/${i}`, (data) => {
      if (data) {
        const base64Image = 'data:image/jpeg;base64,' + data;
        compress(base64Image, 4, (compressedImage) => { // 假设压缩比率为2
          if (i > 13 && i <= 28) {
            images2.value.push(compressedImage);
          } else if (i > 28 && i <= 41) {
            images3.value.push(compressedImage);
          } else {
            images1.value.push(compressedImage);
          }
        });
      } else {
        ElMessage.warning(`Failed to decode the image with id: ${i}`);
      }
    }, () => {
      console.log(`can't find image: ${i}`);
    });
  }
}


fetchImage();
response.value = true;
</script>

<template>
<div class="scroll-view">
  <div class="scroll-section"
       v-for="(images) in [images1]"
       :key="images"
  >
    <div class="scroll-slide">
      <img v-show="response" v-for="image in images" :key="image" :src="image" alt="database-image"/>
    </div>
    <div class="scroll-slide">
      <img v-show="response" v-for="image in images" :key="image + '-copy'" :src="image" alt="database-image"/>
    </div>
  </div>
</div>
</template>

<style scoped>
*{
  margin:0;
  padding: 0;
}
.scroll-view{
  border-radius: 10px;
  display: grid;
  grid-template-rows: 1fr 1fr 1fr;
  grid-gap: 10px;
  margin-top: 20px;
  margin-bottom: 20px;
  animation: trans 8s ease-in-out;
}

.scroll-section{
  overflow: hidden;
  white-space: nowrap;
}

.scroll-slide img{
  width: 220px;
  height: 220px;
  margin-left: 10px;
}

.scroll-slide{
  will-change: transform;
  display: inline-block;
  animation: 20s slide infinite linear;
}

@keyframes slide {
  from {
    transform: translate3d(0, 0, 0);
  }
  to {
    transform: translate3d(-100%, 0, 0);
  }
}

</style>