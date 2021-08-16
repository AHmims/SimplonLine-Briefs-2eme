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
    this.currentPage = this.$store.getters.getCurrentPage;
    this.totalPages = this.$store.getters.getTotalPages;
    this.initCards(this.currentPage);
  },
  methods: {
    async initCards(page: number) {
      this.isLoading = true;
      const response = await getAllCards(page);
      this.isLoading = false;

      if (response.status === true) {
        await this.$store.dispatch('setCurrentPage', response.data.number);
        await this.$store.dispatch('setTotalPages', response.data.totalPages);

        this.totalPages = response.data.totalPages;
        this.currentPage = response.data.number;

        this.cards = response.data.content;
      } else {
        console.error(response.data);
      }
    }
  }
};
</script>
