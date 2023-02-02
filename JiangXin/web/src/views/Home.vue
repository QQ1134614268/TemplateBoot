<template>
  <div class="p_c_flexbox">
    <div :key="o" v-for="o in imgs" class="img_box" style="padding: 1rem; ">
      <div @click="go(Info)" class="imgContainer">
        <img :src="'http://127.0.0.1:29090/api/file/download/'+o.img" class="img imgCover">
      </div>
      <div class="imgDesc">
        265
      </div>
    </div>
  </div>
</template>
<script>
import {getJson3} from "@/api/http";
import {getPage, Info} from "@/views/api";

export default {
  name: "Home",
  data() {
    return {
      imgs: [],
      Info,
    }
  },
  methods: {
    go(url) {
      this.$router.push(url)
    },
    async getAllTree() {
      let data = {
        parentId: 0
      }
      let ret = await getJson3(getPage,data)
      this.imgs = ret.data.data.records;
    },
  },
  created() {
    this.getAllTree()
  }
}
</script>

<style scoped lang="less">
@media only screen and (max-width: 768px) {
  .img_box {
    width: 10rem;
    height: 7.5rem;
  }
}

@media only screen and (min-width: 600px) {
  /*pc*/
  .img_box {
    width: 30rem;
    height: 22.5rem;
  }
}

.imgContainer {
  width: 100%;
  height: 100%;
  border: #0b9ef2 solid 1px;
}

.img {
  width: 100%;
  height: 100%;
}


.imgFill {
  object-fit: fill;
}

.imgContain {
  object-fit: contain;
}

.imgCover {
  object-fit: cover;
}

.imgNone {
  object-fit: none;
}

.imgScaleDown {
  object-fit: scale-down;
}
</style>