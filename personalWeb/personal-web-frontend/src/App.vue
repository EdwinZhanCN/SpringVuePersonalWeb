<template>
  <navigation-bar/>
</template>

<script>
  import {defineComponent} from "vue";
  import navigationBar from "@/components/navigationBar.vue";
  import imageUpload from "@/components/imageUpload.vue";

  export default defineComponent({
    components: {
      navigationBar,
      imageUpload,
    },
  })
</script>

