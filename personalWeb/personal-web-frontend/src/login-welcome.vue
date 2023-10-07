<template>
  <div class = "login-template">
    <div class="picture-text">
      <typing-effect text= "Welcome to Edwinzhan Personal web!" />
    </div>
      <router-view/>
  </div>
</template>

<script>
import {defineComponent} from "vue";
import typingEffect from "@/components/animation/TypingEffect.vue";

export default defineComponent({
  components: {
    typingEffect,
  },
})

</script>

<style>
.login-template{
  height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  overflow: hidden;
}

@media screen and (min-width: 792px){
  .login-template{
    height: 100vh;
    display: grid;
    grid-template-columns: 5fr 4fr;
    align-items: stretch;
  }
}

.picture-text{
  font-size: 60px;
  display: flex;
  align-items: center;
  justify-content: space-around;
  height: 100vh;
  background: rgb(0,199,190);
}

.picture-text p{
  margin-left: 20px;
  height: 150px;
  width: 100%;
  font-size: 60px;
  margin-block-start: 0;
  margin-block-end: 0;
}
</style>