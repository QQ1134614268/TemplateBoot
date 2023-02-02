import {createRouter, createWebHistory} from "vue-router";

const routes = [
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
