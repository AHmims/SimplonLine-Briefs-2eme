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
                        <path d="M22.0156 22.7853C22.1327 22.9431 22.0759 23.1756 21.8977 23.2584C20.451 23.9313 19.299 25.1311 18.6881 26.6111C18.5975 26.8305 18.3912 26.9847 18.1539 26.9895C15.0298 27.0528 11.9036 26.9729 8.78499 26.7498L6.64015 26.5963C5.26809 26.4981 4.13639 25.4838 3.88915 24.1307C3.28331 20.8148 3.17959 17.4268 3.58147 14.0801L3.9675 10.8655C4.15383 9.31378 5.47024 8.146 7.03311 8.146H10.2795C11.6853 8.146 12.8249 9.28562 12.8249 10.6914C12.8249 10.7379 12.8626 10.7755 12.909 10.7755H25.2522C26.7548 10.7755 28.0346 11.8673 28.2715 13.3511L28.3622 13.9198C28.4213 14.2895 28.4735 14.6601 28.5189 15.0313C28.5474 15.2641 28.2913 15.4289 28.0784 15.3305C27.4462 15.0382 26.7421 14.8752 26 14.8752C23.2615 14.8752 21.0416 17.0951 21.0416 19.8335C21.0416 20.9393 21.4036 21.9606 22.0156 22.7853Z" fill="black" />
                        <path d="M26 17.0002C24.4351 17.0002 23.1666 18.2687 23.1666 19.8335C23.1666 21.3983 24.4351 22.6668 26 22.6668C27.5648 22.6668 28.8333 21.3983 28.8333 19.8335C28.8333 18.2687 27.5648 17.0002 26 17.0002Z" fill="black" />
                        <path d="M20.3333 29.0418C20.3333 26.6946 22.2361 24.7918 24.5833 24.7918H27.4166C29.7638 24.7918 31.6666 26.6946 31.6666 29.0418C31.6666 29.8242 31.0324 30.4585 30.25 30.4585H21.75C20.9676 30.4585 20.3333 29.8242 20.3333 29.0418Z" fill="black" />
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
                <h1 class="font-Inter font-bold text-5xl text-blueGray-900">Apprenants</h1>
            </div>
            <!-- content -->
            <div class="w-full flex-1 pt-12 space-y-12 overflow-y-auto overflow-hidden flex flex-col">
                <!-- cards -->
                <div class="w-full font-Inter space-y-4 px-10">
                    <span class="block font-medium text-xl text-coolGray-500">Demandes d'inscription</span>
                    <div class="w-full space-x-10 flex flex-row overflow-x-auto p-2">
                        <!-- cards -->
                        <c:forEach items="${requestScope._app_count_inactive}" var="apprenant">
                            <form method="post" action="/admin/apprenants/validator" class="card-learner">
                                <!-- top -->
                                <div class="top">
                                    <!-- left -->
                                    <div class="left">
                                        <div class="top">
                                            <span class="name"><c:out value="${apprenant.nomUtilisateur} ${apprenant.prenomUtilisateur}"/></span>
                                            <span class="email"><c:out value="${apprenant.authentification.emailAuthentification}"/></span>
                                        </div>
                                        <div class="bot">
                                            <span class="groupe"><c:out value="${apprenant.groupe !=null ? apprenant.groupe.libelleGroupe : 'X'}"/></span>
                                            <span class="promotion"><c:out value="${apprenant.groupe.promotion != null ? apprenant.groupe.promotion.libellePromotion : 'X'}"/></span>
                                        </div>
                                    </div>
                                    <!-- right -->
                                    <div class="right">
                                        <div class="imgCont">
                                            <img referrerpolicy="no-referrer" src="<c:out value="${apprenant.imgApprenant}"/>" alt="" class="img">
                                        </div>
                                    </div>
                                </div>
                                <!-- bot -->
                                <div class="bot">
                                    <div class="btnsCont">
                                        <button class="buttonSec">
                                            <span>Refuser</span>
                                        </button>
                                        <button class="buttonMain">
                                            <span>Verifier</span>
                                        </button>
                                    </div>
                                </div>
                                <!-- data -->
                                <input type="hidden" name="_action" class="card_action" value="ok"/>
                                <input type="hidden" name="_id" class="card_id" value="<c:out value="${apprenant.idUtilisateur}"/>"/>
                            </form>
                        </c:forEach>
                    </div>
                </div>
                <!-- table -->
                <div class="flex-1 bg-white grid grid-cols-learners relative">
                    <!-- column -->
                    <div class="tableColumn">
                        <!-- table head -->
                        <div class="row head">
                            <span class="">Apprenant</span>
                        </div>
                        <!-- rows -->
                        <!-- row -->
                        <c:forEach items="${requestScope._app_count_active}" var="apprenant">
                            <div class="row data">
                                <!-- img -->
                                <div class="imgCont">
                                    <img referrerpolicy="no-referrer" src="<c:out value="${apprenant.imgApprenant}"/>" alt="" class="img">
                                </div>
                                <!-- info -->
                                <div class="infos">
                                    <span class="name"><c:out value="${apprenant.nomUtilisateur} ${apprenant.prenomUtilisateur}"/></span>
                                    <span class="email"><c:out value="${apprenant.authentification.emailAuthentification}"/></span>
                                </div>
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
                        <!-- row -->
                        <c:forEach items="${requestScope._app_count_active}" var="apprenant">
                            <div class="row data">
                                <span class="infos"><c:out value="${apprenant.dateCreation}"/></span>
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
                        <c:forEach items="${requestScope._app_count_active}" var="apprenant">
                            <div class="row data">
                                <span class="infos"><c:out value="${apprenant.groupe !=null ? apprenant.groupe.libelleGroupe : 'X'}"/></span>
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
                        <!-- row -->
                        <c:forEach items="${requestScope._app_count_active}" var="apprenant">
                            <form action="/admin/apprenants/manager" method="post" class="row data option learner_row" style="margin: 0;">
                                <span class="infos"><c:out value="${apprenant.groupe.promotion != null ? apprenant.groupe.promotion.libellePromotion : 'X'}"/></span>
                                <button type="button">
                                    <svg width="20" height="20" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path d="M7.70817 2.5C7.70817 2.15482 7.98799 1.875 8.33317 1.875H11.6665C12.0117 1.875 12.2915 2.15482 12.2915 2.5V3.125H15.8332C16.1783 3.125 16.4582 3.40482 16.4582 3.75C16.4582 4.09518 16.1783 4.375 15.8332 4.375H4.1665C3.82133 4.375 3.5415 4.09518 3.5415 3.75C3.5415 3.40482 3.82133 3.125 4.1665 3.125H7.70817V2.5Z" fill="#4B5563" />
                                        <path fill-rule="evenodd" clip-rule="evenodd" d="M5.19975 6.62065C5.2232 6.40964 5.40156 6.25 5.61387 6.25H14.3858C14.5981 6.25 14.7765 6.40964 14.7999 6.62065L14.9667 8.12178C15.2674 10.8276 15.2674 13.5584 14.9667 16.2642L14.9503 16.412C14.8408 17.3975 14.077 18.1833 13.095 18.3207C11.0416 18.6082 8.95808 18.6082 6.90462 18.3207C5.92265 18.1833 5.15888 17.3975 5.04938 16.412L5.03296 16.2642C4.73231 13.5584 4.73231 10.8276 5.03296 8.12177L5.19975 6.62065ZM12.1085 10.3914C12.3525 10.6355 12.3525 11.0312 12.1085 11.2753L10.8837 12.5L12.1084 13.7247C12.3525 13.9688 12.3525 14.3645 12.1084 14.6086C11.8644 14.8527 11.4686 14.8527 11.2246 14.6086L9.99984 13.3839L8.77512 14.6086C8.53104 14.8527 8.13531 14.8527 7.89124 14.6086C7.64716 14.3645 7.64716 13.9688 7.89124 13.7247L9.11595 12.5L7.89123 11.2753C7.64715 11.0312 7.64715 10.6355 7.89123 10.3914C8.13531 10.1473 8.53103 10.1473 8.77511 10.3914L9.99984 11.6161L11.2246 10.3914C11.4686 10.1473 11.8644 10.1473 12.1085 10.3914Z" fill="#4B5563" />
                                    </svg>
                                </button>
                                <input type="hidden" name="_id" value="<c:out value="${apprenant.idUtilisateur}"/>"/>
                            </form>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="/js/admin.learners.js"></script>
    <c:if test="${not empty param.ret_code}">
        <script>
            errorHandler(`<c:out value="${param.ret_code}"/>`);
        </script>
    </c:if>
</body>

</html>