var googleUser = {};
window.onLoadCallback = function () {
    gapi.load('auth2', function () {
        // Retrieve the singleton for the GoogleAuth library and set up the client.
        auth2 = gapi.auth2.init({
            client_id: '901956477803-2usslh9shsaa92699519rak6732253v9.apps.googleusercontent.com',
            cookiepolicy: 'single_host_origin',
            scope: 'profile email'
        });
        attachBtn(document.getElementById('gBtn'));
    });
};

function attachBtn(element) {
    auth2.attachClickHandler(element, {},
        async googleUser => {
            var profile = googleUser.getBasicProfile();
            console.log(profile);
            let response = await axios.post(`/register?idToken=${googleUser.getAuthResponse().id_token}`);
            /*
            ERROR CODES:
            -1: unknown
            0: learner not saved
            1: learner saved
            100: token invalid
            101: no email address
            102: already registered
            103: email is not registered to simplonline
            */
            const loginLink = window.location.origin + "/login";
            switch (response.data) {
                case 102:
                    await toastRedirectNormal(loginLink);
                    break;
                case 103: logError("Veuillez vous inscrire avec votre email Simplonline."); break;
                case 1: await logSuccess("Compte créé avec succès"); window.location.href = loginLink; break;
                case -1: case 0: case 100: case 101: default: await logServerError();
            }
        },
        error => {
            console.log(JSON.stringify(error, undefined, 2));
        }
    );
}