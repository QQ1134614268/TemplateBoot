<template>
  <div style="display: flex">
    <el-tree ref="treeRef" :props="defaultProps" lazy :data="typeList" node-key="id" draggable>
      <template #default="{ node, data }">
        <span>{{ node.level }}</span>
        <span>{{ data.uniCode }}</span>
      </template>
    </el-tree>
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
import {api_getContent} from "@/views/api";
import {ImgType_getPage} from "@/api/api";

export default {
  name: 'App',
  components: {},
  data() {
    return {
      form: {},
      data: [],
      user: {},
      tree: [],
      close: true,
      dialogVisible: false,
      ruleForm: {
        username: '',
        checkPass: '',
      }, defaultProps: {
        children: "children",
        label: "name",
      },
      typeList: [],
      rules: {
        username: [
          {required: true, message: '用户名不能为空', trigger: 'blur'}
        ],
        checkPass: [
          {required: true, message: '密码不能为空', trigger: 'blur'}
        ],
      }
    }
  },
  methods: {
    async init() {
      // 判断登陆
      // 弹出
      // if (localStorage.getItem("token") !== undefined) {
      //   this.user = getUserInfoByToken();
      // } else {
      //   this.dialogVisible = true;
      // }
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
      let ret = await getJson3(api_getContent, para);
      console.log(ret)
      return this.form = ret.data;
    },
    logout() {
      localStorage.removeItem("token");
    },
  },
  created() {
    this.init();
    // this.getContent(1);
  }
}
</script>

<style>
</style>
