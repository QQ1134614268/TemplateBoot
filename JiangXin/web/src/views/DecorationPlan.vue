<template>
  <div>
    <el-form ref="form" :model="form" label-width="8rem" :rules="rules" style="padding: 1rem">
      <el-form-item label="面积">
        <el-input v-model="form.TheMeasureOfArea"></el-input>
      </el-form-item>
      <el-form-item label="风格">
        <el-radio-group v-model="form.Style" style="display: flex">
          <div style="width: 50%">
            <img src="@/assets/logo.jpg">
            <el-radio label="欧式风格">
            </el-radio>
          </div>
          <div style="width: 50%">
            <img src="@/assets/logo.jpg">
            <el-radio label="科技">
            </el-radio>
          </div>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="您的称呼">
        <el-input v-model="form.Name"></el-input>
      </el-form-item>
      <el-form-item label="手机号">
        <!--        <el-input v-model="form.phone"></el-input>-->
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="save">确定</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import {postJson3} from "@/api/http";

export default {
  name: "DecorationPlan",
  data() {
    return {
      form: {},
      url: "api/Add"
    }
  },
  methods: {
    async save() {
      this.form.Date = this.getDate()
      let result = postJson3(this.url, this.form)
      if (result.data.code == 200) {
        this.$message(result.data.data);
      } else {
        this.$message('保存失败');
      }
    },
    getDate() {
      const nowDate = new Date();
      const date = {
        year: nowDate.getFullYear(),
        month: nowDate.getMonth() + 1,
        date: nowDate.getDate(),
      }
      const newmonth = date.month > 10 ? date.month : '0' + date.month
      const day = date.date > 10 ? date.date : '0' + date.date
      return date.year + '-' + newmonth + '-' + day
    },
  }
}
</script>

<style scoped>

</style>