<script>
import mainNavigation from "@/components/main/main-navigation.vue";
import dailyWrapper from "@/components/main/daily-wrapper.vue";
import contactInfo from "@/components/main/contact-info.vue";
export default {
  components:{
    mainNavigation,
    dailyWrapper,
    contactInfo,
  }
}
</script>

<template>
  <mainNavigation/>
  <daily-wrapper/>
  <contact-info/>
</template>

<style scoped>

</style>