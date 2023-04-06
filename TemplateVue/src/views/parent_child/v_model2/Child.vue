<template>
  <div>
    {{ value }}
    <el-button type="success" @click="value=value+1">add</el-button>
  </div>
</template>
<script>
export default {
  props: {
    value: 1
  },
  data() {
    return {}
  },
}
</script>