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
        googleUser => {

            console.log(googleUser);
            var profile = googleUser.getBasicProfile();
            var id_token = googleUser.getAuthResponse().id_token;
            console.log(id_token);
            console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
            console.log('Name: ' + profile.getName());
            console.log('Image URL: ' + profile.getImageUrl());
            console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
        },
        error => {
            console.log(JSON.stringify(error, undefined, 2));
        }
    );
}