import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/orders',
      component: () => import('../components/ui/OrderGrid.vue'),
    },
    {
      path: '/delivers',
      component: () => import('../components/ui/DeliverGrid.vue'),
    },
    {
      path: '/inventories',
      component: () => import('../components/ui/InventoryGrid.vue'),
    },
    {
      path: '/mypages',
      component: () => import('../components/MypageView.vue'),
    },
  ],
})

export default router;
