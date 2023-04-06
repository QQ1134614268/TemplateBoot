<!-- 父组件 -->
<template>
  <div class="test">
    <Child v-model:message="message"></Child>
    <br/>
    子组件传来的值 : {{ message }}
  </div>
</template>

<script>
import Child from "@/views/parent_child/v_model/Child";

export default {
  components: {Child},
  data() {
    return {
      message: '初始值'
    }
  },
  methods: {
    parentFn(payload) {
      this.message = payload;
    }
  }
}
</script>