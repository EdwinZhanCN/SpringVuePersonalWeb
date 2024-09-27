<script setup>

import {get} from "@/net/index.js"
import {useStore} from "@/stores";
import Gallery from "@/components/Gallery.vue";

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
  <RouterView/>
</template>

<style>
</style>