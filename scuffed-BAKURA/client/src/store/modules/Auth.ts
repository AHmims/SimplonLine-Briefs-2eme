declare interface State {
  auth_token: string | null;
}

export default {
  state: {
    auth_token: null
  },
  getters: {
    getAuthToken: (state: State) => {
      if (state.auth_token == null) {
        state.auth_token = localStorage.getItem('SB_AUTH_TOKEN');
      }

      return state.auth_token;
    }
  },
  mutations: {
    setAuthToken: (state: State, token: string) => {
      state.auth_token = token;
      localStorage.setItem('SB_AUTH_TOKEN', token);
    }
  },
  actions: {
    setAuthToken: ({commit}: any, token: string) => {
      commit('setAuthToken', token);
    }
  }
};
