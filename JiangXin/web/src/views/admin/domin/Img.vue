<template>
  <div>

  </div>
  <el-dialog :model-value="flag">
    <el-form v-model="form">

    </el-form>
  </el-dialog>
</template>

<script>
export default {
  name: "Img",
  data() {
    return {
      flag: "",
      form:{}
    }
  }
}
</script>
<style scoped>

</style>