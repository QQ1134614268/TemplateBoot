import {createApp} from 'vue'
import App from './App.vue'
import router from './index'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import './assets/global.css'

const app = createApp(App);
app.config.errorHandler = (err) => {
    /* handle error */
};

app.use(router).use(ElementPlus).mount('#app')
