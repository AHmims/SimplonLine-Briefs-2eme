<template>
  <div>
    <h3>Cards</h3>
    <div>
      <div v-for="card in cards">
        <span>{{ card.nomCarte }}</span>
      </div>
    </div>
    <div></div>
  </div>
</template>

<script lang="ts">
import Card from '@/models/card/Card';
import {getAllCards} from '@/services/Cards';

export default {
  name: 'cards',
  props: {},
  data() {
    return {
      cards: [] as Card[],
      isLoading: false as boolean,
      currentPage: null,
      totalPages: null
    };
  },
  created() {
    this.currentPage = this.$store.getters.getCurrentPage == null ? 0 : this.$store.getters.getCurrentPage;
    this.totalPages = this.$store.getters.getTotalPages;
    this.cards = this.$store.getters.getCards;

    console.log(this.$store.getters.getCurrentPage == null);
    if (this.$store.getters.getCurrentPage == null) {
      this.initCards(this.currentPage);
    }
  },
  methods: {
    async initCards(page: number) {
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
