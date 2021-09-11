import {CustomResponse, responseHandler} from '@/helpers/ResponseHandler';
import store from '@/store';

function likeCard(cardId: String): Promise<CustomResponse> {
  return new Promise((resolve, reject) => {
    // @ts-ignore
    axios.put(`${API_ENDPOINT}/favori/card/${cardId}`, {}, {
      headers: {
        'Authorization': `Bearer ${store.getters.getAuthToken}`
      }
    }).then(({data}: any) => {
      resolve(responseHandler(true, data));
    }).catch((error: Error) => {
      resolve(responseHandler(false, error));
    });
  });
}

function checkCard(cardId: String): Promise<CustomResponse> {
  return new Promise((resolve, reject) => {
    // @ts-ignore
    axios.get(`${API_ENDPOINT}/favori/card/${cardId}`, {
      headers: {
        'Authorization': `Bearer ${store.getters.getAuthToken}`
      }
    }).then(({data}: any) => {
      resolve(responseHandler(true, data));
    }).catch((error: Error) => {
      resolve(responseHandler(false, error));
    });
  });
}

function all(): Promise<CustomResponse> {
  return new Promise((resolve, reject) => {
    // @ts-ignore
    axios.get(`${API_ENDPOINT}/favori/me`, {
      headers: {
        'Authorization': `Bearer ${store.getters.getAuthToken}`
      }
    }).then(({data}: any) => {
      resolve(responseHandler(true, data));
    }).catch((error: Error) => {
      resolve(responseHandler(false, error));
    });
  });
}

export {
  likeCard,
  checkCard,
  all
};
