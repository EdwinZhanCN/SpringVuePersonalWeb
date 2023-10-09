<script setup>

import {get} from "@/net/index.js"
import {ElMessage} from "element-plus"
import {useStore} from "@/stores";
import router from "@/router";

const store = useStore()

if(store.auth.user == null){
  get('api/user/me', (message)=> {
    console.log(store.auth.user)
    store.auth.user = message
  },()=>{
    store.auth.user = null
    console.log(store.auth.user)
  })
}

</script>

<template>
  <router-view/>
</template>

<style scoped>

</style>