const colors = require('tailwindcss/colors')
module.exports = {
  purge: [],
  darkMode: false, // or 'media' or 'class'
  theme: {
    extend: {
      fontFamily: {
        'Kollektif': ['Kollektif', 'sans-serif'],
        'Source Sans Pro': ['Source Sans Pro', 'sans-serif']
      },
      borderRadius: {
        '20': '20px',
        '34': '34px',
        '40': '40px'
      },
      colors: {
        amber: colors.amber,
        coolGray: colors.coolGray,
        warmGray: colors.warmGray,
        orange: colors.orange
      }
    },
  },
  variants: {
    extend: {},
  },
  plugins: [],
}