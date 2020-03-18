<template>
  <div class="backtop">
    <img src="@/assets/img/top.png" alt="">
  </div>
</template>

<script>
  export default {
    name: "backtop"
  }
</script>

<style scoped>
  .backtop {
    position: fixed;
    right: 8px;
    bottom: 60px;
  }
  .backtop img {
    width: 40px;
    height: 40px;
  }
</style>
