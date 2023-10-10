<script setup>
import 'element-plus/dist/index.css'
import {ElMessage} from "element-plus";
import {get, post} from "@/net/index.js";
import {reactive, ref, nextTick} from 'vue';
import router from "@/router";
import {useStore} from "@/stores";
const store = useStore();
const form = reactive({
  username:'',
  password: '',
  remember: false
})

const login = () =>{
  if(!form.username || !form.password){
    ElMessage.warning('Please Enter the password or username')
  }else {
    post('/api/auth/login', {
      username: form.username,
      password: form.password,
      remember: form.remember,
    }, (message) => {
      ElMessage.success(message)
      get('api/user/me', (message) => {
        store.auth.user = message
        console.log(store.auth.user)
        router.push('/idea')
      },() => {
        store.auth.user = null
      })
    })
  }
}

const expanding = ref(false);


const goToRegister = async () => {
  expanding.value = true;
  await nextTick();
  setTimeout(() => {
    router.push('/register');
  }, 1200);
};
const goToResetPassword = async () => {
  expanding.value = true;
  await nextTick();
  setTimeout(() => {
    router.push('/forget-password');
  }, 1200);
};

</script>

<template>
    <div class= "login-interface-background">
      <div :class="{'expanding': expanding}" class = "login-interface">
          <h2 :class="{'fadeOut': expanding}">Login</h2>
          <div :class="{'fadeOut': expanding}" class = "space-center">
            <el-input v-model= "form.username"
                      type="text"
                      size="large"
                      class = "text-area"
                      style="padding-bottom: 20px"
                      clearable prefix-icon="User"/>
            <el-input v-model = "form.password"
                      prefix-icon="Lock"
                      type = "password"
                      size = "large"
                      class="text-area"
                      show-password/>
            <div style="padding-bottom: 20px">
              <el-row style="justify-content: space-between">
                <el-checkbox v-model='form.remember' label="remember me"/>
                <el-link @click = "goToResetPassword" :underline="false">Forget Password?</el-link>
              </el-row>
            </div>
            <el-button @click = "login()" class="login-Button" type="primary" round>Login</el-button>
            <el-divider>
              <span style = "color: grey"> No account?</span>
            </el-divider>
            <el-button @click="goToRegister" class="login-Button" type = "warning" round>Register</el-button>
          </div>
        </div>
    </div>
</template>



<style>

h2{
  padding: 30px;
  margin-block-end: 0;
  margin-block-start: 0;
}

.login-interface-background{
  align-items: center;
  display: flex;
  justify-content: space-around;
  background-color: rgb(229,229,234);
}

.login-interface{
  animation: fadeIn 0.2s forwards;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-around;
  width: 80%;
  max-width: 578px;
  min-width: 374px;
  height: 374px;
  overflow: hidden;
  border-radius: 10px;
  background: white;
}

.space-center{
  flex-direction: column;
  display: flex;
  width: 80%;
  padding-bottom: 20px;
}

.text-area{
  padding-left: 0;
  padding-right: 0;
  padding-bottom: 0;
  display: flex;
}

.login-Button{
  padding-top: 20px;
  padding-bottom: 20px;
}

.login-interface-background .expanding {
  animation: expand 1.5s forwards;
}

.login-interface-background .fadeOut {
  animation: fadeOut 1.5s forwards;
}

@keyframes expand {
  to {
    max-width: 999999px;
    width: 100%;
    height: calc(100%);
  }
}

@keyframes fadeOut {
  to {
    opacity: 0;
  }
}

@keyframes fadeIn {
  from{
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}

</style>