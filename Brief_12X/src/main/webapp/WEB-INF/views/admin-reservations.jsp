<%@ page import="model.Reservation" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
    <title>List d'apprenants</title>
</head>

<body>
    <div class="bg-white h-screen max-h-screen min-h-screen w-full flex flex-row">
        <!-- sideBar -->
        <div class="h-full w-auto py-5.5 px-4 bg-coolGray-100 border-r-2 border-coolGray-200 flex flex-col justify-between items-center">
            <!-- logo -->
            <svg width="53" height="53" viewBox="0 0 53 53" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path d="M10.1811 15.2727L16.5646 26.8977V32.7273H20.7578V26.8977L27.1413 15.2727H22.4283L18.7379 22.5767H18.5845L14.8942 15.2727H10.1811Z" fill="#0F172A" />
                <path d="M28.9098 32.7273H36.7422C40.603 32.7273 42.8189 30.6648 42.8189 27.8437C42.8189 25.321 40.9865 23.7358 38.8729 23.642V23.4716C40.7905 23.071 42.1371 21.6818 42.1371 19.6875C42.1371 17.054 40.1086 15.2727 36.1882 15.2727H28.9098V32.7273ZM33.1285 29.3267V25.1676H35.8132C37.424 25.1676 38.4126 26.0199 38.4126 27.3579C38.4126 28.5937 37.5604 29.3267 35.7365 29.3267H33.1285ZM33.1285 22.4488V18.6221H35.5319C36.9382 18.6221 37.8331 19.3466 37.8331 20.5057C37.8331 21.7329 36.8444 22.4488 35.4638 22.4488H33.1285Z" fill="#0F172A" />
                <path d="M28.7294 36.2273C28.7294 35.3988 29.401 34.7273 30.2294 34.7273H41.2294C42.0578 34.7273 42.7294 35.3988 42.7294 36.2273C42.7294 37.0557 42.0578 37.7273 41.2294 37.7273H30.2294C29.401 37.7273 28.7294 37.0557 28.7294 36.2273Z" fill="#0F172A" />
            </svg>
            <!-- navlinks -->
            <div class="flex flex-col space-y-10">
                <a href="/admin" class="block">
                    <svg width="35" height="34" viewBox="0 0 35 34" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" clip-rule="evenodd" d="M19.7069 7.84021C18.4736 6.65678 16.5263 6.65678 15.293 7.84021L8.73891 14.1293C8.57833 14.2834 8.47031 14.4841 8.43017 14.703C7.64515 18.9839 7.5872 23.3666 8.25876 27.6668L8.41817 28.6875H12.6348V19.8881C12.6348 19.3013 13.1105 18.8256 13.6973 18.8256H21.3026C21.8894 18.8256 22.3651 19.3013 22.3651 19.8881V28.6875H26.5817L26.7411 27.6668C27.4127 23.3666 27.3547 18.9839 26.5697 14.703C26.5296 14.4841 26.4216 14.2834 26.261 14.1293L19.7069 7.84021ZM13.8218 6.30692C15.8773 4.33454 19.1226 4.33454 21.1781 6.30692L27.7323 12.596C28.2147 13.0589 28.5393 13.662 28.6599 14.3197C29.488 18.8355 29.5491 23.4586 28.8407 27.9947L28.5846 29.6344C28.4787 30.3126 27.8946 30.8125 27.2083 30.8125H21.3026C20.7158 30.8125 20.2401 30.3368 20.2401 29.75V20.9506H14.7598V29.75C14.7598 30.3368 14.2841 30.8125 13.6973 30.8125H7.79162C7.10526 30.8125 6.52119 30.3126 6.41529 29.6344L6.15921 27.9947C5.45081 23.4586 5.51193 18.8355 6.34002 14.3197C6.46062 13.662 6.78516 13.0589 7.26763 12.596L13.8218 6.30692Z" fill="black" />
                    </svg>
                </a>
                <a href="/admin/apprenants" class="block">
                    <svg width="35" height="34" viewBox="0 0 35 34" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M26.9634 14.1429C26.993 14.3282 27.0208 14.5137 27.0468 14.6995C27.0716 14.8764 27.2032 15.0186 27.3749 15.0681C27.8818 15.2141 28.3553 15.4387 28.7815 15.728C28.9947 15.8728 29.3076 15.7125 29.2805 15.4561C29.2222 14.9054 29.1493 14.3558 29.0619 13.8079L28.9711 13.2393C28.6794 11.4117 27.103 10.067 25.2523 10.067H13.4736C13.1824 8.56865 11.8631 7.4375 10.2796 7.4375H7.03325C5.11185 7.4375 3.49344 8.87319 3.26436 10.7809L2.87834 13.9955C2.46798 17.4127 2.57389 20.8721 3.1925 24.2578C3.49782 25.9289 4.89537 27.1815 6.58974 27.3027L8.73459 27.4561C11.8239 27.6771 14.9208 27.7586 18.0157 27.7005C18.2124 27.6968 18.3789 27.5575 18.4305 27.3676C18.5597 26.8913 18.7428 26.4372 18.9729 26.0121C19.0821 25.8103 18.9367 25.5536 18.7073 25.5595C15.4328 25.6447 12.1553 25.5704 8.88623 25.3365L6.74138 25.1831C6.01396 25.131 5.41397 24.5933 5.28289 23.8759C4.70258 20.6998 4.60323 17.4545 4.98818 14.2488L5.3742 11.0342C5.47504 10.1945 6.18746 9.5625 7.03325 9.5625H10.2796C10.903 9.5625 11.4084 10.0679 11.4084 10.6913C11.4084 11.5201 12.0803 12.192 12.9091 12.192H25.2523C26.0587 12.192 26.7456 12.7779 26.8726 13.5742L26.9634 14.1429Z" fill="#111827" />
                        <path d="M26.0001 17C24.4352 17 23.1667 18.2685 23.1667 19.8333C23.1667 21.3981 24.4352 22.6667 26.0001 22.6667C27.5649 22.6667 28.8334 21.3981 28.8334 19.8333C28.8334 18.2685 27.5649 17 26.0001 17Z" fill="#111827" />
                        <path d="M20.3334 29.0417C20.3334 26.6945 22.2362 24.7917 24.5834 24.7917H27.4167C29.7639 24.7917 31.6667 26.6945 31.6667 29.0417C31.6667 29.8241 31.0325 30.4583 30.2501 30.4583H21.7501C20.9677 30.4583 20.3334 29.8241 20.3334 29.0417Z" fill="#111827" />
                    </svg>
                </a>
                <a href="/admin/reservations" class="block">
                    <svg width="35" height="34" viewBox="0 0 35 34" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" clip-rule="evenodd" d="M27.4167 30.4585H9.00002C6.26161 30.4585 4.04169 28.2385 4.04169 25.5001V7.00298C4.04169 5.49062 5.53746 4.53182 6.85363 4.98877C7.04165 5.05405 7.22601 5.14822 7.40182 5.2738L7.6498 5.45093C8.8795 6.32929 10.5426 6.3254 11.7758 5.44457C13.4998 4.21314 15.8336 4.21314 17.5576 5.44457C18.7907 6.3254 20.4539 6.32929 21.6836 5.45093L21.9316 5.2738C23.338 4.26917 25.2917 5.27456 25.2917 7.00298V17.7085H30.25C30.8368 17.7085 31.3125 18.1841 31.3125 18.771V26.5626C31.3125 28.7142 29.5683 30.4585 27.4167 30.4585ZM25.6459 19.8335V26.5626C25.6459 27.5406 26.4387 28.3335 27.4167 28.3335C28.3947 28.3335 29.1875 27.5406 29.1875 26.5626V19.8335H25.6459ZM19.625 13.8126C19.625 13.2258 19.1493 12.7501 18.5625 12.7501H10.0625C9.47572 12.7501 9.00002 13.2258 9.00002 13.8126C9.00002 14.3994 9.47572 14.8751 10.0625 14.8751H18.5625C19.1493 14.8751 19.625 14.3994 19.625 13.8126ZM18.2084 18.0626C18.2084 17.4758 17.7327 17.0001 17.1459 17.0001H10.0625C9.47572 17.0001 9.00002 17.4758 9.00002 18.0626C9.00002 18.6494 9.47572 19.1251 10.0625 19.1251H17.1459C17.7327 19.1251 18.2084 18.6494 18.2084 18.0626ZM18.5625 21.2501C19.1493 21.2501 19.625 21.7258 19.625 22.3126C19.625 22.8994 19.1493 23.3751 18.5625 23.3751H10.0625C9.47572 23.3751 9.00002 22.8994 9.00002 22.3126C9.00002 21.7258 9.47572 21.2501 10.0625 21.2501H18.5625Z" fill="#111827" />
                    </svg>
                </a>
                <a href="/admin/calendrier" class="block">
                    <svg width="35" height="35" viewBox="0 0 35 35" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" clip-rule="evenodd" d="M10.4167 5.40771C11.0035 5.40771 11.4792 5.88341 11.4792 6.47021V8.83269C15.4851 8.47593 19.5149 8.47594 23.5208 8.8327V6.47021C23.5208 5.88341 23.9965 5.40771 24.5833 5.40771C25.1701 5.40771 25.6458 5.88341 25.6458 6.47021V9.0435C27.761 9.34257 29.432 11.0155 29.7148 13.1496L29.8374 14.0746C30.3532 17.9652 30.3086 21.9097 29.7052 25.7877C29.4062 27.7087 27.8456 29.1843 25.9108 29.3751L24.2207 29.5418C19.751 29.9825 15.2489 29.9825 10.7792 29.5418L9.08912 29.3751C7.15432 29.1843 5.59364 27.7087 5.29471 25.7877C4.69127 21.9097 4.64673 17.9652 5.16244 14.0746L5.28506 13.1496C5.56793 11.0155 7.23896 9.34252 9.35415 9.04349V6.47021C9.35415 5.88341 9.82985 5.40771 10.4167 5.40771ZM11.0473 11.0075C15.3386 10.5843 19.6612 10.5843 23.9526 11.0075L25.2353 11.134C26.4632 11.2551 27.4461 12.2056 27.6083 13.4288L27.7309 14.3538C27.7737 14.677 27.8125 15.0005 27.8471 15.3244H7.15274C7.18742 15.0005 7.22618 14.677 7.26902 14.3538L7.39163 13.4288C7.55377 12.2057 8.53668 11.2551 9.76458 11.134L11.0473 11.0075ZM6.98383 17.4494C6.84474 20.1242 6.98177 22.8089 7.39444 25.4609C7.54438 26.4245 8.3272 27.1646 9.29767 27.2603L10.9878 27.427C15.3187 27.8541 19.6812 27.8541 24.0121 27.427L25.7022 27.2603C26.6727 27.1646 27.4555 26.4245 27.6054 25.4609C28.0181 22.8089 28.1551 20.1242 28.0161 17.4494H6.98383Z" fill="black"/>
                    </svg>
                </a>
            </div>
            <!-- out -->
            <a href="#" class="block">
                <svg width="35" height="34" viewBox="0 0 35 34" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M16.4375 26.9166C16.4375 26.3298 16.9132 25.8541 17.5 25.8541H26C26.1956 25.8541 26.3542 25.6955 26.3542 25.4999L26.3542 8.49992C26.3542 8.30432 26.1956 8.14575 26 8.14575L17.5 8.14575C16.9132 8.14575 16.4375 7.67006 16.4375 7.08325C16.4375 6.49645 16.9132 6.02075 17.5 6.02075H26C27.3692 6.02075 28.4792 7.13071 28.4792 8.49992V25.4999C28.4792 26.8691 27.3692 27.9791 26 27.9791H17.5C16.9132 27.9791 16.4375 27.5034 16.4375 26.9166Z" fill="#111827" />
                    <path d="M22.6164 18.5798C22.6164 19.3622 21.9822 19.9965 21.1998 19.9965H14.3204C14.288 20.5 14.2473 21.0031 14.1985 21.5056L14.1564 21.938C14.0881 22.641 13.3416 23.062 12.7046 22.7568C10.1151 21.5158 7.7708 19.8175 5.78455 17.7437L5.74211 17.6994C5.36372 17.3043 5.36372 16.6813 5.74211 16.2862L5.78455 16.2419C7.7708 14.1681 10.1151 12.4698 12.7046 11.2288C13.3416 10.9235 14.0881 11.3445 14.1564 12.0475L14.1985 12.4799C14.2473 12.9824 14.288 13.4856 14.3204 13.9891L21.1998 13.9891C21.9822 13.9891 22.6164 14.6233 22.6164 15.4058V18.5798Z" fill="#111827" />
                </svg>
            </a>
        </div>
        <!-- main -->
        <div class="flex-1 bg-white flex flex-col overflow-hidden">
            <!-- header -->
            <div class="py-7.5 px-10 w-full h-auto border-b-2 border-coolGray-200 bg-white">
                <h1 class="font-Inter font-bold text-5xl text-blueGray-900">Réservations</h1>
            </div>
            <!-- content -->
            <div class="w-full flex-1 pt-12 space-y-12 overflow-y-auto overflow-hidden flex flex-col">
                <!-- cards -->
                <div class="w-full font-Inter space-y-4 px-10">
                    <span class="block font-medium text-xl text-coolGray-500">Demandes de réservations</span>
                    <div class="w-full space-x-10 flex flex-row overflow-x-auto p-2">
                        <c:forEach items="${requestScope._reservations_hold}" var="reservation">
                            <form action="/admin/reservations/validator" method="post" class="card-reservation">
                                <!-- top -->
                                <div class="c-top">
                                    <div class="top">
                                        <div class="user">
                                            <div class="name">
                                                <a href="#">
                                                    <svg width="20" height="20" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                        <path d="M8.33333 3.125C6.60744 3.125 5.20833 4.52411 5.20833 6.25C5.20833 7.97589 6.60744 9.375 8.33333 9.375C10.0592 9.375 11.4583 7.97589 11.4583 6.25C11.4583 4.52411 10.0592 3.125 8.33333 3.125Z" fill="#111827" />
                                                        <path d="M5 11.0417C3.27411 11.0417 1.875 12.4408 1.875 14.1667V15.1569C1.875 15.7846 2.3299 16.3198 2.94939 16.4209C4.79167 16.7217 6.65285 16.8671 8.51339 16.8571C8.64348 16.8564 8.72215 16.7125 8.65852 16.599C8.18606 15.7565 7.91667 14.7847 7.91667 13.75C7.91667 13.0941 8.02492 12.4635 8.22453 11.875C8.26205 11.7644 8.1818 11.6469 8.06514 11.6417C7.52194 11.6176 6.98121 11.5201 6.45799 11.3492L5.73673 11.1137C5.59058 11.066 5.4378 11.0417 5.28406 11.0417H5Z" fill="#111827" />
                                                        <path d="M14.375 12.5C14.375 12.1548 14.0952 11.875 13.75 11.875C13.4048 11.875 13.125 12.1548 13.125 12.5V13.9773C13.125 14.1772 13.2207 14.3651 13.3824 14.4827L14.2157 15.0888C14.4949 15.2918 14.8858 15.2301 15.0888 14.9509C15.2918 14.6718 15.2301 14.2809 14.9509 14.0779L14.375 13.659V12.5Z" fill="#111827" />
                                                        <path fill-rule="evenodd" clip-rule="evenodd" d="M13.75 18.3333C16.2813 18.3333 18.3333 16.2813 18.3333 13.75C18.3333 11.2187 16.2813 9.16667 13.75 9.16667C11.2187 9.16667 9.16667 11.2187 9.16667 13.75C9.16667 16.2813 11.2187 18.3333 13.75 18.3333ZM13.75 17.0833C15.5909 17.0833 17.0833 15.5909 17.0833 13.75C17.0833 11.9091 15.5909 10.4167 13.75 10.4167C11.909 10.4167 10.4167 11.9091 10.4167 13.75C10.4167 15.5909 11.909 17.0833 13.75 17.0833Z" fill="#111827" />
                                                    </svg>
                                                </a>
                                                <span><c:out value="${reservation.reservation.apprenant.nomUtilisateur} ${reservation.reservation.apprenant.prenomUtilisateur}"/></span>
                                            </div>
                                            <span class="email"><c:out value="${reservation.reservation.apprenant.authentification.emailAuthentification}"/></span>
                                        </div>
                                        <div class="imgCont">
                                            <img src="<c:out value="${reservation.reservation.apprenant.imgApprenant}"/>" alt="" class="img">
                                        </div>
                                    </div>
                                    <div class="bot">
                                        <div class="top">
                                            <!-- date -->
                                            <div class="date">
                                                <input type="date" value="<fmt:formatDate pattern = "YYYY-MM-dd" value = "${reservation.reservation.dateReservation}" />" />
                                            </div>
                                            <!-- loc -->
                                            <div class="loc">
                                                <svg width="18" height="18" viewBox="0 0 18 18" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                    <path d="M6.5625 7.5C6.5625 6.15381 7.65381 5.0625 9 5.0625C10.3462 5.0625 11.4375 6.15381 11.4375 7.5C11.4375 8.84619 10.3462 9.9375 9 9.9375C7.65381 9.9375 6.5625 8.84619 6.5625 7.5Z" fill="#4B5563" />
                                                    <path fill-rule="evenodd" clip-rule="evenodd" d="M2.83016 6.65804C3.08789 3.53134 5.70073 1.125 8.83804 1.125H9.162C12.2993 1.125 14.9122 3.53134 15.1699 6.65804C15.3086 8.34149 14.7886 10.0131 13.7194 11.3207L10.1246 15.7171C9.54337 16.4279 8.45667 16.4279 7.87544 15.7171L4.28064 11.3207C3.2114 10.0131 2.69139 8.34149 2.83016 6.65804ZM9 3.9375C7.03249 3.9375 5.4375 5.53249 5.4375 7.5C5.4375 9.46751 7.03249 11.0625 9 11.0625C10.9675 11.0625 12.5625 9.46751 12.5625 7.5C12.5625 5.53249 10.9675 3.9375 9 3.9375Z" fill="#4B5563" />
                                                </svg>
                                                <span><c:out value="${reservation.reservation.emplacement.local.villeLocal}-${reservation.reservation.emplacement.local.libelleLocal}"/></span>
                                            </div>
                                            <!-- emplace -->
                                            <div class="empla">
                                                <svg width="18" height="18" viewBox="0 0 18 18" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                    <path fill-rule="evenodd" clip-rule="evenodd" d="M9.5625 1.5C9.5625 1.18934 9.31066 0.9375 9 0.9375C8.68934 0.9375 8.4375 1.18934 8.4375 1.5V2.83772C5.46911 3.10522 3.10522 5.46911 2.83772 8.4375H1.5C1.18934 8.4375 0.9375 8.68934 0.9375 9C0.9375 9.31066 1.18934 9.5625 1.5 9.5625H2.83772C3.10522 12.5309 5.46911 14.8948 8.4375 15.1623V16.5C8.4375 16.8107 8.68934 17.0625 9 17.0625C9.31066 17.0625 9.5625 16.8107 9.5625 16.5V15.1623C12.5309 14.8948 14.8948 12.5309 15.1623 9.5625H16.5C16.8107 9.5625 17.0625 9.31066 17.0625 9C17.0625 8.68934 16.8107 8.4375 16.5 8.4375H15.1623C14.8948 5.46911 12.5309 3.10522 9.5625 2.83772V1.5ZM6.1875 9C6.1875 7.4467 7.4467 6.1875 9 6.1875C10.5533 6.1875 11.8125 7.4467 11.8125 9C11.8125 10.5533 10.5533 11.8125 9 11.8125C7.4467 11.8125 6.1875 10.5533 6.1875 9Z" fill="#4B5563" />
                                                </svg>
                                                <span><c:out value="${reservation.reservation.emplacement.libelleEmplacement}"/></span>
                                            </div>
                                        </div>
                                        <div class="bot">
                                            <!-- badge -->
                                            <c:choose>
                                                <c:when test="${reservation.nature == 1}">
                                                    <div class="badge-2 badge-2-B">
                                                        <svg width="10" height="10" viewBox="0 0 10 10" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                            <rect width="10" height="10" rx="5" fill="#475569" />
                                                        </svg>
                                                        <span>En-semaine</span>
                                                    </div>
                                                </c:when>
                                                <c:otherwise>
                                                    <div class="badge-2 badge-2-A">
                                                        <svg width="10" height="10" viewBox="0 0 10 10" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                            <rect width="10" height="10" rx="5" fill="#57534E" />
                                                        </svg>
                                                        <span>Week-end</span>
                                                    </div>
                                                </c:otherwise>
                                            </c:choose>
                                            <div class="badge-2 badge-X">
                                                <svg width="15" height="15" viewBox="0 0 15 15" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                    <path d="M4.72164 2.6575C4.93719 2.67324 5.11404 2.83432 5.14979 3.04746L6.27501 9.75524L7.67438 4.87091C7.732 4.66977 7.91595 4.53118 8.12517 4.53126C8.3344 4.53134 8.51824 4.67006 8.57572 4.87124L9.5246 8.19235L10.069 7.26306C10.1532 7.11948 10.3071 7.03126 10.4735 7.03126H11.634C11.8331 6.39734 12.4254 5.93751 13.125 5.93751C13.9879 5.93751 14.6875 6.63707 14.6875 7.50001C14.6875 8.36295 13.9879 9.06251 13.125 9.06251C12.4254 9.06251 11.8331 8.60268 11.634 7.96876H10.7421L9.77945 9.61196C9.6846 9.77387 9.50233 9.8636 9.31617 9.84005C9.13001 9.81651 8.97584 9.68421 8.92429 9.50379L8.12438 6.70412L6.60592 12.0041C6.5456 12.2147 6.34754 12.3554 6.12887 12.343C5.91021 12.3307 5.72925 12.1686 5.69301 11.9526L4.54336 5.09912L3.72264 7.64389C3.66019 7.83752 3.47997 7.96876 3.27652 7.96876H1.25C0.991117 7.96876 0.78125 7.75889 0.78125 7.50001C0.78125 7.24113 0.991117 7.03126 1.25 7.03126H2.93517L4.24138 2.98113C4.30772 2.77544 4.50609 2.64177 4.72164 2.6575Z" fill="#3B82F6" />
                                                </svg>
                                                <span><c:out value="${reservation.weekCounter}"/></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- bot -->
                                <div class="c-bot">
                                    <div class="btnsCont">
                                        <button class="buttonSec">
                                            <span>Refuser</span>
                                        </button>
                                        <button class="buttonMain">
                                            <span>Verifier</span>
                                        </button>
                                    </div>
                                </div>
                                <input type="hidden" name="_action" class="card_action" value="ok"/>
                                <input type="hidden" name="_id" class="card_id" value="<c:out value="${reservation.reservation.idReservation}"/>"/>
                            </form>
                        </c:forEach>
                    </div>
                </div>
                <!-- table -->
                <div class="flex-1 bg-white grid grid-cols-reservations relative">
                    <!-- column -->
                    <div class="tableColumn">
                        <!-- table head -->
                        <div class="row head">
                            <span class="">Apprenant</span>
                        </div>
                        <!-- rows -->
                        <c:forEach items="${requestScope._reservations_all}" var="reservation">
                            <div class="row data">
                                <!-- img -->
                                <div class="imgCont">
                                    <img src="<c:out value="${reservation.apprenant.imgApprenant}"/>" alt="" class="img">
                                </div>
                                <!-- info -->
                                <div class="infos">
                                    <span class="name"><c:out value="${reservation.apprenant.nomUtilisateur} ${reservation.apprenant.prenomUtilisateur}"/></span>
                                    <span class="email"><c:out value="${reservation.apprenant.authentification.emailAuthentification}"/></span>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <!-- column -->
                    <div class="tableColumn">
                        <!-- table head -->
                        <div class="row head">
                            <span class="">nature</span>
                        </div>
                        <!-- rows -->
                        <% for (Reservation reservation: (ArrayList<Reservation>) request.getAttribute("_reservations_all")) { %>
                            <%
                                Calendar cal_res = Calendar.getInstance();
                                cal_res.setTime(reservation.getDateReservation());
                                int day = cal_res.get(Calendar.DAY_OF_WEEK);
                                int nature = day >= Calendar.MONDAY && day <= Calendar.FRIDAY ? 1 : 2;
                            %>
                            <div class="row data">
                                <!-- badge-1-A -->
                                <% if(nature == 1){ %>
                                <div class="badge-2 badge-2-B">
                                    <svg width="10" height="10" viewBox="0 0 10 10" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <rect width="10" height="10" rx="5" fill="#475569" />
                                    </svg>
                                    <span>En-semaine</span>
                                </div>
                                <% }else { %>
                                    <div class="badge-2 badge-2-A">
                                        <svg width="10" height="11" viewBox="0 0 10 11" fill="none" xmlns="http://www.w3.org/2000/svg">
                                            <rect y="0.5" width="10" height="10" rx="5" fill="#57534E" />
                                        </svg>
                                        <span>Week-end</span>
                                    </div>
                                <% } %>
                            </div>
                        <% } %>
                    </div>
                    <!-- column -->
                    <div class="tableColumn">
                        <!-- table head -->
                        <div class="row head">
                            <span class="">Date reservation</span>
                        </div>
                        <!-- rows -->
                        <!-- row -->
                        <c:forEach items="${requestScope._reservations_all}" var="reservation">
                            <div class="row data">
                                <span class="infos"><fmt:formatDate pattern = "yyyy-MM-dd" value = "${reservation.dateReservation}" /></span>
                            </div>
                        </c:forEach>
                    </div>
                    <!-- column -->
                    <div class="tableColumn">
                        <!-- table head -->
                        <div class="row head">
                            <span class="">emplacement</span>
                        </div>
                        <!-- rows -->
                        <c:forEach items="${requestScope._reservations_all}" var="reservation">
                            <div class="row data">
                                <span class="infos"><c:out value="${reservation.emplacement.local.villeLocal}-${reservation.emplacement.local.libelleLocal} @ ${reservation.emplacement.libelleEmplacement}" /></span>
                            </div>
                        </c:forEach>
                    </div>
                    <!-- column -->
                    <div class="tableColumn">
                        <!-- table head -->
                        <div class="row head">
                            <span class="">Groupe</span>
                        </div>
                        <!-- rows -->
                        <c:forEach items="${requestScope._reservations_all}" var="reservation">
                            <div class="row data">
                                <span class="infos"><c:out value="${reservation.apprenant.groupe != null ? reservation.apprenant.groupe.libelleGroupe : 'X'}"/></span>
                            </div>
                        </c:forEach>
                    </div>
                    <!-- column -->
                    <div class="tableColumn">
                        <!-- table head -->
                        <div class="row head">
                            <span class="">Promotion</span>
                        </div>
                        <!-- rows -->
                        <c:forEach items="${requestScope._reservations_all}" var="reservation">
                            <div class="row data">
                                <span class="infos"><c:out value="${reservation.apprenant.groupe.promotion != null ? reservation.apprenant.groupe.promotion.libellePromotion : 'X'}"/></span>
                            </div>
                        </c:forEach>
                    </div>
                    <!-- column -->
                    <div class="tableColumn">
                        <!-- table head -->
                        <div class="row head">
                            <span class="">Date d’envoie</span>
                        </div>
                        <!-- rows -->
                        <c:forEach items="${requestScope._reservations_all}" var="reservation">
                            <div class="row data">
                                <span class="infos"><fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${reservation.dateCreation}" /></span>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="/js/admin.reservations.js"></script>
    <c:if test="${not empty param.ret_code}">
        <script>
            errorHandler(`<c:out value="${param.ret_code}"/>`);
        </script>
    </c:if>
</body>

</html>