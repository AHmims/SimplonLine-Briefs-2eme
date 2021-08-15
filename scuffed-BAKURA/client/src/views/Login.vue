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
import {login} from '@/services/Auth';

export default {
  name: 'login',
  props: {},
  data() {
    return {
      auth: {} as Authentication,
      isLoading: false as Boolean
    };
  },
  created() {
    this.auth.email = 'ali.hmims99@gmail.com';
    this.auth.password = '123456789';
  },
  methods: {
    async login() {
      this.isLoading = true;
      const response = await login(this.auth);
      this.isLoading = false;

      if (response.status === true) {
        await this.$store.dispatch('setUserData', response.data);
        await this.$store.dispatch('setAuthToken', response.data.token);
      } else {
        console.error(response.data);
      }
    }
  }
};
</script>
