<template>
  <div>
    <form @submit.prevent="login()">
      <h2>Login form</h2>
      <div>
        <label for="login-email">Email</label>
        <input type="text" name="email" id="login-email" v-model="auth.email">
      </div>
      <div>
        <label for="login-pass">Password</label>
        <input type="password" name="password" id="login-pass" v-model="auth.password">
      </div>
      <button type="submit" :disabled="isLoading">{{ isLoading ? '~~' : 'Login' }}</button>
    </form>
  </div>
</template>

<script lang="ts">
import Authentication from '@/models/login/Authentication';

export default {
  name: 'login',
  props: {},
  data() {
    return {
      auth: new Authentication,
      isLoading: false as Boolean
    };
  },
  methods: {
    login(): void {
      this.isLoading = true;
      // @ts-ignore
      axios.post(`${API_ENDPOINT}/auth/login`, {
        email: this.auth.email,
        password: this.auth.password
      }).then((response: Response) => {
        console.log(response);
      }).catch((error: Error) => {
        console.error(error);
      }).finally(() => {
        this.isLoading = false;
      });
    }
  }
};
</script>
