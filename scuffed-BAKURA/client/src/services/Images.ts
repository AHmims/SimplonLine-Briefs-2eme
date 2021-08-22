import {CustomResponse, responseHandler} from '@/helpers/ResponseHandler';

function getDefaultAvatars(): Promise<CustomResponse> {
  return new Promise((resolve, reject) => {
    // @ts-ignore
    axios.get(`${API_ENDPOINT}/image/avatars`).then(({data}: any) => {
      resolve(responseHandler(true, data));
    }).catch((error: Error) => {
      resolve(responseHandler(false, error));
    });
  });
}


export {
  getDefaultAvatars
};
