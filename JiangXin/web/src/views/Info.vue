<template>
  <h1> form.name</h1>
  <h1> form.type</h1>
  <h1> form.img</h1>
  <h1> form.desc</h1>
  <div :key="index" v-for="(type, index) in form.content">
    <WrdImgUpload v-model="type.img"></WrdImgUpload>
    <el-input v-model="type.desc"></el-input>
  </div>
</template>

<script>
export default {
  name: "Info",
  data(){
    return {
      form:{}
    }
  }
}
</script>

<style scoped>

</style>