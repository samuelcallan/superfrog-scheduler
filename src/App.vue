<script>
import { RouterLink, RouterView } from 'vue-router';
export default {
  components:{
    RouterLink,
    RouterView
  }
}
</script>

<template>
<RouterView></RouterView>
</template>

<style lang="scss" scoped>
  .navbar-brand{
    margin-left: 10px;
    color: white;
  }

</style>
