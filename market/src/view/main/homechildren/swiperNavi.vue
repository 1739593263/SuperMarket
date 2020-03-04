<template>
  <div class="recommends">
    <div v-for="item in recommends" class="recommends-item">
      <a href="#">
        <img :src="item.image" alt=""/>
        <div>{{item.name}}</div>
      </a>
    </div>
  </div>
</template>

<script>
  export default {
    name: "swiperNavi",
    props:{
      recommends:{
        type:Array,
        default(){
         return [];
        },
      }
    },

  }
</script>

<style scoped>
  .recommends{
    display: flex;
    width: 100%;
    font-size: 12px;
    text-align: center;

    padding: 15px 0 0 0;
    border-bottom: 8px solid #eee;
  }
  .recommends-item{
    /* distribute evenly */
    flex: 1;
  }

  .recommends-item img {
    width: 70px;
    height: 70px;
    border-radius: 50%;
    border: #666666;
    margin-bottom: 10px;

  }
</style>
