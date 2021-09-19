<template>
  <div class="w-full flex h-[735px]">
    <div class="relative rounded-lg overflow-hidden">
      <div class="">
        <img src="@/assets/banner.png" alt="banner img" class="" />
      </div>
      <div class="absolute bottom-0 left-0 pb-10 pl-5">
        <img src="@/assets/logo-full.svg" alt="bakura" class="pb-3" />
        <span class="text-blueGray-800 text-2xl font-bold leading-3">
          Modern & powerful<br />Yu-gi-oh! Deck builder
        </span>
      </div>
    </div>
    <div class="flex-1 flex items-center justify-center">
      <form @submit.prevent="login()" class="flex flex-col items-center">
        <img src="@/assets/logo-min.svg" alt="bakura" class="w-12 h-12 mb-6" />
        <div
          class="text-blueGray-900 space-y-1 flex flex-col items-center mb-12"
        >
          <h1 class="text-3xl font-extrabold">Sign in to your account</h1>
          <span class="text-sm font-medium">
            <span class="mr-1">Or</span>
            <router-link to="/signup" class="text-blue-900"
              >create yours now</router-link
            >
          </span>
        </div>
        <div class="w-[350px] space-y-8">
          <div class="w-ful space-y-5">
            <div class="input-combo">
              <label for="login-email" class="label">Email</label>
              <div class="flex space-x-2">
                <input
                  class="input"
                  type="text"
                  name="email"
                  id="login-email"
                  v-model="auth.email"
                />
              </div>
            </div>
            <div class="input-combo">
              <label for="login-pass" class="label">Password</label>
              <div class="flex space-x-2">
                <input
                  class="input"
                  :type="showPassword ? 'text' : 'password'"
                  name="password"
                  id="login-pass"
                  v-model="auth.password"
                />
                <button
                  type="button"
                  class="
                    flex flex-none
                    items-center
                    justify-center
                    bg-white
                    text-sm
                    border border-blueGray-200
                    shadow
                    rounded-lg
                    h-9
                    w-9
                    outline-none
                    ring-blueGray-300
                    focus:ring
                  "
                  @click="showPassword = !showPassword"
                >
                  <svg
                    width="18"
                    height="19"
                    viewBox="0 0 18 19"
                    fill="none"
                    xmlns="http://www.w3.org/2000/svg"
                  >
                    <path
                      d="M8.99995 11.3C9.47734 11.3 9.93518 11.1104 10.2727 10.7728C10.6103 10.4352 10.8 9.9774 10.8 9.50001C10.8 9.02262 10.6103 8.56479 10.2727 8.22722C9.93518 7.88965 9.47734 7.70001 8.99995 7.70001C8.52256 7.70001 8.06472 7.88965 7.72716 8.22722C7.38959 8.56479 7.19995 9.02262 7.19995 9.50001C7.19995 9.9774 7.38959 10.4352 7.72716 10.7728C8.06472 11.1104 8.52256 11.3 8.99995 11.3Z"
                      fill="#334155"
                    />
                    <path
                      fill-rule="evenodd"
                      clip-rule="evenodd"
                      d="M0.412109 9.50001C1.55871 5.84871 4.96971 3.20001 8.99991 3.20001C13.0301 3.20001 16.4411 5.84871 17.5877 9.50001C16.4411 13.1513 13.0301 15.8 8.99991 15.8C4.96971 15.8 1.55871 13.1513 0.412109 9.50001ZM12.5999 9.50001C12.5999 10.4548 12.2206 11.3705 11.5455 12.0456C10.8704 12.7207 9.95469 13.1 8.99991 13.1C8.04513 13.1 7.12946 12.7207 6.45432 12.0456C5.77919 11.3705 5.39991 10.4548 5.39991 9.50001C5.39991 8.54523 5.77919 7.62956 6.45432 6.95443C7.12946 6.2793 8.04513 5.90001 8.99991 5.90001C9.95469 5.90001 10.8704 6.2793 11.5455 6.95443C12.2206 7.62956 12.5999 8.54523 12.5999 9.50001Z"
                      fill="#334155"
                    />
                  </svg>
                </button>
              </div>
            </div>
          </div>
          <button
            type="submit"
            class="btn-main-dark w-full py-2"
            :disabled="isLoading"
          >
            {{ isLoading ? "~~" : "Sign in" }}
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script lang="ts">
import Authentication from "@/models/login/Authentication";
import { login } from "@/services/Auth";

export default {
  props: {},
  data() {
    return {
      auth: {} as Authentication,
      isLoading: false as boolean,
      showPassword: false,
    };
  },
  created() {
    this.auth.email = "ali.hmims99@gmail.com";
    this.auth.password = "123456789";
  },
  methods: {
    async login() {
      this.isLoading = true;
      const response = await login(this.auth);
      this.isLoading = false;

      if (response.status === true) {
        await this.$store.dispatch("setUserData", response.data);
        await this.$store.dispatch("setAuthToken", response.data.token);
        await this.$router.push({ name: "Home" });
      } else {
        toastjs.logErrorActive(response.data.response.data.message);
      }
    },
  },
};
</script>
