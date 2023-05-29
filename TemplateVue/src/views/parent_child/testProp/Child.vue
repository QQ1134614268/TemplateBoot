<!-- 子组件 -->
<template>
  <div class="p_c_test_border">
    父组件传值: num1:{{ num1 }}, num2: {{ num2 }}
    <div>
      <button @click="click">计算</button>
    </div>
  </div>
</template>
<script>
export default {
  props: {
    num1: {
      type: Number,
    },
    num2: {
      type: Number,
    },
    type: {
      type: Number,
    },
  },
  // ...
  data() {
    return {
      res: ""
    }
  },
  methods: {
    click() {
      this.$emit('childFn', this.num1 + this.num2);
    }
  }
}
</script>