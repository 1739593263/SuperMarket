<template>
  <div id="home" class="wrapper">
    <Nav-Bar class="home-nav">
      <div slot="center">Wild Life</div>
    </Nav-Bar>
    <scroll class="content"
            ref="scroll"
            :probType='1'
            :pull-up-load="true"
            @position="showPosition"
            @pageload="loadmore">
      <!--    <swiper>-->
      <!--      <swiper-item v-for="item in banners"></swiper-item>-->
      <!--    </swiper>-->
      <main-swiper :banners="banners"/>
      <swiper-navi :recommends="recommends"/>
      <feature-img/>
      <tabcontrol :titles="['herbivore','carnivore','poikilotherm','omnivore']" @tabclick="tabClick"/>
      <animals :animals="this.lifes[point].list"/>
    </scroll>
    <backtop @click.native="backClick()" v-show="isShow"/>
  </div>
</template>

<script>
  import {debounce} from '@/common/utils';

  import {swiperApi,controltab,animalRes} from '@/api/resourceApi';

  import NavBar from "@/components/common/navibar/NavBar";
  import Scroll from "@/components/common/scroll/Scroll";
  import tabcontrol from "@/components/content/tabcontrol/tabcontrol";
  import animals from "@/components/content/animalItems/animals";
  import backtop from "@/components/content/backtop/backtop";

  import swiperNavi from "./homechildren/swiperNavi";
  import FeatureImg from "./homechildren/imgblewNavi";
  import mainSwiper from "@/view/main/homechildren/mainSwiper";

  export default {
    name: "home",
    data(){
      return{
        banners:[],
        recommends:[],
        lifes:{
          "herbivore":{page:0, list:[]},
          "carnivore":{page:0, list:[]},
          "poikilotherm":{page:0, list:[]},
          "omnivore":{page:0, list:[]},
        },
        animals:[],
        point:'herbivore',
        isShow: false,
        mainPages:{
          "herbivore":0,
          "carnivore":0,
          "poikilotherm":0,
          "omnivore":0,
        }
      }
    },
    methods:{
      tabClick(click){
        this.point = click;
      },

      getMultidata(){
        swiperApi().then(res => {
          this.banners = res.map.resources.list;
          this.recommends = res.map.recommends.list;
          // console.log(this.recommends);
          // console.log(this.banners.length);
          // console.log("length="+this.banners.length);
          // for(i=1;i<this.banners.length;i++){
          //   console.log(i);
          // }
        });
      },

      getwildlifes(type){
        const page = this.lifes[type].page+1;
        controltab(type, page).then(res => {
          this.mainPages[type] = res.map.tab.mainPage;
          this.lifes[type].list.push(...res.map.tab.data.list);  //pushed the list from backend to the lifes[type].list.
          this.lifes[type].page+=1;  //and add extra page to contain more data.
          // console.log(res);

          this.$refs.scroll.finishScroll();
        }).catch(err => {
          console.log(err);
        })
      },

      getAnimalsInfo(){
        animalRes().then(res => {
          this.animals = res.map.animals;
          // console.log(res.map.animals['poikilotherm']);
        }).catch(err => {
          console.log(err);
        })
      },

      backClick(){
        this.$refs.scroll.backTo(0, 0, 500)
      },

      showPosition(position){
        this.isShow = -position.y > 500;
      },

      loadmore(){
        // console.log("load more "+this.point);
        const sumP = this.mainPages[this.point];
        let nowP = this.lifes[this.point].page;
        if(sumP > nowP){
          this.getwildlifes(this.point);
        }else if (sumP == nowP){
          console.log("it's over");
        }
      },


    },
    mounted(){
      const refresh = debounce(this.$refs.scroll.refresh, 500);
      console.log(debounce(this.$refs.scroll.refresh, 500));
      this.$bus.$on("imageload", () => {
        console.log('----');

        refresh();
      })
    },
    // created a life cycle function
    created() {
      this.getMultidata();

      this.getwildlifes('herbivore');
      this.getwildlifes('carnivore');
      this.getwildlifes('poikilotherm');
      this.getwildlifes('omnivore');

      this.getAnimalsInfo();

    },
    components:{
      swiperNavi,
      controltab,
      animalRes,

      NavBar,
      Scroll,
      tabcontrol,
      animals,
      backtop,

      FeatureImg,
      mainSwiper,
    }
  }
</script>

<style scoped>
  #home {
    /*viewport height*/
    /*height: 100vh;*/
  }

  .home-nav {
    background-color: darkgray;
    color: white;
  }

  .content {
    /*height: calc(100% - 93vh);*/
    position: absolute;
    right: 0;
    left: 0;
    top: 44px;
    bottom: 49px;
    overflow: hidden;
  }
</style>
