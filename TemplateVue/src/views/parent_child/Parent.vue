<!-- 父组件 -->
<template>
  <div class="test">
    <div>
      <input v-model="num1"></input>
    </div>
    <div>
      <input v-model="num2"></input>
    </div>
    <div>
      子组件传来的值 : {{ res }}
    </div>
    <br/>
    <div>
      <Child :num1="num1" :num2="num2" @childFn="parentFn"></Child>
    </div>
  </div>
</template>

<script>
import Child from "@/views/parent_child/Child";

export default {
  components: {Child},
  data() {
    return {
      num1: '',
      num2: "",
      res: ""
    }
  },
  methods: {
    parentFn(payload) {
      this.res = payload;
    }
  }
}
</script>