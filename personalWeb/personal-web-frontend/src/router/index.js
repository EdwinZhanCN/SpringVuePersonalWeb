import  {createRouter, createWebHistory} from 'vue-router'

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
            name:'login',
            component: () => import('@/login-welcome.vue'),
            children:[
                {
                    path: '',
                    name: 'login',
                    component: () => import('@/components/login-page.vue')

                },{
                    path:'/register',
                    name:'Register',
                    component: () => import("@/components/RegisterPage.vue")
                }]
        },
        {
            path:'/album-gallery',
            name:'album-gallery',
            component: () => import('@/components/albumGallery.vue')
        },
    ]

})

export default router;
