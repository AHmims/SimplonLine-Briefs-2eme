interface CustomResponse {
  status: Boolean,
  data: any
}

const responseHandler = (status: boolean, data: any) => {
  return {
    status,
    data
  } as CustomResponse;
};

export {
  responseHandler, CustomResponse
};
