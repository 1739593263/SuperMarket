import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

const home = () => import("@/view/main/main");
const category = () => import("@/view/class/class");
const cart = () => import("@/view/cart/cart");
const personal = () => import("@/view/personal/personal");

Vue.use(Router);

const routes = [
  {
    path: '',
    redirect: '/home'
  },
  {
    path: '/home',
    name: 'main',
    component: home
  },
  {
    path: '/class',
    name: 'category',
    component: category
  },
  {
    path: '/cart',
    name: 'cart',
    component: cart
  },
  {
    path: '/personal',
    name: 'personal',
    component: personal
  },
]

export default new Router({
  routes,
  mode: "history",
})
