<template>
  <div class="animals">
    <animalicons v-for="(item,index) in animals" :animalItem="item" :key="index"/>
  </div>
</template>

<script>
  import animalicons from "./animalitems";

  export default {
    name: "animals",
    components:{
      animalicons,
    },
    props:{
      animals:{
        type:Array,
        default(){
          return [];
        },
      }
    },

  }
</script>

<style scoped>
  .animals {
    margin-top: 5px;
    display: flex;
    flex-wrap: wrap;
  }
</style>
