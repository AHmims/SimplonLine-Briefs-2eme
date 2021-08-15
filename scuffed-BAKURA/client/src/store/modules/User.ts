declare interface State {
  nom: string,
  email: string,
  role: Object,
  avatar: string | null
}

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
    getUserData: (state: State) => {
      return state;
    }
  },
  mutations: {
    setUserData: (state: State, {nom, email, role, avatar}: State) => {
      state.nom = nom;
      state.email = email;
      state.role = role;
      state.avatar = avatar;
    }
  },
  actions: {
    setUserData: ({commit}: any, userData: State) => {
      commit('setUserData', userData);
    }
  }
};
