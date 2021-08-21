import {CustomResponse, responseHandler} from '@/helpers/ResponseHandler';

function getArchetypesList(): Promise<CustomResponse> {
  return new Promise((resolve, reject) => {
    // @ts-ignore
    axios.get(`${API_ENDPOINT}/archetype`).then(({data}: any) => {
      resolve(responseHandler(true, data));
    }).catch((error: Error) => {
      resolve(responseHandler(false, error));
    });
  });
}

export {
  getArchetypesList
};
