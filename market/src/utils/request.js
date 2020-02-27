import axios from "axios";
import cors from 'cors'

export function request(config){

  const instance = axios.create({
    baseURL:"http://localhost:8080",
    timeout:5000,
  });

  instance.interceptors.request.use(config => {
    console.log(config);
    return config;
  },error => {
    console.log(error);
  });

  instance.interceptors.response.use(res => {
    return res.data
  }, error => {
    console.log(error);
  })

  return instance(config)
}


// ;(async () => {
//    const response = await axios({
//      url: 'https://dog.ceo/api/breeds/list/all',
//      method: 'get'
//    })
//    console.log(response)
//  })()
//
//  axios.defaults.baseURL = 'http://localhost:8080';
// //unit: millisecond
//  axios.defaults.timeout = 5000;
//
//  axios({
//    url: "/test/data",
//    timeout:1000,
//    // method:"post"
//    headers:{
//      'Content-Type': 'application/json',
//      // 'Accept': 'application/json',
//      'Access-Control-Allow-Origin': 'http://localhost:8080/',
//      'Access-Control-Allow-Methods': 'GET,HEAD,OPTIONS,POST,PUT',
//      'Access-Control-Allow-Headers': 'Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers'
//    },
//  }).then(res => {
//    console.log(res);
//  }).catch(err => {
//    console.log(err);
//  });
//
//  axios.all([axios({
//    url:'/test/data'
//  }),axios({
//    url:'/test/multidata',
//    params:{
//      username:1234567,
//      password:"invulnerable hacks",
//    }
//  })]).then(axios.spread((res1,res2) => {
//    console.log(res1);
//    console.log(res2);
//  })).catch(err => {
//    console.log(err);
//  });
//  axios.create();


