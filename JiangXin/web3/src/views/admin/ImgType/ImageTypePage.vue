<template>
  <div>
    <el-form ref="queryForm" :inline="true" :model="queryParams" label-width="68px" size="small">
      <el-form-item label="显示顺序" prop="orderNum">
        <el-input
            v-model="queryParams.orderNum"
            clearable
            placeholder="请输入显示顺序"
            @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-date-picker
            v-model="daterangeCreateTime"
            end-placeholder="结束日期"
            range-separator="-"
            start-placeholder="开始日期"
            style="width: 240px"
            type="daterange"
            value-format="yyyy-MM-dd"
        >
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button icon="el-icon-search" size="mini" type="primary" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
            icon="el-icon-plus"
            plain
            size="mini"
            type="primary"
            @click="flag=!flag"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
            icon="el-icon-download"
            plain
            size="mini"
            type="warning"
            @click="alert('待实现')"
        >导出
        </el-button>
      </el-col>
    </el-row>
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
      <ImgTypeAdd></ImgTypeAdd>
    </el-dialog>
  </div>
</template>

<script>
import {getJson3, postJson3} from "@/api/http";
import {ImgType_create, ImgType_getPage} from "@/api/api";
import ImgTypeAdd from "@/views/admin/ImgType/ImgTypeAdd";

export default {
  name: "ImgType",
  components: {
    ImgTypeAdd
  },
  data() {
    return {
      queryParams: {},
      daterangeCreateTime:[],
      typeList: [],
      flag: false,
      current: 1,
      total: 0,
      size: 10,
      form: {},
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
    },
    async handleQuery() {
    },
    async resetQuery() {
    }
  },
  created() {
    this.init()
  }

}
</script>

<style scoped>

</style>