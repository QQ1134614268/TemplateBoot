import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import './assets/global.css'
import '@/assets/g2.css'
import '@/assets/g3.css'
import ElementUI from 'element-ui'; //全局引入element
import 'element-ui/lib/theme-chalk/index.css'; //全局引入element的样式

Vue.config.productionTip = false
Vue.use(ElementUI);     //全局注入element

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')