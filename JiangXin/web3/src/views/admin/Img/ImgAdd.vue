<template>
  <div>
    <el-form ref="form" :model="form">
      <el-form-item label="名称">
        <el-input v-model="form.name" class="formItem"></el-input>
      </el-form-item>
      <el-form-item label="分类">
        <el-select v-model="form.typeId" class="formItem" placeholder="请选择">
          <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="内容">
        <div class="p_c_flexbox p_c_test_border" style="width: 100%">
          <WrdImgUploadModel v-for="(item, index) in form.children" :key="index" v-model="item.url"
                             class="col-3"></WrdImgUploadModel>
          <WrdImgUploadModel v-model="tmpUrl" class="col-3"></WrdImgUploadModel>
        </div>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>

import WrdImgUploadModel from "@/components/WrdImgUploadModel";

export default {
  name: 'App',
  components: {WrdImgUploadModel},
  data() {
    return {
      form: {
        name: "现代简约风",
        typeId: "1",
        children: [
          {
            url: ""
          },
          {
            url: ""
          },
          {
            url: ""
          },
          {
            url: ""
          },
          {
            url: ""
          }
        ],
      },
      tmpUrl: ""
    }
  },
  methods: {
    async initImgType() {
    },
    async onSubmit() {
    },
  },
  created() {
    this.initImgType();
  },
  watch: {
    tmpUrl: {
      handler(newValue, oldValue) {
        if (newValue) {
          this.form.children.push({url: newValue});
          this.newValue = ""
        }
      },
      deep: true
    }
  }
}
</script>
<style>
.formItem {
  width: 80%;
}
</style>
