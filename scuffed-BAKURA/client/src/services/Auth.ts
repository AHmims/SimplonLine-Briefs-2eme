import Authentication from '@/models/login/Authentication';
import {CustomResponse, responseHandler} from '@/helpers/ResponseHandler';
import store from '@/store';
import UserMainData from '@/models/login/UserMainData';

function login(loginData: Authentication): Promise<CustomResponse> {
  return new Promise((resolve, reject) => {
    // @ts-ignore
    axios.post(`${API_ENDPOINT}/auth/login`, loginData).then(({data}: any) => {
      resolve(responseHandler(true, data));
    }).catch((error: Error) => {
      resolve(responseHandler(false, error));
    });
  });

}

function signup(userData: UserMainData): Promise<CustomResponse> {
  return new Promise((resolve, reject) => {
    // @ts-ignore
    axios.post(`${API_ENDPOINT}/auth/signup`, userData).then(({data}: any) => {
      resolve(responseHandler(true, data));
    }).catch((error: Error) => {
      resolve(responseHandler(false, error));
    });
  });
}

function ping(): Promise<CustomResponse> {
  return new Promise((resolve, reject) => {
    // @ts-ignore
    axios.get(`${API_ENDPOINT}/ping`, {
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
  login,
  ping,
  signup
};
