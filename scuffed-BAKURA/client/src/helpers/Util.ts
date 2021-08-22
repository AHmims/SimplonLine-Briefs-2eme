import Card from '@/models/card/Card';

export default {
  methods: {
    getImageUrl(imageUrl: String) {
      // @ts-ignore
      return `${SERVER_ENDPOINT}${imageUrl}`;
    },
    isMonster(card: Card): Boolean {
      return card.typeCarte.toLocaleLowerCase().includes('monster') || card.typeCarte.toLocaleLowerCase() === 'token';
    },
    isLink(card: Card): Boolean {
      return card.typeCarte.toLocaleLowerCase() === 'link monster';
    },
    isPendulum(card: Card): Boolean {
      return card.typeCarte.toLocaleLowerCase().includes('pendulum');
    },
    isXyz(card: Card): Boolean {
      return card.typeCarte.toLocaleLowerCase().includes('xyz');
    }
  }
};
