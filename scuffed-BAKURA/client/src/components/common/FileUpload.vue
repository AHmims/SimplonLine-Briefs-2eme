<template>
  <div>
    <file-pond
      name="images"
      ref="pond"
      :labelIdle="label"
      :allow-multiple="multiple"
      :accepted-file-types="fileTypes"
      :server="server"
      :files="value"
      @processfile="updateFileData"
      @removefile="removeFile"
      :imageCropAspectRatio="aspectRatio"
      :stylePanelLayout="previewMode"
      styleLoadIndicatorPosition="center bottom"
      styleProgressIndicatorPosition="right bottom"
      styleButtonRemoveItemPosition="left bottom"
      styleButtonProcessItemPosition="right bottom"
    />
  </div>
</template>

<script lang="ts">
import vueFilePond from 'vue-filepond';
import 'filepond/dist/filepond.min.css';
import 'filepond-plugin-image-preview/dist/filepond-plugin-image-preview.min.css';
import FilePondPluginImagePreview from 'filepond-plugin-image-preview';
import FilePondPluginImageCrop from 'filepond-plugin-image-crop';
import FilePondPluginFileValidateType from 'filepond-plugin-file-validate-type';

export default {
  name: 'file-upload',
  props: {
    value: {
      required: true
    },
    label: {
      type: String,
      required: false,
      default: 'Drop files here...'
    },
    multiple: {
      type: Boolean,
      required: false,
      default: true
    },
    fileTypes: {
      type: String,
      required: false,
      default: null
    },
    endpoint: {
      type: String,
      required: true
    },
    aspectRatio: {
      type: String,
      required: false,
      default: null
    },
    previewMode: {
      type: String,
      required: false,
      default: null
    }
  },
  data() {
    return {
      FilePond: vueFilePond(
        FilePondPluginImagePreview,
        FilePondPluginImageCrop,
        FilePondPluginFileValidateType
      ),
      file: null,
      server: null
    };
  },
  created() {
    this.server = {
      url: this.endpoint,
      process: {
        headers: {
          'Authorization': `Bearer ${this.$store.getters.getAuthToken}`
        }
      },
      revert: {
        headers: {
          'Authorization': `Bearer ${this.$store.getters.getAuthToken}`,
          'Content-Type': 'application/json'
        }
      },
      load: null,
      fetch: null,
      restore: null,
      patch: null
    };
  },
  methods: {
    updateFileData(err, data) {
      this.file = data.serverId;
    },
    removeFile() {
      this.file = null;
    }
  },
  watch: {
    file() {
      this.$emit('fileUpload', JSON.parse(this.file));
    }
  }
};
</script>
