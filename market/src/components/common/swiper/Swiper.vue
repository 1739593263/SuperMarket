<template>
  <div>
    <div id="hy-swiper">
      <slot></slot>
      <div class="dot-list">
        <span v-for="(item,index) in names" :class="active" @click="todo(index)"></span>
      </div>
    </div>
    <div class="btn-list">
      <button @click="todo(active-1)"><b><</b></button>
      <button @click="todo(active+1)"><b>></b></button>
    </div>
<!--    <div class="swiper" @touchstart="touchStart" @touchmove="touchMove"-->
<!--    @touchend="touchEnd">-->
<!--      <slot></slot>-->
<!--    </div>-->
<!--    <slot name="indicator"></slot>-->
<!--    <div class="indicator">-->
<!--      <slot name="indicator" v-if="showIndicator && slidCount">-->
<!--        <div v-for="(item, index) in slideCount" class="indi-item" :class="{active:-->
<!--      index === currentIndex-1}" :key="index"></div>-->
<!--      </slot>-->
<!--    </div>-->
  </div>

</template>

<script>
  export default {
    props:{
      // values = selected in father module
      value:{
        type:String,
        default:'',
      }
    },
    data(){
      return{
        names:[],
        itemlen:0,
        curSelected:'',
        prePosition:0,
      }
    },
    mounted() {
      this.names = this.$children.map(children => children.name)
      this.itemlen = this.names.length;
      console.log(this.names);
      this.showChildren();
      this.run();
      // initiate
      this.prePosition = this.active
    },
    methods:{
      showChildren(){
        this.curSelected = this.value || this.name[0];
        this.$children.forEach(vm => {
          this.$nextTick(() => {
            vm.selected = this.curSelected;
          });
          // in this situation, user clicked '<' button which change 'active-1'
          // but after emit, prePosition was attached this.active. So, after emit, this.active
          // become to the value equal with 'active-1'. Of course that active>active-1, so it's false.
          vm.reverse = this.prePosition < this.active? true:false;
          // judge edge
          if(this.prePosition === 0 && this.active === this.itemlen-1){
            vm.reverse = false;
          };
          if(this.prePosition === this.itemlen-1 && this.active === 0){
            vm.reverse = true;
          }
        })
      },
      todo(nextItem){
        if(nextItem>this.itemlen-1) nextItem = 0;
        if(nextItem<0) nextItem = this.itemlen-1;
        this.prePosition = this.active;
        this.$emit('input', this.names[nextItem]);
      },
      run(){
        setInterval(() => {
          const index = this.active;
          const nextItem = (index+1>this.itemlen-1? 0:index+1);
          this.todo(nextItem)
        },10000)
      }
    },
    // spy/monitor
    watch:{
      value(){
        this.showChildren();
      }
    },
    computed:{
      active(){
        return this.names.indexOf(this.curSelected)
      }
    }

    // name: "Swiper",
    // props:{
    //   interval:{
    //     type:Number,
    //     default:3000,
    //   },
    //   animDuration:{
    //     type:Number,
    //     default:300
    //   },
    //   moveRatio:{
    //     type:Number,
    //     default:0.25
    //   },
    //   showIndicator:{
    //     type:Boolean,
    //     default:true,
    //   },
    //   data:function(){
    //     return{
    //       slideCount:0, // elements number
    //       totalWidth:0, // Swiper width
    //       swiperStyle:{}, // Swiper style
    //       currentIndex:1,
    //       scrolling: false,
    //     }
    //   },
    //   mounted: function(){
    //     setTimeout(() => {
    //       this.handleDom();
    //
    //       this.startTimer();
    //     },100)
    //   },
    //   methods:{
    //     startTimer:function () {
    //       this.playTimer = window.setInterval(() => {
    //         this.currentIndex++;
    //         this.scrollContent(-this.currentIndex*this.totalWidth)
    //       },this.interval)
    //     },
    //     stopTimer: function(){
    //       window.clearInterval(this.playTimer);
    //     },
    //
    //     // control the scroll position
    //     scrollContent: function (currentPosition) {
    //       //0. scrolling
    //       this.scrolling = true;
    //
    //       //1. start to scrolling
    //       this.swiperStyle.transition = 'transform'+this.animDuration+'ms';
    //       this.setTransform(currentPosition);
    //
    //       //2. detect position of scroll
    //       this.checkPosition();
    //
    //       //3. finish scroll
    //       this.scrolling = false;
    //     },
    //
    //     // detect position of scroll
    //     checkPosition: function(){
    //       window.setTimeout(() => {
    //         //1. check position
    //         this.swiperStyle.transition = '0ms';
    //         if (this.currentIndex >= this.slideCount+1){
    //           this.currentIndex = 1;
    //           this.setTransform(-this.currentIndex*this.totalWidth)
    //         } else if (this.currentIndex <= 0){
    //           this.currentIndex = this.slideCount;
    //           this.setTransform(-this.currentIndex*this.totalWidth)
    //         }
    //
    //         //2. call-back after scrolling
    //         this.$emit("transitionEnd", this.currentIndex-1);
    //       }, this.animDuration)
    //     },
    //
    //     // set position of scroll
    //     setTransform: function(position){
    //       this.swiperStyle.transform = 'translate3d(${position}px,0,0)'
    //       this.swiperStyle['-webkit-transform'] = 'translate3d(${position}px),0,0'
    //       this.swiperStyle['-ms-transform'] = 'translate3d(${position}px),0,0'
    //     },
    //
    //     // add slid into DOM
    //     handleDom: function () {
    //       //1. catch elements
    //       let swiperEl = document.querySelector('.swiper');
    //       let slidesEls = swiperEl.getElementsByClassName('slide');
    //
    //       //2. save object
    //       this.slideCount = slidesEls.length;
    //
    //       //3. if slideCount>1, separate them to two sides.
    //       if(this.slideCount > 1){
    //         let cloneFirst = slidesEls[0].cloneNode(true);
    //         let cloneLast = slidesEls[this.slideCount - 1].cloneNode(true);
    //         swiperEl.insertBefore(cloneLast, slidesEls[0]);
    //         swiperEl.appendChild(cloneFirst);
    //         this.totalWidth = swiperEl.offsetWidth;
    //         this.swiperStyle = swiperEl.style;
    //       }
    //     },
    //
    //     // boost deal event
    //     touchStart: function (e) {
    //       //1 can't be dragged while scrolling
    //       if(this.scrolling) return;
    //
    //       //2 stop timer
    //       this.stopTimer();
    //
    //       //3 save position where start scrolling
    //       this.startX = e.touches[0].pageX;
    //     },
    //
    //     touchMove: function (e) {
    //       // calculate distant user dragged
    //       this.currentX = e.touches[0].pageX;
    //       this.distance = this.currentX = this.startX;
    //       let currentPosition = -this.currentIndex*this.totalWidth;
    //       let moveDistance = this.distance + currentPosition;
    //
    //       // setting current position
    //       this.setTransform(moveDistance);
    //     },
    //
    //     touchEnd: function (e) {
    //       // 1. catch distant user dragged
    //       let currentMove = Math.ads(this.distance);
    //
    //       //2. judge final distance
    //       if(this.distance === 0){
    //         return
    //       } else if(this.distance > 0 && currentMove > this.totalWidth*this.moveRatio){
    //         // move right over 0.5
    //         this.currentIndex--
    //       } else if(this.distance < 0 && currentMove > this.totalWidth*this.moveRatio){
    //         // move left over 0.5
    //         this.currentIndex++
    //       }
    //
    //       //3. move to correct position
    //       this.scrollContent(-this.currentIndex*this.totalWidth);
    //
    //       //4. relaunch timer after moved
    //       this.startTimer();
    //     },
    //
    //     previous: function () {
    //       this.changeItem(-1);
    //     },
    //     next: function () {
    //       this.changeItem(1);
    //     },
    //
    //     changeItem: function (num) {
    //       //1. stop timer
    //       this.stopTimer();
    //
    //       //2. update index and position
    //       this.currentIndex+=num;
    //       this.scrollContent(-this.currentIndex*this.totalWidth);
    //
    //       //3. add timer
    //       this.startTimer();
    //     }
    //   }
    // }
  }
</script>

<style scoped>
  #hy-swiper {
    overflow: hidden;
    position: relative;
    height: 150px;
    width: 100%;
    text-align: center;
  }

  .btn-list {
    position: absolute;
  }

  .dot-list {
    position: absolute;
    bottom: 10px;
    left: 50%;
  }

  .dot-list span{
    width: 20px;
    height: 4px;
    background: skyblue;
    display: inline-block;
    margin-right: 5px;
    cursor: pointer;
  }

  .swiper {
    display: flex;
  }

  .indicator{
    display: flex;
    justify-content: center;
    position: absolute;
    width: 100%;
    bottom: 8px;
  }

  .indi-item{

  }
</style>
