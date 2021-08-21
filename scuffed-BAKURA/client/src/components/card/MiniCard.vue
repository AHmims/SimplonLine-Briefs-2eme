<template>
  <div style="display: flex; align-items: center;">
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
  methods: {}
};
</script>
