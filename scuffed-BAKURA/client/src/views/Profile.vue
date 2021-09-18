<template>
  <div class="flex flex-col">
    <div class="w-full flex flex-col relative mb-16">
      <div class="w-full h-60 profile-banner rounded-lg"></div>
      <div class="w-full flex justify-center absolute -bottom-16">
        <img
          :src="getImageUrl(user.avatar.lienImage)"
          alt="User avatar"
          class="
            w-52
            h-52
            object-cover
            rounded-full
            border-4 border-coolGray-50
            ring-8 ring-coolGray-800 ring-opacity-60
          "
        />
      </div>
    </div>
    <div v-if="favCards != null" class="w-full my-10">
      <h1 class="text-3xl text-coolGray-800 font-bold mb-1.5">
        Favorite cards:
      </h1>
      <div class="flex space-x-2 w-full overflow-x-auto pb-2">
        <card
          v-for="card in favCards"
          :value="card"
          :key="card.idCarte"
          :show-like="false"
          class="flex-none"
        />
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import UserMainData from "@/models/user/UserMainData";
import Util from "@/helpers/Util";
import { all } from "@/services/Favorites";
import Card from "@/components/card/Card.vue";

export default {
  name: "profile",
  components: { Card },
  props: {},
  mixins: [Util],
  data() {
    return {
      user: null as UserMainData,
      favCards: null,
    };
  },
  created() {
    this.user = this.$store.getters.getUserData;
    this.fetchFavorites();
  },
  methods: {
    async fetchFavorites() {
      const favoritesResponse = await all();

      if (favoritesResponse.status === true) {
        this.favCards = favoritesResponse.data.cartes;
      } else {
        console.error(favoritesResponse.data);
      }
    },
  },
};
</script>
