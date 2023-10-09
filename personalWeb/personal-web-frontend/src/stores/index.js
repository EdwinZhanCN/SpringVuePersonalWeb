import { defineStore } from 'pinia';
import { reactive } from 'vue';
export const useStore = defineStore('store', () => {
   const auth = reactive({
       user: null
   })
    const images = reactive({
        image: []
    })
    return {auth, images}
})