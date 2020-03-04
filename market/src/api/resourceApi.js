import {request} from "../utils/request";

export function swiperApi(config) {
  return request({
    url: "/resources/swiper",
  })
}
