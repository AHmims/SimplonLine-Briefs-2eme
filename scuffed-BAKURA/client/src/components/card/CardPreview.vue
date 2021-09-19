<template>
  <transition name="fade">
    <div v-if="isVisible" class="fixed bottom-0 left-0 p-6">
      <div
        class="
          flex
          h-[562px]
          bg-white
          p-6
          rounded-xl
          border-blueGray-200 border-2
        "
      >
        <img
          :src="getImageUrl(card.imageCarte.lienImage)"
          :alt="card.nomCarte"
          class="w-[350px] rounded-md mr-8"
        />
        <div class="flex flex-col items-start relative max-w-[500px]">
          <button @click="hidePreview" class="absolute right-0">
            <svg
              class="w-6 h-6"
              fill="currentColor"
              viewBox="0 0 20 20"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                fill-rule="evenodd"
                d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
                clip-rule="evenodd"
              ></path>
            </svg>
          </button>
          <div class="flex items-start">
            <img
              v-if="isMonster(card) && card.attribute.imageAttribute != null"
              :src="getImageUrl(card.attribute.imageAttribute.lienImage)"
              :alt="card.attribute.libelleAttribute"
              class="w-8 mr-2"
            />
            <p class="text-2xl font-bold text-blueGray-800 text-left">
              {{ card.nomCarte }}
            </p>
          </div>
          <div class="flex items-center space-x-2 mb-3">
            <span>{{ card.givenCarteId }}</span>
            <span
              v-if="card.archetype != null"
              class="
                px-3
                py-1.5
                rounded-md
                bg-blue-50
                text-blue-600
                font-bold
                text-sm
              "
            >
              {{ card.archetype.libelleArchetype }}
            </span>
          </div>
          <div
            v-if="isMonster(card)"
            class="mb-3 w-full flex items-center justify-between"
          >
            <div class="space-x-2 text-base">
              <span
                v-if="isLink(card)"
                class="
                  text-warmGray-700
                  bg-warmGray-100
                  font-bold
                  px-2
                  py-1
                  rounded-md
                "
                >Link-{{ card.monsterScale }}
              </span>
              <template v-else>
                <span
                  v-if="!isXyz(card)"
                  class="text-white bg-amber-500 font-bold px-2 py-1 rounded-md"
                  >Lvl-{{ card.monsterLvl }}
                </span>
                <span
                  v-else
                  class="text-white bg-black font-bold px-2 py-1 rounded-md"
                  >Rank-{{ card.monsterLvl }}
                </span>
                <span
                  v-if="isPendulum(card)"
                  class="
                    text-white
                    bg-gradient-to-b
                    from-amber-400
                    to-teal-600
                    font-bold
                    px-2
                    py-1
                    rounded-md
                  "
                >
                  Scale-{{ card.monsterScale }}
                </span>
              </template>
            </div>
            <div
              class="
                flex
                items-center
                px-2
                py-1
                bg-coolGray-100
                text-coolGray-700
                font-bold
                rounded-md
                space-x-2
                text-base
              "
            >
              <span>ATK/{{ card.monsterAtk }}</span>
              <span>DEF/{{ card.monsterDef }}</span>
            </div>
          </div>
          <div class="mb-2 font-bold text-black text-sm space-x-1">
            <span>[ </span>
            <span>{{ card.typeCarte }} </span>
            <span v-if="isMonster(card)">
              <span>/{{ card.race.libelleRace }} </span>
              <span>/{{ card.attribute.libelleAttribute }} </span>
            </span>
            <span> ]</span>
          </div>
          <p
            class="
              block
              flex-1 flex flex-col
              text-left text-black
              overflow-y-auto
              space-y-1
            "
          >
            <span
              v-for="(text, index) in card.descriptionCarte.split(
                '----------------------------------------'
              )"
              :key="index"
              v-html="
                text
                  .replace(
                    '[ Pendulum Effect ]',
                    `<span class='bg-teal-100 text-teal-800 font-bold py-0.5 px-1.5 rounded'>[ Pendulum Effect ]</span>`
                  )
                  .replace(
                    '[ Monster Effect ]',
                    `<span class='bg-amber-100 text-amber-700 font-bold py-0.5 px-1.5 rounded'>[ Monster Effect ]</span>`
                  )
              "
            >
            </span>
          </p>
        </div>
      </div>
    </div>
  </transition>
</template>

<script lang="ts">
import Card from "@/models/card/Card";
import Util from "@/helpers/Util";
import { getCardData } from "@/services/Cards";

export default {
  name: "card-preview",
  props: {},
  mixins: [Util],
  data() {
    return {
      isVisible: false as boolean,
      card: null as Card,
      isLoading: false as boolean,
    };
  },
  created() {
    if (this.isVisible && this.$store.getters.getCardPreviewId != null) {
      this.fetchCardData(this.$store.getters.getCardPreviewId);
      this.isVisible = this.$store.getters.isCardPreviewVisible;
    }

    this.$store.watch(
      (state: any) => {
        return {
          isVisible: this.$store.getters.isCardPreviewVisible,
          cardData: this.$store.getters.getCardPreviewData,
          cardId: this.$store.getters.getCardPreviewId,
        };
      },
      (val: Object) => {
        this.isVisible = val.isVisible;
        if (val.cardData == null) {
          this.fetchCardData(val.cardId);
        } else {
          this.card = val.cardData;
        }
      },
      {
        deep: true,
      }
    );
  },
  mounted() {},
  methods: {
    async fetchCardData(cardId: String) {
      this.isLoading = true;
      const response = await getCardData(cardId);
      this.isLoading = false;

      if (response.status === true) {
        this.card = response.data;

        await this.$store.dispatch("setCardPreviewData", this.card);
        await this.$store.dispatch("setCardPreviewId", this.card.idCarte);
      } else {
        toastjs.logErrorActive(response.data.response.data.message);
      }
    },
    hidePreview() {
      this.isVisible = false;
      this.$store.dispatch("setCardPreviewVisible", this.isVisible);
    },
  },
};
</script>

<style>
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.2s;
}

.fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
  opacity: 0;
}
</style>
