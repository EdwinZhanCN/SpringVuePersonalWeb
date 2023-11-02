<template>
  <div class = "login-template">
    <div class="picture-text">
      <typing-effect text= "Welcome to Edwinzhan Personal web!" />
        <span></span>
        <span></span>
        <span></span>
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
  z-index: 1;
  margin-left: 20px;
  height: 150px;
  width: 100%;
  font-size: 60px;
  margin-block-start: 0;
  margin-block-end: 0;
}

.picture-text span{
  overflow: hidden;
  top: 35%;
  left: 10%;
  width: 120px;
  height: 120px;
  background: orange;
  z-index: 0;
  position: absolute;
  border-radius: 50%;
  animation: hanging ease-in-out 3s infinite alternate;
}


.picture-text span:nth-child(2){
  top: 30%;
  left: 36%;
  width: 230px;
  height: 230px;
  background: cornflowerblue;
  animation: hanging ease-in-out 4s infinite alternate-reverse;
}

.picture-text span:nth-child(3){
  top: 60%;
  left: 10%;
  width: 300px;
  height: 300px;
  background: palegreen;
  animation: hanging ease-in-out 2.5s 0.5s infinite alternate;
}

@keyframes hanging {
  0%{
    transform: translateY(0);
  }
  100%{
    transform: translateY(-30px);
  }
}

</style>