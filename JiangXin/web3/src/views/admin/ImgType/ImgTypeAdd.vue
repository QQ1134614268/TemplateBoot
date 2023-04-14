<template>
  <el-form ref="form" :model="form" :rules="rules" label-width="100px" status-icon>
    <el-form-item label="标签" prop="username">
      <el-input v-model="form.label" autocomplete="on"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submit">提交</el-button>
      <el-button @click="cancel">取消</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import {postJson3} from "@/api/http";
import {ImgType_create} from "@/api/api";

export default {
  name: "ImgType",
  data() {
    return {}
  },
  methods: {
    async submit() {
      let res = await postJson3(ImgType_create, this.form);
      this.$message.info("成功");
    },
  },
}
</script>

<style scoped>

</style>