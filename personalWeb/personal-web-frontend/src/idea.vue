<template>
  <navigation-bar/>
</template>

<script>
  import {defineComponent} from "vue";
  import navigationBar from "@/components/navigationBar.vue";

  export default defineComponent({
    components: {
      navigationBar,
    },
  })
</script>

