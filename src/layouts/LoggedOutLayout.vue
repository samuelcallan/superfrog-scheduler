<script>
import Navigation from '@/components/Navigation.vue';
export default{
    components: {
        Navigation,
    }
}
</script>

<template>
<div class="template">
  <navigation class="navigation"></navigation>
  <hr id="separator">
    <div class="router-view">
        <router-view></router-view>
    </div>
</div>
</template>


<style>
.navigation {
  margin-bottom: 20px;
}
.home {
  background-color: #9b59b6;
  /* padding: 20px; */
}
#separator{
  height: 5px;
  border-color: red;
  border: none;
}
</style>