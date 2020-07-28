import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login.vue'
import Registered from '../views/Registered.vue'
import HomePage from '../views/HomePage.vue'
import MyCollect from '../views/MyCollect.vue'
import Write from '../views/Write.vue'

import PersonalSpace from "../views/PersonalSpace.vue";
import PersonalDate from "../views/PersonalDate.vue";
import Ask from "../views/Ask.vue";
import Favorite from "../views/Favorite";
import Test from "../views/Test";

Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login
  },
  {
    path: '/register',
    name: 'Registered',
    component: Registered
  },
  {
    path: '/home',
    name: 'HomePage',
    component: HomePage
  },
  {
    path: '/mycollect',
    name: 'MyCollect',
    component: MyCollect
  },
  {
    path: '/write',
    name: 'Write',
    component: Write
  },
    {
      path: '/personalSpace',
      name: 'PersonalSpace',
      component: PersonalSpace,
      redirect:'/1',
      children:[
          {path:'/1',component:Ask},
        {path:'/2-1',component:Favorite},
        ],
    },
    {
      path: '/personalDate',
      name: 'PersonalDate',
      component: PersonalDate,
    },
    {
      path: '/test',
      name: 'Test',
      component: Test,
    },

  ]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
