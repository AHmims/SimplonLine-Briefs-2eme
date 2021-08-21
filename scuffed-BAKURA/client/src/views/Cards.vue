<template>
  <div>
    <h3>Cards</h3>
    <div>
      <form @submit.prevent="searchCards">
        <input type="text" v-model="searchValue"/>
        <select v-model="searchCardType" :disabled="isSearchingCards">
          <option value="all">All</option>
          <option value="monster">Monsters</option>
          <option value="spell">Spells</option>
          <option value="trap">Traps</option>
        </select>
        <input type="submit" value="search" :disabled="isSearchingCards"/>
        <div>
          <h4>Search results</h4>
          <div>
            <mini-card v-for="(card, index) in searchedCards" :value="card" :key="card.idCarte"/>
          </div>
        </div>
      </form>
      <select v-model="cardsFilterType" @change="filterCards" :disabled="isLoadingCards">
        <option value="all">All</option>
        <option value="monster">Monsters</option>
        <option value="spell">Spells</option>
        <option value="trap">Traps</option>
      </select>
      <select v-model="cardsFilterArchetype" @change="filterCards" :disabled="isLoadingCards">
        <option value="">All</option>
        <option v-for="archetype in archetypes" :value="archetype.idArchetype">{{ archetype.libelleArchetype }}</option>
      </select>
      <pagination v-model="totalPages"
                  :offset="3"
                  :pagination-count="10"
                  :starting-page="currentPage + 1"
                  :enable-navigation="true"
                  :disabled="isLoadingCards"
                  @paginated="initCards"/>
    </div>
    <div>
      <h4 v-if="isLoadingCards">Traveling through the cards verse to get cards...</h4>
      <div style="display: grid; grid-template-columns: repeat(3, 1fr); width: 50%;margin: 0 auto; grid-gap: 20px;">
        <card v-for="(card, index) in cards" :value="card" :key="card.idCarte"/>
      </div>
    </div>
    <div></div>
  </div>
</template>

<script lang="ts">
import Card from '@/models/card/Card';
import {getAllCards, searchForCards} from '@/services/Cards';
import CardComponent from '@/components/card/Card.vue';
import Pagination from '@/components/common/Pagination.vue';
import MiniCard from '@/components/card/MiniCard.vue';
import Archetype from '@/models/card/Archetype';
import {getArchetypesList} from '@/services/Archetypes';

export default {
  name: 'cards',
  components: {MiniCard, Pagination, CardComponent},
  props: {},
  data() {
    return {
      cards: [] as Card[],
      isLoadingCards: false as boolean,
      currentPage: -1 as Number,
      totalPages: null,
      cardsPerPage: 25,
      cardsFilterType: 'all',
      cardsFilterArchetype: '',
      archetypes: [] as Archetype[],
      searchValue: '' as String,
      searchedCards: [] as Card[],
      searchCardType: 'all' as String,
      isSearchingCards: false as boolean
    };
  },
  created() {
    this.initArchetypes();

    this.currentPage = this.$store.getters.getCurrentPage == null ? 0 : this.$store.getters.getCurrentPage;
    this.totalPages = this.$store.getters.getTotalPages || 0;
    this.cards = this.$store.getters.getCards;
    this.cardsFilterType = this.$store.getters.getCardsType;
    this.cardsFilterArchetype = this.$store.getters.getArchetype;

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
      const response = await getAllCards(page, this.cardsPerPage, this.cardsFilterType, this.cardsFilterArchetype);
      this.isLoadingCards = false;

      if (response.status === true) {
        this.currentPage = response.data.number;
        this.totalPages = response.data.totalPages;
        this.cards = response.data.content;

        await this.$store.dispatch('setCurrentPage', this.currentPage);
        await this.$store.dispatch('setTotalPages', this.totalPages);
        await this.$store.dispatch('setCards', this.cards);
        await this.$store.dispatch('setCardsType', this.cardsFilterType);
        await this.$store.dispatch('setArchetype', this.cardsFilterArchetype);
      } else {
        console.error(response.data);
      }
    },
    filterCards() {
      this.initCards(0);
    },
    async searchCards() {
      this.isSearchingCards = true;
      const response = await searchForCards(this.searchValue, 0, 5, this.searchCardType);
      this.isSearchingCards = false;

      if (response.status === true) {
        this.searchedCards = response.data.content;
      } else {
        console.error(response.data);
      }
    },
    async initArchetypes() {
      const response = await getArchetypesList();

      if (response.status === true) {
        this.archetypes = response.data;
      } else {
        console.error(response.data);
      }
    }
  }
};
</script>
