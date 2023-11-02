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
    <div class="scroll imgbx"
         v-for="(images) in [images1, images2, images3]"
         :key="images"
         style="--t: 35s;">
      <div>
        <img v-for="image in images" key="image" :src="image" alt="database-img">
      </div>
      <div>
        <img v-for="image in images" key="image-copy" :src="image" alt="database-img">
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
  overflow: hidden;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  min-height: 100vh;
  background-color: #111;
}

.imgbx img {
  margin: 0 10px;
  width: 200px;
  height: 200px;
  cursor: pointer;
  transition: .5s;
}
.scroll {
  position: relative;
  display: flex;
  overflow: hidden;
}

.scroll div {
  white-space: nowrap;
  animation: animate var(--t) linear infinite;
  animation-delay: calc(var(--t) * -1);
}

.scroll div:nth-child(2) {
  animation: animate2 var(--t) linear infinite;
  animation-delay: calc(var(--t) / -2);
}

@keyframes animate {
  0% {
    transform: translateX(100%);
  }
  100% {
    transform: translateX(-100%);
  }
}

@keyframes animate2 {
  0% {
    transform: translateX(0);
  }
  100% {
    transform: translateX(-200%);
  }
}

</style>