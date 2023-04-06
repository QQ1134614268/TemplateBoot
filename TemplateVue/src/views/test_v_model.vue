<template>
  <div>
    test
    <div>
      {{ num }}
      单向: <input :value="num"></input>
      <el-button @click="num=num+1">加</el-button>
    </div>

    <div>
      {{ num2 }}
      双向: <input v-model:value="num2"></input>
      <el-button @click="num2=num2+1">加</el-button>
    </div>
  </div>
  <!--
  vue 中@的第一种用法：@作为 v-on指令的缩写
  @作为模块路径的别名

  ：其实是 v-bind 指令 的缩写

-----------
1、v-bind是单向绑定，用来绑定数据和属性以及表达式，数据只能从data流向页面。
2、v-model是双向绑定，数据能从data流向页面，也能从页面流向data。
3、v-bind可以给任何属性赋值，v-model只能给表单类，也就是具有value属性的元素进行数据双向绑定，如text、radio、checkbox、selected。
  -->
</template>
<script>

export default {
  data() {
    return {num: 3, num2: 3}
  },
  methods: {}
}
</script>