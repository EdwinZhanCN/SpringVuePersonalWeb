<template>
  <div @click = "router.push('/')" class="rounded-rectangle"><h3>Edwin Zhan</h3></div>
</template>

<script setup>

import router from "@/router";
</script>

<style scoped>
.rounded-rectangle {
  font-family: "Helvetica",sans-serif;
  cursor: pointer;
  width: auto;  /* 或根据需要设置宽度 */
  height: 44px;
  border-radius: 10px;
  background-color: rgb(199,199,204,.3);  /* 或根据需要设置颜色 */
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  text-align: center;
  line-height: .7em;
  color: black;
}
</style>
