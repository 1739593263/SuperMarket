<template>
  <div class="nav-bar">
    <div class="left"><slot name="left"></slot></div>
    <div class="center"><slot name="center"></slot></div>
    <div class="right"><slot name="right"></slot></div>
  </div>
</template>

<script>
  export default {
    name: "NavBar"
  }
</script>

<style scoped>
  .nav-bar {
    display: flex;
    line-height: 44px;
    text-align: center;

    z-index: 8;
    position: fixed;
    left: 0;
    right: 0;
    top: 0;
  }

  .left .right {
    width: 60px;
  }

  .center {
    /* 'flex = 1 when other parts have certain size' means that this part occupy all remain area */
    flex: 1
  }
</style>
