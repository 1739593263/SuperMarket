<template>
  <div class="tab">
    <div v-for="(item,index) in titles"
         class="tab-item"
         :class="{active: index === curIndex}"
         @click="actclick(index)">
      <span>{{item}}</span>
    </div>
  </div>
</template>

<script>
  export default {
    name: "tabcontrol",
    props:{
      titles:{
        type:Array,
        default:[],
      },
    },
    data(){
      return{
        curIndex:0,
        click:'herbivore'
      }
    },
    methods:{
      actclick(index){
        this.curIndex = index;
        this.click = this.titles[index];
        this.$emit('tabclick',this.click);
      }
    }
  }
</script>

<style scoped>
  .tab {
    display: flex;
    text-align: center;
    font-size: 15px;
    height: 30px;
    line-height: 40px;

    position: sticky;
    top: 44px;
    background-color: #fff;
    z-index: 8;
  }
  .tab-item {
    flex: 1;
  }

  .active span {
    padding-bottom: 2px;
  }
  .active {
    color: var(--color-tint);
  }
  .active span {
    border-bottom: 2px solid var(--color-tint);
  }
</style>
