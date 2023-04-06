import Vue from 'vue'
import VueRouter from 'vue-router'

//测试
export const HelloRootUrl = "/test"
export const test_box = "/test/test_box"
export const BgColor = '/test/BgColor'
const routes = [
    {
        path: "/",
        component: () => import('@/views/TestHome')
    },
    {
        path: test_box,
        component: () => import('@/views/test_box')
    },
    {
        path: BgColor,
        component: () => import('@/views/BgColor')
    },
    {
        path: '/test/test_navmenu',
        component: () => import('@/views/test_navmenu')
    },
    {
        path: '/test/testHeader',
        component: () => import('@/views/testHeader')
    },
    {
        path: '/test/test_vue-cropper',
        component: () => import('@/components/WrdVueCropper')
    },
    {
        path: '/test/home',
        component: () => import('@/views/TestHome')
    },
    {
        path: '/test/test_object_fit',
        component: () => import('@/views/test_object_fit')
    },
    {
        path: '/test/form_check',
        component: () => import('@/views/test_form_check')
    },
    {
        path: '/test/test_input',
        component: () => import('@/views/test_form')
    },
    {
        path: '/test/test',
        component: () => import('@/views/test_v_model')
    },
    {
        path: '/test/test_component',
        component: () => import('@/views/test_component')
    },
    {
        path: '/test/test_popup',
        component: () => import('@/views/test_popup')
    },
    {
        path: '/test/test_echarts',
        component: () => import('@/views/test_echarts')
    },
    {
        path: '/test/flex-test',
        component: () => import('@/views/flex-test')
    },
    {
        path: '/test/test_search',
        component: () => import('@/views/test_search')
    },
    {
        path: '/test/test_search_page',
        component: () => import('@/views/test_search_page')
    },
    {
        path: '/test/test_upload',
        component: () => import('@/views/test_upload')
    },
    {
        path: '/test/parent_child/Parent',
        component: () => import('@/views/parent_child/Parent')
    },
    {
        path: '/test/parent_child/v_model/Parent',
        component: () => import('@/views/parent_child/v_model/Parent')
    },
    {
        path: '/test/parent_child/v_model2/Parent',
        component: () => import('@/views/parent_child/v_model2/Parent')
    },
    {
        path: '/test/test_img_highlight',
        component: () => import('@/views/test_img_highlight')
    },
]
Vue.use(VueRouter)
const router = new VueRouter({
    mode: 'history',
    routes: routes
})
export {routes, router}
