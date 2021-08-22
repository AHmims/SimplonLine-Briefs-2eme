<template>
  <div>
    <h3>Account settings</h3>
    <div>
      <h4>Image picker</h4>
      <input type="file">
      <div>
        <img v-for="(avatar, index) in defaultAvatars" :src="getImageUrl(avatar.lienImage)"
             :alt="'Avatar number ' + index"/>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import Image from '@/models/image/Image';
import {getDefaultAvatars} from '@/services/Images';
import Util from '@/helpers/Util';

export default {
  name: 'account-settings',
  props: {},
  mixins: [Util],
  data() {
    return {
      defaultAvatars: [] as Image[],
      isLoadingAvatars: false as boolean
    };
  },
  created() {
    this.fetchDefaultAvatars();
  },
  methods: {
    async fetchDefaultAvatars() {
      this.isLoadingAvatars = true;
      const response = await getDefaultAvatars();
      this.isLoadingAvatars = false;

      if (response.status === true) {
        this.defaultAvatars = response.data;
      } else {
        console.error(response.data);
      }
    }
  }
};
</script>
