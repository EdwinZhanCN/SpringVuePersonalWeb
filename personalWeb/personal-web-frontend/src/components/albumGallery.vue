<template>
  <image-upload/>
  <el-button @click = "logout()" type="primary" round style="margin-top: 50px">log out</el-button>
  <el-button type="primary" @click = "getImage()">
    显示图片
  </el-button>
  <img v-for="image in images" :key="image" :src="image" alt="database-image" />
</template>

<script setup>

import imageUpload from "@/components/imageUpload.vue";
import {get} from "@/net/index.js";
import {ref} from "vue";
import {ElMessage} from "element-plus";
import router from "@/router";
import {useStore} from "@/stores";

const store = useStore()
const images = ref([])
const logout = () => {

  get("/api/image/logout", (message) => {
    ElMessage.success(message)
    store.auth.user = null
    router.push('/login')
  })
}
const getImage = () => {
  for (let i = 2; i <= 23; i++) {
    get(`api/image/${i}`, (data) => {
      if (data) {
        images.value.push('data:image/jpeg;base64,' + data);
      } else {
        ElMessage.warning(`Failed to decode the image with id: ${i}`);
      }
    });
  }
}


function byteArrayToBase64(byteArray) {
  let binary = '';
  const len = byteArray.byteLength;
  for (let i = 0; i < len; i++) {
    binary += String.fromCharCode(byteArray[i]);
  }
  return window.btoa(binary);
}

</script>

<style scoped>

</style>