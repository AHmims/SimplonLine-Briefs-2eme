<template>
  <div>
    <form @submit.prevent="signup()">
      <h2>Signup form</h2>
      <div>
        <label for="login-avatar">Avatar</label>
        <input type="text" name="avatar" id="login-avatar" v-model="userData.avatar" disabled>
      </div>
      <div>
        <label for="login-username">UserName</label>
        <input type="text" name="username" id="login-username" v-model="userData.nom">
      </div>
      <div>
        <label for="login-email">Email</label>
        <input type="text" name="email" id="login-email" v-model="userData.email">
      </div>
      <div>
        <label for="login-pass">Password</label>
        <input type="password" name="password" id="login-pass" v-model="userData.password">
      </div>
      <div>
        <label for="login-passConfirm">Confirm your password</label>
        <input type="password" name="passwordConfirmation" id="login-passConfirm" v-model="passwordConfirmation">
      </div>
      <button type="submit" :disabled="isLoading">{{ isLoading ? '~~' : 'Signup' }}</button>
    </form>
  </div>
</template>

<script lang="ts">
import UserMainData from '@/models/user/UserMainData';
import {signup} from '@/services/Auth';

export default {
  props: {},
  data() {
    return {
      userData: {} as UserMainData,
      passwordConfirmation: null as string,
      isLoadingCards: false as boolean
    };
  },
  created() {
  },
  methods: {
    async signup(){
      this.isLoading = true;
      const signupResponse = await signup(this.userData);
      this.isLoading = false;

      if (signupResponse.status === true) {
        console.log(signupResponse.data);
      } else {
        console.error(response.data);
      }
    }
  }
};
</script>
