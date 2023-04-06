<template>
  <div>
    <Child :snycTest.sync="test" class="abc"></Child>
    {{ '外面的值：' + test }}
    <button @click="fn">
      外面改变里面
    </button>

  </div>
</template>

<script>
import Child from './Child.vue'

export default {
  components: {Child},
  data() {
    return {
      test: ''
    }
  },
  methods: {
    fn() {
      this.test += 1
    }
  },
}
</script>