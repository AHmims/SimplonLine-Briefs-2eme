const {
  lightBlue
} = require('tailwindcss/colors');
const colors = require('tailwindcss/colors');
module.exports = {
  purge: {
    enabled: true,
    content: ['./web/*.jsp', './web/components/*.jsp'],
  },
  darkMode: false, // or 'media' or 'class'
  theme: {
    extend: {}
  },
  variants: {
    extend: {},
  },
  plugins: [],
}