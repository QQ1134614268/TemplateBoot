<template>
  <div style="display: flex">
    <el-dialog :title="form.id?'编辑':'新增'" :visible.sync="dialogVisible">
    </el-dialog>
    <div>
      分类
      <el-tree :data="typeList" :expand-on-click-node="false">
        <span class="custom-tree-node" slot-scope="{ node, data }">
          <span>{{ data.label }}</span>
          <span>
            <el-button type="text" size="mini" @click="() => alert('data')">Append</el-button>
          </span>
        </span>
      </el-tree>
    </div>
    <div style="width: 100%">
      <div>
        <div>首页</div>
        <div><img alt=".." :src="form.name"></div>
        <div>{{ form.name }}</div>
        <div>{{ form.desc }}</div>
      </div>
      <div style="margin-top: 4rem">
        <div :key="index" v-for="(type, index) in form.content">
          <div><img alt=".." :src="type.name"></div>
          <div>{{ type.name }}</div>
          <div>{{ type.desc }}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import {getJson3} from "@/api/http";
import {getContent} from "@/views/api";
import {ImgType_getPage} from "@/api/api";

export default {
  name: 'App',
  components: {},
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
      typeList: [],
    }
  },
  methods: {
    async init() {
      let data = {
        current: 1,
        size: 10
      }
      let res = await getJson3(ImgType_getPage, data);
      this.typeList = res.data.records
    },
    async getContent(id) {
      let para = {
        id: id
      };
      let ret = await getJson3(getContent, para);
      console.log(ret)
      return this.form = ret.data;
    },
    async open(id) {
      await this.getContent(id);
    },
    logout() {
      localStorage.removeItem("token");
    },
  },
  created() {
    this.init();
  }
}
</script>

<style>
</style>
