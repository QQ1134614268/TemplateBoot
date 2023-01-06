<template>
  <div>
    {{ typeList }}
    1111
  </div>
</template>

<script>
import {getJson3} from "@/api/http";

export default {
  name: "ImgType",
  data() {
    return {
      url: "/api/ImgTypeController/getPage",
      typeList: [],
    }
  },
  methods: {
    async init() {
      let data = {
        current: 1,
        size: 10
      }
      let res = await getJson3(this.url, data);
      this.typeList = res.data.data
    },
  },
  created() {
    this.init()
  }

}
</script>

<style scoped>

</style>