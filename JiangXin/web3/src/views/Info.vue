<template>
  <div>
    <div>
      <div class="img_box p_c_test_border">
        <div class="parent">
          <div class="child">
            <img :src="form.imgUrl" class="img">
          </div>
        </div>
        <div class="desc p_c_test_border">
          <div class="title">
            {{ form.description }}
          </div>
        </div>
      </div>
      <div :key="index" v-for="(type, index) in form.children">
        <div class="img_box">
          <div class="parent">
            <div class="child">
              <img :src="type.imgUrl" class="img">
            </div>
          </div>
          <div class="desc">
            <div class="title">
              {{ type.description }}
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import {getAllTree2} from "@/api/img";

export default {
  name: "Info",
  data() {
    return {
      form: {},
      id: this.$route.query.id,
    }
  },
  methods: {
    async init() {

      let data = {
        id: this.id
      }
      this.form = await getAllTree2(data)
    }
  },
  created() {
    this.init()
  }
}
</script>

<style scoped>

.img_box {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin: 1rem;
  background-color: #c6c8c5;
}

.parent {
  position: relative;
  width: 100%;
  padding-bottom: 75%;
}

.child {
  position: absolute;
  width: 100%;
  height: 100%;
}

.img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}


.title {
  margin: 1rem;
}

.desc {
  width: 100%;
}
</style>