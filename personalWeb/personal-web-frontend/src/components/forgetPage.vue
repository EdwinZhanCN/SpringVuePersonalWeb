<script  lang="ts" setup>
import {onMounted, reactive, ref, nextTick} from "vue";
import {ElMessage, FormInstance, FormRules} from "element-plus";
import {post} from "@/net/index.js";
import router from '@/router/index.js';
import {Arrayable} from "element-plus/es/utils";
import {FormItemProp} from "element-plus/es/components/form/src/form-item";

const minimize = ref(false);
const isEmailValidate = ref(false);
const isEmailCorrect = ref(false);
const ruleFormRef = ref<FormInstance>();
const isResettingPassword = ref(true);
const active = ref(0)

const next = () => {
  if (active.value++ > 2) active.value = 0
}
const setActiveZero =()=>{
  active.value = 0
}

const ruleForm = reactive({
  email:'',
  pass: '',
  checkPass: '',
  emailConfig: '',
})

const resetForm = (ruleFormRef) => {
  if (!ruleFormRef) return;
  ruleForm.pass = '';
  ruleForm.checkPass = '';
  ruleForm.emailConfig= '';
}



const validateEmail = () =>{
  post('/api/auth/valid-email', {
    email: ruleForm.email,
    isResettingPassword: isResettingPassword.value,
  }, (message)=>{
    ElMessage.success(message)
    cool.value = 60
    startCountdown()
  })
}

const cool = ref(0);

function startCountdown() {
  let endTime = new Date().getTime() + 60000; // 当前时间加上60秒（60000毫秒）
  localStorage.setItem("endTime", endTime.toString());
  updateCountdown();
}

function updateCountdown() {
  const now = new Date().getTime();
  const endTime = parseInt(localStorage.getItem("endTime"), 10);

  if (!endTime) return;

  const timeLeft = Math.floor((endTime - now) / 1000);

  if (timeLeft > 0) {
    cool.value = timeLeft;
    setTimeout(updateCountdown, 1000);
  } else {
    cool.value = 0;
    localStorage.removeItem("endTime");
  }
}

onMounted(() => {
  updateCountdown();
});

const verifyEmail = () =>{
  post('/api/auth/email-verify', {
    email: ruleForm.email
  }, (message)=>{
    next()
    ElMessage.success(message)
    isEmailCorrect.value = true;
  })
}
const verifyCode = () =>{
  post('/api/auth/email-validate-verify', {
    email: ruleForm.email,
    code: ruleForm.emailConfig
  }, (message)=>{
    next()
    ElMessage.success(message)
    isEmailValidate.value = true;
  })
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

const rules = reactive<FormRules<typeof ruleForm>>({
  pass: [
    { validator: validatePass, trigger: ['blur', 'change']},
    {min: 6, max: 16, message:'the length of the password should between 6 and 16', trigger:['blur', 'change']}
  ],
  email: [{ validator: checkEmail, trigger: ['blur', 'change']}],
  checkPass: [{ validator: validatePass2, trigger: ['blur', 'change'] }],
  emailConfig:[{ validator: checkEmailConfig, trigger: ['blur', 'change'] }],
})

const goToLogin = async () => {
  minimize.value = true;
  await nextTick();
  setTimeout(() => {
    router.push('/Login');
  }, 1300);
};

const resetPassWord = () => {
  post('/api/auth/reset-password', {
    password: ruleForm.pass,
  }, (message) => {
    next()
    ElMessage.success(message)
    goToLogin();
  })
}

</script>

<template>
  <div :class="{'change': minimize}">
    <div :class="{'fadeOut': minimize}" style="padding: 0 20px 0 20px; width: auto">
      <h1 style="animation: fadeIn 0.3s forwards;">
        Forget password?
      </h1>
      <el-steps :active="active" finish-status="success" style="padding-top: 20px; padding-bottom: 20px" align-center>
        <el-step title="Check exists account" />
        <el-step title="Verify your email" />
        <el-step title="Reset your new password" />
      </el-steps>
      <div class="main-wrapper" style="animation: fadeIn 0.3s forwards;">
        <el-form
            ref="ruleFormRef"
            :model="ruleForm"
            status-icon
            :rules="rules"
            label-width="80px"
            label-position="left"
        >
          <el-form-item prop="email" label="Email">
            <el-input :disabled = "isEmailCorrect" v-model="ruleForm.email" />
          </el-form-item>
          <el-form-item v-show = isEmailCorrect label="Verify" prop="emailConfig">
            <el-row style="width: 100%" :gutter = "22">
              <el-col :span = "10">
                <el-input v-model="ruleForm.emailConfig" type="text"
                          :maxlength = "6" placeholder="Email verification code"></el-input>
              </el-col>
              <el-col :span = "5">
                <el-button type="success" @click = "validateEmail"
                           :disabled="!isEmailCorrect || cool > 0">{{cool > 0 ? cool + 's' : "Get Code"}}</el-button>
              </el-col>
            </el-row>
          </el-form-item>
          <el-form-item v-show = isEmailValidate label="Password" prop="pass">
            <el-input v-model="ruleForm.pass" :maxlength = "16" type="password" autocomplete="off" />
          </el-form-item>
          <el-form-item v-show = isEmailValidate label="Confirm" :maxlength = "16" prop="checkPass">
            <el-input
                v-model="ruleForm.checkPass"
                :maxlength = "16"
                type="password"
                autocomplete="off"/>
          </el-form-item>
          <el-form-item>
            <el-button style="transition: width 0.2s ease-in-out;" type="primary"
                       @click="!isEmailCorrect? verifyEmail() : (isEmailValidate? resetPassWord() : verifyCode());">
              {{!isEmailValidate? "Verify": "Submit new password"}}
            </el-button>
            <el-button v-show="isEmailCorrect" @click="resetForm(ruleFormRef)">Reset</el-button>
          </el-form-item>
        </el-form>
        <div style = "display: flex; flex-direction: row; padding-left: 80px;">
            <span style = "padding-right: 5px">
              Already have an account?
            </span>
            <span @click = "goToLogin" style="color: grey; cursor: pointer">
              Login here
            </span>
            <span v-show="isEmailCorrect" @click = "isEmailCorrect = false + setActiveZero()" style="color: grey; cursor: pointer;padding-left: 10px; align-items: end">
              Not your email?
            </span>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
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