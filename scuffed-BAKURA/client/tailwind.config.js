const colors = require('tailwindcss/colors')

module.exports = {
  mode: 'jit',
  purge: ['./index.html', './src/**/*.{vue,js,ts,jsx,tsx}'],
  darkMode: false, // or 'media' or 'class'
  theme: {
    extend: {
      fontFamily: {
        'Inter': ['Inter', 'sans-serif']
      },
      colors: {
        amber: colors.amber,
        coolGray: colors.coolGray,
        blueGray: colors.blueGray,
        trueGray: colors.trueGray,
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
  },
  plugins: [],
}
