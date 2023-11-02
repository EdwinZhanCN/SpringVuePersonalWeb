<template>
  <image-upload/>
  <el-button @click="logout()" type="primary" round style="margin-top: 50px">log out</el-button>
</template>

<script setup>

import imageUpload from "@/components/ImageUpload.vue";
import {get} from "@/net/index.js";
import {ref, watch} from "vue";
import {ElMessage} from "element-plus";
import router from "@/router";
import {useStore} from "@/stores";
import scroll from "@/components/Derapcated/scroll.vue";

const store = useStore()

const logout = () => {

  get("/api/auth/logout", (message) => {
    ElMessage.success(message)
    store.auth.user = null
    router.push('/login')
  })
}

</script>


<style>
.container {
  display: flex;
  flex-direction: row;
  overflow: scroll;
  max-width: 99999%;
}

.moving-image {
  transition: transform 1s linear;
  width: calc(100%/7.6);
  height: auto;
}
</style>