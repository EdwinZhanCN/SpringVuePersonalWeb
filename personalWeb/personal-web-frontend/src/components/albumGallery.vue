<template>
  <div>
    <img v-for="(cover, index) in covers" :key="index" :src="cover.src" :alt="cover.alt" />
  </div>
</template>

<script>
import imageUpload from "@/components/imageUpload.vue";
export default {
  name: 'album-gallery',
  components: {
    imageUpload
  },
  data() {
    return {
      covers: [
        { title: 'iDea' },
        { title: 'Progress' },
        { title: 'self-intro' },
        { title: 'Blog' },
      ]
    }
  }
};
</script>

<style scoped>

</style>