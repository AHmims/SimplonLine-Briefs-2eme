import Vue from 'vue';
import Vuex from 'vuex';

import AuthModule from './modules/Auth';
import UserModule from './modules/User';
import CardsPageModule from '@/store/modules/CardsPage';
import CardsPreview from '@/store/modules/CardsPreview';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {},
  mutations: {},
  actions: {},
  modules: {
    AuthModule,
    UserModule,
    CardsPageModule,
    CardsPreview
  },
});
