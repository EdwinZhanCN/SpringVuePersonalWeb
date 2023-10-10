<script setup>

import {get} from "@/net/index.js"
import {ElMessage} from "element-plus"
import {useStore} from "@/stores";
import router from "@/router";
import VisualCliff from "@/components/visual-cliff.vue";
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
  <router-view></router-view>
</template>

<style>
</style>