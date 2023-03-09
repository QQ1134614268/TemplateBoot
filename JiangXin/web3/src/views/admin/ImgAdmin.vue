<template>
  <div style="display: flex">
    <el-dialog :title="form.id?'编辑':'新增'" :visible.sync="dialogVisible">
      <!--            <el-form ref="form" :model="form" style="padding: 1rem">-->
      <!--              <el-form-item label="取值">-->
      <!--                <el-input v-model="form.value"></el-input>-->
      <!--              </el-form-item>-->
      <!--              <el-form-item label="分组">-->
      <!--                <el-input v-model="form.group_code"></el-input>-->
      <!--              </el-form-item>-->
      <!--              <el-form-item>-->
      <!--                <el-button type="primary" @click="onSubmit">确定</el-button>-->
      <!--                <el-button type="primary" @click="onCancel">取消</el-button>-->
      <!--              </el-form-item>-->
      <!--            </el-form>-->
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
