<template>
  <div class="homeContainer">
    <div class="col-2">
      <el-menu router active-text-color="#409EFF">
        <el-menu-item :index="item.menuPath" v-for="(item, index) in menuList" :key="index">
          <i :class="item.menuIcon"></i>
          <span>
          {{ item.menuName }}
        </span>
        </el-menu-item>
      </el-menu>
    </div>
    <div class="col-8">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import {ImgAdmin} from "@/views";
import {adminLogin, AdminMessageBoard, ImgType} from "@/views/api";
import save from "@/views/admin/save";

export default {
  name: "Home",
  data() {
    return {
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
          menuPath: save,
          menuIcon: "el-icon-connection",
        },
        {
          menuName: "留言板",
          menuPath: AdminMessageBoard,
          menuIcon: "el-icon-connection",
        },
        {
          menuName: "类型",
          menuPath: adminLogin,
          menuIcon: "el-icon-connection",
        },
      ],
    }
  }
}
</script>

<style scoped>
.homeContainer {
  display: flex;
}
</style>