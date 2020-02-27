<template>
  <div class="slide">
    <transition>
      <div v-if="isShow" :class="{reverse}">
        <slot></slot>
      </div>
    </transition>
  </div>
</template>

<script>
  export default {
    name: "slide",
    props:{
      name:{
        type:String,
        default:'',
        required:true,
      }
    },
    data(){
      return{
        selected:'',
        reverse:''
      }
    },
    computed:{
      isShow(){
        return this.selected === this.name;
      }
    }
  }
</script>

<style scoped>
  .v-enter-active, .leave-active {
    transition: all 0.5s ease-in-out;
  }
  .v-leave-to {
    transform: translate(100%);
  }
  .v-enter {
    transform: translate(-100%);
  }
  .v-leave-to.reverse {
    transform: translate(-100%);
  }
  .v-enter.reverse {
    transform: translate(100%);
  }
  .v-enter-active{
    position: absolute;
    width: 100%;
    top: 0px;
    left: 0px;
  }

  .slide {
    width: 100%;
    flex-shrink: 0;
  }

  .slide img {
    width: 100%;
  }
</style>
