<template>
  <div>
    <file-upload :multiple="false"
                 :value="null"
                 label='Drag & Drop your picture or <span class="filepond--label-action">Browse</span>'
                 :endpoint="imageUploadEndpoint"
                 aspect-ratio="1:1"
                 preview-mode="compact circle"
                 @fileUpload="updateImageObject"
                 file-types="image/jpeg, image/png, image/jpg, image/jfif"/>
  </div>
</template>

<script lang="ts">
import FileUpload from '@/components/common/FileUpload.vue';

export default {
  name: 'single-image-uploader',
  components: {FileUpload},
  props: {},
  data() {
    return {
      image: null,
      imageUploadEndpoint: `${API_ENDPOINT}/image`
    };
  },
  methods: {
    updateImageObject(data) {
      this.image = data;

      this.$emit('input', this.image != null ? this.image[0] : null);
    }
  }
};
</script>

<style scoped>

</style>
