<script setup>
import ProgressSideBar from "@/components/progress/Progress-SideBar.vue";
import ProgressMain from "@/components/progress/Progress-Main.vue";
import {onMounted, onUnmounted, ref} from "vue";
import {useStore} from "@/stores";
const store = useStore()

function updateActiveId() {
  const sections = ['intro', 'fakeClass', 'gameLogic', 'intro2', 'bisearch', 'dataSelect', 'userInter'];
  for (let section of sections) {
    const element = document.getElementById(section);
    const rect = element.getBoundingClientRect();
    if (rect.top <= 0 && rect.bottom >= 0) {
      store.active.active = section;
      break;
    }
  }
}

function handleScroll() {
  updateActiveId();
}

onMounted(() => {
  window.addEventListener('scroll', handleScroll);
  updateActiveId();  // 初始检查
});

onUnmounted(() => {
  window.removeEventListener('scroll', handleScroll);
});

</script>

<template>
<div class="main-wrapper">
  <div style="grid-area: sidebar;">
    <progress-side-bar/>
  </div>
  <main class="main-content">
    <progress-main/>
  </main>
</div>
</template>

<style scoped>

.main-wrapper{
  max-width: 1200px;
  margin:0 auto;
  height: 100%;
  z-index: 1;
  padding-top: 0;
  grid-gap: 3rem;
  display: grid;
  gap: 3rem;
  grid-template-areas: "sidebar main";
  grid-template-columns: minmax(0,1fr) minmax(0,2fr);
  padding-left: 1.5rem;
  padding-right: 3rem;
}

section {
  padding: 0;
  position: relative;
}



.main-content{
  grid-area: main;
  padding-top: 2rem;
  display: flex;
  flex-direction: column;
  width: 100%;
  height: 5000px;
}
</style>