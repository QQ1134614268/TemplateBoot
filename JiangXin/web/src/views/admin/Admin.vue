<template>
  <div style="display: flex">
    <div>
      <div>欢迎{{}}</div>
      树形结构 -- 增加分类 ;
      <div :key="index" v-for="(type, index) in tree" @click="get" style="width: 20rem">
        {{type.type}}
        <div :key="index" v-for="(name, index) in type.content" @click="open(name.id)">
          {{name.name}}
        </div>
      </div>
    </div>
    <div style="width: 100%">
      <div>
        <div>首页</div>
        <div><img alt=".." :src="form.name"></div>
        <div>{{form.name}}</div>
        <div>{{form.desc}}</div>
      </div>
      <div style="margin-top: 4rem">
        <div :key="index" v-for="(type, index) in form.content">
          <div><img alt=".." :src="type.name"></div>
          <div>{{type.name}}</div>
          <div>{{type.desc}}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import {getUserInfoByToken} from "@/api/util";
import {getJson3, postJson3} from "@/api/http";
import {getAllTree, getContent} from "@/views/api";

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
      },
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
      if (localStorage.getItem("token") !== undefined) {
        this.user = getUserInfoByToken();
      } else {
        this.dialogVisible = true;
      }
      // 判断登陆
      // 弹出
    },
    async getAllTree() {
      let ret = await getJson3(getAllTree)
      return this.tree = ret.data.data;
    },
    async getContent(id) {
      let para = {
        id: id
      };
      let ret = await getJson3(getContent, para);
      console.log(ret)
      return this.form = ret.data.data;
    },
    async updateContent() {
      return this.tree = await getJson3("/api/updateContent");
    },
    async login() {
      let res = await postJson3("/api/user/login", this.ruleForm);
      let token = res.data.data;
      console.log(res.data);
      if (res.data.code === 1) {
        localStorage.setItem("token", token);
        this.user = getUserInfoByToken();
        this.dialogVisible = false;
      } else {
        this.$message.error('服务器异常');
      }
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
    this.getAllTree();
    this.getContent(1);
  }
}
</script>

<style>
</style>
