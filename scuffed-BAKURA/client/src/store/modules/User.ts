export default {
  state: {
    nom: null,
    email: null,
    role: {
      libelleRole: null,
      nivRole: null
    },
    avatar: null
  },
  getters: {
    getUserData: (state) => {
      return state;
    }
  },
  mutations: {
    setUserData: (state, {nom, email, role, avatar}) => {
      state.nom = nom;
      state.email = email;
      state.role = role;
      state.avatar = avatar;
    }
  },
  actions: {
    setUserData: ({commit}, userData) => {
      commit('setUserData', userData);
    }
  }
};
