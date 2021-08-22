import Card from '@/models/card/Card';

export default {
  state: {
    cardPreviewVisible: false,
    cardPreviewData: null,
    cardPreviewId: ''
  },
  getters: {
    isCardPreviewVisible: (state: any) => {
      return state.cardPreviewVisible;
    },
    getCardPreviewData: (state: any) => {
      return state.cardPreviewData;
    },
    getCardPreviewId: (state: any) => {
      return state.cardPreviewId;
    }
  },
  mutations: {
    setCardPreviewVisible: (state: any, cardPreviewVisible: boolean) => {
      state.cardPreviewVisible = cardPreviewVisible;
    },
    setCardPreviewData: (state: any, cardPreviewData: Card) => {
      state.cardPreviewData = cardPreviewData;
    },
    setCardPreviewId: (state: any, cardPreviewId: String) => {
      state.cardPreviewId = cardPreviewId;
    }
  },
  actions: {
    setCardPreviewVisible: ({commit}: any, cardPreviewVisible: boolean) => {
      commit('setCardPreviewVisible', cardPreviewVisible);
    },
    setCardPreviewData: ({commit}: any, cardPreviewData: Card) => {
      commit('setCardPreviewData', cardPreviewData);
    },
    setCardPreviewId: ({commit}: any, cardPreviewId: String) => {
      commit('setCardPreviewId', cardPreviewId);
    }
  }
};
