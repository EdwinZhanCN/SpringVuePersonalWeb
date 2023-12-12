import './assets/main.css'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import { createApp } from 'vue'
import router from '@/router/index.js'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import { createPinia } from 'pinia';
import vue3SeamlessScroll from "vue3-seamless-scroll";

import App from './App.vue'
import axios from "axios";
import { library } from '@fortawesome/fontawesome-svg-core'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faForward } from "@fortawesome/free-solid-svg-icons";
import{faBackward} from "@fortawesome/free-solid-svg-icons";
import{faShuffle} from "@fortawesome/free-solid-svg-icons";
import {faRepeat} from "@fortawesome/free-solid-svg-icons";
import {faComments} from "@fortawesome/free-solid-svg-icons";
import {faStar} from "@fortawesome/free-solid-svg-icons";
import { fas } from "@fortawesome/free-solid-svg-icons";
import { faUserSecret } from '@fortawesome/free-solid-svg-icons'
import { far } from '@fortawesome/free-regular-svg-icons'


/* add icons to the library */
library.add(faUserSecret)
library.add(fas)
library.add(faForward)
library.add(faBackward)
library.add(faShuffle)
library.add(faRepeat)
library.add(faComments)
library.add(faStar)
library.add(far)


const app = createApp(App)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}

axios.defaults.baseURL = "http://localhost:8080"
app.use(ElementPlus)
app.use(createPinia())
app.use(vue3SeamlessScroll)
app.use(router)
app.component('font-awesome-icon', FontAwesomeIcon)
    .mount('#app')
