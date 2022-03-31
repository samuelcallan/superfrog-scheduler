<script>
import { RouterLink, RouterView } from 'vue-router';
</script>

<template>
<header>
  <div class="logo">
    <img alt="Vue logo" src="./assets/logo.png" width="125" height="125" />
  </div>  
  <div class="greeting">
    <p>Welcome to Vue Router!</p>
  </div>
  <nav>
    <RouterLink to="/customerView">Customers</RouterLink>
    <RouterLink to="/teamView">Teams</RouterLink>
  </nav>
</header>
  <RouterView></RouterView>
</template>

<style lang="scss" scoped>
#app {
  width: 100vw;
  margin: 0 auto;
  padding: 2rem;
  font-weight: normal;
}

header {
  line-height: 1.5;
  margin-bottom: 1rem;
}
.logo {
  display: flex;
  justify-content: center;
}
.greeting {
  display: flex;
  justify-content: center;
  margin-top: 1rem;
}
nav {
  display: flex;
  justify-content: center;
  margin-top: 1rem;
  a {
    display: inline-block;
    padding: 0 1rem;
    text-decoration: none;
    color: hsla(160, 100%, 37%, 1);
    transition: 0.4s;
    &:hover {
      background-color: hsla(160, 100%, 37%, 0.2);
    }
    &:first-of-type {
      border: 0;
    }
  }
}
</style>
