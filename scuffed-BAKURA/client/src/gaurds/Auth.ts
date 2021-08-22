import {NavigationGuardNext, Route} from 'vue-router';
import {ping} from '@/services/Auth';

const isAuthenticated = async (to: Route, from: Route, next: NavigationGuardNext) => {
  const response = await ping();
  if (response.status) {
    next();
  } else {
    next({name: from.name ?? 'Home'});
  }

};

const isNotAuthenticated = async (to: Route, from: Route, next: NavigationGuardNext) => {
  const response = await ping();
  if (response.status) {
    next({name: from.name ?? 'Home'});
  } else {
    next();
  }
};

export {
  isAuthenticated,
  isNotAuthenticated
};
