<template>
  <div>
    <h3>Account settings</h3>
    <avatar-picker/>
    <div>
      <input type="text" placeholder="username" v-model="userName">
      <button type="button" @click="updateUserData({nom: userName})">Change username</button>
    </div>
    <div>
      <input type="text" placeholder="email" v-model="userEmail">
      <button type="button" @click="updateUserData({email: userEmail})">Change email</button>
    </div>
    <div>
      <input type="password" placeholder="password" v-model="userPassword">
      <button type="button" @click="updateUserData({password: userPassword})">Change password</button>
    </div>
  </div>
</template>

<script lang="ts">
import AvatarPicker from '@/components/common/AvatarPicker.vue';
import {updateProfile} from '@/services/User';

export default {
  name: 'account-settings',
  components: {AvatarPicker},
  data() {
    return {
      userName: null,
      userEmail: null,
      userPassword: null
    };
  },
  mounted() {
  },
  created() {
    const userData = this.$store.getters.getUserData;
    this.userName = userData.nom;
    this.userEmail = userData.email;
  },
  methods: {
    async updateUserData(data) {
      const response = await updateProfile(data);

      if (response.status === true) {
        await this.$store.dispatch('setUserData', response.data);
      } else {
        console.error(response.data);
      }
    }
  }
};
</script>

<style scoped>
div > div:not(:last-of-type) {
  margin-bottom: 20px;
}
</style>
