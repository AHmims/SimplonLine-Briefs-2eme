const colors = require('tailwindcss/colors')
module.exports = {
  purge: [],
  darkMode: false, // or 'media' or 'class'
  theme: {
    extend: {
      fontFamily: {
        'Kollektif': ['Kollektif', 'sans-serif'],
        'SourceSansPro': ['"Source Sans Pro"', 'sans-serif']
      },
      borderRadius: {
        '20': '20px',
        '34': '34px',
        '40': '40px'
      },
      width: {
        '456': '456px',
        '719': '719px'
      },
      zIndex: {
        '-1': '-1'
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