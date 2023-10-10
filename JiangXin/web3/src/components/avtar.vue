<template>
  <div>
    <a :href="href">
      <div class="avatarBox">
        <img src="@/assets/logo.jpg" class="img" alt="图片加载失败">
        <div class="text">{{ name }}</div>
      </div>
    </a>
  </div>

</template>

<script>
export default {
  name: "AvtarComponent",
  props: {
    avatarUrl: String,
    name: String,
    href: String,
  }
}
</script>

<style scoped>
.avatarBox {
  display: flex;
  justify-content: flex-start;
  align-content: center;
  align-items: center;

  .img {
    width: 2rem;
    height: 2rem;
    margin: 0.2rem;
    object-fit: cover;
    border-radius: 50%;
  }

  .text {
    font-size: 0.8rem;
    color: gray;
  }
}

</style>