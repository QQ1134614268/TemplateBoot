<template>
  <div>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="Name" label="姓名" width="180"></el-table-column>
      <el-table-column prop="Style" label="风格" width="180"></el-table-column>
      <el-table-column prop="TheMeasureOfArea" label="面积" width="180"></el-table-column>
      <el-table-column prop="Date" label="时间"></el-table-column>
      <el-table-column prop="phone" label="联系方式"></el-table-column>
    </el-table>
  </div>
</template>

<script>
import {getJson3} from "@/api/http";

export default {
  name: "MessageBoard",
  data() {
    return {
      tableData: [
        {
          "phone": "18800000000",
          "style": "欧式",
          "area": "180",
          "name": "李先生",
          "time": "2021-02-21"
        }
      ],
      url: "api/GetData"
    }
  },
  methods: {
    async init() {
      let result = await getJson3(this.url)
      if (result.data.code == 1) {
        this.tableData = result.data.data
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