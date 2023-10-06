<script setup>
import 'element-plus/dist/index.css'
import {ElMessage} from "element-plus";
import { post } from "./net/index.js";
import { reactive } from 'vue';
import router from "@/router";

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
    }, (message) =>{
      ElMessage.success(message)
      router.push('/album-gallery')
    })
  }
}

</script>

<template>

    <div class= "login-interface-background">
      <div class = "login-interface">
        <h2>Login</h2>
        <div class = "space-center">
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
                <el-link :underline="false">Forget Password?</el-link>
            </el-row>
          </div>
          <el-button @click = "login()" class="login-Button" type="primary" round>Login</el-button>
          <el-divider>
            <span style = "color: grey"> No account?</span>
          </el-divider>
          <el-button class="login-Button" type = "warning" round>Register</el-button>
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
  width: 80%;
  max-width: 578px;
  min-width: 374px;
  height: auto;
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
  padding-right: 0 ;
  padding-bottom: 0px;
  display: flex;
}

.login-Button{
  padding-top: 20px;
  padding-bottom: 20px;
}
</style>