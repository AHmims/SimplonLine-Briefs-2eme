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
        '40': '40px',
        '50': '50px'
      },
      width: {
        '456': '456px',
        '719': '719px',
        '650': '650px'
      },
      zIndex: {
        '-1': '-1'
      },
      borderWidth: {
        '3': '3px'
      },
      spacing: {
        '52_': '52px',
        '13': '50px',
        '420': '420px'
      },
      gridTemplateColumns: {
        // Simple 16 column grid
        'article': 'repeat(auto-fill, 300px)'
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