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
    <button @click="updateAvatar">Change</button>
  </div>
</template>

<script lang="ts">
import Util from '@/helpers/Util';
import Image from '@/models/image/Image';
import {getDefaultAvatars} from '@/services/Images';
import SingleImageUploader from '@/components/common/SingleImageUploader.vue';
import {updateProfile} from '@/services/User';

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

      if (this.userProfileImage === null) {
        return;
      }

      this.defaultAvatars.forEach(avatar => {
        avatar.selected = false;
      });

      this.userAvatar = null;
    },
    getUserAvatar() {
      if (this.userAvatar === null) {
        return this.userProfileImage;
      }

      return this.userAvatar;
    },
    async updateAvatar() {
      if (this.getUserAvatar() === null) {
        console.error('Select an image first');
        return;
      }

      const response = await updateProfile({avatar: this.getUserAvatar()});

      if (response.status === true) {
        let userData = this.$store.getters.getUserData;
        userData.avatar = this.getUserAvatar();

        await this.$store.dispatch('setUserData', userData);
      } else {
        console.error(response.data);
      }
    }
  }
};
</script>

<style scoped>
.inactive {
  opacity: 0.2;
}
</style>
