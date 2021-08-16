export default {
  state: {
    currentPage: null,
    totalPages: null,
    cards: []
  },
  getters: {
    getCurrentPage: (state: any) => {
      return state.currentPage;
    },
    getTotalPages: (state: any) => {
      return state.totalPages;
    },
    getCards: (state: any) => {
      return state.cards;
    },
    getNextPage: (state: any) => {
      let nextPage = state.currentPage + 1;

      return state.totalPages < nextPage ? state.currentPage : nextPage;
    }
  },
  mutations: {
    setCurrentPage: (state: any, currentPage: number) => {
      state.currentPage = currentPage;
    },
    setTotalPages: (state: any, totalPages: number) => {
      state.totalPages = totalPages;
    },
    setCards: (state: any, cards: []) => {
      state.cards = cards;
    }
  },
  actions: {
    setCurrentPage: ({commit}: any, currentPage: number) => {
      commit('setCurrentPage', currentPage);
    },
    setTotalPages: ({commit}: any, totalPages: number) => {
      commit('setTotalPages', totalPages);
    },
    setCards: ({commit}: any, cards: []) => {
      commit('setCards', cards);
    }
  }
};
