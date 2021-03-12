const colors = require('tailwindcss/colors')
module.exports = {
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
        '122.5': '490px'
      },
      height: {
        '0.25': '1px'
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
        '7.5': '30px',
        'offCenter': '47%'
      },
      gridTemplateColumns: {
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
    },
  },
  variants: {
    extend: {},
    scrollbar: ['rounded']
  },
  plugins: [
    require('tailwind-scrollbar')
  ],
  // purge: {
  //   enabled: true,
  //   content: ['./f_src/html/*.html']
  // }
}