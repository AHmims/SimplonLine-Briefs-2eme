<%@ page import="model.Administrateur" %>
<%@ page import="model.Apprenant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/style.css">
    <title>Acceuil</title>
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
                        <path d="M20.0443 5.85953C18.6526 4.42215 16.3473 4.42215 14.9555 5.85952L8.15771 12.8801C7.7673 13.2833 7.50495 13.7931 7.40372 14.3451C6.57815 18.8472 6.51721 23.4563 7.22346 27.9787L7.47351 29.5798C7.55249 30.0855 7.98806 30.4584 8.49991 30.4584H13.2499C13.6411 30.4584 13.9583 30.1412 13.9583 29.75V19.8334H21.0416V29.75C21.0416 30.1412 21.3587 30.4584 21.7499 30.4584H26.4999C27.0117 30.4584 27.4473 30.0855 27.5263 29.5798L27.7763 27.9787C28.4826 23.4563 28.4217 18.8472 27.5961 14.3451C27.4949 13.7931 27.2325 13.2833 26.8421 12.8801L20.0443 5.85953Z" fill="#111827" />
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
                        <path d="M19.625 13.8125C19.625 13.2257 19.1493 12.75 18.5625 12.75H10.0625C9.4757 12.75 9 13.2257 9 13.8125C9 14.3993 9.4757 14.875 10.0625 14.875H18.5625C19.1493 14.875 19.625 14.3993 19.625 13.8125Z" fill="#111827" />
                        <path d="M18.2083 18.0625C18.2083 17.4757 17.7326 17 17.1458 17H10.0625C9.4757 17 9 17.4757 9 18.0625C9 18.6493 9.4757 19.125 10.0625 19.125H17.1458C17.7326 19.125 18.2083 18.6493 18.2083 18.0625Z" fill="#111827" />
                        <path d="M18.5625 21.25C19.1493 21.25 19.625 21.7257 19.625 22.3125C19.625 22.8993 19.1493 23.375 18.5625 23.375H10.0625C9.4757 23.375 9 22.8993 9 22.3125C9 21.7257 9.4757 21.25 10.0625 21.25H18.5625Z" fill="#111827" />
                        <path fill-rule="evenodd" clip-rule="evenodd" d="M9 30.8125H27.4167C29.5683 30.8125 31.3125 29.0683 31.3125 26.9167V19.125C31.3125 18.5382 30.8368 18.0625 30.25 18.0625H25.6458V7.0029C25.6458 4.98641 23.3666 3.81346 21.7257 4.98552L21.4777 5.16265C20.372 5.95243 18.8743 5.94978 17.7634 5.15629C15.9163 3.8369 13.4171 3.8369 11.5699 5.15629C10.459 5.94978 8.96133 5.95243 7.85564 5.16265L7.60765 4.98552C5.96677 3.81346 3.6875 4.98641 3.6875 7.0029V25.5C3.6875 28.4341 6.06599 30.8125 9 30.8125ZM12.8051 6.88547C13.9134 6.09384 15.42 6.09384 16.5283 6.88547C18.3728 8.203 20.8631 8.21307 22.7128 6.89183L22.9608 6.7147C23.1952 6.54726 23.5208 6.71483 23.5208 7.0029V26.9167C23.5208 27.5544 23.674 28.1562 23.9456 28.6875H9C7.23959 28.6875 5.8125 27.2605 5.8125 25.5V7.0029C5.8125 6.71483 6.13811 6.54726 6.37252 6.7147L6.62051 6.89183C8.47024 8.21307 10.9605 8.203 12.8051 6.88547ZM25.6458 26.9167V20.1875H29.1875V26.9167C29.1875 27.8947 28.3947 28.6875 27.4167 28.6875C26.4387 28.6875 25.6458 27.8947 25.6458 26.9167Z" fill="#111827" />
                    </svg>
                </a>
                <a href="/admin/calendrier" class="block">
                    <svg width="35" height="35" viewBox="0 0 35 35" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" clip-rule="evenodd" d="M10.4167 5.40771C11.0035 5.40771 11.4792 5.88341 11.4792 6.47021V8.83269C15.4851 8.47593 19.5149 8.47594 23.5208 8.8327V6.47021C23.5208 5.88341 23.9965 5.40771 24.5833 5.40771C25.1701 5.40771 25.6458 5.88341 25.6458 6.47021V9.0435C27.761 9.34257 29.432 11.0155 29.7148 13.1496L29.8374 14.0746C30.3532 17.9652 30.3086 21.9097 29.7052 25.7877C29.4062 27.7087 27.8456 29.1843 25.9108 29.3751L24.2207 29.5418C19.751 29.9825 15.2489 29.9825 10.7792 29.5418L9.08912 29.3751C7.15432 29.1843 5.59364 27.7087 5.29471 25.7877C4.69127 21.9097 4.64673 17.9652 5.16244 14.0746L5.28506 13.1496C5.56793 11.0155 7.23896 9.34252 9.35415 9.04349V6.47021C9.35415 5.88341 9.82985 5.40771 10.4167 5.40771ZM11.0473 11.0075C15.3386 10.5843 19.6612 10.5843 23.9526 11.0075L25.2353 11.134C26.4632 11.2551 27.4461 12.2056 27.6083 13.4288L27.7309 14.3538C27.7737 14.677 27.8125 15.0005 27.8471 15.3244H7.15274C7.18742 15.0005 7.22618 14.677 7.26902 14.3538L7.39163 13.4288C7.55377 12.2057 8.53668 11.2551 9.76458 11.134L11.0473 11.0075ZM6.98383 17.4494C6.84474 20.1242 6.98177 22.8089 7.39444 25.4609C7.54438 26.4245 8.3272 27.1646 9.29767 27.2603L10.9878 27.427C15.3187 27.8541 19.6812 27.8541 24.0121 27.427L25.7022 27.2603C26.6727 27.1646 27.4555 26.4245 27.6054 25.4609C28.0181 22.8089 28.1551 20.1242 28.0161 17.4494H6.98383Z" fill="black"/>
                    </svg>
                </a>
            </div>
            <!-- out -->
            <a href="/signout" class="block">
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
                <h1 class="font-Inter font-bold text-5xl text-blueGray-900">Accueil</h1>
            </div>
            <!-- content -->
            <div class="w-full flex-1 pt-12 space-y-12 overflow-y-auto overflow-hidden flex flex-col">
                <!-- cards -->
                <div class="w-full font-Inter space-y-4 px-10">
                    <span class="block font-medium text-xl text-coolGray-500">Overview</span>
                    <div class="w-full space-x-10 flex flex-row overflow-x-auto p-2">
                        <!-- card -->
                        <div class="card-home">
                            <!-- top -->
                            <div class="top">
                                <!-- left -->
                                <div class="left">
                                    <span class="main"><c:out value="${requestScope._app_count_active}"/></span>
                                    <span class="desc">Apprenants inscrits</span>
                                </div>
                                <!-- right -->
                                <div class="right">
                                    <svg width="34" height="34" viewBox="0 0 34 34" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" clip-rule="evenodd" d="M10.9792 10.6251C10.9792 7.29987 13.6748 4.60425 17 4.60425C20.3252 4.60425 23.0208 7.29987 23.0208 10.6251C23.0208 13.9503 20.3252 16.6459 17 16.6459C13.6748 16.6459 10.9792 13.9503 10.9792 10.6251ZM17 6.72925C14.8484 6.72925 13.1042 8.47347 13.1042 10.6251C13.1042 12.7767 14.8484 14.5209 17 14.5209C19.1516 14.5209 20.8958 12.7767 20.8958 10.6251C20.8958 8.47347 19.1516 6.72925 17 6.72925Z" fill="#6B7280" />
                                        <path fill-rule="evenodd" clip-rule="evenodd" d="M11.3333 20.8959C9.57294 20.8959 8.14584 22.323 8.14584 24.0834V25.7668C8.14584 25.7924 8.16442 25.8143 8.18972 25.8184C14.0246 26.7711 19.9754 26.7711 25.8103 25.8184C25.8356 25.8143 25.8542 25.7924 25.8542 25.7668V24.0834C25.8542 22.323 24.4271 20.8959 22.6667 20.8959H22.1838C22.1464 20.8959 22.1093 20.9018 22.0738 20.9134L20.8477 21.3138C18.3475 22.1302 15.6525 22.1302 13.1523 21.3138L11.9262 20.9134C11.8907 20.9018 11.8536 20.8959 11.8162 20.8959H11.3333ZM6.02084 24.0834C6.02084 21.1494 8.39933 18.7709 11.3333 18.7709H11.8162C12.0776 18.7709 12.3373 18.8122 12.5858 18.8934L13.8119 19.2937C15.8835 19.9702 18.1165 19.9702 20.1881 19.2937L21.4142 18.8934C21.6627 18.8122 21.9224 18.7709 22.1838 18.7709H22.6667C25.6007 18.7709 27.9792 21.1494 27.9792 24.0834V25.7668C27.9792 26.8339 27.2058 27.7437 26.1527 27.9157C20.091 28.9053 13.909 28.9053 7.84731 27.9157C6.79418 27.7437 6.02084 26.8339 6.02084 25.7668V24.0834Z" fill="#6B7280" />
                                    </svg>
                                </div>
                            </div>
                            <!-- bot -->
                            <div class="bot">
                                <a href="/admin/apprenants">
                                    <span>Voir tous</span>
                                    <svg width="14" height="15" viewBox="0 0 14 15" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path d="M7.8573 5.47611C7.68644 5.30525 7.68644 5.02824 7.8573 4.85739C8.02815 4.68653 8.30516 4.68653 8.47602 4.85739L10.8093 7.19072C10.9802 7.36158 10.9802 7.63859 10.8093 7.80944L8.47602 10.1428C8.30516 10.3136 8.02815 10.3136 7.8573 10.1428C7.68644 9.97192 7.68644 9.69491 7.8573 9.52406L9.44377 7.93758H3.79166C3.55003 7.93758 3.35416 7.74171 3.35416 7.50008C3.35416 7.25846 3.55003 7.06258 3.79166 7.06258H9.44377L7.8573 5.47611Z" fill="#334155" />
                                    </svg>
                                </a>
                            </div>
                        </div>
                        <!-- card -->
                        <div class="card-home">
                            <!-- top -->
                            <div class="top">
                                <!-- left -->
                                <div class="left">
                                    <span class="main"><c:out value="${requestScope._app_count_inactive}"/></span>
                                    <span class="desc">Apprenants en attente de vérification</span>
                                </div>
                                <!-- right -->
                                <div class="right">
                                    <svg width="34" height="34" viewBox="0 0 34 34" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" clip-rule="evenodd" d="M14.1667 4.60425C10.8415 4.60425 8.14583 7.29987 8.14583 10.6251C8.14583 13.9503 10.8415 16.6459 14.1667 16.6459C17.4919 16.6459 20.1875 13.9503 20.1875 10.6251C20.1875 7.29987 17.4919 4.60425 14.1667 4.60425ZM10.2708 10.6251C10.2708 8.47347 12.0151 6.72925 14.1667 6.72925C16.3183 6.72925 18.0625 8.47347 18.0625 10.6251C18.0625 12.7767 16.3183 14.5209 14.1667 14.5209C12.0151 14.5209 10.2708 12.7767 10.2708 10.6251Z" fill="#6B7280" />
                                        <path d="M5.3125 24.0834C5.3125 22.323 6.73959 20.8959 8.5 20.8959H8.9829C9.02024 20.8959 9.05734 20.9018 9.09283 20.9134L10.319 21.3138C11.2816 21.6281 12.2732 21.8214 13.2714 21.8937C13.4815 21.9089 13.6658 21.7614 13.7133 21.5562C13.8203 21.0933 13.9598 20.6429 14.1291 20.2074C14.2039 20.0152 14.0634 19.8026 13.8572 19.7964C12.8846 19.7671 11.9151 19.5995 10.9786 19.2937L9.75244 18.8934C9.50398 18.8122 9.24426 18.7709 8.9829 18.7709H8.5C5.56599 18.7709 3.1875 21.1494 3.1875 24.0834V25.7668C3.1875 26.8339 3.96084 27.7437 5.01397 27.9157C8.07134 28.4148 11.1593 28.6622 14.2471 28.6579C14.4625 28.6576 14.5979 28.4248 14.5014 28.2321C14.2934 27.8164 14.1137 27.3841 13.9649 26.9376C13.8853 26.6988 13.6664 26.5312 13.4147 26.5277C10.7192 26.4907 8.02564 26.2542 5.35637 25.8184C5.33108 25.8143 5.3125 25.7924 5.3125 25.7668V24.0834Z" fill="#6B7280" />
                                        <path d="M24.4375 21.675C24.4375 21.0882 23.9618 20.6125 23.375 20.6125C22.7882 20.6125 22.3125 21.0882 22.3125 21.675V24.1864C22.3125 24.5263 22.4752 24.8457 22.7501 25.0457L24.1667 26.076C24.6413 26.4211 25.3058 26.3162 25.6509 25.8416C25.9961 25.3671 25.8912 24.7025 25.4166 24.3574L24.4375 23.6453V21.675Z" fill="#6B7280" />
                                        <path fill-rule="evenodd" clip-rule="evenodd" d="M23.375 31.5917C27.6782 31.5917 31.1667 28.1032 31.1667 23.8C31.1667 19.4968 27.6782 16.0084 23.375 16.0084C19.0718 16.0084 15.5833 19.4968 15.5833 23.8C15.5833 28.1032 19.0718 31.5917 23.375 31.5917ZM23.375 29.4667C26.5046 29.4667 29.0417 26.9296 29.0417 23.8C29.0417 20.6704 26.5046 18.1334 23.375 18.1334C20.2454 18.1334 17.7083 20.6704 17.7083 23.8C17.7083 26.9296 20.2454 29.4667 23.375 29.4667Z" fill="#6B7280" />
                                    </svg>
                                </div>
                            </div>
                            <!-- bot -->
                            <div class="bot">
                                <a href="/admin/apprenants">
                                    <span>Voir tous</span>
                                    <svg width="14" height="15" viewBox="0 0 14 15" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path d="M7.8573 5.47611C7.68644 5.30525 7.68644 5.02824 7.8573 4.85739C8.02815 4.68653 8.30516 4.68653 8.47602 4.85739L10.8093 7.19072C10.9802 7.36158 10.9802 7.63859 10.8093 7.80944L8.47602 10.1428C8.30516 10.3136 8.02815 10.3136 7.8573 10.1428C7.68644 9.97192 7.68644 9.69491 7.8573 9.52406L9.44377 7.93758H3.79166C3.55003 7.93758 3.35416 7.74171 3.35416 7.50008C3.35416 7.25846 3.55003 7.06258 3.79166 7.06258H9.44377L7.8573 5.47611Z" fill="#334155" />
                                    </svg>
                                </a>
                            </div>
                        </div>
                        <!-- card -->
                        <div class="card-home">
                            <!-- top -->
                            <div class="top">
                                <!-- left -->
                                <div class="left">
                                    <span class="main"><c:out value="${requestScope._res_count_all}"/></span>
                                    <span class="desc">Réservations cette semaine</span>
                                </div>
                                <!-- right -->
                                <div class="right">
                                    <svg width="34" height="34" viewBox="0 0 34 34" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path d="M19.125 13.8125C19.125 13.2257 18.6493 12.75 18.0625 12.75H9.5625C8.9757 12.75 8.5 13.2257 8.5 13.8125C8.5 14.3993 8.9757 14.875 9.5625 14.875H18.0625C18.6493 14.875 19.125 14.3993 19.125 13.8125Z" fill="#6B7280" />
                                        <path d="M17.7083 18.0625C17.7083 17.4757 17.2326 17 16.6458 17H9.5625C8.9757 17 8.5 17.4757 8.5 18.0625C8.5 18.6493 8.9757 19.125 9.5625 19.125H16.6458C17.2326 19.125 17.7083 18.6493 17.7083 18.0625Z" fill="#6B7280" />
                                        <path d="M18.0625 21.25C18.6493 21.25 19.125 21.7257 19.125 22.3125C19.125 22.8993 18.6493 23.375 18.0625 23.375H9.5625C8.9757 23.375 8.5 22.8993 8.5 22.3125C8.5 21.7257 8.9757 21.25 9.5625 21.25H18.0625Z" fill="#6B7280" />
                                        <path fill-rule="evenodd" clip-rule="evenodd" d="M8.5 30.8125H26.9167C29.0683 30.8125 30.8125 29.0683 30.8125 26.9167V19.125C30.8125 18.5382 30.3368 18.0625 29.75 18.0625H25.1458V7.0029C25.1458 4.98641 22.8666 3.81346 21.2257 4.98552L20.9777 5.16265C19.872 5.95243 18.3743 5.94978 17.2634 5.15629C15.4163 3.8369 12.9171 3.8369 11.0699 5.15629C9.95905 5.94978 8.46133 5.95243 7.35564 5.16265L7.10765 4.98552C5.46677 3.81346 3.1875 4.98641 3.1875 7.0029V25.5C3.1875 28.4341 5.56599 30.8125 8.5 30.8125ZM12.3051 6.88547C13.4134 6.09384 14.92 6.09384 16.0283 6.88547C17.8728 8.203 20.3631 8.21307 22.2128 6.89183L22.4608 6.7147C22.6952 6.54726 23.0208 6.71483 23.0208 7.0029V26.9167C23.0208 27.5544 23.174 28.1562 23.4456 28.6875H8.5C6.73959 28.6875 5.3125 27.2605 5.3125 25.5V7.0029C5.3125 6.71483 5.63811 6.54726 5.87252 6.7147L6.12051 6.89183C7.97024 8.21307 10.4605 8.203 12.3051 6.88547ZM25.1458 26.9167V20.1875H28.6875V26.9167C28.6875 27.8947 27.8947 28.6875 26.9167 28.6875C25.9387 28.6875 25.1458 27.8947 25.1458 26.9167Z" fill="#6B7280" />
                                    </svg>
                                </div>
                            </div>
                            <!-- bot -->
                            <div class="bot">
                                <a href="/admin/reservations">
                                    <span>Voir tous</span>
                                    <svg width="14" height="15" viewBox="0 0 14 15" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path d="M7.8573 5.47611C7.68644 5.30525 7.68644 5.02824 7.8573 4.85739C8.02815 4.68653 8.30516 4.68653 8.47602 4.85739L10.8093 7.19072C10.9802 7.36158 10.9802 7.63859 10.8093 7.80944L8.47602 10.1428C8.30516 10.3136 8.02815 10.3136 7.8573 10.1428C7.68644 9.97192 7.68644 9.69491 7.8573 9.52406L9.44377 7.93758H3.79166C3.55003 7.93758 3.35416 7.74171 3.35416 7.50008C3.35416 7.25846 3.55003 7.06258 3.79166 7.06258H9.44377L7.8573 5.47611Z" fill="#334155" />
                                    </svg>
                                </a>
                            </div>
                        </div>
                        <!-- card -->
                        <div class="card-home">
                            <!-- top -->
                            <div class="top">
                                <!-- left -->
                                <div class="left">
                                    <span class="main"><c:out value="${requestScope._res_count_onhold}"/></span>
                                    <span class="desc">Réservations en attente de vérification</span>
                                </div>
                                <!-- right -->
                                <div class="right">
                                    <svg width="34" height="34" viewBox="0 0 34 34" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path d="M11.6875 11.3334C11.6875 10.7466 12.1632 10.2709 12.75 10.2709H22.6667C23.2535 10.2709 23.7292 10.7466 23.7292 11.3334C23.7292 11.9202 23.2535 12.3959 22.6667 12.3959H12.75C12.1632 12.3959 11.6875 11.9202 11.6875 11.3334Z" fill="#6B7280" />
                                        <path d="M12.75 14.5209C12.1632 14.5209 11.6875 14.9966 11.6875 15.5834C11.6875 16.1702 12.1632 16.6459 12.75 16.6459H19.8333C20.4201 16.6459 20.8958 16.1702 20.8958 15.5834C20.8958 14.9966 20.4201 14.5209 19.8333 14.5209H12.75Z" fill="#6B7280" />
                                        <path fill-rule="evenodd" clip-rule="evenodd" d="M12.0417 4.60425C8.32525 4.60425 5.3125 7.617 5.3125 11.3334V25.5001C5.3125 28.4341 7.69099 30.8126 10.625 30.8126H26.2083C27.5775 30.8126 28.6875 29.7026 28.6875 28.3334V7.08341C28.6875 5.71421 27.5775 4.60425 26.2083 4.60425H12.0417ZM26.5625 20.1876V7.08341C26.5625 6.88781 26.4039 6.72925 26.2083 6.72925H12.0417C9.49886 6.72925 7.4375 8.7906 7.4375 11.3334V21.2497C8.32539 20.5828 9.42904 20.1876 10.625 20.1876H26.5625ZM26.5625 22.3126H10.625C8.86459 22.3126 7.4375 23.7397 7.4375 25.5001C7.4375 27.2605 8.86459 28.6876 10.625 28.6876H26.2083C26.4039 28.6876 26.5625 28.529 26.5625 28.3334V22.3126Z" fill="#6B7280" />
                                    </svg>
                                </div>
                            </div>
                            <!-- bot -->
                            <div class="bot">
                                <a href="/admin/reservations">
                                    <span>Voir tous</span>
                                    <svg width="14" height="15" viewBox="0 0 14 15" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path d="M7.8573 5.47611C7.68644 5.30525 7.68644 5.02824 7.8573 4.85739C8.02815 4.68653 8.30516 4.68653 8.47602 4.85739L10.8093 7.19072C10.9802 7.36158 10.9802 7.63859 10.8093 7.80944L8.47602 10.1428C8.30516 10.3136 8.02815 10.3136 7.8573 10.1428C7.68644 9.97192 7.68644 9.69491 7.8573 9.52406L9.44377 7.93758H3.79166C3.55003 7.93758 3.35416 7.74171 3.35416 7.50008C3.35416 7.25846 3.55003 7.06258 3.79166 7.06258H9.44377L7.8573 5.47611Z" fill="#334155" />
                                    </svg>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- table -->
                <div class="flex-1 bg-white grid grid-cols-home relative">
                    <!-- column -->
                    <div class="tableColumn">
                        <!-- table head -->
                        <div class="row head">
                            <span class="">Apprenant</span>
                        </div>
                        <!-- rows -->
                        <c:forEach items="${requestScope._logs}" var="log">
                            <div class="row data">
                                <!-- img -->
                                <div class="imgCont">
                                    <img referrerpolicy="no-referrer" src="<c:out value="${log.apprenant.imgApprenant}"/>" alt="" class="img">
                                </div>
                                <!-- info -->
                                <div class="infos">
                                    <span class="name"><c:out value="${log.apprenant.nomUtilisateur} ${log.apprenant.prenomUtilisateur}"/></span>
                                    <span class="email"><c:out value="${log.apprenant.authentification.emailAuthentification}"/></span>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <!-- column -->
                    <div class="tableColumn">
                        <!-- table head -->
                        <div class="row head">
                            <span class="">Action</span>
                        </div>
                        <!-- rows -->
                        <!-- row -->
                        <c:forEach items="${requestScope._logs}" var="log">
                            <div class="row data">
                            <c:choose>
                                <c:when test="${log.action == 1}">
                                    <!-- badge-1-A -->
                                    <div class="badge badge-1-A">
                                        <svg width="17" height="18" viewBox="0 0 17 18" fill="none" xmlns="http://www.w3.org/2000/svg">
                                            <path d="M7.08333 3.15625C5.61633 3.15625 4.42708 4.34549 4.42708 5.8125C4.42708 7.27951 5.61633 8.46875 7.08333 8.46875C8.55034 8.46875 9.73958 7.27951 9.73958 5.8125C9.73958 4.34549 8.55034 3.15625 7.08333 3.15625Z" fill="#57534E" />
                                            <path d="M4.25 9.88542C2.78299 9.88542 1.59375 11.0747 1.59375 12.5417V13.3834C1.59375 13.9169 1.98042 14.3718 2.50698 14.4578C4.07292 14.7135 5.65492 14.837 7.23639 14.8285C7.34696 14.8279 7.41383 14.7056 7.35975 14.6092C6.95815 13.893 6.72917 13.067 6.72917 12.1875C6.72917 11.63 6.82118 11.094 6.99086 10.5938C7.02274 10.4998 6.95453 10.3998 6.85537 10.3954C6.39365 10.3749 5.93403 10.2921 5.48929 10.1468L4.87622 9.94665C4.75199 9.90608 4.62213 9.88542 4.49145 9.88542H4.25Z" fill="#57534E" />
                                            <path d="M12.2188 11.125C12.2188 10.8316 11.9809 10.5938 11.6875 10.5938C11.3941 10.5938 11.1563 10.8316 11.1563 11.125V12.3807C11.1563 12.5506 11.2376 12.7104 11.375 12.8103L12.0834 13.3255C12.3207 13.498 12.6529 13.4456 12.8255 13.2083C12.998 12.971 12.9456 12.6388 12.7083 12.4662L12.2188 12.1102V11.125Z" fill="#57534E" />
                                            <path fill-rule="evenodd" clip-rule="evenodd" d="M11.6875 16.0833C13.8391 16.0833 15.5833 14.3391 15.5833 12.1875C15.5833 10.0359 13.8391 8.29167 11.6875 8.29167C9.53589 8.29167 7.79167 10.0359 7.79167 12.1875C7.79167 14.3391 9.53589 16.0833 11.6875 16.0833ZM11.6875 15.0208C13.2523 15.0208 14.5208 13.7523 14.5208 12.1875C14.5208 10.6227 13.2523 9.35417 11.6875 9.35417C10.1227 9.35417 8.85417 10.6227 8.85417 12.1875C8.85417 13.7523 10.1227 15.0208 11.6875 15.0208Z" fill="#57534E" />
                                        </svg>
                                        <span>En attente de vérification</span>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <!-- badge-1-B -->
                                    <div class="badge badge-1-B">
                                        <svg width="15" height="16" viewBox="0 0 15 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                            <path d="M4.01798 2.00818C4.18821 1.81313 4.16809 1.51702 3.97304 1.34679C3.77799 1.17657 3.48188 1.19669 3.31165 1.39174L2.50427 2.31684C2.0463 2.8416 1.7874 3.51067 1.77288 4.20701L1.73745 5.90555C1.73206 6.16438 1.9375 6.37857 2.19633 6.38397C2.45516 6.38937 2.66935 6.18393 2.67475 5.9251L2.71018 4.22656C2.72011 3.75011 2.89725 3.29233 3.2106 2.93329L4.01798 2.00818Z" fill="#475569" />
                                            <path fill-rule="evenodd" clip-rule="evenodd" d="M3.89811 5.31304C3.98492 3.92508 5.13592 2.84383 6.52659 2.84383H6.87497V2.37508C6.87497 2.0299 7.1548 1.75008 7.49997 1.75008C7.84515 1.75008 8.12497 2.0299 8.12497 2.37508V2.84383H8.47335C9.86402 2.84383 11.015 3.92509 11.1018 5.31304L11.24 7.52145C11.2926 8.36345 11.5753 9.17486 12.0572 9.86731C12.4926 10.493 12.105 11.3571 11.3482 11.4479L9.21872 11.7034V12.3751C9.21872 13.3243 8.44921 14.0938 7.49997 14.0938C6.55073 14.0938 5.78122 13.3243 5.78122 12.3751V11.7034L3.65177 11.4479C2.89494 11.3571 2.5073 10.493 2.94273 9.86731C3.42464 9.17486 3.70732 8.36345 3.75998 7.52145L3.89811 5.31304ZM6.71872 12.3751C6.71872 12.8065 7.0685 13.1563 7.49997 13.1563C7.93145 13.1563 8.28122 12.8065 8.28122 12.3751V11.9063H6.71872V12.3751Z" fill="#475569" />
                                            <path d="M11.0269 1.34679C10.8319 1.51702 10.8117 1.81313 10.982 2.00818L11.7893 2.93329C12.1027 3.29233 12.2798 3.75011 12.2898 4.22656L12.3252 5.9251C12.3306 6.18393 12.5448 6.38937 12.8036 6.38397C13.0624 6.37857 13.2679 6.16438 13.2625 5.90555L13.2271 4.20701C13.2125 3.51067 12.9537 2.8416 12.4957 2.31684L11.6883 1.39174C11.5181 1.19669 11.222 1.17657 11.0269 1.34679Z" fill="#475569" />
                                        </svg>
                                        <span>En attente de validation</span>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                            </div>
                        </c:forEach>
                    </div>
                    <!-- column -->
                    <div class="tableColumn">
                        <!-- table head -->
                        <div class="row head">
                            <span class="">Date</span>
                        </div>
                        <!-- rows -->
                        <c:forEach items="${requestScope._logs}" var="log">
                            <div class="row data">
                                <span class="infos"><c:out value="${log.strDate}"/></span>
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
                        <!-- row -->
                        <c:forEach items="${requestScope._logs}" var="log">
                            <div class="row data">
                                <span class="infos"><c:out value="${log.apprenant.groupe !=null ? log.apprenant.groupe.libelleGroupe : 'X'}"/></span>
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
                        <c:forEach items="${requestScope._logs}" var="log">
                            <div class="row data option">
                                <span class="infos"><c:out value="${log.apprenant.groupe.promotion != null ? log.apprenant.groupe.promotion.libellePromotion : 'X'}"/></span>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>