const colors = require('tailwindcss/colors')
module.exports = {
  darkMode: false, // or 'media' or 'class'
  theme: {
    extend: {
      fontFamily: {
        'Kollektif': ['Inter', 'sans-serif']
      },
      borderRadius: {
      },
      width: {
      },
      height: {
      },
      boxShadow: {
      },
      zIndex: {
      },
      borderWidth: {
      },
      spacing: {
      },
      gridTemplateColumns: {
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