<template>
  <div style="margin-top: 20px">
    <navigation-bar/>
  </div>

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

