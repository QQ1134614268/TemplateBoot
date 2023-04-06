<template>
  <div className="Father">这个是父组件{{ value }}
    <Child v-model:value.sync="value"/>
    <el-input v-model="value"></el-input>
  </div>
</template>

<script>
import Child from "@/views/parent_child/v_model2/Child";

export default {
  components: {Child},
  data() {
    return {
      title: '初始值',
      count: 5,
      value: 6
    }
  },
}
</script>