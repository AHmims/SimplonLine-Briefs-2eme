<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/style.css">
    <title>Calendrier</title>
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
                    <svg width="35" height="35" viewBox="0 0 35 35" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M19.625 14.616C19.625 14.0292 19.1493 13.5535 18.5625 13.5535H10.0625C9.4757 13.5535 9 14.0292 9 14.616C9 15.2028 9.4757 15.6785 10.0625 15.6785H18.5625C19.1493 15.6785 19.625 15.2028 19.625 14.616Z" fill="#111827" />
                        <path d="M18.2083 18.866C18.2083 18.2792 17.7326 17.8035 17.1458 17.8035H10.0625C9.4757 17.8035 9 18.2792 9 18.866C9 19.4528 9.4757 19.9285 10.0625 19.9285H17.1458C17.7326 19.9285 18.2083 19.4528 18.2083 18.866Z" fill="#111827" />
                        <path d="M18.5625 22.0535C19.1493 22.0535 19.625 22.5292 19.625 23.116C19.625 23.7028 19.1493 24.1785 18.5625 24.1785H10.0625C9.4757 24.1785 9 23.7028 9 23.116C9 22.5292 9.4757 22.0535 10.0625 22.0535H18.5625Z" fill="#111827" />
                        <path fill-rule="evenodd" clip-rule="evenodd" d="M9 31.616H27.4167C29.5683 31.616 31.3125 29.8718 31.3125 27.7202V19.9285C31.3125 19.3417 30.8368 18.866 30.25 18.866H25.6458V7.80637C25.6458 5.78988 23.3666 4.61693 21.7257 5.78898L21.4777 5.96612C20.372 6.7559 18.8743 6.75324 17.7634 5.95976C15.9163 4.64037 13.4171 4.64037 11.5699 5.95976C10.459 6.75324 8.96133 6.7559 7.85564 5.96612L7.60765 5.78898C5.96677 4.61693 3.6875 5.78988 3.6875 7.80637V26.3035C3.6875 29.2375 6.06599 31.616 9 31.616ZM12.8051 7.68894C13.9134 6.89731 15.42 6.89731 16.5283 7.68894C18.3728 9.00647 20.8631 9.01654 22.7128 7.6953L22.9608 7.51817C23.1952 7.35073 23.5208 7.5183 23.5208 7.80637V27.7202C23.5208 28.3578 23.674 28.9597 23.9456 29.491H9C7.23959 29.491 5.8125 28.0639 5.8125 26.3035V7.80637C5.8125 7.5183 6.13811 7.35073 6.37252 7.51817L6.62051 7.6953C8.47024 9.01654 10.9605 9.00647 12.8051 7.68894ZM25.6458 27.7202V20.991H29.1875V27.7202C29.1875 28.6982 28.3947 29.491 27.4167 29.491C26.4387 29.491 25.6458 28.6982 25.6458 27.7202Z" fill="#111827" />
                    </svg>
                </a>
                <a href="/admin/calendrier" class="block">
                    <svg width="35" height="35" viewBox="0 0 35 35" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M11.4792 6.47021C11.4792 5.88341 11.0035 5.40771 10.4167 5.40771C9.82985 5.40771 9.35415 5.88341 9.35415 6.47021V9.04349C7.23896 9.34252 5.56793 11.0155 5.28506 13.1496L5.16244 14.0746C5.14166 14.2314 5.12178 14.3883 5.10281 14.5453C5.0525 14.9618 5.3806 15.3244 5.80009 15.3244H29.1998C29.6193 15.3244 29.9474 14.9618 29.8971 14.5453C29.8781 14.3883 29.8582 14.2314 29.8374 14.0746L29.7148 13.1496C29.432 11.0155 27.761 9.34257 25.6458 9.0435V6.47021C25.6458 5.88341 25.1701 5.40771 24.5833 5.40771C23.9965 5.40771 23.5208 5.88341 23.5208 6.47021V8.8327C19.5149 8.47594 15.4851 8.47593 11.4792 8.83269V6.47021Z" fill="black" />
                        <path d="M30.1715 18.1231C30.1591 17.7456 29.8472 17.4494 29.4695 17.4494H5.53038C5.15274 17.4494 4.84083 17.7456 4.82843 18.1231C4.74428 20.6839 4.89984 23.25 5.29471 25.7877C5.59364 27.7087 7.15432 29.1843 9.08912 29.3751L10.7792 29.5418C15.2489 29.9825 19.751 29.9825 24.2207 29.5418L25.9108 29.3751C27.8456 29.1843 29.4062 27.7087 29.7052 25.7877C30.1 23.25 30.2556 20.6839 30.1715 18.1231Z" fill="black" />
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
                <h1 class="font-Inter font-bold text-5xl text-blueGray-900">Calendrier</h1>
            </div>
            <!-- content -->
            <div class="w-full flex-1 pt-12 space-y-12 overflow-y-auto overflow-hidden flex flex-col">
                <!-- form -->
                <div class="w-full font-Inter space-y-4 px-10">
                    <span class="block font-medium text-xl text-coolGray-500">Gestion d’acces au fabrique</span>
                    <div class="w-full space-x-10 flex flex-row overflow-x-auto p-2">
                        <!-- form -->
                        <form action="/admin/calendrier" method="post" class="space-y-5 font-Inter" style="width: 900px;">
                            <!-- row -->
                            <div class="w-full grid gap-x-6 grid-cols-7">
                                <!-- col -->
                                <div class="w-full flex flex-col space-y-1.5">
                                    <!-- top -->
                                    <div class="flex flex-row items-center space-x-2.5">
                                        <span class="text-base text-coolGray-700 font-medium">Dimanche</span>
                                    </div>
                                    <!-- bot -->
                                    <input name="d-dimanche" type="text" class="h-11 border-2 border-coolGray-100 rounded-lg px-4 text-coolGray-800" placeholder="Nombre">
                                </div>
                                <!-- col -->
                                <div class="w-full flex flex-col space-y-1.5">
                                    <!-- top -->
                                    <div class="flex flex-row items-center space-x-2.5">
                                        <span class="text-base text-coolGray-700 font-medium">Lundi</span>
                                    </div>
                                    <!-- bot -->
                                    <input name="d-lundi" type="text" class="h-11 border-2 border-coolGray-100 rounded-lg px-4 text-coolGray-800" placeholder="Nombre">
                                </div>
                                <!-- col -->
                                <div class="w-full flex flex-col space-y-1.5">
                                    <!-- top -->
                                    <div class="flex flex-row items-center space-x-2.5">
                                        <span class="text-base text-coolGray-700 font-medium">Mardi</span>
                                    </div>
                                    <!-- bot -->
                                    <input name="d-mardi" type="text" class="h-11 border-2 border-coolGray-100 rounded-lg px-4 text-coolGray-800" placeholder="Nombre">
                                </div>
                                <!-- col -->
                                <div class="w-full flex flex-col space-y-1.5">
                                    <!-- top -->
                                    <div class="flex flex-row items-center space-x-2.5">
                                        <span class="text-base text-coolGray-700 font-medium">Mercredi</span>
                                    </div>
                                    <!-- bot -->
                                    <input name="d-mercredi" type="text" class="h-11 border-2 border-coolGray-100 rounded-lg px-4 text-coolGray-800" placeholder="Nombre">
                                </div>
                                <!-- col -->
                                <div class="w-full flex flex-col space-y-1.5">
                                    <!-- top -->
                                    <div class="flex flex-row items-center space-x-2.5">
                                        <span class="text-base text-coolGray-700 font-medium">Jeudi</span>
                                    </div>
                                    <!-- bot -->
                                    <input name="d-jeudi" type="text" class="h-11 border-2 border-coolGray-100 rounded-lg px-4 text-coolGray-800" placeholder="Nombre">
                                </div>
                                <!-- col -->
                                <div class="w-full flex flex-col space-y-1.5">
                                    <!-- top -->
                                    <div class="flex flex-row items-center space-x-2.5">
                                        <span class="text-base text-coolGray-700 font-medium">Vendredi</span>
                                    </div>
                                    <!-- bot -->
                                    <input name="d-vendredi" type="text" class="h-11 border-2 border-coolGray-100 rounded-lg px-4 text-coolGray-800" placeholder="Nombre">
                                </div>
                                <!-- col -->
                                <div class="w-full flex flex-col space-y-1.5">
                                    <!-- top -->
                                    <div class="flex flex-row items-center space-x-2.5">
                                        <span class="text-base text-coolGray-700 font-medium">Samedi</span>
                                    </div>
                                    <!-- bot -->
                                    <input name="d-samedi" type="text" class="h-11 border-2 border-coolGray-100 rounded-lg px-4 text-coolGray-800" placeholder="Nombre">
                                </div>
                            </div>
                            <!-- row -->
                            <div class="w-full space-x-6 flex items-start">
                                <!-- col -->
                                <div class="w-full flex flex-col space-y-1.5">
                                    <!-- top -->
                                    <div class="flex flex-row items-center space-x-2.5">
                                        <span class="text-base text-coolGray-700 font-medium">Date debut</span>
                                    </div>
                                    <!-- bot -->
                                    <input name="d-debut" type="date" class="h-11 border-2 border-coolGray-100 rounded-lg px-4 text-coolGray-800">
                                </div>
                                <!-- col -->
                                <div class="w-full flex flex-col space-y-1.5">
                                    <!-- top -->
                                    <div class="flex flex-row items-center space-x-2.5">
                                        <span class="text-base text-coolGray-700 font-medium">Date fin</span>
                                    </div>
                                    <!-- bot -->
                                    <input name="d-fin" type="date" class="h-11 border-2 border-coolGray-100 rounded-lg px-4 text-coolGray-800">
                                </div>
                            </div>
                            <!-- row -->
                            <div class="w-full space-x-6 flex items-start">
                                <!-- col -->
                                <div class="w-full flex flex-col">
                                    <ul class="text-xs text-coolGray-500 list-disc list-inside">
                                        <li>Les dates de début et de fin permettent de définir un intervalle d'une semaine pour les demandes de réservation.</li>
                                        <li>L'intervalle choisi doit commencer du dimanche au samedi, ce qui couvre précisément 7 jours.</li>
                                    </ul>
                                </div>
                                <!-- col -->
                                <button class="buttonMain h-8.5">Ajouter</button>
                            </div>

                        </form>
                    </div>
                </div>
                <div class="flex flex-col w-full items-end">
                    <!-- filter -->
                    <div class="w-max formInputCombo user-reserv mb-4 mr-1">
                        <select name="" id="" class="rounded-lg">
                            <option value="">Tous</option>
                            <option value="">Week-End</option>
                            <option value="">En-Semaine</option>
                        </select>
                    </div>
                    <!-- table -->
                    <div class="flex-1 w-full bg-white grid grid-cols-reservations relative">
                        <!-- column -->
                        <div class="tableColumn">
                            <!-- table head -->
                            <div class="row head">
                                <span class="">Apprenant</span>
                            </div>
                            <!-- rows -->
                            <!-- row -->
                            <div class="row data">
                                <!-- img -->
                                <div class="imgCont">
                                    <img src="https://pbs.twimg.com/profile_images/1232803900857688065/1QzYpsjB_400x400.jpg" alt="" class="img">
                                </div>
                                <!-- info -->
                                <div class="infos">
                                    <span class="name">Khalid ELFAKKIR</span>
                                    <span class="email">khalid.elfa@gmail.com</span>
                                </div>
                            </div>
                            <!-- row -->
                            <div class="row data">
                                <!-- img -->
                                <div class="imgCont">
                                    <img src="https://pbs.twimg.com/profile_images/1232803900857688065/1QzYpsjB_400x400.jpg" alt="" class="img">
                                </div>
                                <!-- info -->
                                <div class="infos">
                                    <span class="name">Khalid ELFAKKIR</span>
                                    <span class="email">khalid.elfa@gmail.com</span>
                                </div>
                            </div>
                        </div>
                        <!-- column -->
                        <div class="tableColumn">
                            <!-- table head -->
                            <div class="row head">
                                <span class="">nature</span>
                            </div>
                            <!-- rows -->
                            <!-- row -->
                            <div class="row data">
                                <!-- badge-1-A -->
                                <div class="badge-2 badge-2-B">
                                    <svg width="10" height="10" viewBox="0 0 10 10" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <rect width="10" height="10" rx="5" fill="#475569" />
                                    </svg>
                                    <span>En-semaine</span>
                                </div>
                            </div>
                            <!-- row -->
                            <div class="row data">
                                <!-- badge-1-B -->
                                <div class="badge-2 badge-2-A">
                                    <svg width="10" height="11" viewBox="0 0 10 11" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <rect y="0.5" width="10" height="10" rx="5" fill="#57534E" />
                                    </svg>
                                    <span>Week-end</span>
                                </div>
                            </div>
                        </div>
                        <!-- column -->
                        <div class="tableColumn">
                            <!-- table head -->
                            <div class="row head">
                                <span class="">Date reservation</span>
                            </div>
                            <!-- rows -->
                            <!-- row -->
                            <div class="row data">
                                <span class="infos">06/03/2021</span>
                            </div>
                            <!-- row -->
                            <div class="row data">
                                <span class="infos">06/03/2021</span>
                            </div>
                        </div>
                        <!-- column -->
                        <div class="tableColumn">
                            <!-- table head -->
                            <div class="row head">
                                <span class="">emplacement</span>
                            </div>
                            <!-- rows -->
                            <!-- row -->
                            <div class="row data">
                                <span class="infos">Safi-A @ Agora</span>
                            </div>
                            <!-- row -->
                            <div class="row data">
                                <span class="infos">Safi-A @ Agora</span>
                            </div>
                        </div>
                        <!-- column -->
                        <div class="tableColumn">
                            <!-- table head -->
                            <div class="row head">
                                <span class="">Groupe</span>
                            </div>
                            <!-- rows -->
                            <!-- row -->
                            <div class="row data">
                                <span class="infos">Mary Jackson</span>
                            </div>
                            <!-- row -->
                            <div class="row data">
                                <span class="infos">Mary Jackson</span>
                            </div>
                        </div>
                        <!-- column -->
                        <div class="tableColumn">
                            <!-- table head -->
                            <div class="row head">
                                <span class="">Promotion</span>
                            </div>
                            <!-- rows -->
                            <!-- row -->
                            <div class="row data">
                                <span class="infos">2019/2020</span>
                            </div>
                            <!-- row -->
                            <div class="row data">
                                <span class="infos">2019/2020</span>
                            </div>
                        </div>
                        <!-- column -->
                        <div class="tableColumn">
                            <!-- table head -->
                            <div class="row head">
                                <span class="">Date d’envoie</span>
                            </div>
                            <!-- rows -->
                            <!-- row -->
                            <div class="row data">
                                <span class="infos">06/03/2021 04:56</span>
                            </div>
                            <!-- row -->
                            <div class="row data">
                                <span class="infos">06/03/2021 04:56</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>