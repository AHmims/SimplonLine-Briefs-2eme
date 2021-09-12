import {CustomResponse, responseHandler} from '@/helpers/ResponseHandler';

function getAllCards(
  page = 0 as Number,
  size = 28 as Number,
  cardType = 'all' as String,
  archetype = '' as String
): Promise<CustomResponse> {
  return new Promise((resolve, reject) => {
    // @ts-ignore
    axios
      .get(`${API_ENDPOINT}/card`, {
        params: {
          page,
          size,
          cardType,
          archetype,
        },
      })
      .then(({data}: any) => {
        resolve(responseHandler(true, data));
      })
      .catch((error: Error) => {
        resolve(responseHandler(false, error));
      });
  });
}

function searchForCards(
  searchText: String,
  page = 0 as Number,
  size = 28 as Number,
  cardType = 'all' as String
): Promise<CustomResponse> {
  return new Promise((resolve, reject) => {
    // @ts-ignore
    axios
      .get(`${API_ENDPOINT}/card/search/minified`, {
        params: {
          searchText,
          page,
          size,
          cardType,
        },
      })
      .then(({data}: any) => {
        resolve(responseHandler(true, data));
      })
      .catch((error: Error) => {
        resolve(responseHandler(false, error));
      });
  });
}

function getCardData(cardId: String): Promise<CustomResponse> {
  return new Promise((resolve, reject) => {
    // @ts-ignore
    axios
      .get(`${API_ENDPOINT}/card/${cardId}`)
      .then(({data}: any) => {
        resolve(responseHandler(true, data));
      })
      .catch((error: Error) => {
        resolve(responseHandler(false, error));
      });
  });
}

export {getAllCards, searchForCards, getCardData};
