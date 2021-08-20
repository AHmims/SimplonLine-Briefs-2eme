export default {
  methods: {
    getImageUrl(imageUrl: String) {
      // @ts-ignore
      return `${SERVER_ENDPOINT}${imageUrl}`;
    }
  }
};
