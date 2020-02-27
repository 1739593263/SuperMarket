import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
// import express from 'express'

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App)
})


// const xhr = new XMLHttpRequest();
// const url = "https://192.168.56.1:8080/test/data";
// xhr.open('GET',url);
// xhr.onreadystatechange = someHandler;
// xhr.send();

// const app = express();
// app.use(express.json());
//
// app.get('/test/data', (req, res, next) => {
//   console.log(req);
// });
//
// app.listen(8080, () => {
//   console.log('CORS-enabled web server listening on port 8080')
// })


// console.log(process.env.BABEL_ENV);
