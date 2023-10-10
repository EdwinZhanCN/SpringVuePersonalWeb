<script setup>

</script>

<template>
  <div class="scroll-view">
    <div
        class="scroll"
    >
      <img v-for="image in images1" :key="image" :src="image" alt="database-image"/>
    </div>
    <div
        class="scroll"
    >
      <img v-for="image in images2" :key="image" :src="image" alt="database-image"/>
    </div>
    <div
        class="scroll"
    >
      <img v-for="image in images3" :key="image" :src="image" alt="database-image"/>
    </div>
  </div>
</template>

<style scoped>
.scroll {
  position: relative;
  display: block;
  width: 90%;
  height: 220px;
  margin: 0 auto;
  overflow: hidden;
  background: black;
}

.scroll img{
  width: 220px;
  height: 220px;
  justify-content: space-between;
  margin-left: 10px;
}

.scroll-view{
  border-radius: 10px;
  display: grid;
  grid-template-rows: 1fr 1fr 1fr;
  grid-gap: 10px;
  margin-top: 20px;
  margin-bottom: 20px;
}
</style>