<template>
  <div id="app">
    <nav-bar/>
    <div style="display: flex; width: 100%">
      <router-view style="flex: 1"/>
      <card-preview/>
    </div>
  </div>
</template>

<script>
import NavBar from "@/components/NavBar.vue";
import CardPreview from "@/components/card/CardPreview.vue";

export default {
  components: {CardPreview, NavBar}
}
</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
