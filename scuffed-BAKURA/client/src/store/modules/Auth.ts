export default {
  state: {
    auth_token: null
  },
  getters: {
    getAuthToken: (state) => {
      if (state.auth_token == null) {
        state.auth_token = localStorage.getItem('SB_AUTH_TOKEN');
      }

      return state.auth_token;
    }
  },
  mutations: {
    setAuthToken: (state, token) => {
      state.auth_token = token;
      localStorage.setItem('SB_AUTH_TOKEN', token);
    }
  },
  actions: {
    setAuthToken: ({commit}, token) => {
      commit('setAuthToken', token);
    }
  }
};
