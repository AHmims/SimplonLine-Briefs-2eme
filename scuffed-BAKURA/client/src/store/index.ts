import Vue from 'vue';
import Vuex from 'vuex';

import AuthModule from './modules/Auth';
import UserModule from './modules/User';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {},
  mutations: {},
  actions: {},
  modules: {
    AuthModule,
    UserModule
  },
});
