<template>
  <div id="home">
    <Nav-Bar class="home-nav">
      <div slot="center">Wild Life</div>
    </Nav-Bar>
<!--    <swiper>-->
<!--      <swiper-item v-for="item in banners"></swiper-item>-->
<!--    </swiper>-->
    <main-swiper :banners="banners"/>
    <swiper-navi :recommends="recommends"/>
    <feature-img/>
    <tabcontrol :titles="['herbivore','carnivore','poikilotherm','omnivore']"></tabcontrol>
    <ul>
      <li>title1</li>
      <li>title2</li>
      <li>title3</li>
      <li>title4</li>
      <li>title5</li>
      <li>title6</li>
      <li>title7</li>
      <li>title8</li>
      <li>title9</li>
      <li>title10</li>
      <li>title11</li>
      <li>title12</li>
      <li>title13</li>
      <li>title14</li>
      <li>title15</li>
      <li>title16</li>
      <li>title17</li>
      <li>title18</li>
      <li>title19</li>
      <li>title20</li>
      <li>title21</li>
      <li>title22</li>
      <li>title23</li>
      <li>title24</li>
      <li>title25</li>
      <li>title26</li>
      <li>title27</li>
      <li>title28</li>
      <li>title29</li>
      <li>title30</li>
    </ul>
  </div>
</template>

<script>
  import NavBar from "@/components/common/navibar/NavBar";
  import {swiperApi} from '@/api/resourceApi';
  import tabcontrol from "@/components/content/tabcontrol/tabcontrol";

  import swiperNavi from "./homechildren/swiperNavi";
  import FeatureImg from "./homechildren/imgblewNavi";
  import mainSwiper from "@/view/main/homechildren/mainSwiper";

  export default {
    name: "home",
    data(){
      return{
        banners:[],
        recommends:[],
      }
    },
    methods:{

    },
    // created a life cycle function
    created() {
      swiperApi().then(res => {
        console.log(res);
        this.banners = res.map.resources.list;
        this.recommends = res.map.recommends.list;
        console.log(this.recommends);
        // console.log(this.banners.length);
        // console.log("length="+this.banners.length);
        // for(i=1;i<this.banners.length;i++){
        //   console.log(i);
        // }
      });
    },
    components:{
      NavBar,
      tabcontrol,

      swiperNavi,
      FeatureImg,
      mainSwiper,
    }
  }
</script>

<style scoped>
  .home-nav {
    background-color: darkgray;
    color: white;
  }
</style>
