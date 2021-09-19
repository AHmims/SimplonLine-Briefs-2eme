<template>
  <div class="">
    <h1 class="text-3xl text-coolGray-800 font-bold mb-1.5">Settings:</h1>
    <div class="flex mt-4 space-x-16">
      <avatar-picker />
      <div class="flex flex-col flex-1">
        <h2 class="text-xl text-blueGray-800 font-semibold mb-5">
          Personal settings
        </h2>
        <div class="flex flex-col">
          <div class="input-combo max-w-none">
            <span class="label">Username</span>
            <div class="flex space-x-2">
              <input
                type="text"
                class="input"
                placeholder="username"
                v-model="userName"
              />
              <button
                type="button"
                class="btn-main-dark"
                @click="updateUserData({ nom: userName })"
              >
                Update
              </button>
            </div>
          </div>
          <div class="input-combo max-w-none">
            <span class="label">Email</span>
            <div class="flex space-x-2">
              <input
                type="text"
                class="input"
                placeholder="email"
                v-model="userEmail"
              />
              <button
                type="button"
                class="btn-main-dark"
                @click="updateUserData({ email: userEmail })"
              >
                Update
              </button>
            </div>
          </div>
          <div class="input-combo max-w-none">
            <span class="label">Password</span>
            <div class="flex space-x-2">
              <input
                type="password"
                class="input"
                placeholder="password"
                v-model="userPassword"
                autocomplete="false"
              />
              <button
                type="button"
                class="btn-main-dark"
                @click="updateUserData({ password: userPassword })"
              >
                Update
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import AvatarPicker from "@/components/common/AvatarPicker.vue";
import { updateProfile } from "@/services/User";

export default {
  name: "account-settings",
  components: { AvatarPicker },
  data() {
    return {
      userName: null,
      userEmail: null,
      userPassword: null,
    };
  },
  mounted() {},
  created() {
    const userData = this.$store.getters.getUserData;
    this.userName = userData.nom;
    this.userEmail = userData.email;
  },
  methods: {
    async updateUserData(data) {
      const response = await updateProfile(data);

      if (response.status === true) {
        await this.$store.dispatch("setUserData", response.data);
      } else {
        toastjs.logErrorActive(response.data.response.data.message);
      }
    },
  },
};
</script>

<style scoped>
div > div:not(:last-of-type) {
  margin-bottom: 20px;
}
</style>
