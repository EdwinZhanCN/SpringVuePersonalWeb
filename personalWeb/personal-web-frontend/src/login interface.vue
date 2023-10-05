<template>
  <login-page/>
</template>

<script>
import {defineComponent} from "vue";
import { ref } from 'vue'
const input = ref('')
import loginPage from "@/components/login page.vue";

export default defineComponent({
  components: {
     loginPage,
  },
})

</script>