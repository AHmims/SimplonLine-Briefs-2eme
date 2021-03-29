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
    --- insertion reservation
    50: inserted
    51: not inserted
    500: learner(apprenant) not found
    501: emplacement not found
    502: local not found
    503: date format is invalid
    504: no calendar exists in the date given
    505: already booked for this date, choose another date
    506: already have a reservation in waiting for validation
    507: queue filled for the provided date
    --- cancel reservation
    60: reservation cancelled
    61: reservation not cancelled
    600: learner not found
    601: reservation not found
    602: reservation already validated
    --- validate reservation
    40: learner deleted
    41: learner not deleted
    42: learner updated / validated
    43: learner not updated / validated
    400: learner not found
    401: admin not found
    --- insert calendrier
    20: "Calendrier" and "Jour" objects inserted successfully
    200: form inputs can't be empty
    201: inputs can't have alphabets, use numbers instead
    202: numbers can't be negative && can't be double
    203: date is not valid
    204: start date isn't monday || end date isn't sunday
    205: date interval does not match 7 days
    206: interval already exists in DB
    207: error saving "Jour" record or "Calendrier"
    --- validate learner
    30: learner refused
    31: learner not refused
    32: learner updated / validated
    33: learner not updated / validated
    38: learner deleted
    39: learner not deleted
    300: learner not found
    */
    const loginLink = window.location.origin + "/auth/login";
    const signupLink = window.location.origin + "/auth/register";
    switch (parseInt(errorCode)) {
        case 102:
            await toastRedirectNormal(loginLink, "Vous êtes déjà inscrit", "S'authentifier");
            break;
        case 103: logErrorActive("Veuillez vous inscrire avec votre email Simplonline.");
            break;
        case 104:
            await toastRedirectNormal(signupLink, "Vous n'êtes pas inscrit, veuillez créer un compte.", "S'inscrire");
            break;
        case 105:
            logWarningActive("Votre compte n'est pas encore validé par un administrateur, veuillez revérifier plus tard.");
            break;
        case 50:
            logSuccess("Reservation envoyée avec succées!");
            break;
        //
        case 30: logSuccess("La demande d'inscription a été refusée"); break;
        case 32: logErrorActive("La demande d'inscription a été accepté"); break;
        case 38: logSuccess("Apprenant supprimé avec succès"); break;
        case 39: logErrorActive("L'apprenant n'a pas été supprimé"); break;
        //
        case 20: logSuccess("Calendrier créé avec succès"); break;
        case 200: logErrorActive("les champs du formulaire ne doivent pas être vides"); break;
        case 201: logErrorActive("Les champs de jours n'acceptent que les chiffres"); break;
        case 202: logErrorActive("Les champs de jours n'acceptent que les nombres supérieurs a 0 et qui n'ont pas de virgule"); break;
        case 203: logErrorActive("Champs date n'est pas valide"); break;
        case 204: logErrorActive("Le jour de date début est différent de lundi ou bien date fin et different de dimanche"); break;
        case 205: logErrorActive("l'intervalle n'est pas égal à 7 jours"); break;
        case 206: logErrorActive("Il existe déjà un intervalle dans DB qui correspond à celui fourni"); break;
        //
        case 40: logSuccess("La demande de réservation a été refusée"); break;
        case 42: logSuccess("La demande de réservation a été accepté"); break;
        case 401: logErrorActive("Merci d'authentifier"); break;
        //
        case 51: logSuccess("La réservation n'a pas été envoyée.<br/>Veuillez réessayer plus tard"); break;
        case 500: logErrorActive("Merci d'authentifier"); break;
        case 501: logErrorActive("Emplacement non trouvée"); break;
        case 502: logErrorActive("Local non trouvée"); break;
        case 503: logErrorActive("Date invalide"); break;
        case 504: logErrorActive("Les réservations ne sont pas encore programmées pour cette semaine.<br />Veuillez attendre ou contacter l'administration."); break;
        case 505: logWarningActive("Vous avez déjà effectué une réservation qui a été validée à cette date."); break;
        case 506: logErrorActive("Vous avez déjà une réservation en attente de validation"); break;
        case 507: logWarningActive("Le nombre de réservations autorisées pour ce jour a été atteint.<br />Choisir un autre jour."); break;
        //
        case 60: logSuccess("Réservation annulée avec succès"); break;
        case 600: logErrorActive("Merci d'authentifier"); break;
        case 602: logWarningActive("Réservation déjà validée"); break;
        //
        case 555: logErrorActive("les données envoyées ne sont pas valides, veuillez utiliser des données valides"); break;
        case 106: logErrorActive("Champ email no doit pas etre vide"); break;
        case 107: logErrorActive("Champ mot de passe ne doit pas etre vide"); break;
        case 108: logErrorActive("La combinaison d'email est mot de passe ne correspond a aucun utilisateur"); break;
        case 11: await logSuccess("Compte créé avec succès"); window.location.href = loginLink; break;
        case 12: await logSuccess("Authentifié avec succès"); window.location.href = window.location.origin + "/apprenant/reserver"; break;
        case 13: await logSuccess("Authentifié avec succès"); window.location.href = window.location.origin + "/admin"; break;
        case -1: case 10: case 100: case 101: case 61: case 601: case 41: case 43: case 400: case 207: case 31: case 33: case 300: default: await logServerError();
    }
}