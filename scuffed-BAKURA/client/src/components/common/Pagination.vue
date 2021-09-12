<template>
  <div class="pagination">
    <button
      class="pagination-control-button mr-2"
      @click="navigate(currentPage - 1)"
      :disabled="disabled"
    >
      <svg
        class="w-6 h-6"
        fill="currentColor"
        viewBox="0 0 20 20"
        xmlns="http://www.w3.org/2000/svg"
      >
        <path
          fill-rule="evenodd"
          d="M12.707 5.293a1 1 0 010 1.414L9.414 10l3.293 3.293a1 1 0 01-1.414 1.414l-4-4a1 1 0 010-1.414l4-4a1 1 0 011.414 0z"
          clip-rule="evenodd"
        ></path>
      </svg>
    </button>
    <div v-for="(pagination, index) in currentPagesView" :key="index">
      <button
        class="pagination-nav"
        :class="{ 'pagination-nav-selected': currentPage + 1 === pagination }"
        @click="navigate(pagination - 1)"
        :disabled="disabled"
      >
        <span>{{ pagination }}</span>
      </button>
    </div>
    <button
      class="pagination-control-button ml-2"
      @click="navigate(currentPage + 1)"
      :disabled="disabled"
    >
      <svg
        class="w-6 h-6"
        fill="currentColor"
        viewBox="0 0 20 20"
        xmlns="http://www.w3.org/2000/svg"
      >
        <path
          fill-rule="evenodd"
          d="M7.293 14.707a1 1 0 010-1.414L10.586 10 7.293 6.707a1 1 0 011.414-1.414l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414 0z"
          clip-rule="evenodd"
        ></path>
      </svg>
    </button>
  </div>
</template>

<script lang="ts">
export default {
  name: "pagination",
  props: {
    value: {
      type: Number,
      required: true,
    },
    paginationCount: {
      type: Number,
      required: false,
      default: 10,
    },
    enableNavigation: {
      type: Boolean,
      required: false,
      default: true,
    },
    offset: {
      type: Number,
      required: false,
      default: 3,
    },
    startingPage: {
      type: Number,
      required: false,
      default: 1,
    },
    disabled: {
      type: Boolean,
      required: false,
      default: false,
    },
  },
  data() {
    return {
      currentPage: (this.startingPage - 1) as Number,
      currentPagesView: [],
    };
  },
  created() {
    this.setupPaginationView();
  },
  methods: {
    navigate(page: Number) {
      if (this.currentPage != page) {
        if (page < 0) {
          this.currentPage = 0;
        } else if (page > this.value) {
          this.currentPage = this.value;
        } else {
          this.currentPage = page;
        }

        this.setupPaginationView();
        this.$emit("paginated", this.currentPage);
      }
    },
    setupPaginationView() {
      let count = 0;
      let newCurrentPagesView = [];
      let startingIndex =
        this.offset < this.currentPage ? this.currentPage - this.offset : 0;

      for (let i = startingIndex; i < this.value; i++) {
        newCurrentPagesView.push(i + 1);

        count++;
        if (count >= this.paginationCount) {
          break;
        }
      }

      this.currentPagesView = newCurrentPagesView;
    },
  },
  watch: {
    value(newVal: Number, oldVal: Number) {
      if (newVal != oldVal) {
        this.setupPaginationView();
      }
    },
    startingPage(newVal: Number, oldVal: Number) {
      if (newVal != oldVal) {
        this.currentPage = newVal - 1;
        this.setupPaginationView();
      }
    },
  },
};
</script>
