<template>
  <div>
    <div class="container">
      <el-button type="primary" @click="flag=!flag">
        新增
      </el-button>
    </div>
    <el-table :data="typeList">
      <el-table-column label="id" prop="id"></el-table-column>
      <el-table-column label="uniCode" prop="uniCode"></el-table-column>
      <el-table-column label="value" prop="value"></el-table-column>
      <el-table-column label="label" prop="label"></el-table-column>
      <el-table-column label="createTime" prop="createTime"></el-table-column>
      <el-table-column label="status" prop="status"></el-table-column>
      <el-table-column label="groupCode" prop="groupCode"></el-table-column>
      <el-table-column label="sort" prop="sort"></el-table-column>
      <el-table-column label="note" prop="note"></el-table-column>
      <el-table-column label="操作" width="160">
        <template slot-scope="scope">
          <el-button circle icon="el-icon-edit" type="danger" @click="handleEdit(scope.row)"></el-button>
          <el-button circle icon="el-icon-delete" type="danger" @click="handleDelete(scope.row)"></el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination :total="total" layout="total,prev, pager, next" @current-change="init">
    </el-pagination>
    <el-dialog :visible.sync="flag">
      <el-form ref="form" :model="form" :rules="rules" label-width="100px" status-icon>
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
import {ImgType_create, ImgType_getPage} from "@/api/api";

export default {
  name: "ImgType",
  data() {
    return {
      typeList: [],
      flag: false,
      current: 1,
      total: 0,
      size: 10,
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
        current: this.current,
        size: this.size
      }
      let res = await getJson3(ImgType_getPage, data);
      this.typeList = res.data.records;
      this.current = res.data.current;
      this.size = res.data.size;
      this.total = res.data.total;
    },
    async submit() {
      let res = await postJson3(ImgType_create, this.form);
      this.$message.info("成功");
      this.flag = !this.flag;
      await this.init();
    },
    handleEdit(row) {
      this.form = row
      this.flag = true
    },
    async handleDelete(row) {
      let url = "/api/ImgTypeController/deleteById"
      let data = {
        id: row.id
      }
      let res = await postJson3(url, data);
      this.$message.info("成功");
      await this.init();
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