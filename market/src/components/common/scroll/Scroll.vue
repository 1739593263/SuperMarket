<template>
  <div class="wrap" ref="sw">
    <div class="content">
      <slot></slot>
    </div>
  </div>
</template>

<script>
  import BScroll from "better-scroll";

  export default {
    name: "Scroll",
    props:{
      probType:{
        type: Number,
        default: 0,
      },
      pullUpLoad:{
        type: Boolean,
        default: false
      }
    },
    data(){
      return{
        wrap: null,
        scroll: null,
      }
    },
    mounted(){
      this.$nextTick(() => {
        this.wrap = this.$refs.sw;
        this.scroll = new BScroll(this.wrap, {
          probeType: this.probeType,
          pullUpLoad: this.pullUpLoad,
          click: true,
        });

        this.scroll.on('scroll',(position) => {
          this.$emit("position", position);
          // console.log(position);
        });

        if(this.pullUpLoad){
          this.scroll.on('pullingUp',() => {
            this.$emit("pageload");
          })
        }
      });
    },
    methods:{
      backTo(x, y, time=0){
        if(!time){
          // judge if scroll has value of scrollTo has value before run the function(this.scroll.scrollTo(x, y))
          this.scroll && this.scrollTo() && this.scroll.scrollTo(x, y);
        }else{
          this.scroll && this.scrollTo() && this.scroll.scrollTo(x, y, time);
        }
      },

      refresh(){
        this.scroll && this.scroll.refresh();
      },

      finishScroll(){
        this.scroll && this.scroll.finishPullUp();
      }
    }
  }
</script>

<style scoped>

</style>
