import Vue from 'vue';
import VueRouter, {RouteConfig} from 'vue-router';

import Home from '@/views/Home.vue';
import About from '@/views/About.vue';
import Login from '@/views/Login.vue';
import Signup from '@/views/Signup.vue';
import Cards from '@/views/Cards.vue';

import {isNotAuthenticated} from '@/gaurds/Auth';

Vue.use(VueRouter);

const routes: Array<RouteConfig> = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/cards',
    name: 'Cards',
    component: Cards
  },
  {
    path: '/about',
    name: 'About',
    component: About
  },
  {
    path: '/login',
    name: 'Login',
    component: Login,
    beforeEnter: (to, from, next) => {
      isNotAuthenticated(to, from, next);
    }
  },
  {
    path: '/signup',
    name: 'Signup',
    component: Signup,
    beforeEnter: (to, from, next) => {
      isNotAuthenticated(to, from, next);
    }
  }
];

const router = new VueRouter({
  mode: 'history',
  base: import.meta.env.BASE_URL,
  routes,
});

export default router;
