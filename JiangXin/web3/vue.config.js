const {defineConfig} = require('@vue/cli-service')
module.exports = defineConfig({
    transpileDependencies: true,
    lintOnSave: "warning", // eslint 告警级别
    devServer: {
        // hot: true,
        // contentBase:"/",
        open: true, // 浏览器自动打开， 打包后
        // useLocalIp: true, // 浏览器自动打开时 使用本机ip 报错
        host: "127.0.0.1",
        allowedHosts: "all",
        port: process.env.PORT,
        https: false,
        historyApiFallback: true,
        proxy: {
            "^/api/": {
                target: process.env.VUE_APP_BASE_URL,
                changeOrigin: true,
                pathRewrite: { // 路径重写
                    '^/api/': '/api/'
                }
            },
        }
    },
})
