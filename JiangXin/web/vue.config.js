const {defineConfig} = require('@vue/cli-service')
module.exports = defineConfig({
    transpileDependencies: true,
    lintOnSave: "warning", // eslint 告警级别
    devServer: {
        open: true,
        host: "0.0.0.0",
        port: process.env.PORT,
        https: false,
        historyApiFallback: true,
        allowedHosts: "all",
        proxy: {
            "^/api/": {
                target: process.env.VUE_APP_BASE_URL,
                changeOrigin: true,
                pathRewrite: { // 路径重写
                    '^/api/': '/api/'
                }
            },
            // "/upload_file/": {
            //     target: process.env.NGINX_FILE_SERVER_URL,
            //     changeOrigin: true,
            //     pathRewrite: {
            //         '^/upload_file/': process.env.NGINX_FILE_SERVER_API
            //     }
            // }
        }
    },
})
