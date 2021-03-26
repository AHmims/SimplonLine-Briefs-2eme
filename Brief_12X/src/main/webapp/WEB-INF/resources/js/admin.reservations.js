const forms = document.getElementsByClassName('card-reservation');
Array.from(forms).forEach(form => {
    const btnsV = form.getElementsByClassName('buttonMain');
    const btnsA = form.getElementsByClassName('buttonSec');
    const actionInput = form.getElementsByClassName('card_action')[0];
    //
    Array.from(btnsV).forEach(btnV => {
        btnV.addEventListener('click', e => {
            actionInput.value = "ok";
        });
    });
    //
    Array.from(btnsA).forEach(btnA => {
        btnA.addEventListener('click', e => {
            actionInput.value = "no";
        });
    });
});