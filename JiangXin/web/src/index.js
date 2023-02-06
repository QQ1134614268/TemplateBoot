import {createRouter, createWebHistory} from "vue-router";
import {Admin, DecorationPlan, Home, Info, MessageBoard, root, save} from "@/views";
import {ImgType} from "@/views/api";

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
        path: Admin,
        component: () => import('./views/admin/Admin'),
    },
    {
        path: ImgType,
        component: () => import('./views/admin/domin/ImgType'),
    },
    {
        path: save,
        component: () => import('./views/save'),
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