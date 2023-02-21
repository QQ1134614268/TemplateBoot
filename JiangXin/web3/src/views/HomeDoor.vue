<template>
  <div id="app" class="container">
    <div id="header" class="p_c_box-flex_center ">
      <div style="" class="p_c_box-flex_center ">
        <img src="@/assets/logo.jpg" style="width: 4rem; border-radius: 45rem" @click="go(root)">
        匠心装饰
      </div>
      <div @click="go(Home)"> 首页</div>
      <div @click="go(DecorationPlan)"> 我要装修</div>
    </div>
    <div id="body">
      <router-view/>
    </div>
    <div id="footer">
      <a href="http://www.beian.miit.gov.cn" target="_blank" style="color: #e7e3e3">皖ICP备20002024号-1</a>
    </div>
  </div>
</template>
<script>

import {HomeDoor} from "@/views";

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
  height: 100%;

}

body {
  /*background-color: #f90;*/
  /*background-image: linear-gradient(0deg, rgba(255, 255, 255, .2) 10%, transparent 50%, transparent);*/
}

#header {
  display: flex;
  justify-content: space-around;
  height: 10%;
}

#body {
  min-height: 80%
}

#footer {
  text-align: center;
  height: 10%;
}
</style>
