<template>
  <div>
    <h1>父组件{{ this.activeName }}</h1>
    <Child :activeName.sync="activeName"/>
  </div>
</template>

<script>
import Child from './Child';

export default {
  components: {Child},
  data() {
    return {
      activeName: true
    }
  },
}
</script>