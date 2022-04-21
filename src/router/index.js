import { createRouter, createWebHistory } from 'vue-router';
import CustomerView from '../views/customerView.vue';
import TeamView from '../views/teamView.vue';
import Request from '../views/request.vue';
import Home from '../views/homeView.vue';
import Login from '../views/Login.vue';
import Account from '../views/account.vue';
import Signup from '../views/signup.vue';

// Create the router instance
const router = createRouter({
    // Provide the history implementation to use.
    history: createWebHistory(),
    // Define some route recods, each route record should map to a component.
    routes: [
        { path: '/', component: Home },
        { path: '/login', component: Login },
        { path: '/signup', component: Signup },
        { path: '/customerView', component: CustomerView },
        { path: '/teamView', component: TeamView },
        { path: '/account', component: Account },
        { path: '/request', component: Request },
    ],
});

export default router
