//测试
export const HelloRootUrl = "/hello"
export const test_box = "/test_box"
export const BgColor = '/BgColor'

const routes = [
    {
        path: HelloRootUrl,
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
        path: '/test_navmenu',
        component: () => import('@/views/test_navmenu')
    },
    {
        path: '/testHeader',
        component: () => import('@/views/testHeader')
    },
    {
        path: '/test_vue-cropper',
        component: () => import('@/components/WrdVueCropper')
    },
    {
        path: '/home',
        component: () => import('@/views/TestHome')
    },
    {
        path: '/test_object_fit',
        component: () => import('@/views/test_object_fit')
    },
    {
        path: '/form_check',
        component: () => import('@/views/test_form_check')
    },
    {
        path: '/test_input',
        component: () => import('@/views/test_form')
    },
    {
        path: '/hello',
        component: () => import('@/views/Hello')
    },
    {
        path: '/test_component',
        component: () => import('@/views/test_component')
    },
    {
        path: '/test_popup',
        component: () => import('@/views/test_popup')
    },
    {
        path: '/test_echarts',
        component: () => import('@/views/test_echarts')
    },
    {
        path: '/flex-test',
        component: () => import('@/views/flex-test')
    },
    {
        path: '/test_search',
        component: () => import('@/views/test_search')
    },
    {
        path: '/test_search_page',
        component: () => import('@/views/test_search_page')
    },
    {
        path: '/test',
        component: () => import('@/views/test')
    },
    {
        path: '/test_upload',
        component: () => import('@/views/test_upload')
    },
    {
        path: '/parent_child/Parent',
        component: () => import('@/views/parent_child/Parent')
    },
    {
        path: '/test_img_highlight',
        component: () => import('@/views/test_img_highlight')
    },
]
export default routes

