<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/style.css">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <script src="/js/axios.min.js"></script>
    <link rel="stylesheet" href="/css/toast.css">
    <script src="/js/toast.js"></script>
    <script src="/js/toastsHandler.js"></script>
    <script src="/js/request.errors.js"></script>
    <title>Acceuil</title>
</head>

<body>
    <div class="bg-white p-4 min-h-screen w-full flex flex-col">
        <!-- main -->
        <div class="w-full h-auto flex-1 flex flex-col justify-between space-y-4">
            <!-- Hero -->
            <div class="w-full p-10 space-y-20 bg-white rounded-lg.5">
                <!-- navbar -->
                <div class="w-full h-auto">
                    <div class="container mx-auto bg-white py-4 px-5 flex flex-row items-center justify-between rounded-lg.5 shadow-navBarOther">
                        <!-- logo -->
                        <div class="w-3/12">
                            <svg width="33" height="23" viewBox="0 0 33 23" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path d="M0 0.272736L6.38352 11.8977V17.7273H10.5767V11.8977L16.9602 0.272736H12.2472L8.55682 7.57671H8.40341L4.71307 0.272736H0Z" fill="#0F172A" />
                                <path d="M18.7287 17.7273H26.5611C30.4219 17.7273 32.6378 15.6648 32.6378 12.8438C32.6378 10.321 30.8054 8.7358 28.6918 8.64205V8.4716C30.6094 8.07103 31.956 6.68183 31.956 4.68751C31.956 2.05399 29.9276 0.272736 26.0071 0.272736H18.7287V17.7273ZM22.9474 14.3267V10.1676H25.6321C27.2429 10.1676 28.2315 11.0199 28.2315 12.358C28.2315 13.5938 27.3793 14.3267 25.5554 14.3267H22.9474ZM22.9474 7.44887V3.62217H25.3509C26.7571 3.62217 27.652 4.3466 27.652 5.50569C27.652 6.73296 26.6634 7.44887 25.2827 7.44887H22.9474Z" fill="#0F172A" />
                                <path d="M18.5483 21.2273C18.5483 20.3989 19.2199 19.7273 20.0483 19.7273H31.0483C31.8767 19.7273 32.5483 20.3989 32.5483 21.2273C32.5483 22.0557 31.8767 22.7273 31.0483 22.7273H20.0483C19.2199 22.7273 18.5483 22.0557 18.5483 21.2273Z" fill="#0F172A" />
                            </svg>
                        </div>
                        <!-- navlinks -->
                        <div class="font-Inter text-sm text-blueGray-900 font-medium">
                            <a href="/">
                                <span class="navLink">Accueil</span>
                            </a>
                        </div>
                        <!-- btns -->
                        <div class="w-3/12 flex flex-row items-center justify-end space-x-3.5">
                            <a href="/auth/login" class="buttonSec">
                                <span>Authentifier</span>
                            </a>
                            <a href="/auth/register" class="buttonMain">
                                <span>Enregistrer</span>
                            </a>
                        </div>
                    </div>
                </div>
                <!-- form -->
                <div class="mx-auto space-y-10 font-Inter w-122.5 border-3 border-coolGray-100 rounded-lg.5 py-10 px-7.5 flex flex-col">
                    <!-- top text -->
                    <div class="space-y-1.5">
                        <h1 class="text-2xl font-medium text-coolGray-900">S’inscrire</h1>
                        <h2 class="text-sm font-normal text-coolGray-700">
                            Créez votre compte avec <span class="underline">Google</span>, pour effectuer votre première réservation
                        </h2>
                    </div>
                    <!-- btns -->
                    <div class="space-y-3.5 w-full">
                        <!-- google auth btn -->
                        <button id="gBtn" class="buttonBorder py-3 flex flex-row items-center justify-center space-x-2.5 w-full">
                            <svg width="19" height="18" viewBox="0 0 19 18" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <g clip-path="url(#clip0)">
                                    <path fill-rule="evenodd" clip-rule="evenodd" d="M18.14 9.19999C18.14 8.56298 18.083 7.94899 17.976 7.35999H9.5V10.841H14.344C14.135 11.966 13.501 12.919 12.548 13.558V15.816H15.456C17.158 14.249 18.14 11.942 18.14 9.20099V9.19999Z" fill="#4285F4" />
                                    <path fill-rule="evenodd" clip-rule="evenodd" d="M9.50301 18C11.933 18 13.97 17.194 15.459 15.82L12.55 13.56C11.744 14.1 10.714 14.42 9.50301 14.42C7.15901 14.42 5.17501 12.836 4.46701 10.709H1.46001V13.041C2.94001 15.983 5.98501 18 9.50301 18Z" fill="#34A853" />
                                    <path fill-rule="evenodd" clip-rule="evenodd" d="M4.464 10.712C4.284 10.172 4.182 9.59496 4.182 9.00196C4.182 8.40896 4.284 7.83196 4.464 7.29196V4.95996H1.457C0.847 6.17496 0.5 7.54996 0.5 9.00196C0.5 10.454 0.848 11.829 1.457 13.044L4.464 10.712Z" fill="#FBBC05" />
                                    <path fill-rule="evenodd" clip-rule="evenodd" d="M9.50301 3.58C10.824 3.58 12.011 4.034 12.943 4.925L15.525 2.345C13.964 0.891 11.928 0 9.50201 0C5.98501 0 2.94001 2.017 1.46001 4.958L4.46701 7.29C5.17501 5.163 7.15901 3.58 9.50301 3.58Z" fill="#EA4335" />
                                </g>
                                <defs>
                                    <clipPath id="clip0">
                                        <rect width="18" height="18" fill="white" transform="translate(0.5)" />
                                    </clipPath>
                                </defs>
                            </svg>
                            <span>S'inscrire avec Google</span>
                        </button>
                    </div>
                    <!-- bot -->
                    <div class="w-full space-y-1.5">
                        <span class="block w-full text-center text-xs text-coolGray-500 font-normal">Avez vous déja un compte ?</span>
                        <a href="/auth/login" class="block text-center w-full buttonSec py-3">
                            <span>S’authentifier</span>
                        </a>
                    </div>
                </div>
            </div>
            <!-- footer -->
            <div class="w-full bg-coolGray-900 p-10 space-x-10 flex flex-row justify-center items-center rounded-lg.5">
                <svg class="w-24" width="34" height="23" viewBox="0 0 34 23" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M0.508026 0.440002L6.89155 12.065V17.8945H11.0847V12.065L17.4683 0.440002H12.7552L9.06484 7.74398H8.91144L5.22109 0.440002H0.508026Z" fill="#F1F5F9" />
                    <path d="M19.2367 17.8945H27.0691C30.9299 17.8945 33.1458 15.832 33.1458 13.011C33.1458 10.4883 31.3134 8.90307 29.1998 8.80932V8.63887C31.1174 8.2383 32.464 6.84909 32.464 4.85478C32.464 2.22125 30.4356 0.440002 26.5151 0.440002H19.2367V17.8945ZM23.4555 14.494V10.3349H26.1401C27.7509 10.3349 28.7396 11.1872 28.7396 12.5252C28.7396 13.761 27.8873 14.494 26.0634 14.494H23.4555ZM23.4555 7.61614V3.78943H25.8589C27.2651 3.78943 28.16 4.51387 28.16 5.67296C28.16 6.90023 27.1714 7.61614 25.7907 7.61614H23.4555Z" fill="#F1F5F9" />
                    <path d="M19.0563 21.3945C19.0563 20.5661 19.7279 19.8945 20.5563 19.8945H31.5563C32.3847 19.8945 33.0563 20.5661 33.0563 21.3945C33.0563 22.223 32.3847 22.8945 31.5563 22.8945H20.5563C19.7279 22.8945 19.0563 22.223 19.0563 21.3945Z" fill="#F1F5F9" />
                </svg>
                <!--  -->
                <div class="w-24">
                    <img src="/img/white 1.png" alt="youcode logo">
                </div>
            </div>
        </div>
    </div>
    <script src="/js/auth.signup.js"></script>
</body>

</html>