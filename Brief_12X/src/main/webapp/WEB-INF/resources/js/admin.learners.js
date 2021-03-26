const forms = document.getElementsByClassName('card-learner');
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
// 
// 
const learners = document.getElementsByClassName('learner_row');
Array.from(learners).forEach(learner => {
    learner.querySelector('button').addEventListener('click', async e => {
        if (await toastConfirmDelete())
            learner.submit();
    });
});