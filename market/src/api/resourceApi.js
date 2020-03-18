import {request} from "../utils/request";

export function swiperApi(config) {
  return request({
    url: "/resources/swiper",
  })
}

export function controltab(type,page){
  return request({
    url:"/resources/tabItem",
    params:{
      type,
      page
    }
  })
}

export function animalRes(){
  return request({
    url:"/resources/animals",
  })
}
