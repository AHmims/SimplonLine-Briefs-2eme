//init object
let _data = {
    emplacement: [],
    local: []
};
//
window.onload = () => {
    //date input manager
    (function () {
        let currDate = new Date();
        /*currDate = currDate.setDate(currDate.getDate() - 6);
        currDate = new Date(currDate);*/
        //
        let tempMonth = currDate.getMonth() + 1;
        let tempDay = currDate.getDate();
        //
        let data = {
            dayNumber: currDate.getDay() + 1,
            day: tempDay.toString().length != 1 ? tempDay : `0${tempDay}`,
            month: tempMonth.toString().length != 1 ? tempMonth : `0${tempMonth}`,
            year: currDate.getFullYear(),
            interval: {
                min: 0,
                max: 0
            }
        }
        //
        if (data.dayNumber >= 2 && data.dayNumber <= 7) {
            currDate.setDate(currDate.getDate() + 1 + 7 - data.dayNumber);
            let tempMaxDay = currDate.getDate();
            let newTempMonth = currDate.getMonth() + 1;
            let maxMonth = newTempMonth.toString().length != 1 ? newTempMonth : `0${newTempMonth}`;
            //
            data.interval.min = `${data.year}-${data.month}-${data.day}`;
            data.interval.max = `${data.year}-${maxMonth}-${tempMaxDay.toString().length != 1 ? tempMaxDay : `0${tempMaxDay}`}`;
        } else if (data.dayNumber == 1) {
            data.interval.min = `${data.year}-${data.month}-${data.day}`;
            data.interval.max = data.interval.min;
        }
        //
        const dateInput = document.getElementById('formDateInput');
        dateInput.setAttribute('max', data.interval.max);
        dateInput.setAttribute('min', data.interval.min);
    }());
    //select manager
    (function () {
        console.log('uhmmm');
        const slct_1 = document.getElementById('inputLocal');
        slct_1.addEventListener('change', e => {
            const slct_2 = document.getElementById('inputEmplacement');
            if (slct_2.disabled)
                slct_2.disabled = false;
            let optionsCount = slct_2.options.length;
            if (optionsCount > 1) {
                for (let i = 1; i < optionsCount; i++) {
                    slct_2.remove(1);
                }
            }
            //
            const selectedValue = slct_1.options[slct_1.selectedIndex].value;
            for (const emplacement of _data.emplacement) {
                //console.log({ emplacement, selectedValue });
                if (selectedValue == emplacement.local) {
                    let option = document.createElement('option');
                    option.setAttribute('value', emplacement.id);
                    option.innerText = emplacement.label;
                    //
                    slct_2.appendChild(option);
                }
            }
        });
    }());
}
const addData = (type, id, label, fk = null) => {
    if (type == "emplacement") _data.emplacement.push({ id: id, label: label, local: fk });
    else _data.local.push({ id: id, label: label });
}