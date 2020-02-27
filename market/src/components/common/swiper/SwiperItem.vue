<template>
  <div class="slide">
    <div v-if="isShow">
      <slot></slot>
    </div>
  </div>
</template>

<script>
  export default {
    name: "slide",
    props:{
      name:{
        type: String,
        default:"",
        required:true,
      }
    },
    data(){
      return{
        selected:''
      }
    },
    computed:{
      isShow(){
        console.log(this.selected);
        return  this.selected === this.name;
      }
    }
  }
</script>

<style scoped>
  .slide {
    width: 100%;
    flex-shrink: 0;
  }

  .slide img {
    width: 100%;
  }
</style>
