const colors = require('tailwindcss/colors')

module.exports = {
  mode: 'jit',
  purge: ["./src/**/*.{html,css}"],
  darkMode: false, // or 'media' or 'class'
  theme: {
    extend: {
      fontFamily: {
        'Inter': ['Inter', 'sans-serif']
      },
      borderRadius: {
        'lg.5': '10px'
      },
      width: {
        '10.5': '42px',
        '68': '270px',
        '122.5': '490px',
        '150': '600px'
      },
      height: {
        '0.25': '1px',
        '10.5': '42px',
        '12.5': '51px',
      },
      boxShadow: {
        'navBarHome': '0px 0px 0px 6px rgba(255, 255, 255, 0.2), 0px 10px 15px 2px rgba(15, 23, 42, 0.03)',
        'navBarOther': '0px 0px 0px 3px #F3F4F6, 0px 10px 15px 2px rgba(15, 23, 42, 0.03)'
      },
      zIndex: {
      },
      borderWidth: {
        '3': '3px'
      },
      spacing: {
        '4.5': '18px',
        '5.5': '16px',
        '7.5': '30px',
        '8.5': '34px',
        '8.6': '35px',
        '12.2': '49px',
        'offCenter': '47%'
      },
      gridTemplateColumns: {
        'home': 'minmax(500px,650px) 320px repeat(3,minmax(0, 1fr))',
        'learners': 'minmax(500px,650px) repeat(3,minmax(0, 1fr))',
        'reservations': '350px repeat(6,minmax(0, 1fr))',
        'items': 'repeat(auto-fill, 279px)'
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
        teal: colors.teal,
        customClr: {
          trans: 'rgba(15, 23, 42, 0.2)'
        }
      }
    }
  },
  variants: {
    extend: {},
  },
  plugins: [],
}
