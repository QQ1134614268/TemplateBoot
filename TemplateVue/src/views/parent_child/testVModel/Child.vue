<template>
  <div>
    <div>
      内容： <input :value="value" type="text" @input="inputMethods"/>
    </div>
    <div>{{ value }}</div>
    <el-button @click="add"> 加1</el-button>
  </div>
</template>

<script>
export default {
  props: ["value"],
  name: "vmodel",
  methods: {
    inputMethods(event) {
      this.$emit("input", event.target.value)
    },
    add() {
      this.value = this.value + 1
      this.$emit("input", this.value)
    }
  },
}
</script>
<style>

</style>