var googleUser = {};
window.onload = function () {
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
            let response = await axios.post(`/auth/login/apprenant?idToken=${googleUser.getAuthResponse().id_token}`);
            errorHandler(response.data);
        },
        error => {
            console.log(JSON.stringify(error, undefined, 2));
        }
    );
}