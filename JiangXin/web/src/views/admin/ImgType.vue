<template>
  <div class="container">
    <el-button @click="flag=!flag">
      新增
    </el-button>
  </div>
  <div class="p_c_flexbox p_c_border_black p_c_box_grow">
    <div :key="index" v-for="(type, index) in typeList"
         class="p_c_color_blue2 p_c_border_black p_c_box_margin p">
      {{ type.uniqueCode }}
    </div>
  </div>
  <el-dialog :model-value="flag">
    <el-form :model="form" status-icon :rules="rules" ref="form" label-width="100px">
      <el-form-item label="用户名" prop="username">
        <el-input v-model="form.uniqueCode" autocomplete="on"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submit">提交</el-button>
        <el-button @click="cancel">取消</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>

<script>
import {getJson3, postJson3} from "@/api/http";

export default {
  name: "ImgType",
  data() {
    return {
      url: "/api/ImgTypeController/getPage",
      typeList: [],
      flag: false,
      form: {}
    }
  },
  methods: {
    async init() {
      let data = {
        current: 1,
        size: 10
      }
      let res = await getJson3(this.url, data);
      this.typeList = res.data.records
    },
    async submit() {
      let url = "/api/ImgTypeController/create"
      let res = await postJson3(url, this.form)
      this.$message.info("成功")
      this.flag = !this.flag;
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