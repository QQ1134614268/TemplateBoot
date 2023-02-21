import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import './assets/global.css'
import '@/assets/g2.css'
import '@/assets/g3.css'

Vue.config.productionTip = false

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')