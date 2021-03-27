(function () {
    let currDate = new Date();
    /*currDate = currDate.setDate(currDate.getDate() + 1);
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
        let tempMaxDay = currDate.getDate() + 1 + 7 - data.dayNumber;
        data.interval.min = `${data.year}-${data.month}-${data.day}`;
        data.interval.max = `${data.year}-${data.month}-${tempMaxDay.toString().length != 1 ? tempMaxDay : `0${tempMaxDay}`}`;
    } else if (data.dayNumber == 1) {
        data.interval.min = `${data.year}-${data.month}-${data.day}`;
        data.interval.max = data.interval.min;
    }
    //
    const dateInput = document.getElementById('formDateInput');
    dateInput.setAttribute('max', data.interval.max);
    dateInput.setAttribute('min', data.interval.min);
}());