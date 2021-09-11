<template>
  <div
    @click="showPreview"
    class="flex items-center px-3 py-2 cursor-pointer rounded-lg transition-colors duration-150 ease-in-out hover:bg-blueGray-200"
  >
    <img
      :src="getImageUrl(card.imageCarte.lienImage)"
      :id="card.imageCarte.idImage"
      :alt="card.nomCarte"
      class="w-16 h-16 object-cover object-top rounded-full"
    />
    <span class="ml-3">{{ card.nomCarte }}</span>
  </div>
</template>

<script lang="ts">
import Util from "@/helpers/Util";
import Card from "@/models/card/Card";

export default {
  name: "mini-card",
  mixins: [Util],
  props: {
    value: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      card: {} as Card,
    };
  },
  created() {
    // @ts-ignore
    this.card = this.value;
  },
  mounted() {},
  methods: {
    showPreview() {
      if (this.card.idCarte != this.$store.getters.getCardPreviewId) {
        this.$store.dispatch("setCardPreviewId", this.card.idCarte);
        this.$store.dispatch("setCardPreviewData", null);
      }
      if (!this.$store.getters.isCardPreviewVisible) {
        this.$store.dispatch("setCardPreviewVisible", true);
      }
    },
  },
};
</script>
