<template>
  <div>
    <h1>{{ form.name }}</h1>
    <el-select v-model="form.typeId" class="formItem" placeholder="请选择">
      <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.id">
      </el-option>
    </el-select>
    <div class="p_c_test_border container p_c_flexbox" style="width: 100%">
      <div v-if="form.imgUrl" class="col-3 p_c_test_border">
        <div class="parent p_c_test_border">
          <div class="child">
            <img :src="form.imgUrl">
          </div>
        </div>
        <div>desc</div>
      </div>
      <div v-for="item in form.children" :key="item.imgUrl" class="col-3">
        <div class="parent">
          <div class="child">
            <img :src="item.imgUrl">
          </div>
        </div>
        <div> desc</div>
      </div>
    </div>
  </div>
</template>

<script>

import {getJson3} from "@/api/http";
import {ImgType_getPage} from "@/api/api";

export default {
  name: 'App',
  props: {
    form: {
      type: Object
    }
  },
  components: {},
  data() {
    return {
      options: [],
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
  },
  created() {
    this.initImgType();
  }
}
</script>

<style>
img {
  width: 100%;
  height: 100%;
}
</style>
