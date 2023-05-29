<template>
  <div class="p_c_test_border">
    父组件: {{ num }}
    <div>
      内容： <input :value="num" type="text" @input="inputMethods"/>
    </div>
    <div>
      <el-button type="success" @click="inputMethods">add</el-button>
    </div>
  </div>
</template>
<script>
export default {
  props: {
    num: 1
  },
  data() {
    return {}
  },
  methods: {
    inputMethods() {
      this.$emit('update:num', this.num + 100)
      //这儿是关键 update:num 自定义事件会告诉父组件将父组件的 test值改为this.num+100，并传回给子组件。
    },
  }
}
</script>