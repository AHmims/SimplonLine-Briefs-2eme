<template>
  <transition name="fade">
    <div v-if="isVisible" style="width: 400px;position: sticky;top: 0;right: 0;height: 85vh;padding: 20px;">
      <div style="border: 1px solid black; width: 100%;height: 100%; box-sizing: border-box">
        <h3>Card preview <input type="button" value="X" @click="hidePreview"/></h3>
        <img :src="getImageUrl(card.imageCarte.lienImage)" :alt="card.nomCarte" style="width: 350px"/>
        <p>{{ card.nomCarte }}</p>
        <p>{{ card.givenCarteId }}</p>
        <div v-if="isMonster(card)">
          <span>
            <span>{{ card.monsterAtk }}-ATK /{{ card.monsterDef }}-DEF </span>
            <span v-if="isLink(card)">/Link-{{ card.monsterScale }} </span>
            <span v-else>
              <span v-if="!isXyz(card)">/Lvl-{{ card.monsterLvl }} </span>
              <span v-else>/Rank-{{ card.monsterLvl }} </span>
              <span v-if="isPendulum(card)">/Scale-{{ card.monsterScale }} </span>
            </span>
          </span>
        </div>
        <div>
          <span>{{ card.typeCarte }} </span>
          <span v-if="isMonster(card)">
            <span>/{{ card.race.libelleRace }} <img v-if="card.race.imageRace != null"
                                                    :src="getImageUrl(card.race.imageRace.lienImage)"
                                                    :alt="card.race.libelleRace"
                                                    style="width: 30px;"> </span>
            <span>/{{ card.attribute.libelleAttribute }} <img v-if="card.attribute.imageAttribute != null"
                                                              :src="getImageUrl(card.attribute.imageAttribute.lienImage)"
                                                              :alt="card.attribute.libelleAttribute"
                                                              style="width: 30px;"> </span>
          </span>
        </div>
        <textarea :value="card.descriptionCarte" cols="46" rows="6"></textarea>
      </div>
    </div>
  </transition>
</template>

<script lang="ts">
import Card from '@/models/card/Card';
import Util from '@/helpers/Util';
import {getCardData} from '@/services/Cards';

export default {
  name: 'card-preview',
  props: {},
  mixins: [Util],
  components: {},
  data() {
    return {
      isVisible: false as boolean,
      card: null as Card,
      isLoading: false as boolean
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
          cardId: this.$store.getters.getCardPreviewId
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
        deep: true
      }
    );
  },
  mounted() {
  },
  methods: {
    async fetchCardData(cardId: String) {
      this.isLoading = true;
      const response = await getCardData(cardId);
      this.isLoading = false;

      if (response.status === true) {
        this.card = response.data;

        await this.$store.dispatch('setCardPreviewData', this.card);
        await this.$store.dispatch('setCardPreviewId', this.card.idCarte);
      } else {
        console.error(response.data);
      }
    },
    hidePreview() {
      this.isVisible = false;
      this.$store.dispatch('setCardPreviewVisible', this.isVisible);
    }
  }
};
</script>

<style>
.fade-enter-active, .fade-leave-active {
  transition: opacity .2s;
}

.fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */
{
  opacity: 0;
}
</style>
