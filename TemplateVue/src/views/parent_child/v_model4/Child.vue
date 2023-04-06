<template>
  <div>
    <ul>
      <li>{{ '里面的值：' + snycTest }}</li>
      <button @click="fn2">里面改变外面</button>
    </ul>
  </div>

</template>

<script>
export default {
  props: {
    snycTest: ''
  },
  methods: {
    fn2() {
      this.$emit('update:snycTest', this.snycTest + 1) //这儿是关键 update:snycTest 自定义事件会告诉父组件将父组件的 test值改为this.snycTest+1，并传回给子组件。
    }
  }
}
</script>