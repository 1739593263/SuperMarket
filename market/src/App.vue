<template>
  <div id="app">
    <main-tab-bar/>
    <router-view/>
    <h1>{{message}}</h1>
    <button @click="request">request</button>
  </div>
</template>

<script>
  import mainTabBar from './components/content/mainTabber/mainTabBar'
  import {testApi} from '@/api/testApi'

  export default {
    name: 'App',
    data(){
      return{
        message:"hello",
      }
    },
    components:{
      mainTabBar,
      testApi,
    },
    methods:{
      request(){
        console.log("lalala");
        testApi().then(res => {
          console.log(res);
        }).catch(err => {
          console.log(err);
        });
        // testApi({
        //   url:'test/data',
        // }).then(res => {
        //   console.log(res);
        // }).catch(err => {
        //   console.log(err);
        // });
      }
    }
  };

</script>
<!--after define alias in vue.config.js, import address can drop './'-->
<style>
  @import "assets/css/base.css";
</style>
