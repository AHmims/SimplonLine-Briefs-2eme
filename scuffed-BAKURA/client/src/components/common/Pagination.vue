<template>
  <div style="display: flex; flex-direction: row; justify-content: center; margin: 10px 0;">
    <button style="width: 50px;" @click="navigate(currentPage - 1)" :disabled="disabled"><</button>
    <div v-for="(pagination, index) in currentPagesView">
      <button style="width: 26px; height: 40px" @click="navigate(pagination - 1)" :disabled="disabled">
        <template v-if="currentPage + 1 === pagination">
          <strong>{{ pagination }}</strong>
        </template>
        <template v-else>{{ pagination }}</template>
      </button>
    </div>
    <button style="width: 50px;" @click="navigate(currentPage + 1)" :disabled="disabled">></button>
  </div>
</template>

<script lang="ts">
export default {
  name: 'pagination',
  props: {
    value: {
      type: Number,
      required: true
    },
    paginationCount: {
      type: Number,
      required: false,
      default: 10
    },
    enableNavigation: {
      type: Boolean,
      required: false,
      default: true
    },
    offset: {
      type: Number,
      required: false,
      default: 3
    },
    startingPage: {
      type: Number,
      required: false,
      default: 1
    },
    disabled: {
      type: Boolean,
      required: false,
      default: false
    }
  },
  data() {
    return {
      currentPage: this.startingPage - 1 as Number,
      currentPagesView: []
    };
  },
  created() {
    this.setupPaginationView();
  },
  methods: {
    navigate(page: Number) {
      if (page < 0) {
        this.currentPage = 0;
      } else if (page > this.value) {
        this.currentPage = this.value;
      } else {
        this.currentPage = page;
      }

      if (this.currentPage != page) {
        this.setupPaginationView();
        this.$emit('paginated', this.currentPage);
      }
    },
    setupPaginationView() {
      let count = 0;
      let newCurrentPagesView = [];
      let startingIndex = this.offset < this.currentPage ? this.currentPage - this.offset : 0;

      for (let i = startingIndex; i < this.value; i++) {
        newCurrentPagesView.push(i + 1);

        count++;
        if (count >= this.paginationCount) {
          break;
        }
      }

      this.currentPagesView = newCurrentPagesView;
    }
  },
  watch: {
    value(newVal: Number, oldVal: Number) {
      if (newVal != oldVal) {
        this.setupPaginationView();
      }
    },
    startingPage: function(newVal: Number, oldVal: Number) {
      console.log(newVal, oldVal);
      if (newVal != oldVal) {
        this.currentPage = newVal - 1;
        this.setupPaginationView();
      }
    }
  }
};
</script>
