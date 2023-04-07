<template>
  <div>
    <div>
      内容： <input :value="value" type="text" @input="inputMethods"/>
    </div>
    <div>{{ value }}</div>
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
  },
}
</script>
<style>

</style>