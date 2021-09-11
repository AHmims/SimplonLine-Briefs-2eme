<template>
  <button @click="clickHandler">
    <span>{{ value ? 'dislike' : 'like' }}</span>
  </button>
</template>

<script lang="ts">
import {likeCard} from '@/services/Favorites';

export default {
  name: 'like-card-button',
  props: {
    value: {
      type: Boolean,
      required: true
    },
    card: {
      type: String,
      required: true
    }
  },
  data() {
    return {};
  },
  created() {
  },
  mounted() {
  },
  methods: {
    async clickHandler() {
      const response = await likeCard(this.card);

      if (response.status === true) {
        this.$emit('input', response.data.changed);
      } else {
        console.error(response.data);
      }
    }
  }
};
</script>
