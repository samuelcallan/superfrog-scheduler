import { createRouter, createWebHistory } from 'vue-router';

import CustomerView from '../views/customerView.vue';
import TeamView from '../views/teamView.vue';



// Create the router instance
const router = createRouter({
    // Provide the history implementation to use.
    history: createWebHistory(),
    // Define some route recods, each route record should map to a component.
    routes: [
        { path: '/customerView', component: CustomerView },
        { path: '/teamView', component: TeamView },
    ],
});

export default router
