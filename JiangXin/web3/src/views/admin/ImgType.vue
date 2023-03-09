<template>
  <div>
    <div class="container">
      <el-button @click="flag=!flag">
        新增
      </el-button>
    </div>
    <el-table :data="typeList">
      <el-table-column prop="id" label="id"></el-table-column>
      <el-table-column prop="uniCode" label="uniCode"></el-table-column>
      <el-table-column prop="value" label="value"></el-table-column>
      <el-table-column prop="label" label="label"></el-table-column>
      <el-table-column prop="createTime" label="createTime"></el-table-column>
      <el-table-column prop="status" label="status"></el-table-column>
      <el-table-column prop="groupCode" label="groupCode"></el-table-column>
      <el-table-column prop="sort" label="sort"></el-table-column>
      <el-table-column prop="note" label="note"></el-table-column>
      <el-table-column label="操作" width="160">
        <template slot-scope="scope">
          <el-button size="mini" type="danger" @click="handleEdit(scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog :visible.sync="flag">
      <el-form :model="form" status-icon :rules="rules" ref="form" label-width="100px">
        <el-form-item label="标签" prop="username">
          <el-input v-model="form.label" autocomplete="on"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submit">提交</el-button>
          <el-button @click="cancel">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import {getJson3, postJson3} from "@/api/http";
import {ImgType_getPage} from "@/api/api";

export default {
  name: "ImgType",
  data() {
    return {
      typeList: [],
      flag: false,
      form: {},
      rules: {
        parentId: [
          {required: true, message: "上级部门不能为空", trigger: "blur"}
        ],
        email: [
          {
            type: "email",
            message: "请输入正确的邮箱地址",
            trigger: ["blur", "change"]
          }
        ],
        phone: [
          {
            pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/,
            message: "请输入正确的手机号码",
            trigger: "blur"
          }
        ]
      }
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
    async submit() {
      let url = "/api/ImgTypeController/create"
      let res = await postJson3(url, this.form)
      this.$message.info("成功")
      this.flag = !this.flag;
      await this.init();
    },
    handleEdit(row) {
      this.form = row
      this.dialogVisible = true
    },
    async handleDelete() {
    },
    async cancel() {
      this.flag = !this.flag;
    }
  },
  created() {
    this.init()
  }

}
</script>

<style scoped>

</style>