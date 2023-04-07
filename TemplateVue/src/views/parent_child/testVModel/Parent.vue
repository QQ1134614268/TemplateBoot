<!-- 父组件 -->
<template>
  <div class="test">
    <Child v-model="num"></Child>
    <div>
      结果:{{ num }}
    </div>
  </div>
</template>

<script>
import Child from "@/views/parent_child/testVModel/Child";

export default {
  components: {Child},
  data() {
    return {
      num: '',
    }
  },
}
</script>