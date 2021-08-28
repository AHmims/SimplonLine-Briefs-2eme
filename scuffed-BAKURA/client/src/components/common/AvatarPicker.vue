<template>
  <div>
    <h4>Image picker</h4>
    <single-image-uploader @input="setUserImage" style="width: 190px; margin: 0 auto;"/>
    <div>
      <img v-for="(avatar, index) in defaultAvatars"
           :class="{inactive: !avatar.selected}"
           @click="selectAvatar(index)"
           :src="getImageUrl(avatar.lienImage)"
           :alt="'Avatar number ' + index"/>
    </div>
  </div>
</template>

<script lang="ts">
import Util from '@/helpers/Util';
import Image from '@/models/image/Image';
import {getDefaultAvatars} from '@/services/Images';
import SingleImageUploader from '@/components/common/SingleImageUploader.vue';

export default {
  name: 'avatar-picker',
  components: {SingleImageUploader},
  props: {},
  mixins: [Util],
  data() {
    return {
      defaultAvatars: [],
      isLoadingAvatars: false as boolean,
      userAvatar: null,
      userProfileImage: null
    };
  },
  created() {
    this.userAvatar = this.$store.getters.getUserData.avatar;
    this.fetchDefaultAvatars();
  },
  methods: {
    async fetchDefaultAvatars() {
      this.isLoadingAvatars = true;
      const response = await getDefaultAvatars();
      this.isLoadingAvatars = false;

      if (response.status === true) {
        this.defaultAvatars = response.data.map((image: Image) => {
          return {...image, selected: this.userAvatar != null && image.idImage === this.userAvatar.idImage};
        });
      } else {
        console.error(response.data);
      }
    },
    selectAvatar(index) {
      if (this.defaultAvatars[index] != this.userAvatar) {
        this.userAvatar = this.defaultAvatars[index];
        this.defaultAvatars[index].selected = true;

        this.defaultAvatars.forEach((avatar, i) => {
          if (i != index) {
            avatar.selected = false;
          }
        });
      }
    },
    setUserImage(image: Image) {
      this.userProfileImage = image;
    }
  }
};
</script>

<style scoped>
.inactive {
  opacity: 0.5;
}
</style>
