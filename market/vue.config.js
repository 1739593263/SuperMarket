const path = require("path");

module.exports = {
  configureWebpack: {
    resolve: {
      alias: {
        // "@":"src",  this alia was defined in vue file(prototype).
        "assets":"@/assets",
        "common":"@/common",
        "components":"@/components",
        "network":"@/network",
        "store":"@/store",
        "view":"@/view",
      }
    }
  },
  devServer: {
    // open:false,
    // host: '0.0.0.0',
    // port:8080,
    // https:false,
    // hot:true,
    // hotOnly:false,
    // proxy: {
    //   '/api': {
    //     target: 'https://localhost:8080/test/data',//设置你调用的接口域名
    //     changeOrigin: true,
    //     pathRewrite: {
    //       '^/api': '/'//这里理解成用‘/api’代替target里面的地址，后面组件中我们掉接口时直接用api代替 比如我要调用'http://m.kugou.com/rank/info/?rankid=23784&page=1&json=true'，直接写‘/api/rank/info/?rankid=23784&page=1&json=true’即可
    //     }
    //   }
    // },
    // overlay:{
    //   warnings:true,
    //   errors:true,
    // },
  }
}

