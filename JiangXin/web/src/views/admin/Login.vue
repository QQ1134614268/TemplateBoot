<template>
  <el-tree
      :data="data"
      node-key="id"
      default-expand-all
      :props="defaultProps"
      @node-click="handleNodeClick"
  >
    <!-- 想当于for循环 -->
    <template #default="{ node, data }">
            <span class="custom-tree-node">
            </span>
    </template>
  </el-tree>
</template>

<script>
import Axios from "axios";

export default {
  data() {
    return {
      name: "",
      menulist: [],
      dialogVisible: false,
      MenuUpdate: false,
      data: [],
      defaultProps: {
        children: "children",
        label: "name",
      },
      pid: 0,
      cname: "",
      cateid: 0,

    };
  },
  components: {},
  methods: {
    handleNodeClick(data) {
      console.log("handleNodeClick", data.name);
    },
    getcatelist() {
      Axios.get("/meum/get_menu/")
          .then((resp) => {
            console.log(resp.data);
            if (resp.data.code == 200) {
              console.log(resp.data);
              this.data = resp.data.data;
            }
          })
          .catch((err) => {
            alert("获取失败");
            console.log(err);
          });
    },
    // 获取点击添加  某一条数据中的id   变为添加的新数据的父id
    add_id(data) {
      console.log("data添加", data);
      this.dialogVisible = true;
      this.pid = data.id;
    },
    // 获取点击修改时  某一条数据中的id   变为修改这条数据的id  修改数据id=原id 进行了传值
    put_update(data) {
      console.log("11111修改", data);
      this.id = data.id;
      this.cname = data.name
      this.MenuUpdate = true;
    },

    // 增加菜单-----添加是为了获取点击添加这条数据的id 变为新数据的pid父id ----然后再添加他的新名字就可以了
    append() {
      Axios.post("/meum/add_menu/", {name: this.cname, pid: this.pid}).then(
          (resp) => {
            if (resp.data.code == 200) {
              this.show = false;
              this.cname = "";
              this.cateid = 0;
              // tis.getcatelist() 相当于自动刷新
              this.getcatelist();
              this.dialogVisible = false;
            } else {
              alert("添加数据失败" + resp.data.message);
            }
          }
      );
    },

    // 修改菜单-----修改是修改的这个id的数据名字   要传入之前的id和之前数据的名字
    updatecates() {
      //   console.log("data.id修改>>>>", data.id);
      Axios.post("/meum/update_menu/", {name: this.cname, id: this.id}).then(
          (resp) => {
            if (resp.data.code == 200) {
              this.getcatelist();
              this.MenuUpdate = false;
            } else {
              alert("修改数据失败" + resp.data.msg);
            }
          }
      );
    },
    remove(data) {
      // 删除 点击删除获取到删除这条数据的data  然后从data里面获取到这条数据的id  变成传入数据的id
      var id = data.id;
      Axios.put("/meum/delete_menu/" + id + "/").then((res) => {
        console.log("id>>>", id);
        if ((res.data.code = 200)) {
          this.getcatelist();
        }
      });
    },
  },
  mounted() {
    this.getcatelist();
    // // this.test2()
    // // 从localStorage读取
    var resourcelist = localStorage.getItem("resourcelist");
    this.menulist = JSON.parse(resourcelist);
    this.menulist = ["menu/", "/add_menu"];
  },
};
</script>

<style>
</style>