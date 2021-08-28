<template>
  <div style="display: flex; align-items: center; justify-content: center">
    <div id="nav">
      <router-link to="/">Home</router-link>
      <router-link to="/cards"> | Cards</router-link>
      <router-link to="/about"> | About</router-link>
      <router-link to="/login" v-if="!isAuthenticated"> | Login</router-link>
      <router-link to="/signup" v-if="!isAuthenticated">| Signup</router-link>
    </div>
    <div v-if="isAuthenticated">
      <h5>Le me: </h5>
      <div v-if="user === null">
        <span>Loading...</span>
      </div>
      <div v-else>
        <img :src="getImageUrl(user.avatar.lienImage)" alt=""
             style="width: 60px; height: 60px; object-fit: cover; border-radius: 9999px">
        <router-link to="/profile"><h6>{{ user.nom }}</h6></router-link>
        <router-link to="/settings">Settings</router-link>
        <button type="button" @click="logOut">Log-out</button>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import Util from '@/helpers/Util';
import {ping} from '@/services/Auth';
import {me} from '@/services/User';
import UserMainData from '@/models/user/UserMainData';

export default {
  name: 'nav-bar',
  mixins: [Util],
  props: {},
  data() {
    return {
      isAuthenticated: false as Boolean,
      user: null as UserMainData
    };
  },
  async mounted() {
    this.$store.watch(
      (state: any) => {
        return {token: this.$store.getters.getAuthToken, userData: this.$store.getters.getUserData};
      },
      (val: any) => {
        if (val.token != null && val.userData === this.user) {
          this.initUser();
          return;
        }

        if (val.userData != this.user) {
          this.user = val.userData;
        }
      },
      {
        deep: true
      }
    );
    await this.initUser();
  },
  methods: {
    async initUser() {
      const pingResponse = await ping();
      this.isAuthenticated = pingResponse.status;

      if (!this.isAuthenticated) {
        return;
      }

      const userResponse = await me();
      if (userResponse.status === true) {
        this.user = userResponse.data;

        await this.$store.dispatch('setUserData', this.user);
      } else {
        console.error(userResponse.data);
      }
    },
    logOut() {
      this.$store.commit('setAuthToken', null);
      if (this.$route.name != 'Home') {
        this.$router.push({name: 'Home'});
      }
    }
  }
};
</script>

<style lang="scss">
#nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
