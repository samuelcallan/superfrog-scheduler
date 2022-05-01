
const dynamicRoutes = [
  {
    path: '/customerManagement',
    name: 'Customer Management',
    meta: { title: 'Customer', permissions: ['director'] },
    component: () => import('@/views/customerView.vue'),
  },
  {
    path: '/teamManagement',
    name: 'Team Management',
    meta: { title: 'Team', permissions: ['director'] },
    component: () => import('@/views/teamView.vue'),
  },
  {
    path: '/approval',
    name: 'Approval',
    meta: {
        title: 'Approval',
        permissions: ['director'],
    },  
    component: () => import('@/views/approvalView.vue')
  },
  {
    path: '/superfrogManagement',
    name: 'Superfrog Approval',
    meta: {
      title: 'SuperfrogApproval',
      permissions: ['director'],
    },
    component: () => import('@/views/superfrogView.vue')
  }
];  

export default dynamicRoutes;


