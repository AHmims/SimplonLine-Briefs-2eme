<template>
  <div @click="showPreview">
    <img :src="getImageUrl(card.imageCarte.lienImage)"
         :id="card.imageCarte.idImage"
         :alt="card.nomCarte"
         style="width: 150px;"/>
    <p>{{ card.nomCarte }}</p>
    <p>
      <span>{{ card.givenCarteId }} | </span>
      <span>{{ card.typeCarte }} | </span>
      <span v-if="card.race">{{ card.race.libelleRace }}</span>
    </p>
    <like-card-button v-model="card.liked" :card="card.idCarte"/>
  </div>
</template>

<script lang="ts">
import Util from '@/helpers/Util';
import Card from '@/models/card/Card';
import LikeCardButton from '@/components/card/LikeCardButton.vue';

export default {
  name: 'card',
  components: {LikeCardButton},
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
        this.$store.dispatch('setCardPreviewData', this.card);
      }
      if (!this.$store.getters.isCardPreviewVisible) {
        this.$store.dispatch('setCardPreviewVisible', true);
      }
    }
  }
};
</script>
