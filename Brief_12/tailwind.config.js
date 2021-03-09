const colors = require('tailwindcss/colors')
module.exports = {
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
        '650': '650px',
        '559': '559px'
      },
      height: {
        '530': '530px'
      },
      boxShadow: {
        'avatar': 'inset 0px 0px 0px 3px white;'
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
        'item': 'repeat(auto-fill, 326px)'
      },
      colors: {
        amber: colors.amber,
        coolGray: colors.coolGray,
        warmGray: colors.warmGray,
        orange: colors.orange,
        rose: colors.rose,
        violet: colors.violet,
        emerald: colors.emerald,
        teal: colors.teal
      }
    },
  },
  variants: {
    extend: {},
    scrollbar: ['rounded']
  },
  plugins: [
    require('tailwind-scrollbar')
  ],
  purge: {
    enabled: true,
    content: ['./f_src/html/*.html']
  }
}