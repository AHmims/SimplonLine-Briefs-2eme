<template>
  <div id="app">
    <nav-bar />
    <div class="relative px-6 flex flex-col flex-1">
      <router-view />
      <card-preview />
    </div>
  </div>
</template>

<script>
import NavBar from "@/components/NavBar.vue";
import CardPreview from "@/components/card/CardPreview.vue";

export default {
  components: { CardPreview, NavBar },
};
</script>
