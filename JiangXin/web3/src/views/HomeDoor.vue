<template>
  <div class="container">
    <div id="header">
      <a :href="root">
        <div style="" class="logo">
          <img src="@/assets/logo.jpg" class="logoImg" alt="图片加载失败">
          <span class="logoName">匠心装饰</span>
        </div>
      </a>
      <div class="p_c_box-flex_center">
        <el-menu :default-active="root"
                 @select="go"
                 mode="horizontal"
                 text-color="red"
                 active-text-color="#ffd04b">
          <el-menu-item :index="Home">
            效果图
          </el-menu-item>
          <el-menu-item :index="DecorationPlan">
            我要装修
          </el-menu-item>
        </el-menu>
      </div>
    </div>
    <div id="body">
      <router-view/>
    </div>
    <div id="footer">
      <a href="https://beian.miit.gov.cn" target="_blank" style="color: #e7e3e3">皖ICP备20002024号-1</a>
    </div>
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
<style lang="less">
#header {
  width: 100%;
  height: 4rem;
  //height: 10%;
  //间隙
  //padding: 1rem;
  //margin: 1rem;

  // 布局
  display: flex;
  justify-content: space-around;

  // 字体
  font-size: 4rem;

  //背景颜色
  background-color: #0a53be;

  .logo {
    width: 20rem;
    height: 4rem;
    display: flex;

    .logoImg {
      width: 4rem;
      height: 4rem;
      margin: 0 0.1rem;
      border-radius: 50%;
    }

    .logoName {
      font-size: 3rem;
      color: white;
    }
  }

  .el-menu {
    background-color: inherit;
    height: 100%;
  }

  .el-menu-item {
    background-color: inherit;
    height: 100%;
    font-size: 2rem;
    display: flex;
    justify-content: center;
    align-items: center;
  }
}

.container {
  display: flex;
  flex-direction: column;
  flex-grow: 1;
}

#body {
  display: flex;
  flex-grow: 1;
}

#footer {
  text-align: center;
  height: 10%;
}
</style>
