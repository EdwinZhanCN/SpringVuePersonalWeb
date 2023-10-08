<template>
  <image-upload/>
  <el-button @click = "logout()" type="primary" round>log out</el-button>
</template>

<script setup>

import imageUpload from "@/components/imageUpload.vue";
import {get} from "@/net/index.js";
import {ElMessage} from "element-plus";
import router from "@/router";
import {useStore} from "@/stores";

const store = useStore()
const logout = () => {

  get("/api/auth/logout", (message) => {
    ElMessage.success(message)
    store.auth.user = null
    router.push('/login')
  })
}
</script>

<style scoped>

</style>