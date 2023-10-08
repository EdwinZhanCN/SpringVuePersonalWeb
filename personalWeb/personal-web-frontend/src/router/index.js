import  {createRouter, createWebHistory} from 'vue-router'
import {useStore} from "@/stores";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name:'start',
            component: () => import("@/idea.vue"),
        },
        {
            path:'/login',
            name:'login-welcome',
            component: () => import('@/login-welcome.vue'),
            children:[
                {
                    path: '',
                    name: 'login-',
                    component: () => import('@/components/login-page.vue')

                },{
                    path:'/register',
                    name:'login-Register',
                    component: () => import("@/components/RegisterPage.vue")
                },{
                    path:'/forget-password',
                    name:'login-forgetPassword',
                    component:() =>import("@/components/forgetPage.vue")
                }]
        },
        {
            path:'/album-gallery',
            name:'album-gallery',
            component: () => import('@/components/albumGallery.vue')
        },

    ]

})

router.beforeEach((to, from, next)=>{
    const store = useStore()
    if(store.auth.user != null && to.name.startsWith('login-')){
        next('/')
    }else if(store.auth.user == null && to.fullPath.startsWith("/album-gallery")){
        next('/login')
    }else if(to.matched.length === 0){
        next("/")
    }else{
        next()
    }
})

export default router;
