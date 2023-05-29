<template>
  <a :href="href">
    <div class="avatarBox">
      <img :src="avatarUrl" class="img">
      <div>{{ name }}</div>
    </div>
  </a>

</template>

<script>
export default {
  name: "avtar",
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
}

.img {
  margin: 1rem;
  object-fit: cover;
  width: 3rem;
  height: 3rem;
  border-radius: 50%;
}
</style>