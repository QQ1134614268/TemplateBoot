<template>
  <img :src="form.img">
  <div> {{form.description}}</div>
  <div :key="index" v-for="(type, index) in form.content">
    <img :src="type.img">
    <div> {{type.description}}</div>
  </div>
</template>

<script>
import {getAllTree2} from "@/views/api";

export default {
  name: "Info",
    data() {
      return {
        form: {}
      }
    },
    methods: {
      async init(){
        this. form =await getAllTree2()
      }
    }
  }
</script>

<style scoped>

</style>