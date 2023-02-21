<template>
  <div>
    <div>
      <el-button type="primary" @click="dialogVisible=true">添加分类</el-button>
      <el-dialog :title="form.id?'编辑':'新增'" v-model="dialogVisible">
        <!--      <el-form ref="form" :model="form" style="padding: 1rem">-->
        <!--        <el-form-item label="取值">-->
        <!--          <el-input v-model="form.value"></el-input>-->
        <!--        </el-form-item>-->
        <!--        <el-form-item label="分组">-->
        <!--          <el-input v-model="form.group_code"></el-input>-->
        <!--        </el-form-item>-->
        <!--        <el-form-item>-->
        <!--          <el-button type="primary" @click="onSubmit">确定</el-button>-->
        <!--          <el-button type="primary" @click="onCancel">取消</el-button>-->
        <!--        </el-form-item>-->
        <!--      </el-form>-->
      </el-dialog>
    </div>
    <el-form ref="form" :model="form">
      <el-form-item label="名称">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="分类">
        <el-select v-model="form.typeId" placeholder="请选择">
          <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="首页">
        <el-upload
            class="avatar-uploader"
            action="http://localhost:29090/api/file/upload"
            :show-file-list="false"
            :on-success="(response, file, fileList) => {handleAvatarSuccess(form,response,file,fileList)}">
          <img v-if="form.img" :src="'http://127.0.0.1:29090/api/file/download/'+form.img" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
      </el-form-item>
      <el-form-item label="描述">
        <el-input v-model="form.desc"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="add">增加</el-button>
      </el-form-item>
      <el-form-item :key="index" v-for="(type, index) in form.children">
        <el-upload
            class="avatar-uploader"
            action="http://127.0.0.1:29090/api/file/upload"
            :show-file-list="false"
            :on-success="(response, file, fileList) => {handleAvatarSuccess(type,response,file,fileList)}">
          <img v-if="type.img" :src="'http://127.0.0.1:29090/api/file/download/'+type.img" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
        <el-input v-model="type.description"></el-input>
        <el-button type="primary" @click="add">增加</el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">提交</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>

import {getUserInfoByToken} from "@/api/util";
import {getJson3, postJson3} from "@/api/http";
import WrdImgUpload from "@/components/WrdImgUpload";
import {getContent, updateTree} from "@/views/api";
import {FileApi} from "@/api/api";

export default {
  name: 'App',
  components: {WrdImgUpload},
  data() {
    return {
      FileApi,
      fileUrl: "",
      form: {
        children: [],
        description: ""
      },
      data: [],
      user: {},
      close: true,
      dialogVisible: false,
      options: [{
        value: 1,
        label: "中式"
      }],
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
    async initImgType() {
    },
    async add() {
      this.form.content.push({});
    },
    handleAvatarSuccess(type, res, file, fileList) {
      if (res.code !== 1) {
        this.$message.error(res.data)
        return
      }
      this.$message.success("上传成功");
      type.img = res.data
    },
    async getContent(id) {
      let para = {
        id: id
      };
      let ret = await getJson3(getContent, para);
      this.form = ret.data;
    },
    async onSubmit() {
      let data = this.form
      this.tree = await postJson3(updateTree, data);
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
    this.getContent(1);
  }
}
</script>
