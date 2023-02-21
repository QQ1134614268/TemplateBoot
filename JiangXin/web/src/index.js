import {createRouter, createWebHistory} from "vue-router";
import {adminSave, DecorationPlan, HomeDoor, ImgAdmin, Info, root} from "@/views";
import {admin, AdminHome, adminLogin, AdminMessageBoard, Home, ImgType} from "@/views/api";

export const routes = [
    {
        path: root,
        redirect: HomeDoor,
    },
    {
        path: HomeDoor,
        component: () => import('@/views/HomeDoor'),
        redirect: Home,
        children: [
            {
                path: Home,
                component: () => import('@/views/Home'),
            },
            {
                path: Info,
                component: () => import('@/views/Info'),
            },
            {
                path: DecorationPlan,
                component: () => import('@/views/DecorationPlan'),
            },
        ]
    },
    {
        path: admin,
        component: () => import('@/views/admin/Home'),
        redirect: ImgType,
        children: [
            {
                path: AdminHome,
                component: () => import('@/views/admin/Home'),
                children: []
            },
            {
                path: ImgAdmin,
                component: () => import('@/views/admin/ImgAdmin'),
            },
            {
                path: ImgType,
                component: () => import('@/views/admin/ImgType'),
            },
            {
                path: AdminMessageBoard,
                component: () => import('@/views/admin/MessageBoard'),
            },
            {
                path: adminSave,
                component: () => import('@/views/admin/save'),
            },
        ]
    },
    {
        path: adminLogin,
        component: () => import('@/views/admin/Login'),
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