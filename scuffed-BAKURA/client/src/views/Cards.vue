<template>
  <div>
    <h3>Cards</h3>
    <div>
      <pagination v-model="totalPages"
                  :offset="3"
                  :pagination-count="10"
                  :starting-page="1"
                  :enable-navigation="true"
                  @paginated="initCards"/>
    </div>
    <div>
      <h4 v-if="isLoading">Traveling through the cards verse to get cards...</h4>
      <div style="display: grid; grid-template-columns: repeat(3, 1fr); width: 50%;margin: 0 auto; grid-gap: 20px;">
        <card v-for="(card, index) in cards" :value="card" :key="card.idCarte"/>
      </div>
    </div>
    <div></div>
  </div>
</template>

<script lang="ts">
import Card from '@/models/card/Card';
import {getAllCards} from '@/services/Cards';
import CardComponent from '@/components/Card.vue';
import Pagination from '@/components/common/Pagination.vue';

export default {
  name: 'cards',
  components: {Pagination, CardComponent},
  props: {},
  data() {
    return {
      cards: [] as Card[],
      isLoading: false as boolean,
      currentPage: null as Number,
      totalPages: null
    };
  },
  created() {
    this.currentPage = this.$store.getters.getCurrentPage == null ? 0 : this.$store.getters.getCurrentPage;
    this.totalPages = this.$store.getters.getTotalPages || 0;
    this.cards = this.$store.getters.getCards;

    if (this.$store.getters.getCurrentPage == null) {
      this.initCards(this.currentPage);
    }
  },
  methods: {
    async initCards(page: number) {
      if (page === this.currentPage && this.totalPages == null) {
        return;
      }

      this.isLoading = true;
      const response = await getAllCards(page);
      this.isLoading = false;

      if (response.status === true) {
        this.currentPage = response.data.number;
        this.totalPages = response.data.totalPages;
        this.cards = response.data.content;

        await this.$store.dispatch('setCurrentPage', this.currentPage);
        await this.$store.dispatch('setTotalPages', this.totalPages);
        await this.$store.dispatch('setCards', this.cards);
      } else {
        console.error(response.data);
      }
    }
  }
};
</script>
