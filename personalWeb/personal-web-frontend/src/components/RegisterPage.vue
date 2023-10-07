<script lang="ts" setup>
import {nextTick, reactive, ref} from 'vue'
import type { FormInstance, FormRules } from 'element-plus'
import router from '@/router'
import {post} from './net/index'
import {ElMessage} from "element-plus";

const ruleFormRef = ref<FormInstance>()

const checkEmail = (rule: any, value: any, callback: any) => {
  const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;

  if (value === '') {
    callback(new Error('Please input the email address'))
  } else {
    if (!emailRegex.test(value)) {
      callback(new Error('Invalid email format'))
    } else {
      if (ruleForm.email !== '') {
        if (!ruleFormRef.value) return
        ruleFormRef.value.validateField('checkEmail', () => null)
      }
      callback()
    }
  }
}

const checkUsername = (rule: any, value: any, callback: any) => {
  const usernameRegex = /^[a-zA-Z0-9._-]{3,15}$/;

  if (value === '') {
    callback(new Error('Please input the username'));
  } else {
    if (!usernameRegex.test(value)) {
      callback(new Error("Username can only include alphanumeric characters and '.' '_' '-'"));
    } else {
      if (ruleForm.username !== '') {
        if (!ruleFormRef.value) return;
        ruleFormRef.value.validateField('checkUsername', () => null);
      }
      callback();
    }
  }
}


const checkEmailConfig = (rule: any, value: any, callback: any) => {
  const emailCodeRegex = /^[0-9]{6}$/; // Assuming the code is a 6-character alphanumeric combination

  if (value === '') {
    callback(new Error('Please input the email verification code'));
  } else {
    if (!emailCodeRegex.test(value)) {
      callback(new Error('Invalid verification code format'));
    } else {
      callback(); // if everything is okay
    }
  }
}


const validatePass = (rule: any, value: any, callback: any) => {
  if (value === '') {
    callback(new Error('Please input the password'))
  } else {
    if (ruleForm.checkPass !== '') {
      if (!ruleFormRef.value) return
      ruleFormRef.value.validateField('checkPass', () => null)
    }
    callback()
  }
}
const validatePass2 = (rule: any, value: any, callback: any) => {
  if (value === '') {
    callback(new Error('Please input the password again'))
  } else if (value !== ruleForm.pass) {
    callback(new Error("Two inputs don't match!"))
  } else {
    callback()
  }
}

const ruleForm = reactive({
  pass: '',
  checkPass: '',
  username: '',
  email: '',
  emailConfig: '',
})

const rules = reactive<FormRules<typeof ruleForm>>({
  pass: [
    { validator: validatePass, trigger: ['blur', 'change']},
    {min: 6, max: 16, message:'the length of the password should between 6 and 16', trigger:['blur', 'change']}
  ],
  checkPass: [{ validator: validatePass2, trigger: ['blur', 'change'] }],
  username: [{ validator: checkUsername, trigger: ['blur', 'change']}],
  email: [{ validator: checkEmail, trigger: ['blur', 'change']}],
  emailConfig:[{ validator: checkEmailConfig, trigger: ['blur', 'change'] }],
})

const isEmailValid = ref(false)

const onValidate = (prop, isValid) => {
  if(prop === 'email')
    isEmailValid.value = isValid
}

const submitForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.validate((valid) => {
    if (valid) {
      console.log('submit!')
    } else {
      console.log('error submit!')
      ElMessage("Please complete the register form")
      return false
    }
  })
}

const resetForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.resetFields()
}

const validateEmail = () =>{
  post('/api/auth/valid-email', {
    email: ruleForm.email
  }, (message)=>{
    ElMessage.success(message)
  })
}

const minimize = ref(false);
const goToLogin = async () => {
  minimize.value = true;
  await nextTick();
  setTimeout(() => {
    router.push('/Login');
  }, 1300);
};

</script>

<template>
  <div :class="{'change': minimize}">
      <div :class="{'fadeOut': minimize}" style="padding: 0 20px 0 20px; width: auto">
        <h1>
          Register
        </h1>
        <el-divider>
          <span style = "color: grey"></span>
        </el-divider>
        <div class="main-wrapper">
          <el-form
              ref="ruleFormRef"
              :model="ruleForm"
              status-icon
              :rules="rules"
              label-width="80px"
              label-position="left"
              @validate="onValidate"
          >
            <el-form-item prop="username" label="Username">
              <el-input v-model="ruleForm.username" />
            </el-form-item>
            <el-form-item label="Password" prop="pass">
              <el-input v-model="ruleForm.pass" type="password" autocomplete="off" />
            </el-form-item>
            <el-form-item label="Confirm" prop="checkPass">
              <el-input
                  v-model="ruleForm.checkPass"
                  type="password"
                  autocomplete="off"/>
            </el-form-item>
            <el-form-item prop="email" label="Email">
              <el-input v-model="ruleForm.email" />
            </el-form-item>
            <el-form-item label="Verify" prop="emailConfig">
              <el-row :gutter = "20" style="width: 100%">
                <el-col :span = "16">
                  <el-input type="text" placeholder="Email verification code"></el-input>
                </el-col>
                <el-col :span = "8">
                <el-button type="success" @click = "validateEmail" :disabled="!isEmailValid">Get code</el-button>
                </el-col>
              </el-row>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="submitForm(ruleFormRef)">Register</el-button>
              <el-button @click="resetForm(ruleFormRef)">Reset</el-button>
            </el-form-item>
          </el-form>
          <div style = "display: flex; flex-direction: row; padding-left: 80px; ">
        <span style = "padding-right: 5px">
          Already have an account?
        </span>
            <span @click = "goToLogin" style="color: grey; cursor: pointer">
          Login here
        </span>
          </div>
        </div>
      </div>
    </div>
</template>


<style>
h1{
  padding-top: 30px;
  margin-block-end: 0;
  margin-block-start: 0;
}

.main-wrapper{
  animation: fadeIn 0.3s forwards;
  height: 100%;
  margin-top: 10px;
}

.change{
  animation: change 1s forwards;
}

@keyframes change {
  to {
    background-color: rgb(229,229,234);
  }
}

.fadeOut {
  animation: fadeOut 0.5s forwards;
}

</style>