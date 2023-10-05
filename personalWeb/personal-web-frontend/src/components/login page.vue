<template>
  <div class = "login-template">
    <div class="picture-text">
      <typing-effect text="Welcome to Edwinzhan Personal web!"/>
    </div>
    <div class= "login-interface-background">
      <div class = "login-interface">
        <h2>Login</h2>
        <el-input prefix-icon="user" type="text" size="large" class = "text-area"></el-input>
        <el-input prefix-icon="Password" type = "password" size = "large" class="text-area" disabled></el-input>
        <el-button class="login-Button" type="primary" round>Login</el-button>
      </div>
    </div>
  </div>
</template>

<script>
import typingEffect from "@/components/TypingEffect.vue";
export default {
  name: 'login-page',
  components: {
    typingEffect,
  },
};


</script>

<style>

h2{
  margin: 0;
  padding: 0;
  margin-block-end: 0;
  margin-block-start: 0;
}

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

.login-interface-background{
  align-items: center;
  display: flex;
  justify-content: space-around;
  background-color: rgb(229,229,234);
}

.login-interface{
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-around;
  width: 350px;
  height: 240px;
  overflow: hidden;
  border-radius: 10px;
  background: white;
}

.text-area{
  padding-left: .5rem;
  padding-right: .5rem;
  padding-bottom: 10px;
  display: flex;
  align-items: end;
}

.login-Button{
  padding-bottom: 20px;
}
</style>