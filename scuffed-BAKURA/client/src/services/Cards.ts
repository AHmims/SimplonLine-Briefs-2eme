import {CustomResponse, responseHandler} from '@/helpers/ResponseHandler';

function getAllCards(page = 0 as Number, size = 25 as Number, cardType = 'all' as String): Promise<CustomResponse> {
  return new Promise((resolve, reject) => {
    // @ts-ignore
    axios.get(`${API_ENDPOINT}/card`, {
      params: {
        page,
        size,
        cardType
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
