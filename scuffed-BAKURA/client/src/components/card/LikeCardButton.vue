<template>
  <button @click="clickHandler" class="bg-blueGray-100 p-2 rounded-full w-min">
    <svg
      v-if="value"
      class="w-4 h-4 text-rose-500 fill-current"
      fill="currentColor"
      viewBox="0 0 20 20"
      xmlns="http://www.w3.org/2000/svg"
    >
      <path
        fill-rule="evenodd"
        d="M3.172 5.172a4 4 0 015.656 0L10 6.343l1.172-1.171a4 4 0 115.656 5.656L10 17.657l-6.828-6.829a4 4 0 010-5.656z"
        clip-rule="evenodd"
      ></path>
    </svg>
    <svg
      v-else
      class="w-4 h-4 text-blueGray-400 stroke-current"
      fill="none"
      stroke="currentColor"
      viewBox="0 0 24 24"
      xmlns="http://www.w3.org/2000/svg"
    >
      <path
        stroke-linecap="round"
        stroke-linejoin="round"
        stroke-width="2"
        d="M4.318 6.318a4.5 4.5 0 000 6.364L12 20.364l7.682-7.682a4.5 4.5 0 00-6.364-6.364L12 7.636l-1.318-1.318a4.5 4.5 0 00-6.364 0z"
      ></path>
    </svg>
  </button>
</template>

<script lang="ts">
import { likeCard } from "@/services/Favorites";

export default {
  name: "like-card-button",
  props: {
    value: {
      type: Boolean,
      required: true,
    },
    card: {
      type: String,
      required: true,
    },
  },
  data() {
    return {};
  },
  created() {},
  mounted() {},
  methods: {
    async clickHandler() {
      const response = await likeCard(this.card);

      if (response.status === true) {
        this.$emit("input", response.data.changed);
      } else {
        console.error(response.data);
      }
    },
  },
};
</script>
