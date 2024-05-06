import { createRouter, createWebHashHistory } from 'vue-router'
 
const routes = [
 
  {
    path: '/aboutMd',
    component: () => import('../views/AboutMD.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
