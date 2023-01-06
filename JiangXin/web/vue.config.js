// import {NGINX_FILE_SERVER_API, NGINX_FILE_SERVER_URL, PORT, VUE_APP_BASE_URL} from "@/api/config";
const {defineConfig} = require('@vue/cli-service')
const VUE_APP_BASE_URL = process.env.VUE_APP_BASE_URL
const PORT = process.env.PORT
const NGINX_FILE_SERVER_URL = process.env.NGINX_FILE_SERVER_URL
const NGINX_FILE_SERVER_API = process.env.NGINX_FILE_SERVER_API

module.exports = defineConfig({
    transpileDependencies: true,
    lintOnSave: "warning", // eslint 告警级别
    devServer: {
        open: true,
        host: "0.0.0.0",
        port: PORT,
        https: false,
        historyApiFallback: true,
        allowedHosts: "all",
        proxy: {
            "^/api/": {
                target: VUE_APP_BASE_URL,
                changeOrigin: true,
                // pathRewrite: { // 路径重写
                //     '^/api/': '/api/'
                // }
            },
            "/upload_file/": {
                target: NGINX_FILE_SERVER_URL,
                changeOrigin: true,
                pathRewrite: {
                    '^/upload_file/': NGINX_FILE_SERVER_API
                }
            }
        }
    },
})
