<template>
  <div id="mSwiper">
    <swiper v-model="selected" autoplay>
      <swiper-item v-for="(item,index) in banners" :name="item.name" :key="index">
        <img :src="item.image" alt="">
      </swiper-item>
<!--      <swiper-item name="item1">-->
<!--&lt;!&ndash;        <div class="itembox">item 1</div>&ndash;&gt;-->
<!--        <img :src="banners.url1" alt="elephant">-->
<!--      </swiper-item>-->
<!--      <swiper-item name="item2">-->
<!--&lt;!&ndash;        <div class="itembox">item 2</div>&ndash;&gt;-->
<!--        <img :src="banners.url2" alt="panther">-->
<!--      </swiper-item>-->
<!--      <swiper-item name="item3">-->
<!--&lt;!&ndash;        <div class="itembox">item 3</div>&ndash;&gt;-->
<!--        <img :src="banners.url3" alt="wolf">-->
<!--      </swiper-item>-->
    </swiper>
  </div>
</template>

<script>
  import {Swiper, SwiperItem} from "@/components/common/swiper/index";

  export default {
    name: "mainSwiper",
    props:{
      banners:{
        type:Array,
        default(){
          return [];
        }
      },
    },
    data(){
      return{
        selected:'item1'
      }
    },
    methods:{
      give(index){
        return "item"+index
      }
    },

    components:{
      Swiper,
      SwiperItem,
      // swiperNavi
    },
  }
</script>

<style scoped>
  #mSwiper{
    padding-top: 40px;
  }

  img{
    height: 200px;
    width: 100%;
  }
</style>
