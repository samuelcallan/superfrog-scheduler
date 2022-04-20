import { createRouter, createWebHistory } from 'vue-router';

import CustomerView from '../views/customerView.vue';
import TeamView from '../views/teamView.vue';
import Request from '../views/request.vue';
import Home from '../views/homeView.vue';
import Login from '../views/Login.vue';



// Create the router instance
const router = createRouter({
    // Provide the history implementation to use.
    history: createWebHistory(),
    // Define some route recods, each route record should map to a component.
    routes: [
        { path: '/', component: Home },
        { path: '/login', component: Login },
        { path: '/customerView', component: CustomerView },
        { path: '/teamView', component: TeamView },
        { path: '/request', component: Request },
    ],
});

export default router
