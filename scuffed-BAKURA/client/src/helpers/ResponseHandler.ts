interface CustomResponse {
  status: Boolean,
  data: any
}

function responseHandler(status: boolean, data: any) {
  return {
    status,
    data
  } as CustomResponse;
};

export {
  responseHandler, CustomResponse
};
