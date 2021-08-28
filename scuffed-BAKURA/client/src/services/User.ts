import {CustomResponse, responseHandler} from '@/helpers/ResponseHandler';
import store from '@/store/index';

function me(): Promise<CustomResponse> {
  return new Promise((resolve, reject) => {
    // @ts-ignore
    axios.get(`${API_ENDPOINT}/user`, {
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

function updateProfile(data: Object): Promise<CustomResponse> {
  return new Promise((resolve, reject) => {
    // @ts-ignore
    axios.put(`${API_ENDPOINT}/user`, data, {
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
  me,
  updateProfile
};
