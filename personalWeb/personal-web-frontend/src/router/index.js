import {createRouter, createWebHistory} from 'vue-router'
import {useStore} from "@/stores";
import {get} from "@/net";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/idea',
            name:'idea',
            component: () => import("@/idea.vue"),
        },
        {
            path: '/',
            name:'main',
            component: () => import("@/main.vue"),
        },
        {
            path:'/login',
            name:'login-welcome',
            component: () => import('@/login-welcome.vue'),
            children:[
                {
                    path: '',
                    name: 'login-login',
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
            path:'/upload-image',
            name:'upload-image',
            component: () => import('@/components/upload-image.vue')
        },

    ]

})


router.beforeEach(async (to, from, next) => {
    const store = useStore();

    if (store.auth.user === null) {
        try {
            await new Promise((resolve, reject) => {
                get('api/user/me', (message) => {
                    store.auth.user = message;
                    resolve();
                }, () => {
                    store.auth.user = null;
                    resolve();
                });
            });
        } catch (error) {
            store.auth.user = null;
            // ... 错误处理逻辑
        }
    }

    if (store.auth.user != null && to.fullPath.startsWith('/login')) {
        next('/idea');
        console.log(store.auth.user);
    } else if (store.auth.user == null && to.fullPath.startsWith("/upload-image")) {
        next('/login');
        console.log(store.auth.user);
    } else if (to.matched.length === 0) {
        next("/idea");
        console.log(store.auth.user);
    } else {
        next();
        console.log(store.auth.user);
    }
});

export default router;
