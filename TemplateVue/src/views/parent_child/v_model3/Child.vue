<template>
  <div>
    <h1>子组件{{  this.activeName  }}</h1>
    <button @click="changeName">点击改变值</button>
  </div>
</template>

<script>
export default {
  props: {
    activeName: { type: Boolean, default: false }
  },
  methods: {
    changeName() {
      this.$emit("update:activeName", !this.activeName)
    }
  }
}
</script>
