<template>
  <div style="flex-grow: 1">
    <!--  <div>滚动图</div>-->
    <!--  风格 tag标签-->
    <div class="tagBox">
      <el-button :key="o.id" v-for="o in tagList" @click="initSearch(o.id)" class="tag">{{ o.label }}</el-button>
    </div>
    <div class="page">
      <div v-if="imgs.length!==0" class="p_c_flexbox content">
        <div :key="o.id" v-for="o in imgs" class="col-3">
          <div class="img_box">
            <div class="parent">
              <a :href="'/Info?id='+o.id">
                <div class="child">
                  <img :src="o.imgUrl" class="img" alt="">
                </div>
              </a>
            </div>
            <div class="desc">
              <div class="title">
                <span>
                  {{ o.description }}
                </span>
                <span class="star">
                  点赞
                </span>
              </div>
              <avtar class="avtar"
                     avatar-url="http://127.0.0.1:29090/api/file/download/QQ%E5%9B%BE%E7%89%8720210505153146.png"
                     href="https://www.baidu.com" name="zhang"></avtar>
            </div>
          </div>
        </div>
      </div>
      <el-empty v-else description="没有数据"></el-empty>
      <el-pagination
          @size-change="init"
          @current-change="init"
          :current-page="current"
          :page-sizes="[16, 32, 64]"
          layout="total, sizes, prev, pager, next, jumper"
          :page-size="size"
          :total="total">
      </el-pagination>
    </div>
  </div>
</template>
<script>
import {getJson3} from "@/api/http";
import {img_getPage, ImgType_getPage} from "@/api/api";
import Avtar from "@/components/avtar";

export default {
  name: "HomeComponent",
  components: {Avtar},
  data() {
    return {
      imgs: [],
      Info: 123,
      tagList: [],
      size: 16,
      total: 0,
      current: 1,
      page: {},
    }
  },
  methods: {
    go(url) {
      this.$router.push(url)
    },
    async initSearch(typeId) {
      let data = {
        parentId: 0,
        typeId: typeId,
        current: this.current,
        size: this.size
      }
      let ret = await getJson3(img_getPage, data)
      this.imgs = ret.data.records;
      this.size = ret.data.size;
      this.total = ret.data.total;
      this.current = ret.data.current;
      this.page = ret.data
      console.info("分页数据", this.page)
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
  width: 100%;
  height: 4.8rem;
  margin: 1rem 0;

  background-color: inherit;

  display: flex;
  align-content: center;
  justify-content: center;
  flex-wrap: wrap;

  .tag {
    background-color: red;
  }
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
  display: flex;
  justify-content: space-between;

}

.avtar {
  margin: 0 1rem;
}
</style>