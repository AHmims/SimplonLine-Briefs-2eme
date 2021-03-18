async function errorHandler(errorCode) {
    /*
    ERROR CODES:
    -1: unknown
    10: learner not saved
    11: learner saved
    12: learner authenticated
    13: admin authenticated
    100: token invalid
    101: no email address
    102: user already registered
    103: email is not registered to simplonline
    104: user not registered
    105: account not activated by administrator
    106: email field is empty
    107: password field is empty
    108: credentials combo is wrong
    */
    const loginLink = window.location.origin + "/auth/login";
    const signupLink = window.location.origin + "/auth/register";
    switch (parseInt(errorCode)) {
        case 102:
            await toastRedirectNormal(loginLink, "Vous êtes déjà inscrit", "S'authentifier");
            break;
        case 103: logError("Veuillez vous inscrire avec votre email Simplonline.");
            break;
        case 104:
            await toastRedirectNormal(signupLink, "Vous n'êtes pas inscrit, veuillez créer un compte.", "S'inscrire");
            break;
        case 105:
            logWarningActive("Votre compte n'est pas encore validé par un administrateur, veuillez revérifier plus tard.");
            break;
        case 106: logError("Champ email no doit pas etre vide"); break;
        case 107: logError("Champ mot de passe ne doit pas etre vide"); break;
        case 108: logError("La combinaison d'email est mot de passe ne correspond a aucun utilisateur"); break;
        case 11: await logSuccess("Compte créé avec succès"); window.location.href = loginLink; break;
        case 12: await logSuccess("Authentifié avec succès"); window.location.href = window.location.origin + "/apprenant/reserver"; break;
        case 13: await logSuccess("Authentifié avec succès"); window.location.href = window.location.origin + "/admin"; break;
        case -1: case 10: case 100: case 101: default: await logServerError();
    }
}