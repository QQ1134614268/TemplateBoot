<template>
  <el-form :model="form" status-icon :rules="rules" ref="form" label-width="100px"  >
    <el-form-item label="用户名" prop="username">
      <el-input v-model="form.username" autocomplete="on"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="checkPass">
      <el-input type="password" v-model="form.checkPass" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="login('form')">提交</el-button>
      <el-button @click="dialogVisible=false">取消</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  name: "Login"
}
</script>

<style scoped>

</style>