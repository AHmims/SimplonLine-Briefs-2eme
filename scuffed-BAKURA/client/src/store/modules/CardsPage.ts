export default {
  state: {
    currentPage: 0 as number,
    totalPages: 0 as number
  },
  getters: {
    getCurrentPage: (state: any) => {
      return state.currentPage;
    },
    getTotalPages:  (state: any) => {
      return state.totalPages;
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
    }
  },
  actions: {
    setCurrentPage: ({commit}: any, currentPage: number) => {
      commit('setCurrentPage', currentPage);
    },
    setTotalPages: ({commit}: any, totalPages: number) => {
      commit('setTotalPages', totalPages);
    }
  }
};
