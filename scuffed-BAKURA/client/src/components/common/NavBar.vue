<template>
  <div style="display: flex; align-items: center; justify-content: center">
    <div id="nav">
      <router-link to="/">Home</router-link>
      |
      <router-link to="/cards">Cards</router-link>
      |
      <router-link to="/about">About</router-link>
      |
      <router-link to="/login">Login</router-link>
      |
      <router-link to="/signup">Signup</router-link>
    </div>
    <div v-if="isAuthenticated">
      <h5>Le me: </h5>
      <div v-if="user === null">
        <span>Loading...</span>
      </div>
      <div v-else>
        <router-link to="/profile"><h6>{{ user.nom }}</h6></router-link>
        <router-link to="/settings">Settings</router-link>
        <button type="button" @click="logOut">Log-out</button>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import {ping} from '@/services/Auth';
import {me} from '@/services/User';
import UserMainData from '@/models/user/UserMainData';

export default {
  name: 'nav-bar',
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
        return this.$store.getters.getAuthToken;
      },
      (val: any) => {
        if (val != null) {
          this.initUser();
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
      } else {
        console.error(userResponse.data);
      }
    },
    logOut() {
      this.$store.commit('setAuthToken', null);
      if(this.$route.name != 'Home') {
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
