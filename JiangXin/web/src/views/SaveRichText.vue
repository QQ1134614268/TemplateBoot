<template>
  富文本,自动编辑
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
      this.form = ret.data.data;
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
