<template>
  <div><!--  <div>滚动图</div>-->

    <!--  风格 tag标签-->
    <div class="tagBox">
      <el-button :key="o.id" v-for="o in tagList" @click="initSearch(o.id)">{{ o.label }}</el-button>
    </div>
    <div class="p_c_flexbox content">
      <div :key="o.id" v-for="o in imgs" class="col-3">
        <div class="img_box">
          <div class="parent">
            <a :href="'/Info?id='+o.id">
              <div class="child">
                <img :src="o.imgUrl" class="img">
              </div>
            </a>
          </div>
          <div class="desc">
            <div class="title">
              {{ o.description }}
            </div>
            <!--          <div class="star">-->
            <!--            点赞-->
            <!--          </div>-->
            <avtar avatar-url="http://127.0.0.1:29090/api/file/download/QQ%E5%9B%BE%E7%89%8720210505153146.png"
                   href="http://www.baidu.com" name="zhang"></avtar>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import {getJson3} from "@/api/http";
import {img_getPage, ImgType_getPage} from "@/api/api";
import Avtar from "@/components/avtar";

export default {
  name: "Home",
  components: {Avtar},
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

.img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.img_box {
  margin: 1rem;
  background-color: #c6c8c5;
}

.title {
  margin: 1rem;
}
</style>