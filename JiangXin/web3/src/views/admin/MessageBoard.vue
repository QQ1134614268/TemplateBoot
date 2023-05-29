<template>
  <div>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="name" label="姓名"></el-table-column>
      <el-table-column prop="styleId" label="风格"></el-table-column>
      <el-table-column prop="area" label="面积"></el-table-column>
      <el-table-column prop="dateTime" label="时间"></el-table-column>
      <el-table-column prop="phone" label="联系方式"></el-table-column>
      <el-table-column prop="phone" label="进度"></el-table-column>
      <el-table-column prop="phone" label="责任人"></el-table-column>
      <el-table-column prop="phone" label="进度desc"></el-table-column>
    </el-table>
  </div>
</template>

<script>
import {getJson3} from "@/api/http";

export default {
  name: "MessageBoard",
  data() {
    return {
      tableData: [],
      url: "/api/CustomerController/getPage"
    }
  },
  methods: {
    async init() {
      let data = {
        current: 1,
        size: 10
      }
      let result = await getJson3(this.url, data)

      if (result.code == 1) {
        this.tableData = result.data.records;
      } else {
        this.$message('服务器发生异常');
      }
    }
  },
  created() {
    this.init()
  }
}
</script>

<style scoped>

</style>