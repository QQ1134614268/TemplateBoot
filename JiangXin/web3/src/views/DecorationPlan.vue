<template>
  <div>
    <el-form ref="form" :model="form" label-width="8rem" :rules="rules" style="padding: 1rem">
      <el-form-item label="面积">
        <el-input v-model="form.area"></el-input>
      </el-form-item>
      <el-form-item label="风格">
        <el-radio-group v-model="form.styleId" class="styleContent">
          <div class="typeBox" :key="o" v-for=" o in tagList">
            <img src="@/assets/logo.jpg">
            <el-radio :value="o.value" :label="o.uniCode"></el-radio>
          </div>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="您的称呼">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="手机号">
        <el-input v-model="form.phone"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="save">确定</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import {getJson3, postJson3} from "@/api/http";
import {ImgType_getPage} from "@/api/api";

export default {
  name: "DecorationPlan",
  data() {
    return {
      form: {},
      url: "/api/CustomerController/create",
      tagList: []
    }
  },
  methods: {
    async init() {
      let ret = await getJson3(ImgType_getPage)
      this.tagList = ret.data.records;
    },
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

  },
  created() {
    this.init()
  }
}
</script>

<style scoped>

.styleContent {
  display: flex;
  flex-wrap: wrap;
}

.typeBox {
  display: flex;
  flex-direction: column;
  width: 12.5%;
  padding: 1rem;
}

.typeBox:first-child {
  padding-left: 0rem;
  /*border: #0a53be solid 1px;*/
}
</style>