<template>
  <div style="display: flex">
    <div>
      分类
      <div v-for="item in data" :key="item.id">
        {{ item.label }}
        <div v-for="item1 in item.imgEntityList" :key="item1.id" @click="getContent(item1.id)">
          {{ item1.name }}
        </div>
      </div>
    </div>
    <div style="width: 100%">
      <el-button @click="dialogVisible=!dialogVisible">编辑</el-button>
      <ImgSingle v-if="!dialogVisible" :form="form"></ImgSingle>
      <ImgAdd v-if="dialogVisible" :form2="form"></ImgAdd>
    </div>
  </div>
</template>

<script>

import {getJson3} from "@/api/http";
import {getContent, Img_getImgTree} from "@/api/api";
import ImgSingle from "@/views/admin/Img/ImgSingle";
import ImgAdd from "@/views/admin/Img/ImgAdd";

export default {
  name: 'App',
  components: {
    ImgAdd,
    ImgSingle
  },
  data() {
    return {
      form: {},
      data: [],
      user: {},
      close: true,
      dialogVisible: false,
      defaultProps: {
        children: "children",
        label: "name",
      },
      data: [],
    }
  },
  methods: {
    async init() {
      let data = {
        current: 1,
        size: 10
      }
      let res = await getJson3(Img_getImgTree, data);
      this.data = res.data
    },
    async getContent(id) {
      let para = {
        id: id
      };
      let ret = await getJson3(getContent, para);
      this.dialogVisible = false
      return this.form = ret.data;
    },
    async open(data) {
      this.form = data
    },
  },
  created() {
    this.init();
  }
}
</script>

<style>
</style>
