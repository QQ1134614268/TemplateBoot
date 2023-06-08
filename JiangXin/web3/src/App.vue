<template>
  <div id="app">
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
#app {
  margin: auto;
  min-height: 100%;

}

body {
  /*background-color: #f90;*/
  /*background-image: linear-gradient(0deg, rgba(255, 255, 255, .2) 10%, transparent 50%, transparent);*/
}

</style>
