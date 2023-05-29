<!-- 父组件 -->
<template>
  <div class="test">
    <Child v-model="form.num"></Child>
    <div>
      结果:{{ form.num }}
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
      form:{
        num:""
      }
    }
  },
}
</script>