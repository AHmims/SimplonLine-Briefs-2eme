<template>
  <div
    @click="showPreview"
    class="
      w-[300px]
      h-[191px]
      p-2
      space-x-2
      flex
      border border-blueGray-200
      rounded-2xl
      relative
      cursor-pointer
      select-none
    "
  >
    <img
      :src="getImageUrl(card.imageCarte.lienImage)"
      :id="card.imageCarte.idImage"
      :alt="card.nomCarte"
      class="w-[120px] rounded-md"
    />
    <div class="flex flex-col text-left">
      <p class="font-medium text-base text-blueGray-800 leading-5">
        {{ card.nomCarte }}
      </p>
      <span class="font-normal text-[10px] text-blueGray-400 mb-1.5"
      >{{ card.givenCarteId }}
      </span>
      <div class="flex items-center mb-1">
        <img
          v-if="card.attribute !== undefined"
          :src="getImageUrl(card.attribute.imageAttribute.lienImage)"
          :alt="card.attribute.libelleAttribute"
          class="w-4 h-4 rounded-full mr-1.5"
        />
        <span
          class="
            flex
            items-center
            px-1.5
            py-0.5
            bg-amber-100
            text-amber-500
            rounded-md
            text-[10px]
          "
        >
          <span class="font-semibold mr-0.5">{{ card.monsterLvl }}</span>
          <svg
            width="9"
            height="8"
            viewBox="0 0 9 8"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              d="M3.64177 0.388049C3.8103 -0.12935 4.5423 -0.12935 4.71027 0.388049L5.31138 2.23742C5.3481 2.35005 5.41949 2.44819 5.51534 2.51781C5.61119 2.58743 5.7266 2.62496 5.84507 2.62505H7.78994C8.33431 2.62505 8.56014 3.32166 8.12027 3.64187L6.54729 4.78453C6.45124 4.85421 6.37972 4.95251 6.34299 5.06534C6.30625 5.17817 6.30619 5.29973 6.3428 5.4126L6.94391 7.26197C7.11244 7.77937 6.51976 8.21026 6.07877 7.89004L4.50579 6.74739C4.40984 6.67773 4.29431 6.64021 4.17574 6.64021C4.05717 6.64021 3.94164 6.67773 3.8457 6.74739L2.27271 7.89004C1.83228 8.21026 1.24016 7.77937 1.40814 7.26197L2.00924 5.4126C2.04585 5.29973 2.04579 5.17817 2.00905 5.06534C1.97232 4.95251 1.9008 4.85421 1.80475 4.78453L0.232334 3.64243C-0.207539 3.32222 0.0188578 2.62561 0.56266 2.62561H2.50698C2.62554 2.62565 2.74107 2.58816 2.83703 2.51854C2.933 2.44891 3.00447 2.35071 3.04123 2.23799L3.64233 0.38861L3.64177 0.388049Z"
              fill="#F59E0B"
            />
          </svg>
        </span>
      </div>
      <span class="text-[10px] text-blueGray-700 font-medium mb-1.5"
      >{{ card.monsterAtk }} ATK - {{ card.monsterDef }} DEF</span
      >
      <div class="flex flex-col space-y-1">
        <span
          v-if="card.race"
          class="
            py-1
            px-1.5
            bg-amber-100
            text-amber-800
            rounded-xl
            text-[10px]
            font-medium
            whitespace-nowrap
            w-min
          "
        >{{ card.race.libelleRace }}</span
        >
        <span
          class="
            py-1
            px-1.5
            bg-teal-100
            text-teal-800
            rounded-xl
            text-[10px]
            font-medium
            whitespace-nowrap
            w-min
          "
        >{{ card.typeCarte }}</span
        >
      </div>
      <like-card-button
        v-if="showLike"
        v-model="card.liked"
        :card="card.idCarte"
        class="absolute top-2 left-2"
      />
    </div>
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
      required: true,
    },
    showLike: {
      type: Boolean,
      required: false,
      default: true
    }
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
    },
  },
};
</script>
