<template>
  <div class="w-full flex items-center p-6 space-x-24 mb-6">
    <div>
      <svg
        width="115"
        height="32"
        viewBox="0 0 115 32"
        fill="none"
        xmlns="http://www.w3.org/2000/svg"
      >
        <path
          d="M30.0294 25.8571H36.5564C39.7738 25.8571 41.6204 24.1384 41.6204 21.7875C41.6204 19.6853 40.0934 18.3642 38.332 18.2861V18.1441C39.93 17.8103 41.0522 16.6526 41.0522 14.9907C41.0522 12.7961 39.3618 11.3117 36.0948 11.3117H30.0294V25.8571ZM33.5451 23.0233V19.5574H35.7823C37.1246 19.5574 37.9485 20.2677 37.9485 21.3827C37.9485 22.4125 37.2382 23.0233 35.7184 23.0233H33.5451ZM33.5451 17.2918V14.1029H35.5479C36.7198 14.1029 37.4655 14.7066 37.4655 15.6725C37.4655 16.6952 36.6417 17.2918 35.4911 17.2918H33.5451ZM46.457 25.8571L47.4158 22.8032H52.4371L53.3959 25.8571H57.1743L52.2667 11.3117H47.5863L42.6786 25.8571H46.457ZM48.2539 20.1327L49.8661 14.9765H49.9797L51.599 20.1327H48.2539ZM58.7404 25.8571H62.256V21.9154L63.6623 20.1398L67.2844 25.8571H71.489L66.2404 17.8032L71.3966 11.3117H67.256L62.4478 17.4623H62.256V11.3117H58.7404V25.8571ZM81.5831 11.3117V20.3884C81.5831 21.9012 80.5106 22.9878 78.941 22.9878C77.3643 22.9878 76.299 21.9012 76.299 20.3884V11.3117H72.7833V20.6938C72.7833 23.9466 75.2407 26.0418 78.941 26.0418C82.6129 26.0418 85.0916 23.9466 85.0916 20.6938V11.3117H81.5831ZM87.2951 25.8571H90.8107V20.8785H92.6147L95.2709 25.8571H99.1061L96.0877 20.3174C97.6857 19.5929 98.609 18.1654 98.609 16.1554C98.609 13.1654 96.5706 11.3117 93.3036 11.3117H87.2951V25.8571ZM90.8107 18.1086V14.1455H92.5436C94.1204 14.1455 94.9655 14.806 94.9655 16.1554C94.9655 17.5049 94.1204 18.1086 92.5436 18.1086H90.8107ZM103.684 25.8571L104.642 22.8032H109.664L110.622 25.8571H114.401L109.493 11.3117H104.813L99.9052 25.8571H103.684ZM105.48 20.1327L107.093 14.9765H107.206L108.826 20.1327H105.48Z"
          fill="#1E293B"
        />
        <path
          fill-rule="evenodd"
          clip-rule="evenodd"
          d="M5 19.7857V0.857147H0V19.7857C0 23.1389 2.71827 25.8571 6.07143 25.8571H15V20.8571H6.07143C5.47969 20.8571 5 20.3775 5 19.7857ZM10 16.9285V20.8571H15V16.9285C15 13.5753 12.2817 10.8571 8.92859 10.8571H5.00002V15.8571H8.92859C9.52032 15.8571 10 16.3368 10 16.9285Z"
          fill="#1E293B"
        />
        <path
          d="M22.5 25.8572V6.92864C22.5 4.95619 20.901 3.35721 18.9286 3.35721H8.04663e-07"
          stroke="#1E293B"
          stroke-width="5"
        />
      </svg>
    </div>
    <div
      class="
        navbar-nav-container
        space-x-6
        text-base
        tracking-tighter
        text-blueGray-700
        font-medium
        capitalize
      "
    >
      <router-link to="/">Home</router-link>
      <router-link to="/cards">Cards</router-link>
      <router-link to="/about">About</router-link>
    </div>
    <div class="flex-1 relative">
      <form
        @submit.prevent="searchCards"
        class="flex items-center bg-blueGray-200 px-5 py-2 rounded-lg space-x-2"
      >
        <input
          type="text"
          v-model="searchValue"
          placeholder="search..."
          class="
            bg-transparent
            flex-1
            placeholder-blueGray-600
            text-blueGray-700
            font-medium
            text-xs
            outline-none
          "
        />
        <select
          v-model="searchCardType"
          :disabled="isSearchingCards"
          class="bg-transparent outline-none"
        >
          <option value="all">All</option>
          <option value="monster">Monsters</option>
          <option value="spell">Spells</option>
          <option value="trap">Traps</option>
        </select>
        <button type="submit" value="search" :disabled="isSearchingCards">
          <svg
            width="20"
            height="20"
            viewBox="0 0 20 20"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              fill-rule="evenodd"
              clip-rule="evenodd"
              d="M8 4C6.93913 4 5.92172 4.42143 5.17157 5.17158C4.42143 5.92172 4 6.93914 4 8C4 9.06087 4.42143 10.0783 5.17157 10.8284C5.92172 11.5786 6.93913 12 8 12C9.06087 12 10.0783 11.5786 10.8284 10.8284C11.5786 10.0783 12 9.06087 12 8C12 6.93914 11.5786 5.92172 10.8284 5.17158C10.0783 4.42143 9.06087 4 8 4ZM2 8C1.99988 7.05571 2.22264 6.12472 2.65017 5.28274C3.0777 4.44077 3.69792 3.7116 4.4604 3.15453C5.22287 2.59746 6.10606 2.22822 7.03815 2.07684C7.97023 1.92546 8.92488 1.99621 9.82446 2.28335C10.724 2.57049 11.5432 3.06591 12.2152 3.7293C12.8872 4.39269 13.3931 5.20534 13.6919 6.10114C13.9906 6.99693 14.0737 7.9506 13.9343 8.88456C13.795 9.81852 13.4372 10.7064 12.89 11.476L17.707 16.293C17.8892 16.4816 17.99 16.7342 17.9877 16.9964C17.9854 17.2586 17.8802 17.5094 17.6948 17.6948C17.5094 17.8802 17.2586 17.9854 16.9964 17.9877C16.7342 17.99 16.4816 17.8892 16.293 17.707L11.477 12.891C10.5794 13.5293 9.52335 13.9082 8.42468 13.9861C7.326 14.0641 6.22707 13.8381 5.2483 13.333C4.26953 12.8278 3.44869 12.063 2.87572 11.1224C2.30276 10.1817 1.99979 9.10144 2 8Z"
              fill="#475569"
            />
          </svg>
        </button>
      </form>
      <div
        v-if="showSearchResults"
        class="absolute top-12 w-full bg-blueGray-100 rounded-lg py-3 z-10"
      >
        <div class="w-full flex items-center justify-between mb-3 px-5">
          <span class="text-sm">Search results</span>
          <button type="button" @click="showSearchResults = false">
            <svg
              class="w-5 h-5"
              fill="none"
              stroke="currentColor"
              viewBox="0 0 24 24"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                stroke-linecap="round"
                stroke-linejoin="round"
                stroke-width="2"
                d="M6 18L18 6M6 6l12 12"
              ></path>
            </svg>
          </button>
        </div>
        <div class="px-2">
          <mini-card
            v-for="card in searchedCards"
            :value="card"
            :key="card.idCarte"
          />
        </div>
      </div>
    </div>
    <div v-if="isAuthenticated">
      <div class="flex items-center space-x-2 relative">
        <img
          v-if="user !== null"
          :src="getImageUrl(user.avatar.lienImage)"
          alt="Avatar"
          class="w-9 h-9 object-cover rounded-full"
        />
        <div v-else class="w-9 h-9 bg-blueGray-200 rounded-full"></div>
        <button type="button" @click="showMenuButton = !showMenuButton">
          <svg
            width="20"
            height="20"
            viewBox="0 0 20 20"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              fill-rule="evenodd"
              clip-rule="evenodd"
              d="M3 5C3 4.73478 3.10536 4.48043 3.29289 4.29289C3.48043 4.10536 3.73478 4 4 4H16C16.2652 4 16.5196 4.10536 16.7071 4.29289C16.8946 4.48043 17 4.73478 17 5C17 5.26522 16.8946 5.51957 16.7071 5.70711C16.5196 5.89464 16.2652 6 16 6H4C3.73478 6 3.48043 5.89464 3.29289 5.70711C3.10536 5.51957 3 5.26522 3 5ZM3 10C3 9.73478 3.10536 9.48043 3.29289 9.29289C3.48043 9.10536 3.73478 9 4 9H16C16.2652 9 16.5196 9.10536 16.7071 9.29289C16.8946 9.48043 17 9.73478 17 10C17 10.2652 16.8946 10.5196 16.7071 10.7071C16.5196 10.8946 16.2652 11 16 11H4C3.73478 11 3.48043 10.8946 3.29289 10.7071C3.10536 10.5196 3 10.2652 3 10ZM9 15C9 14.7348 9.10536 14.4804 9.29289 14.2929C9.48043 14.1054 9.73478 14 10 14H16C16.2652 14 16.5196 14.1054 16.7071 14.2929C16.8946 14.4804 17 14.7348 17 15C17 15.2652 16.8946 15.5196 16.7071 15.7071C16.5196 15.8946 16.2652 16 16 16H10C9.73478 16 9.48043 15.8946 9.29289 15.7071C9.10536 15.5196 9 15.2652 9 15Z"
              fill="#1E293B"
            />
          </svg>
        </button>
        <div
          v-if="showMenuButton"
          class="
            bg-white
            flex flex-col
            w-32
            p-1
            border-2 border-blueGray-100
            rounded-lg
            absolute
            top-12
            right-0
            z-10
          "
        >
          <router-link to="/profile" class="navBar-menu-option">
            <span>{{ user.nom }}</span>
          </router-link>
          <router-link to="/settings" class="navBar-menu-option">
            <span>Settings</span>
            <svg
              class="w-4 h-4"
              fill="currentColor"
              viewBox="0 0 20 20"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                fill-rule="evenodd"
                d="M11.49 3.17c-.38-1.56-2.6-1.56-2.98 0a1.532 1.532 0 01-2.286.948c-1.372-.836-2.942.734-2.106 2.106.54.886.061 2.042-.947 2.287-1.561.379-1.561 2.6 0 2.978a1.532 1.532 0 01.947 2.287c-.836 1.372.734 2.942 2.106 2.106a1.532 1.532 0 012.287.947c.379 1.561 2.6 1.561 2.978 0a1.533 1.533 0 012.287-.947c1.372.836 2.942-.734 2.106-2.106a1.533 1.533 0 01.947-2.287c1.561-.379 1.561-2.6 0-2.978a1.532 1.532 0 01-.947-2.287c.836-1.372-.734-2.942-2.106-2.106a1.532 1.532 0 01-2.287-.947zM10 13a3 3 0 100-6 3 3 0 000 6z"
                clip-rule="evenodd"
              ></path>
            </svg>
          </router-link>
          <button type="button" @click="logOut" class="navBar-menu-option">
            <span>Log-out</span>
            <svg
              class="w-4 h-4"
              fill="currentColor"
              viewBox="0 0 20 20"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                fill-rule="evenodd"
                d="M3 3a1 1 0 00-1 1v12a1 1 0 102 0V4a1 1 0 00-1-1zm10.293 9.293a1 1 0 001.414 1.414l3-3a1 1 0 000-1.414l-3-3a1 1 0 10-1.414 1.414L14.586 9H7a1 1 0 100 2h7.586l-1.293 1.293z"
                clip-rule="evenodd"
              ></path>
            </svg>
          </button>
        </div>
      </div>
    </div>
    <div v-else class="flex items-center space-x-5">
      <router-link to="/login" v-if="!isAuthenticated" class="btn-sec">
        <span>Sign in</span>
      </router-link>
      <router-link to="/signup" v-if="!isAuthenticated" class="btn-main-dark">
        <span>Create account</span>
      </router-link>
    </div>
  </div>
</template>

<script lang="ts">
import Card from "@/models/card/Card";
import Util from "@/helpers/Util";
import { ping } from "@/services/Auth";
import { me } from "@/services/User";
import UserMainData from "@/models/user/UserMainData";
import { searchForCards } from "@/services/Cards";
import MiniCard from "@/components/card/MiniCard.vue";

export default {
  name: "nav-bar",
  mixins: [Util],
  components: { MiniCard },
  props: {},
  data() {
    return {
      isAuthenticated: false as Boolean,
      user: null as UserMainData,
      searchValue: "" as String,
      searchedCards: [] as Card[],
      searchCardType: "all" as String,
      isSearchingCards: false as boolean,
      showSearchResults: false as boolean,
      showMenuButton: false,
    };
  },
  async mounted() {
    this.$store.watch(
      (state: any) => {
        return {
          token: this.$store.getters.getAuthToken,
          userData: this.$store.getters.getUserData,
        };
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
        deep: true,
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

        await this.$store.dispatch("setUserData", this.user);
      } else {
        console.error(userResponse.data);
      }
    },
    logOut() {
      this.$store.commit("setAuthToken", null);
      if (this.$route.name != "Home") {
        this.$router.push({ name: "Home" });
      }
    },
    async searchCards() {
      this.showSearchResults = true;
      this.isSearchingCards = true;
      const response = await searchForCards(
        this.searchValue,
        0,
        5,
        this.searchCardType
      );
      this.isSearchingCards = false;

      if (response.status === true) {
        this.searchedCards = response.data.content;
      } else {
        console.error(response.data);
      }
    },
  },
};
</script>