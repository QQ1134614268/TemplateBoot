<template>
  <div id="app" class="container">
    <router-view/>
  </div>
</template>
<script>

import {HomeDoor} from "@/api/url";

export default {
  name: "App",
  data() {
    return {
      MessageBoard: "/MessageBoard",
      DecorationPlan: '/DecorationPlan',
      root: '/',
      Home: HomeDoor
    }
  },
  computed: {},
  methods: {
    go(url) { // todo 每个vue都定义? 全局?
      this.$router.push(url);
    }
  }
}
</script>
<style>
body {
  /*background-color: #f90;*/
  /*background-image: linear-gradient(0deg, rgba(255, 255, 255, .2) 10%, transparent 50%, transparent);*/
  background-image: url("@/assets/bg.webp");
  background-size: cover;
  object-fit: contain;

  display: flex;
  flex-direction: column;
}
#app {

  margin: auto;

  flex-grow: 1;
  display: flex;
}
</style>
