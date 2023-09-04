<template>
  <div>
    <div class="header">
      <h1>匠心后台管理系统</h1>
    </div>
    <div class="homeContainer">
      <div class="col-2">
        <el-menu :default-active="fullPath" active-text-color="#409EFF" router>
          <el-menu-item v-for="item in menuList" :key="item.menuName" :index="item.menuPath">
            <i :class="item.menuIcon"></i>
            <span>
               {{ item.menuName }}
            </span>
          </el-menu-item>
        </el-menu>
      </div>
      <div class="col-10">
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
import {adminLogin, AdminMessageBoard, adminSave, ImgAdmin, ImgType} from "@/api/url";

export default {
  name: "HomeComponent",
  data() {
    return {
      fullPath: this.$route.fullPath,
      menuList: [
        {
          menuName: "类型",
          menuPath: ImgType,
          menuIcon: "el-icon-connection",
        },
        {
          menuName: "图片",
          menuPath: ImgAdmin,
          menuIcon: "el-icon-connection",
        },
        {
          menuName: "图片2",
          menuPath: adminSave,
          menuIcon: "el-icon-connection",
        },
        {
          menuName: "留言板",
          menuPath: AdminMessageBoard,
          menuIcon: "el-icon-connection",
        },
        {
          menuName: "登录",
          menuPath: adminLogin,
          menuIcon: "el-icon-connection",
        },
      ],
    }
  }
}
</script>

<style scoped>
.header {
  display: flex;
  justify-content: center;
}

.homeContainer {
  display: flex;
}
</style>