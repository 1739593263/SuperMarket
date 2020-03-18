<template>
  <div class="animal-items">
    <img :src="animalItem.url" alt="" @load="imageload">
    <div class="animal-info">
      <span class="origin"><b>origin:</b>{{animalItem.origin}}</span>
      <span class="genus"><b>genus:</b>{{animalItem.genus}}</span>
      <span class="info"><b>Info:</b>{{animalItem.Info}}</span>
    </div>
  </div>
</template>

<script>
  export default {
    name: "animalitems",
    props:{
      animalItem:{
        type:Object,
        default(){
          return [];
        },
      }
    },
    methods:{
      imageload(){
        this.$bus.$emit("imageload")
      }
    }
  }
</script>

<style scoped>
  .animal-items {
    padding-bottom: 35px;
    position: relative;
    margin-left: 20px;

    width: 150px;
  }

  .animal-items img {
    /*height: 150px;*/
    width: 100%;
    border-radius: 5px;
  }

  .animal-items .animal-info {
    position: absolute;
    font-size: 12px;
    left: 0;
    right: 0;
    overflow: scroll;
    text-align: left;
    padding-top: 15px;
    width: 100%;
    bottom: 8px;
  }

  .info {
    text-overflow: ellipsis;
    margin-bottom: 3px;
    white-space: nowrap;
  }

  origin .genus {
    position: relative;
  }

  .origin .genus ::after {
    position: absolute;
    left: -15px;
    top:-1px;
    width: 14px;
    height: 14px;
    background: url("../../../assets/magnify.jpg") 0 0/14px 14px;
  }
</style>
