import Vue from 'vue'
import VueRouter from 'vue-router'
import DeptView from '../views/tlias/DeptView.vue'

Vue.use(VueRouter)

// 我们默认的路由路径是/,但是路由配置中没有对应的关系，
// 所以我们需要在路由配置中/对应的路由组件
// redirect:'/emp' //表示重定向到/emp即可

const routes = [
  {
    path: '/dept',
    name: 'dept',
    component: DeptView
  },
  {
    path: '/emp',
    name: 'emp',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/tlias/EmpView.vue')
  },

  {
    path: '/',
    redirect:'/emp'
  }
]

const router = new VueRouter({
  routes
})

export default router
