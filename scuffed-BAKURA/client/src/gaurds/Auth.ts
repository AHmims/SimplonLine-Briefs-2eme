import {NavigationGuardNext, Route} from 'vue-router';
import store from '@/store/index';
import {ping} from '@/services/Auth';

const isAuthenticated = async (to: Route, from: Route, next: NavigationGuardNext) => {
  next();
};

export {
  isAuthenticated
};
