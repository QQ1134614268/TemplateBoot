import Vue from 'vue'
import VueRouter from 'vue-router'
import {adminSave, DecorationPlan, HomeDoor, ImgAdmin, Info, root} from "@/views";
import {admin, AdminHome, adminLogin, AdminMessageBoard, Home, ImgType} from "@/views/api";

Vue.use(VueRouter)

export const routes = [
    {
        path: root,
        redirect: HomeDoor,
    },
    {
        path: HomeDoor,
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import('@/views/HomeDoor'),
        // component: HomeView
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

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
