<template>
  <div id="home">
    <Nav-Bar class="home-nav">
      <div slot="center">Shopping center</div>
    </Nav-Bar>
<!--    <swiper>-->
<!--      <swiper-item v-for="item in banners"></swiper-item>-->
<!--    </swiper>-->
    MAIN HOME
    <swiper v-model="selected">
      <swiper-item name="item1">
        <div class="itembox">item 1</div>
      </swiper-item>
      <swiper-item name="item2">
        <div class="itembox">item 2</div>
      </swiper-item>
      <swiper-item name="item3">
        <div class="itembox">item 3</div>
      </swiper-item>
    </swiper>
  </div>
</template>

<script>
  import NavBar from "@/components/common/navibar/NavBar";
  import {Swiper, SwiperItem} from "@/components/common/swiper/index"

  export default {
    name: "home",
    data(){
      return{
        banners:[],
        recommends:[],
        selected:'item1',
      }
    },
    created(){

    },
    components:{
      NavBar,
      Swiper,
      SwiperItem
    }
  }
</script>

<style scoped>
  .home-nav {
    background-color: darkgray;
    color: white;
  }
</style>
