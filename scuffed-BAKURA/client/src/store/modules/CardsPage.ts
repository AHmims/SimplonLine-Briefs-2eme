export default {
  state: {
    currentPage: null,
    totalPages: null,
    cards: [],
    cardsType: 'all',
    archetype: '',
    cardsCount: 0
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
    getArchetype: (state: any) => {
      return state.archetype;
    },
    getCardsCount: (state: any) => {
      return state.cardsCount;
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
    },
    setArchetype: (state: any, archetype: String) => {
      state.archetype = archetype;
    },
    setCardsCount: (state: any, cardsCount: Number) => {
      state.cardsCount = cardsCount;
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
    },
    setArchetype: ({commit}: any, archetype: String) => {
      commit('setArchetype', archetype);
    },
    setCardsCount: ({commit}: any, cardsCount: Number) => {
      commit('setCardsCount', cardsCount);
    }
  }
};
