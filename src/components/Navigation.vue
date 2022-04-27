<template>
<div class="container">
  <nav class="navbar navbar-expand-lg">
    <a class="navbar-brand" href="#">
      <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/TCU_Horned_Frogs_logo.svg/1200px-TCU_Horned_Frogs_logo.svg.png" width="100" height="50" alt="">
    </a>
    <hr>
  <div class="collapse navbar-collapse justify-content-end" id="navbarNavDropdown">
    <ul class="navbar-nav">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Menu</a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
            <span v-for="route of $router.getRoutes()" :key="route.name">
                <router-link :to="{ name: route.name }" v-if="route.meta?.title" class="dropdown-item">{{
                  route.meta.title
                }}</router-link>
            </span>
          </div>
      </li>
    </ul>
  </div>
</nav>
</div>
</template>

<style lang="scss" scoped>
.nav-item{
  background-color: #4D1979;
}

.nav-link{
  color: white;
  border: 1px solid white;
}

</style>
