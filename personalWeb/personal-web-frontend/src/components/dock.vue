<script setup>
import {ref} from "vue";

const items  =ref([
  {name: "枫", url: "/src/components/album-cover/1400x1400bb-3.jpg"},
  {name: "Think out loud", url: "/src/components/album-cover/1400x1400bb-4.jpg" },
  {name: "枫", url: "/src/components/album-cover/1400x1400bb-3.jpg"},
  {name: "Think out loud", url: "/src/components/album-cover/1400x1400bb-4.jpg" },
  {name: "枫", url: "/src/components/album-cover/1400x1400bb-3.jpg"},

])
</script>

<template>
  <ul class="bottom-ul">
    <li class="bottom-li" v-for="item in items" :key="item.name" :style="{ backgroundImage: 'url(' + item.url + ')' }">
    </li>
  </ul>
</template>

<style scoped>

.bottom-ul{
  background: rgba(255, 255, 255, 0.2);
  -webkit-backdrop-filter: blur(8px);
  backdrop-filter: blur(8px);
  border-radius: 20px;
  margin-block-end: 0;
  margin-block-start: 0;
  list-style: none;
  width: 25%;
  height: 70%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: end;
  gap: 10px;
  padding-left: 0;

}

.bottom-li{
  width: 60px;
  height: 60px;
  border-radius: 10px;
  transition: .22s ease-in-out;
  margin-bottom: 15px;
  background-size: cover;
}

.bottom-li:hover{
  width: 90px;
  height: 90px;
}

.bottom-li:has( + .bottom-li:hover){
  width: 75px;
  height: 75px;
}

.bottom-li:hover + li{
  width: 75px;
  height: 75px;
}
</style>