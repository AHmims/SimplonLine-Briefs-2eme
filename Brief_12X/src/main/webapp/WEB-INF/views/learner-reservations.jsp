<%@ page import="java.util.Calendar" %>
<%@ page import="model.Reservation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/style.css">
    <title>Historique</title>
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
                                <img src="<c:out value="${sessionScope.__user_data.imgApprenant}"/>" alt="" class="w-full h-full object-cover">
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
                <!-- container -->
                <div class="container mx-auto space-y-7.5 font-Inter w-full flex flex-col">
                    <!-- bar -->
                    <div class="w-full flex flex-row justify-end items-center space-x-5">
                        <!-- filters -->
                        <!-- sort -->
                        <div class="flex flex-row items-center h-11 space-x-5 px-5 rounded-lg outline-none border-coolGray-100 text-coolGray-500 border-2">
                            <span>Trier par date</span>
                            <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path d="M13.4697 7.53033C13.7626 7.82322 14.2374 7.82322 14.5303 7.53033L15.25 6.81066L15.25 17C15.25 17.4142 15.5858 17.75 16 17.75C16.4142 17.75 16.75 17.4142 16.75 17L16.75 6.81066L17.4697 7.53033C17.7626 7.82322 18.2374 7.82322 18.5303 7.53033C18.8232 7.23744 18.8232 6.76256 18.5303 6.46967L16.5303 4.46967C16.2374 4.17678 15.7626 4.17678 15.4697 4.46967L13.4697 6.46967C13.1768 6.76256 13.1768 7.23744 13.4697 7.53033Z" fill="#6B7280" />
                                <path d="M8.75 17.1893L9.46967 16.4697C9.76256 16.1768 10.2374 16.1768 10.5303 16.4697C10.8232 16.7626 10.8232 17.2374 10.5303 17.5303L8.53033 19.5303C8.23744 19.8232 7.76256 19.8232 7.46967 19.5303L5.46967 17.5303C5.17678 17.2374 5.17678 16.7626 5.46967 16.4697C5.76256 16.1768 6.23744 16.1768 6.53033 16.4697L7.25 17.1893L7.25 7C7.25 6.58579 7.58579 6.25 8 6.25C8.41421 6.25 8.75 6.58579 8.75 7L8.75 17.1893Z" fill="#6B7280" />
                            </svg>
                        </div>
                        <!-- filter -->
                        <form action="/apprenant/reservations" method="get" class="user-reserv" style="margin-bottom: 0;">
                            <select name="type" onchange="this.form.submit()" class="flex flex-row items-center h-11 space-x-5 px-5 rounded-lg outline-none border-coolGray-100 text-coolGray-500 border-2">
                                <option value="all">Tous</option>
                                <option value="week">Week-End</option>
                                <option value="week-end">En-Semaine</option>
                            </select>
                        </form>
                    </div>
                    <!-- container -->
                    <div class="grid grid-cols-items gap-8.6 overflow-visible">
                        <!-- card -->
                        <%--@elvariable id="reservation" type="model.Reservation"--%>
                        <c:forEach items="${requestScope._reservations}" var="reservation">
                            <div class="reserv-card">
                                <!-- top -->
                                <div class="top">
                                    <input type="date" class="date" value="<fmt:formatDate pattern = "YYYY-MM-dd" value = "${reservation.dateReservation}" />" />
                                </div>
                                <!-- bot -->
                                <div class="bot">
                                    <!-- top -->
                                    <div class="top">
                                        <!-- loc -->
                                        <div class="loc">
                                            <svg width="18" height="18" viewBox="0 0 18 18" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                <path d="M6.5625 7.5C6.5625 6.15381 7.65381 5.0625 9 5.0625C10.3462 5.0625 11.4375 6.15381 11.4375 7.5C11.4375 8.84619 10.3462 9.9375 9 9.9375C7.65381 9.9375 6.5625 8.84619 6.5625 7.5Z" fill="#4B5563" />
                                                <path fill-rule="evenodd" clip-rule="evenodd" d="M2.83016 6.65804C3.08789 3.53134 5.70073 1.125 8.83804 1.125H9.162C12.2993 1.125 14.9122 3.53134 15.1699 6.65804C15.3086 8.34149 14.7886 10.0131 13.7194 11.3207L10.1246 15.7171C9.54337 16.4279 8.45667 16.4279 7.87544 15.7171L4.28064 11.3207C3.2114 10.0131 2.69139 8.34149 2.83016 6.65804ZM9 3.9375C7.03249 3.9375 5.4375 5.53249 5.4375 7.5C5.4375 9.46751 7.03249 11.0625 9 11.0625C10.9675 11.0625 12.5625 9.46751 12.5625 7.5C12.5625 5.53249 10.9675 3.9375 9 3.9375Z" fill="#4B5563" />
                                            </svg>
                                            <span><c:out value="${reservation.emplacement.local.villeLocal}-${reservation.emplacement.local.libelleLocal}"/></span>
                                        </div>
                                        <!-- emplace -->
                                        <div class="empla">
                                            <svg width="18" height="18" viewBox="0 0 18 18" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd" clip-rule="evenodd" d="M9.5625 1.5C9.5625 1.18934 9.31066 0.9375 9 0.9375C8.68934 0.9375 8.4375 1.18934 8.4375 1.5V2.83772C5.46911 3.10522 3.10522 5.46911 2.83772 8.4375H1.5C1.18934 8.4375 0.9375 8.68934 0.9375 9C0.9375 9.31066 1.18934 9.5625 1.5 9.5625H2.83772C3.10522 12.5309 5.46911 14.8948 8.4375 15.1623V16.5C8.4375 16.8107 8.68934 17.0625 9 17.0625C9.31066 17.0625 9.5625 16.8107 9.5625 16.5V15.1623C12.5309 14.8948 14.8948 12.5309 15.1623 9.5625H16.5C16.8107 9.5625 17.0625 9.31066 17.0625 9C17.0625 8.68934 16.8107 8.4375 16.5 8.4375H15.1623C14.8948 5.46911 12.5309 3.10522 9.5625 2.83772V1.5ZM6.1875 9C6.1875 7.4467 7.4467 6.1875 9 6.1875C10.5533 6.1875 11.8125 7.4467 11.8125 9C11.8125 10.5533 10.5533 11.8125 9 11.8125C7.4467 11.8125 6.1875 10.5533 6.1875 9Z" fill="#4B5563" />
                                            </svg>
                                            <span><c:out value="${reservation.emplacement.libelleEmplacement}"/></span>
                                        </div>
                                    </div>
                                    <!-- bot -->
                                    <div class="bot">
                                        <%
                                            Calendar cal_res = Calendar.getInstance();
                                            cal_res.setTime(((Reservation) pageContext.getAttribute("reservation")).getDateReservation());
                                            int day = cal_res.get(Calendar.DAY_OF_WEEK);
                                            int nature = day >= Calendar.MONDAY && day <= Calendar.FRIDAY ? 1 : 2;
                                        %>
                                        <c:set var="nature" value="<%= nature %>"/>
                                        <c:choose>
                                            <c:when test="${nature == 1}">
                                                <div class="badge-2 badge-2-B">
                                                    <svg width="10" height="10" viewBox="0 0 10 10" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                        <rect width="10" height="10" rx="5" fill="#475569" />
                                                    </svg>
                                                    <span>En-semaine</span>
                                                </div>
                                            </c:when>
                                            <c:otherwise>
                                                <div class="badge-2 badge-2-A">
                                                    <svg width="10" height="11" viewBox="0 0 10 11" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                        <rect y="0.5" width="10" height="10" rx="5" fill="#57534E" />
                                                    </svg>
                                                    <span>Week-end</span>
                                                </div>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
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
</body>

</html>