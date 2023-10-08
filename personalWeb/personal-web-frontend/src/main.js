import './assets/main.css'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import { createApp } from 'vue'
import router from '@/router/index.js'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import { createPinia } from 'pinia';

import App from './APP.vue'
import axios from "axios";
const app = createApp(App)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}
axios.defaults.baseURL = "http://localhost:8080"
app.use(ElementPlus)
app.use(createPinia())
app.use(router)
app.mount('#app')
