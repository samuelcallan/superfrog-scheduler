
const dynamicRoutes = [
  {
    path: '/customerManagement',
    name: 'customer Management',
    meta: { title: 'Customer', permissions: ['Customer'] },
    component: () => import('@/views/CustomerView.vue'),
  },
  {
    path: '/account',
    name: 'account',
    meta: { title: 'VIP Users', permissions: ['users'] },
    component: () => import('@/views/account.vue'),
  },
];

export default dynamicRoutes;
