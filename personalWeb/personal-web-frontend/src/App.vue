<script setup>

import {get} from "@/net/index.js"
import {useStore} from "@/stores";
import lyrics from "@/components/lyrics.vue";
import list from "@/components/navigation bar/List.vue";
import NavigationBar from "@/components/navigationBar.vue";
import Idea from "@/idea.vue";
import PlayerFrame from "@/player-frame.vue";
import VisualCliff from "@/components/visual-cliff.vue";
import LoginWelcome from "@/login-welcome.vue";
import ProgressPage from "@/Progress-page.vue";
import ProgressSideBar from "@/components/progress/Progress-sideBar.vue";
import SeamlessScroll from "@/seamless-scroll.vue";

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
  <seamless-scroll/>
</template>

<style>
</style>