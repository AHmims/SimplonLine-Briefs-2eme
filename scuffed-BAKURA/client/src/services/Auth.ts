import Authentication from '@/models/login/Authentication';
import {CustomResponse, responseHandler} from '@/helpers/ResponseHandler';

function login(loginData: Authentication): Promise<CustomResponse> {
  return new Promise((resolve, reject) => {
    // @ts-ignore
    axios.post(`${API_ENDPOINT}/auth/login`, {
      email: loginData.email,
      password: loginData.password
    }).then(({data}: Response) => {
      resolve(responseHandler(true, data));
    }).catch((error: Error) => {
      resolve(responseHandler(false, error));
    });
  });
};

export {
  login
};
