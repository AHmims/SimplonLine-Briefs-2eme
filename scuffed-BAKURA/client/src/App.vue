<template>
  <div id="app">
    <nav-bar />
    <div class="relative px-6">
      <router-view style="flex: 1" />
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
