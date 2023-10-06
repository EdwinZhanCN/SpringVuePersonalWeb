<template>
  <div @click = "login()" class="rounded-rectangle"><h3>Edwin Zhan</h3></div>
</template>

<script setup>
import router from "@/router";

const login = () =>{
  router.push('/login')
}
</script>

<style scoped>
.rounded-rectangle {
  cursor: pointer;
  width: auto;  /* 或根据需要设置宽度 */
  height: auto;
  border-radius: 10px;
  background-color: rgb(242,242,247);  /* 或根据需要设置颜色 */
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  text-align: center;
  line-height: 1em;
  color: black;
}
</style>
