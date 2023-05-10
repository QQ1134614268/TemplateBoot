<template>
  <div>
    {{form}}
    <el-form v-if="form" :model="form">
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
          <WrdImgUploadModel v-for="(item, index) in form.children" :key="index" v-model="item.imgUrl" class="col-3">
          </WrdImgUploadModel>
          <WrdImgUploadModel v-model="tmpUrl" class="col-3"></WrdImgUploadModel>
        </div>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
        <!--        <el-button>取消</el-button>-->
      </el-form-item>
    </el-form>
  </div>
</template>

<script>

import WrdImgUploadModel from "@/components/WrdImgUploadModel";
import {getJson3, postJson3} from "@/api/http";
import {Img_save, ImgType_getPage} from "@/api/api";

export default {
  name: 'App',
  components: {WrdImgUploadModel},
  props: {
    form2: {
      type: Object,
    },
  },
  data() {
    return {
      options: [],
      tmpUrl: "",
      form:this.form2
    }
  },
  methods: {
    async initImgType() {
      let data = {
        current: 1,
        size: -1
      }
      let res = await getJson3(ImgType_getPage, data);
      this.options = res.data.records;
    },
    async onSubmit() {
      let res = await postJson3(Img_save, this.form);
      if (res.data.code == 1) {
        this.$message.success("保存成功")
      } else {
        this.$message.error(res.data)
      }
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
          this.tmpUrl = ""
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
