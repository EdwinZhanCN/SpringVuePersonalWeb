<template>
  <image-upload/>
  <el-button @click = "logout()" type="primary" round>log out</el-button>
</template>

<script setup>

import imageUpload from "@/components/imageUpload.vue";
import {get} from "@/components/net";
import {ElMessage} from "element-plus";
import router from "@/router";

const logout = () => {

  get("/api/auth/logout", (message) => {
   ElMessage.success(message)
    router.push('/login')
  })
}
</script>

<style scoped>

</style>