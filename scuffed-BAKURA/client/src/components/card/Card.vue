<template>
  <div>
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
  </div>
</template>

<script lang="ts">
import Util from '@/helpers/Util';
import Card from '@/models/card/Card';

export default {
  name: 'card',
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
  methods: {}
};
</script>
