
const dynamicRoutes = [
  {
    path: '/customerManagement',
    name: 'Customer Management',
    meta: { title: 'Customer', permissions: ['director'] },
    component: () => import('@/views/CustomerView.vue'),
  },
  {
    path: '/teamManagement',
    name: 'Team Management',
    meta: { title: 'Team', permissions: ['director'] },
    component: () => import('@/views/teamView.vue'),
  },
];

export default dynamicRoutes;


