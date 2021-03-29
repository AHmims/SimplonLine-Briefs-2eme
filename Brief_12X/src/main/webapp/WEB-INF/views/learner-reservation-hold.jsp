<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/toast.css">
    <script src="/js/toast.js"></script>
    <script src="/js/toastsHandler.js"></script>
    <script src="/js/request.errors.js"></script>
    <title>Reservation</title>
</head>

<body>
    <div class="bg-white p-4 min-h-screen w-full flex flex-col">
        <!-- main -->
        <div class="w-full h-auto space-y-4 flex-1 flex flex-col justify-between">
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
                        <div class="font-Inter flex text-sm text-blueGray-900 font-medium space-x-3.5">
                            <a href="/">
                                <span class="navLink">Accueil</span>
                            </a>
                            <a href="/apprenant/reserver">
                                <span class="navLink">Reservation</span>
                            </a>
                            <a href="/apprenant/reservations">
                                <span class="navLink">Historique</span>
                            </a>
                        </div>
                        <!-- user -->
                        <div class="w-3/12 flex flex-row items-center justify-end space-x-4">
                            <div class="w-9 h-9 rounded-full overflow-hidden border-3 border-coolGray-700 relative">
                                <img referrerpolicy="no-referrer" src="<c:out value="${sessionScope.__user_data.imgApprenant}"/>" alt="" class="w-full h-full object-cover">
                                <div class="w-full h-full rounded-full shadow-avatar absolute top-0 left-0"></div>
                            </div>
                            <a href="/signout">
                                <svg width="24" height="24" viewBox="0 0 30 30" fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd" clip-rule="evenodd" d="M4.5 4.5C4.10218 4.5 3.72064 4.65804 3.43934 4.93934C3.15804 5.22064 3 5.60218 3 6V24C3 24.3978 3.15804 24.7794 3.43934 25.0607C3.72064 25.342 4.10218 25.5 4.5 25.5C4.89782 25.5 5.27936 25.342 5.56066 25.0607C5.84196 24.7794 6 24.3978 6 24V6C6 5.60218 5.84196 5.22064 5.56066 4.93934C5.27936 4.65804 4.89782 4.5 4.5 4.5ZM19.9395 18.4395C19.6663 18.7224 19.5151 19.1013 19.5185 19.4946C19.5219 19.8879 19.6797 20.2641 19.9578 20.5422C20.2359 20.8203 20.6121 20.9781 21.0054 20.9815C21.3987 20.9849 21.7776 20.8337 22.0605 20.5605L26.5605 16.0605C26.8417 15.7792 26.9997 15.3977 26.9997 15C26.9997 14.6023 26.8417 14.2208 26.5605 13.9395L22.0605 9.4395C21.9221 9.29624 21.7566 9.18196 21.5736 9.10335C21.3906 9.02473 21.1938 8.98336 20.9946 8.98162C20.7954 8.97989 20.5979 9.01785 20.4136 9.09327C20.2292 9.16869 20.0617 9.28007 19.9209 9.42091C19.7801 9.56175 19.6687 9.72922 19.5933 9.91357C19.5178 10.0979 19.4799 10.2954 19.4816 10.4946C19.4834 10.6938 19.5247 10.8906 19.6033 11.0736C19.682 11.2566 19.7962 11.4221 19.9395 11.5605L21.879 13.5H10.5C10.1022 13.5 9.72064 13.658 9.43934 13.9393C9.15804 14.2206 9 14.6022 9 15C9 15.3978 9.15804 15.7794 9.43934 16.0607C9.72064 16.342 10.1022 16.5 10.5 16.5H21.879L19.9395 18.4395Z" fill="#374151" />
                                </svg>
                            </a>
                        </div>
                    </div>
                </div>
                <!-- form -->
                <form action="/apprenant/reserver/remove" method="post" class="mx-auto space-y-10 font-Inter w-150 border-3 border-coolGray-100 rounded-lg.5 py-10 px-7.5 flex flex-col">
                    <!-- top text -->
                    <div class="space-y-1.5">
                        <h1 class="text-2xl font-medium text-coolGray-900 flex items-center space-x-2.5">
                            <span>Vouz aves une reservation en cours...</span>
                            <svg class="animate-spin" width="20" height="21" viewBox="0 0 20 21" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <mask id="path-1-inside-1" fill="white">
                                    <path d="M18.6767 10.5C19.4075 10.5 20.009 11.095 19.9126 11.8195C19.7214 13.2555 19.2197 14.6384 18.4362 15.8694C17.4149 17.474 15.9571 18.7541 14.2339 19.5595C12.5107 20.3648 10.5936 20.662 8.70746 20.4161C6.82132 20.1703 5.04441 19.3916 3.58524 18.1714C2.12606 16.9513 1.04513 15.3403 0.469281 13.5274C-0.106567 11.7146 -0.15345 9.77514 0.334133 7.9366C0.821717 6.09806 1.82354 4.43671 3.22206 3.14748C4.29496 2.15843 5.56718 1.41986 6.9467 0.977527C7.64263 0.754383 8.33471 1.24102 8.46408 1.9603C8.59345 2.67958 8.10847 3.35651 7.42396 3.61253C6.53692 3.94431 5.7183 4.44583 5.01588 5.09337C3.98749 6.04139 3.2508 7.26306 2.89226 8.61502C2.53372 9.96698 2.56819 11.3932 2.99164 12.7262C3.41509 14.0593 4.20994 15.2439 5.28294 16.1411C6.35594 17.0384 7.66257 17.611 9.04954 17.7918C10.4365 17.9725 11.8463 17.754 13.1134 17.1618C14.3805 16.5696 15.4525 15.6283 16.2035 14.4484C16.7165 13.6424 17.0652 12.7479 17.2347 11.8162C17.3655 11.0971 17.9459 10.5 18.6767 10.5Z" />
                                </mask>
                                <path d="M18.6767 10.5C19.4075 10.5 20.009 11.095 19.9126 11.8195C19.7214 13.2555 19.2197 14.6384 18.4362 15.8694C17.4149 17.474 15.9571 18.7541 14.2339 19.5595C12.5107 20.3648 10.5936 20.662 8.70746 20.4161C6.82132 20.1703 5.04441 19.3916 3.58524 18.1714C2.12606 16.9513 1.04513 15.3403 0.469281 13.5274C-0.106567 11.7146 -0.15345 9.77514 0.334133 7.9366C0.821717 6.09806 1.82354 4.43671 3.22206 3.14748C4.29496 2.15843 5.56718 1.41986 6.9467 0.977527C7.64263 0.754383 8.33471 1.24102 8.46408 1.9603C8.59345 2.67958 8.10847 3.35651 7.42396 3.61253C6.53692 3.94431 5.7183 4.44583 5.01588 5.09337C3.98749 6.04139 3.2508 7.26306 2.89226 8.61502C2.53372 9.96698 2.56819 11.3932 2.99164 12.7262C3.41509 14.0593 4.20994 15.2439 5.28294 16.1411C6.35594 17.0384 7.66257 17.611 9.04954 17.7918C10.4365 17.9725 11.8463 17.754 13.1134 17.1618C14.3805 16.5696 15.4525 15.6283 16.2035 14.4484C16.7165 13.6424 17.0652 12.7479 17.2347 11.8162C17.3655 11.0971 17.9459 10.5 18.6767 10.5Z" stroke="#111827" stroke-width="8" mask="url(#path-1-inside-1)" />
                            </svg>
                        </h1>
                        <h2 class="text-sm font-normal text-coolGray-700">Veuillez attendre qu'un administrateur accepte votre réservation ou vous pouvez l'annuler.</h2>
                    </div>
                    <!-- btns -->
                    <div class="space-x-2.5 w-full flex">
                        <!-- main btn -->
                        <button class="buttonSec py-3 w-full">Anuller</button>
                    </div>
                </form>
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
                    <img referrerpolicy="no-referrer" src="/img/white 1.png" alt="youcode logo">
                </div>
            </div>
        </div>
    </div>
    <c:if test="${not empty param.ret_code}">
        <script>
            errorHandler(`<c:out value="${param.ret_code}"/>`);
        </script>
    </c:if>
</body>

</html>