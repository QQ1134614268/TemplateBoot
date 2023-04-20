<template>
  <el-select v-model="value" class="formItem" placeholder="请选择">
    <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
    </el-option>
  </el-select>
</template>

<script>
import {getJson3, postJson3} from "@/api/http";
import {ImgType_create, ImgType_getPage} from "@/api/api";
import ImgTypeAdd from "@/views/admin/ImgType/ImgTypeAdd";

export default {
  name: "ImgType",
  data() {
    return {
      value: [],
      options: [],
    }
  },
  methods: {
    async init() {
      let data = {
        current: this.current,
        size: this.size
      }
      let res = await getJson3(ImgType_getPage, data);
      this.options = res.data.records;
    },
  },
  created() {
    this.init()
  }

}
</script>

<style scoped>

</style>