<template>
  {{ imgs }}
  {{ Info }}
  <div class="p_c_flexbox">
    <div :key="o" v-for="o in imgs" class="img_box col-3">
      <div @click="go(Info)" class="imgContainer p_c_test_border">
        <img :src="'http://127.0.0.1:29090/api/file/download/'+o.imgUrl" class="img imgCover">
      </div>
      <div class="imgDesc">
        <div class="title">
          {{ o.description }}
        </div>
        <div class="star">
          {{ o.description }}
        </div>
        <div class="avatar">
          {{ o.description }}
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import {getJson3} from "@/api/http";
import {getPage} from "@/views/api";

export default {
  name: "Home",
  data() {
    return {
      imgs: [],
      Info: 123,
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
      let ret = await getJson3(getPage, data)
      this.imgs =ret.data.records;
    },
  },
  created() {
    this.getAllTree()
  }
}
</script>

<style scoped lang="less">
.imgContainer {
  width: 100%;
  border: #0b9ef2 solid 1px;
  height: 300px;
}

.img {
  width: 100%;
  height: 75%;
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