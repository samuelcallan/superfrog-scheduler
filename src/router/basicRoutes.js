const basicRoutes = [
    {
        path: '/',
        name: 'LoggedOutLayout',
        meta: {
            requiresAuth: false,
        },
        component: () => import('@/layouts/LoggedOutLayout.vue'),
        children: [
            {
                path: 'home',
                name: 'home',
                meta: {
                    title: 'Home',
                    requiresAuth: false,
                },
                component: () => import('@/views/homeView.vue'),
            },
            {
                path: 'request',
                name: 'request',
                meta: {
                    title: 'Request',
                    requiresAuth: true,
                },
                component: () => import('@/views/request.vue')
            },
            {
                path: '/account',
                name: 'account',
                meta: { 
                    title: 'Account', 
                    requiresAuth: true,
                },
                component: () => import('@/views/account.vue'),
              },
              {
                path: '/signup',
                name: 'signup',
                meta: { 
                    title: 'Sign-Up', 
                    requiresAuth: false,
                },
                component: () => import('@/views/signup.vue'),
              },
        ],
    },
    {
        path: '/auth',
        meta: {
            requiresAuth: false,
        },
        component: () => import('@/layouts/CustomerLayout.vue'),
        children: [
            {
                path: '/login',
                name: 'auth.login',
                component: () => import('@/views/Login.vue'),
                meta: {
                    visiterOnly: true,
                    requiresAuth: false,
                },
            },
        ],
    },
];

export default basicRoutes;