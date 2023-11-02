<script setup>

import {get} from "@/net/index.js"
import {useStore} from "@/stores";

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

<style>
</style>