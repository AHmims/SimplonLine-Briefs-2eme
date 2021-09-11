<template>
  <div>
    <h3>Cards</h3>
    <div>
      <select
        v-model="cardsFilterType"
        @change="filterCards"
        :disabled="isLoadingCards"
      >
        <option value="all">All</option>
        <option value="monster">Monsters</option>
        <option value="spell">Spells</option>
        <option value="trap">Traps</option>
      </select>
      <select
        v-model="cardsFilterArchetype"
        @change="filterCards"
        :disabled="isLoadingCards"
      >
        <option value="">All</option>
        <option
          v-for="(archetype, index) in archetypes"
          :key="index"
          :value="archetype.idArchetype"
        >
          {{ archetype.libelleArchetype }}
        </option>
      </select>
      <pagination
        v-model="totalPages"
        :offset="3"
        :pagination-count="10"
        :starting-page="currentPage + 1"
        :enable-navigation="true"
        :disabled="isLoadingCards"
        @paginated="initCards"
      />
    </div>
    <div>
      <h4 v-if="isLoadingCards">
        Traveling through the cards verse to get cards...
      </h4>
      <h5>Cards {{ getTotalPassedCards() }} / {{ cardsCount }}</h5>
      <div
        style="
          display: grid;
          grid-template-columns: repeat(3, 1fr);
          width: 50%;
          margin: 0 auto;
          grid-gap: 20px;
        "
      >
        <card v-for="card in cards" :value="card" :key="card.idCarte" />
      </div>
    </div>
    <div></div>
  </div>
</template>

<script lang="ts">
import Card from "@/models/card/Card";
import { getAllCards } from "@/services/Cards";
import CardComponent from "@/components/card/Card.vue";
import Pagination from "@/components/common/Pagination.vue";
import Archetype from "@/models/card/Archetype";
import { getArchetypesList } from "@/services/Archetypes";
import { all } from "@/services/Favorites";

export default {
  name: "cards",
  components: { Pagination, CardComponent },
  props: {},
  data() {
    return {
      cards: [] as Card[],
      isLoadingCards: false as boolean,
      currentPage: -1 as Number,
      totalPages: null,
      cardsPerPage: 25,
      cardsFilterType: "all",
      cardsFilterArchetype: "",
      archetypes: [] as Archetype[],
      cardsCount: 0 as Number,
    };
  },
  created() {
    this.initArchetypes();

    this.currentPage =
      this.$store.getters.getCurrentPage == null
        ? 0
        : this.$store.getters.getCurrentPage;
    this.totalPages = this.$store.getters.getTotalPages || 0;
    this.cards = this.$store.getters.getCards;
    this.cardsFilterType = this.$store.getters.getCardsType;
    this.cardsFilterArchetype = this.$store.getters.getArchetype;
    this.cardsCount = this.$store.getters.getCardsCount;

    if (this.$store.getters.getCurrentPage == null) {
      this.initCards(this.currentPage);
    }
  },
  methods: {
    async initCards(page: number) {
      if (page === this.currentPage && this.totalPages == null) {
        return;
      }

      this.isLoadingCards = true;
      const response = await getAllCards(
        page,
        this.cardsPerPage,
        this.cardsFilterType,
        this.cardsFilterArchetype
      );
      this.isLoadingCards = false;

      if (response.status === true) {
        this.currentPage = response.data.number;
        this.totalPages = response.data.totalPages;
        this.cardsCount = response.data.totalElements;

        let cardsData = response.data.content;
        const likedCards = await all();

        if (likedCards.status === true) {
          cardsData.forEach((card) => {
            let liked = false;
            for (let i = 0; i < likedCards.data.cartes.length; i++) {
              if (card.idCarte === likedCards.data.cartes[i].idCarte) {
                liked = true;
                break;
              }
            }

            card.liked = liked;
          });
        }

        this.cards = cardsData;

        await this.$store.dispatch("setCurrentPage", this.currentPage);
        await this.$store.dispatch("setTotalPages", this.totalPages);
        await this.$store.dispatch("setCards", this.cards);
        await this.$store.dispatch("setCardsType", this.cardsFilterType);
        await this.$store.dispatch("setArchetype", this.cardsFilterArchetype);
        await this.$store.dispatch("setCardsCount", this.cardsCount);
      } else {
        console.error(response.data);
      }
    },
    filterCards() {
      this.initCards(0);
    },
    async initArchetypes() {
      const response = await getArchetypesList();

      if (response.status === true) {
        this.archetypes = response.data;
      } else {
        console.error(response.data);
      }
    },
    getTotalPassedCards(): Number {
      let count = this.cardsPerPage * (this.currentPage + 1);

      return count > this.cardsCount ? this.cardsCount : count;
    },
  },
};
</script>
