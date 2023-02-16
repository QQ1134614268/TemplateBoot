import {createRouter, createWebHistory} from "vue-router";
import {DecorationPlan, Home, ImgAdmin, Info, MessageBoard, root, save} from "@/views";
import {admin, AdminHome, adminLogin, AdminMessageBoard, ImgType} from "@/views/api";

export const routes = [
    {
        path: root,
        component: () => import('./views/save'),
    },
    {
        path: Home,
        component: () => import('./views/Home'),
    },
    {
        path: MessageBoard,
        component: () => import('./views/MessageBoard'),
    },
    {
        path: Info,
        component: () => import('./views/Info'),
    },
    {
        path: DecorationPlan,
        component: () => import('./views/DecorationPlan'),
    },
    {
        path: admin,
        component: () => import('./views/admin/Home'),
        children: [
            {
                path: AdminHome,
                component: () => import('./views/admin/Home'),
                children: []
            },
            {
                path: ImgAdmin,
                component: () => import('./views/admin/ImgAdmin'),
            },
            {
                path: ImgType,
                component: () => import('./views/admin/ImgType'),
            },
            {
                path: AdminMessageBoard,
                component: () => import('./views/admin/MessageBoard'),
            },
            {
                path: save,
                component: () => import('./views/admin/save'),
            },
        ]
        // redirect: workTimeInfo,
        // redirect: "/worker/home",
    },

    {
        path: adminLogin,
        component: () => import('./views/admin/Login'),
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});
// import {TOKEN} from "./api/config";
// import {SYS_LOGIN_URL} from "./api/api";
// router.beforeEach((to, from, next) => {
//     if (to.meta.login) {
//         let token = localStorage.getItem(TOKEN);
//         if (token === null || token === '') {
//             next(SYS_LOGIN_URL);
//         } else {
//             next();
//         }
//     } else {
//         next();
//     }
// });
export default router;