<template>
  <!--  <div>滚动图</div>-->

  <!--  风格 tag标签-->
  <div class="tagBox">
    <el-button :key="o" v-for="o  in tagList" @click="initSearch(o.id)">{{ o.value }}</el-button>
  </div>

  <div class="p_c_flexbox content">
    <div :key="o" v-for="o in imgs" class="col-3">
      <div class="img_box">
        <div class="parent">
          <a href="https://www.baidu.com">
            <div class="child">
              <img :src="'http://127.0.0.1:29090/api/file/download/'+o.imgUrl" class="img">
            </div>
          </a>
        </div>
        <div class="desc">
          <div class="title">
            中式风格
          </div>
          <div class="star">
            点赞
          </div>
          <div class="avatar">
            头像logo
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import {getJson3} from "@/api/http";
import {img_getPage} from "@/views/api";
import {ImgType_getPage} from "@/api/api";

export default {
  name: "Home",
  data() {
    return {
      imgs: [],
      Info: 123,
      tagList: []
    }
  },
  methods: {
    go(url) {
      this.$router.push(url)
    },
    async initSearch(typeId) {
      let data = {
        parentId: 0,
        typeId: typeId
      }
      let ret = await getJson3(img_getPage, data)
      this.imgs = ret.data.records;
    },
    async init() {
      let ret = await getJson3(ImgType_getPage)
      this.tagList = ret.data.records;
    }
  },
  created() {
    this.init()
    this.initSearch()
  }
}
</script>

<style scoped lang="less">
.tagBox {
  display: flex;
  align-content: center;
  justify-content: center;
  flex-wrap: wrap;
}

.content {
  background-color: #d8dbde;
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
  display: flex;
  justify-content: center;
  align-items: center;
}

.img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.img_box {
  margin: 1rem;
  background-color: #c6c8c5;
}
</style>