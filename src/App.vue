<script>
import { RouterLink, RouterView } from 'vue-router';
</script>

<template>
<nav class="navbar navbar-expand-lg text-light" id="mainNav" style="background-color:purple;">
  <a class="navbar-brand" href="#">SuperFrog</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link text-light" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <RouterLink class="nav-link text-light" to="/teamView">Team Managment</RouterLink>
      </li>
      <li class="nav-item">
        <RouterLink class="nav-link text-light" to="/customerView">Customer Managment</RouterLink>
      </li>
      <li class="nav-item">
        <RouterLink class="nav-link text-light" to="/request">Schedule a Request</RouterLink>
      </li>
    </ul>
  </div>
</nav>
<RouterView></RouterView>
</template>

<style lang="scss" scoped>
  .navbar-brand{
    margin-left: 10px;
    color: white;
  }

</style>
