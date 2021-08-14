import Authentication from '@/models/login/Authentication';

const login = (loginData: Authentication) => {
  return new Promise((resolve, reject) => {
    // @ts-ignore
    axios.post(`${API_ENDPOINT}/auth/login`, {
      email: loginData.email,
      password: loginData.password
    }).then(({data}: Response) => {
      resolve(responseHandler(true, data));

      //this.$store.dispatch('setUserData', response.data);
      //this.$store.dispatch('setAuthToken', response.data.token);
    }).catch((error: Error) => {
      resolve(responseHandler(false, error));
    });
  });
};

const responseHandler = (status: boolean, data: any) => {
  return {
    status,
    data
  };
};

export {
  login
};
