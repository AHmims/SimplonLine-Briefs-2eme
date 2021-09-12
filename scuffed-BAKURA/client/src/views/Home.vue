<template>
  <div class="home">
    <div class="relative w-full py-12 px-6">
      <img
        src="@/assets/cover.png"
        alt="cover img"
        class="absolute right-0 h-[430px] z-[-1]"
      />
      <div class="max-w-[932px] flex flex-col space-y-[30px] text-left">
        <h1
          class="
            text-[76px] text-blueGray-700
            font-bold
            leading-[70px]
            capitalize
          "
        >
          Modern & powerful <br />Yu-gi-oh! Deck builder
        </h1>
        <span class="text-3xl text-blueGray-500 leading-10 font-normal cap"
          >Made for Yu-Gi-Oh! enthusiasts who want to make and share their
          unique strategies. No hidden fees, no hassle.</span
        >
        <div class="flex items-center space-x-5">
          <router-link
            to="/signup"
            class="btn-main-dark text-[22px] px-7 py-3 rounded-xl"
          >
            <span>Create account</span>
          </router-link>
          <router-link
            to="/login"
            class="btn-sec text-[22px] px-7 py-3 rounded-xl"
          >
            <span>Sign in</span>
          </router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";

@Component
export default class Home extends Vue {}
</script>
