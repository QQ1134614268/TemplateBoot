<template>
  <div className="Father">
    这个是父组件{{ num }}
    <div>
      <el-input v-model="num"></el-input>
    </div>
    <div>
      <Child :num.sync="num"/>
    </div>
  </div>
</template>

<script>
import Child from "@/views/parent_child/testSync/Child";

export default {
  components: {Child},
  data() {
    return {
      num: 6
    }
  },
}
</script>