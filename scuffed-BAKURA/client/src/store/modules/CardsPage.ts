export default {
  state: {
    currentPage: null,
    totalPages: null,
    cards: [],
    cardsType: 'all'
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
    getCardsType: (state: any) => {
      return state.cardsType;
    },
    getNextPage: (state: any) => {
      let nextPage = state.currentPage + 1;

      return state.totalPages < nextPage ? state.currentPage : nextPage;
    }
  },
  mutations: {
    setCurrentPage: (state: any, currentPage: Number) => {
      state.currentPage = currentPage;
    },
    setTotalPages: (state: any, totalPages: Number) => {
      state.totalPages = totalPages;
    },
    setCards: (state: any, cards: []) => {
      state.cards = cards;
    },
    setCardsType: (state: any, cardsType: String) => {
      state.cardsType = cardsType;
    }
  },
  actions: {
    setCurrentPage: ({commit}: any, currentPage: Number) => {
      commit('setCurrentPage', currentPage);
    },
    setTotalPages: ({commit}: any, totalPages: Number) => {
      commit('setTotalPages', totalPages);
    },
    setCards: ({commit}: any, cards: []) => {
      commit('setCards', cards);
    },
    setCardsType: ({commit}: any, cardsType: String) => {
      commit('setCardsType', cardsType);
    }
  }
};
