import {CustomResponse, responseHandler} from '@/helpers/ResponseHandler';
import store from '@/store/index';

function getAllCards(page = 0 as number, size = 25 as number): Promise<CustomResponse> {
  return new Promise((resolve, reject) => {
    // @ts-ignore
    axios.get(`${API_ENDPOINT}/card`, {
      params: {
        page,
        size
      }
    }).then(({data}: any) => {
      resolve(responseHandler(true, data));
    }).catch((error: Error) => {
      resolve(responseHandler(false, error));
    });
  });
}

export {
  getAllCards
};
