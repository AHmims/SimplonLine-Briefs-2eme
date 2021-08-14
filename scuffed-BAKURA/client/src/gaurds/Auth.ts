import {NavigationGuardNext, Route} from 'vue-router';
import store from '@/store/index';

const isAuthenticated = (to: Route, from: Route, next: NavigationGuardNext) => {
  console.log(store.getters.getAuthToken);
  next();
};

export {
  isAuthenticated
};
