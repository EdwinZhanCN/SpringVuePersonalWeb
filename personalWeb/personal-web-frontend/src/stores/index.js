import { defineStore } from 'pinia';
import { reactive } from 'vue';
export const useStore = defineStore('store', () => {
   const auth = reactive({
       user: null
   })
    const isCache = reactive({
        isCache: false
    })

    const active = reactive({
        active:null
    })
    return {auth, isCache, active}
})