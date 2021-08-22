<template>
  <div style="display: flex; align-items: center;" @click="showPreview">
    <img :src="getImageUrl(card.imageCarte.lienImage)"
         :id="card.imageCarte.idImage"
         :alt="card.nomCarte"
         style="height: 100px;"/>
    <p>{{ card.nomCarte }}</p>
  </div>
</template>

<script lang="ts">
import Util from '@/helpers/Util';
import Card from '@/models/card/Card';

export default {
  name: 'mini-card',
  mixins: [Util],
  props: {
    value: {
      type: Object,
      required: true
    }
  },
  data() {
    return {
      card: {} as Card
    };
  },
  created() {
    // @ts-ignore
    this.card = this.value;
  },
  mounted() {
  },
  methods: {
    showPreview() {
      if (this.card.idCarte != this.$store.getters.getCardPreviewId) {
        this.$store.dispatch('setCardPreviewId', this.card.idCarte);
        this.$store.dispatch('setCardPreviewData', null);
      }
      if (!this.$store.getters.isCardPreviewVisible) {
        this.$store.dispatch('setCardPreviewVisible', true);
      }
    }
  }
};
</script>
