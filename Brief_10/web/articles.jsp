<%@ page import="beans.Article" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.Vote" %>
<%@ page import="beans.Utilisateur" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/style.css">
    <title>Document</title>
</head>

<body class="bg-white p-9 min-h-screen flex flex-col">
    <% Utilisateur user = (Utilisateur) request.getSession(false).getAttribute("__user_data"); %>
    <div class="w-full h-full flex flex-col flex-1 justify-between">
        <div class="w-full h-full flex flex-col space-y-20 flex-1 justify-between">
            <!-- navBar -->
            <div class="w-full flex flex-row items-center justify-between px-16 py-12 bg-amber-100 rounded-40">
                <svg width="116" height="28" viewBox="0 0 116 28" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M16.928 13.86C17.936 14.46 18.704 15.228 19.232 16.164C19.76 17.1 20.024 18.18 20.024 19.404C20.024 20.556 19.748 21.636 19.196 22.644C18.644 23.628 17.864 24.504 16.856 25.272C15.944 25.968 14.9 26.508 13.724 26.892C12.572 27.252 11.348 27.444 10.052 27.468C8.756 27.468 7.52 27.288 6.344 26.928C5.168 26.568 4.124 26.028 3.212 25.308C1.844 24.276 0.908 23.028 0.404 21.564L5.444 19.224C5.444 19.464 5.528 19.764 5.696 20.124C5.864 20.484 6.128 20.832 6.488 21.168C6.848 21.504 7.316 21.792 7.892 22.032C8.468 22.272 9.176 22.392 10.016 22.392C10.688 22.392 11.276 22.308 11.78 22.14C12.308 21.972 12.74 21.768 13.076 21.528C13.436 21.264 13.7 20.976 13.868 20.664C14.06 20.328 14.156 19.992 14.156 19.656C14.156 19.272 14.024 18.912 13.76 18.576C13.52 18.24 13.136 17.976 12.608 17.784C11.648 17.448 10.628 17.172 9.548 16.956C8.492 16.716 7.46 16.428 6.452 16.092C5.444 15.732 4.508 15.264 3.644 14.688C2.78 14.112 2.096 13.308 1.592 12.276C1.136 11.364 0.908 10.392 0.908 9.36C0.908 8.208 1.172 7.092 1.7 6.012C2.252 4.932 2.996 4.02 3.932 3.276C4.82 2.58 5.816 2.052 6.92 1.692C8.024 1.308 9.188 1.116 10.412 1.116C11.636 1.116 12.8 1.296 13.904 1.656C15.032 2.016 16.04 2.544 16.928 3.24C17.792 3.888 18.476 4.644 18.98 5.508L14.876 8.316C14.372 7.62 13.736 7.068 12.968 6.66C12.224 6.228 11.384 6.012 10.448 6.012C9.152 6.012 8.144 6.3 7.424 6.876C6.728 7.452 6.38 8.208 6.38 9.144C6.38 9.576 6.572 9.96 6.956 10.296C7.364 10.632 7.88 10.932 8.504 11.196C9.152 11.46 9.872 11.7 10.664 11.916C11.456 12.108 12.236 12.312 13.004 12.528C13.796 12.72 14.54 12.924 15.236 13.14C15.932 13.356 16.496 13.596 16.928 13.86ZM38.8596 13.104C39.8676 13.8 40.6716 14.7 41.2716 15.804C41.8716 16.884 42.1716 18.084 42.1716 19.404C42.1716 20.46 41.9676 21.456 41.5596 22.392C41.1516 23.304 40.5996 24.108 39.9036 24.804C39.2076 25.476 38.3916 26.016 37.4556 26.424C36.5436 26.808 35.5596 27 34.5036 27H22.9116V1.476H34.1436C35.1036 1.476 36.0036 1.668 36.8436 2.052C37.6836 2.412 38.4156 2.904 39.0396 3.528C39.6876 4.152 40.1916 4.884 40.5516 5.724C40.9116 6.564 41.0916 7.464 41.0916 8.424C41.0916 9.456 40.8876 10.368 40.4796 11.16C40.0956 11.928 39.5556 12.576 38.8596 13.104ZM28.3836 11.052H34.1436C34.7916 11.052 35.3436 10.824 35.7996 10.368C36.2556 9.912 36.4836 9.36 36.4836 8.712C36.4836 8.064 36.2556 7.524 35.7996 7.092C35.3436 6.66 34.7916 6.444 34.1436 6.444H28.3836V11.052ZM34.5036 22.068C35.2236 22.068 35.8356 21.768 36.3396 21.168C36.8436 20.544 37.0956 19.824 37.0956 19.008C37.0956 18.168 36.8436 17.46 36.3396 16.884C35.8356 16.308 35.2236 16.02 34.5036 16.02H28.3836V22.068H34.5036ZM63.7767 9.144V27H59.4927L58.9887 25.092C58.2927 26.028 57.4527 26.652 56.4687 26.964C55.5087 27.276 54.5007 27.432 53.4447 27.432C52.1727 27.432 50.9967 27.192 49.9167 26.712C48.8607 26.208 47.9367 25.536 47.1447 24.696C46.3527 23.832 45.7287 22.836 45.2727 21.708C44.8407 20.556 44.6247 19.332 44.6247 18.036C44.6247 16.74 44.8407 15.528 45.2727 14.4C45.7287 13.248 46.3527 12.252 47.1447 11.412C47.9367 10.548 48.8607 9.876 49.9167 9.396C50.9967 8.892 52.1727 8.64 53.4447 8.64C54.5967 8.64 55.6527 8.82 56.6127 9.18C57.5727 9.54 58.3647 10.116 58.9887 10.908L59.4927 9.144H63.7767ZM58.8087 18.108C58.8087 17.172 58.6767 16.392 58.4127 15.768C58.1727 15.12 57.8367 14.604 57.4047 14.22C56.9967 13.812 56.5047 13.524 55.9287 13.356C55.3767 13.164 54.7767 13.068 54.1287 13.068C53.4807 13.068 52.8687 13.2 52.2927 13.464C51.7407 13.728 51.2487 14.088 50.8167 14.544C50.3847 14.976 50.0487 15.504 49.8087 16.128C49.5687 16.728 49.4487 17.364 49.4487 18.036C49.4487 18.732 49.5687 19.38 49.8087 19.98C50.0487 20.58 50.3847 21.108 50.8167 21.564C51.2487 21.996 51.7407 22.344 52.2927 22.608C52.8687 22.872 53.4807 23.004 54.1287 23.004C55.4247 23.004 56.5167 22.608 57.4047 21.816C58.3167 21 58.7847 19.764 58.8087 18.108ZM76.931 8.64C78.107 8.64 79.199 8.892 80.207 9.396C81.239 9.876 82.127 10.548 82.871 11.412C83.615 12.252 84.191 13.248 84.599 14.4C85.031 15.528 85.247 16.74 85.247 18.036V27H80.387V23.724C80.387 22.812 80.387 21.876 80.387 20.916C80.411 19.932 80.423 19.092 80.423 18.396C80.423 17.724 80.315 17.064 80.099 16.416C79.883 15.768 79.583 15.204 79.199 14.724C78.815 14.22 78.359 13.824 77.831 13.536C77.327 13.224 76.787 13.068 76.211 13.068C75.659 13.068 75.131 13.176 74.627 13.392C74.123 13.584 73.679 13.884 73.295 14.292C72.911 14.676 72.599 15.168 72.359 15.768C72.143 16.368 72.035 17.076 72.035 17.892V27H67.031V0.719999H72.035V10.512C72.659 9.912 73.367 9.456 74.159 9.144C74.975 8.808 75.899 8.64 76.931 8.64ZM93.0711 27H88.1031V9.144H93.0711V27ZM94.7271 1.44L92.4591 7.884H88.7871L89.2911 1.44H94.7271ZM115.597 9.144V27H111.313L110.809 25.092C110.113 26.028 109.273 26.652 108.289 26.964C107.329 27.276 106.321 27.432 105.265 27.432C103.993 27.432 102.817 27.192 101.737 26.712C100.681 26.208 99.757 25.536 98.965 24.696C98.173 23.832 97.549 22.836 97.093 21.708C96.661 20.556 96.445 19.332 96.445 18.036C96.445 16.74 96.661 15.528 97.093 14.4C97.549 13.248 98.173 12.252 98.965 11.412C99.757 10.548 100.681 9.876 101.737 9.396C102.817 8.892 103.993 8.64 105.265 8.64C106.417 8.64 107.473 8.82 108.433 9.18C109.393 9.54 110.185 10.116 110.809 10.908L111.313 9.144H115.597ZM110.629 18.108C110.629 17.172 110.497 16.392 110.233 15.768C109.993 15.12 109.657 14.604 109.225 14.22C108.817 13.812 108.325 13.524 107.749 13.356C107.197 13.164 106.597 13.068 105.949 13.068C105.301 13.068 104.689 13.2 104.113 13.464C103.561 13.728 103.069 14.088 102.637 14.544C102.205 14.976 101.869 15.504 101.629 16.128C101.389 16.728 101.269 17.364 101.269 18.036C101.269 18.732 101.389 19.38 101.629 19.98C101.869 20.58 102.205 21.108 102.637 21.564C103.069 21.996 103.561 22.344 104.113 22.608C104.689 22.872 105.301 23.004 105.949 23.004C107.245 23.004 108.337 22.608 109.225 21.816C110.137 21 110.605 19.764 110.629 18.108Z" fill="#292524" />
                </svg>
                <!-- nav links -->
                <div class="text-warmGray-700 font-Kollektif font-normal text-2xl flex flex-row items-center space-x-10">
                    <a href="/">
                        <span>Accueil</span>
                    </a>
                    <a href="/articles">
                        <span>Articles</span>
                    </a>
                    <div class="w-16 h-16 rounded-full overflow-hidden border-3 border-warmGray-700 relative">
                        <img src="./img/avatar.png" alt="" class="w-full h-full object-cover">
                        <div class="w-full h-full rounded-full shadow-avatar absolute top-0 left-0"></div>
                    </div>
                    <a href="#">
                        <svg width="30" height="31" viewBox="0 0 30 31" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" clip-rule="evenodd" d="M4.5 5C4.10218 5 3.72064 5.15804 3.43934 5.43934C3.15804 5.72064 3 6.10218 3 6.5V24.5C3 24.8978 3.15804 25.2794 3.43934 25.5607C3.72064 25.842 4.10218 26 4.5 26C4.89782 26 5.27936 25.842 5.56066 25.5607C5.84196 25.2794 6 24.8978 6 24.5V6.5C6 6.10218 5.84196 5.72064 5.56066 5.43934C5.27936 5.15804 4.89782 5 4.5 5ZM19.9395 18.9395C19.6663 19.2224 19.5151 19.6013 19.5185 19.9946C19.5219 20.3879 19.6797 20.7641 19.9578 21.0422C20.2359 21.3203 20.6121 21.4781 21.0054 21.4815C21.3987 21.4849 21.7776 21.3337 22.0605 21.0605L26.5605 16.5605C26.8417 16.2792 26.9997 15.8977 26.9997 15.5C26.9997 15.1023 26.8417 14.7208 26.5605 14.4395L22.0605 9.9395C21.9221 9.79624 21.7566 9.68196 21.5736 9.60335C21.3906 9.52473 21.1938 9.48336 20.9946 9.48162C20.7954 9.47989 20.5979 9.51785 20.4136 9.59327C20.2292 9.66869 20.0617 9.78007 19.9209 9.92091C19.7801 10.0617 19.6687 10.2292 19.5933 10.4136C19.5178 10.5979 19.4799 10.7954 19.4816 10.9946C19.4834 11.1938 19.5247 11.3906 19.6033 11.5736C19.682 11.7566 19.7962 11.9221 19.9395 12.0605L21.879 14H10.5C10.1022 14 9.72064 14.158 9.43934 14.4393C9.15804 14.7206 9 15.1022 9 15.5C9 15.8978 9.15804 16.2794 9.43934 16.5607C9.72064 16.842 10.1022 17 10.5 17H21.879L19.9395 18.9395Z" fill="#44403C" />
                        </svg>
                    </a>
                </div>
            </div>
            <!-- content -->
            <div class="w-full flex-1 flex flex-row space-x-12 px-16">
                <!-- MAIN -->
                <div class="flex-1 flex flex-col justify-between space-y-20">
                    <!-- articles -->
                    <div class="flex flex-col space-y-10">
                        <!-- Search bar -->
                        <div class="w-full h-24 flex flex-row">
                            <!-- Search input -->
                            <div class="flex flex-row flex-1 items-center justify-between p-8 rounded-l-34 border-coolGray-100 border-3">
                                <!-- field -->
                                <div class="flex flex-row flex-1 items-center">
                                    <svg width="32" height="32" viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" clip-rule="evenodd" d="M12.8 6.39996C11.1026 6.39996 9.47475 7.07424 8.27451 8.27447C7.07428 9.47471 6.4 11.1026 6.4 12.8C6.4 14.4973 7.07428 16.1252 8.27451 17.3254C9.47475 18.5257 11.1026 19.2 12.8 19.2C14.4974 19.2 16.1252 18.5257 17.3255 17.3254C18.5257 16.1252 19.2 14.4973 19.2 12.8C19.2 11.1026 18.5257 9.47471 17.3255 8.27447C16.1252 7.07424 14.4974 6.39996 12.8 6.39996ZM3.2 12.8C3.1998 11.2891 3.55622 9.7995 4.24027 8.45234C4.92432 7.10519 5.91667 5.93851 7.13663 5.0472C8.35659 4.15588 9.7697 3.5651 11.261 3.32289C12.7524 3.08068 14.2798 3.19389 15.7191 3.65332C17.1585 4.11274 18.469 4.9054 19.5443 5.96683C20.6195 7.02826 21.429 8.32849 21.907 9.76177C22.3849 11.195 22.5179 12.7209 22.2949 14.2152C22.072 15.7096 21.4995 17.1302 20.624 18.3616L28.3312 26.0688C28.6227 26.3705 28.7839 26.7747 28.7803 27.1942C28.7766 27.6137 28.6084 28.015 28.3117 28.3117C28.0151 28.6083 27.6138 28.7766 27.1942 28.7802C26.7747 28.7839 26.3706 28.6226 26.0688 28.3312L18.3632 20.6256C16.927 21.6468 15.2374 22.253 13.4795 22.3777C11.7216 22.5025 9.96331 22.1409 8.39728 21.3327C6.83124 20.5245 5.5179 19.3008 4.60115 17.7957C3.68441 16.2906 3.19965 14.5623 3.2 12.8Z" fill="#9CA3AF" />
                                    </svg>
                                    <input type="text" placeholder="Cherchez un produit ..." class="w-full py-2 ml-5 mr-8 font-SourceSansPro text-2xl text-coolGray-700 placeholder-coolGray-400 bg-transparent">
                                </div>
                                <!-- icon -->
                                <svg width="32" height="32" viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd" clip-rule="evenodd" d="M6.86885 6.86883C7.16889 6.56888 7.57579 6.40037 8.00005 6.40037C8.42431 6.40037 8.8312 6.56888 9.13125 6.86883L16 13.7376L22.8688 6.86883C23.0164 6.71602 23.193 6.59412 23.3882 6.51027C23.5834 6.42642 23.7934 6.38228 24.0058 6.38043C24.2183 6.37859 24.4289 6.41907 24.6256 6.49952C24.8222 6.57997 25.0009 6.69877 25.1511 6.849C25.3013 6.99923 25.4201 7.17787 25.5006 7.37451C25.581 7.57114 25.6215 7.78183 25.6196 7.99427C25.6178 8.20672 25.5737 8.41667 25.4898 8.61188C25.406 8.80709 25.2841 8.98364 25.1312 9.13123L18.2624 16L25.1312 22.8688C25.4227 23.1706 25.584 23.5748 25.5803 23.9943C25.5767 24.4138 25.4084 24.8151 25.1118 25.1117C24.8151 25.4084 24.4138 25.5767 23.9943 25.5803C23.5748 25.584 23.1706 25.4227 22.8688 25.1312L16 18.2624L9.13125 25.1312C8.82948 25.4227 8.42532 25.584 8.00581 25.5803C7.58629 25.5767 7.18499 25.4084 6.88834 25.1117C6.59169 24.8151 6.42342 24.4138 6.41977 23.9943C6.41612 23.5748 6.5774 23.1706 6.86885 22.8688L13.7376 16L6.86885 9.13123C6.5689 8.83119 6.40039 8.42429 6.40039 8.00003C6.40039 7.57577 6.5689 7.16888 6.86885 6.86883Z" fill="#9CA3AF" />
                                </svg>
                            </div>
                            <div class="border-3 border-l-0 p-8 rounded-r-34 border-coolGray-100">
                                <select name="" id="" class="font-SourceSansPro font-normal text-2xl text-coolGray-400 w-48">
                                    <option value="" selected disabled>Trier par</option>
                                    <option value="P">Prix</option>
                                    <option value="S">Stock</option>
                                    <option value="N">Nom</option>
                                </select>
                            </div>
                            <!-- ADMIN -->
                            <% if(user.getRoleUtilisateur().equals("admin")){ %>
                            <button id="addBtn" class="ml-8 py-6 px-16 rounded-34 bg-amber-100 text-amber-600 font-Kollektif text-2xl">Ajouter</button>
                            <% } %>
                        </div>
                        <!-- PRODUCTS -->
                        <div id="articlesContainer" class="w-full grid grid-cols-article gap-13">
                            <!-- Product -->
                            <% for (Article article : (ArrayList<Article>) request.getAttribute("_articles_data")) { %>
                            <% boolean voted = false; %>
                            <% for (Vote vote : (ArrayList<Vote>) request.getAttribute("_votes_data")){ %>
                            <% if(vote.getIdArticle() == article.getIdarticle()){ %>
                            <% voted = true; %>
                            <% } %>
                            <% } %>
                            <div class="articleCard bg-white h-420 rounded-50 border-3 border-coolGray-100 flex flex-col p-7 justify-between">
                                <!-- Top -->
                                <div class="relative w-full h-64">
                                    <img src="<%= article.getImageArticle() %>" alt="" class="articleCard_image rounded-34 select-none object-cover w-full h-full">
                                    <div id="btnSet" class="flex flex-col absolute bottom-0 right-0 space-y-2.5">
                                        <% if(user.getRoleUtilisateur().equals("client")){ %>
                                        <!-- Client -->
                                        <button data-article="<%= article.getIdarticle() %>" data-toggle="<%=voted %>" class="voteBtn p-3 <%= voted ? "bg-red-50" : "bg-coolGray-100"%> rounded-20">
                                            <svg width="30" height="30" class="fill-current <%= voted ? "text-red-500" : "text-coolGray-300"%>" viewBox="0 0 30 30" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd" clip-rule="evenodd" d="M4.758 7.758C5.88317 6.63317 7.40902 6.00128 9 6.00128C10.591 6.00128 12.1168 6.63317 13.242 7.758L15 9.5145L16.758 7.758C17.3115 7.18494 17.9735 6.72784 18.7056 6.41339C19.4376 6.09894 20.2249 5.93342 21.0216 5.9265C21.8183 5.91957 22.6083 6.07138 23.3457 6.37307C24.0831 6.67475 24.753 7.12027 25.3164 7.68363C25.8797 8.24698 26.3252 8.9169 26.6269 9.65427C26.9286 10.3917 27.0804 11.1817 27.0735 11.9784C27.0666 12.7751 26.9011 13.5624 26.5866 14.2944C26.2722 15.0264 25.8151 15.6885 25.242 16.242L15 26.4855L4.758 16.242C3.63317 15.1168 3.00128 13.591 3.00128 12C3.00128 10.409 3.63317 8.88316 4.758 7.758Z" />
                                            </svg>
                                        </button>
                                        <% }else{ %>
                                        <!-- ADMIN -->
                                        <button data-article="<%= article.getIdarticle() %>" class="editBtn p-3 bg-coolGray-100 rounded-20">
                                            <svg width="30" height="30" viewBox="0 0 30 30" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                <path d="M26.121 3.87885C25.5584 3.31643 24.7955 3.00049 24 3.00049C23.2045 3.00049 22.4416 3.31643 21.879 3.87885L10.5 15.2578V19.4998H14.742L26.121 8.12085C26.6834 7.55826 26.9994 6.79534 26.9994 5.99985C26.9994 5.20436 26.6834 4.44143 26.121 3.87885Z" fill="#4B5563" />
                                                <path fill-rule="evenodd" clip-rule="evenodd" d="M3 9C3 8.20435 3.31607 7.44129 3.87868 6.87868C4.44129 6.31607 5.20435 6 6 6H12C12.3978 6 12.7794 6.15804 13.0607 6.43934C13.342 6.72064 13.5 7.10218 13.5 7.5C13.5 7.89782 13.342 8.27936 13.0607 8.56066C12.7794 8.84196 12.3978 9 12 9H6V24H21V18C21 17.6022 21.158 17.2206 21.4393 16.9393C21.7206 16.658 22.1022 16.5 22.5 16.5C22.8978 16.5 23.2794 16.658 23.5607 16.9393C23.842 17.2206 24 17.6022 24 18V24C24 24.7956 23.6839 25.5587 23.1213 26.1213C22.5587 26.6839 21.7956 27 21 27H6C5.20435 27 4.44129 26.6839 3.87868 26.1213C3.31607 25.5587 3 24.7956 3 24V9Z" fill="#4B5563" />
                                            </svg>
                                        </button>
                                        <button class="deleteBtn p-3 bg-rose-100 rounded-20">
                                            <svg width="30" height="30" viewBox="0 0 30 30" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd" clip-rule="evenodd" d="M13.5 3C13.2215 3.00015 12.9486 3.07782 12.7117 3.22433C12.4749 3.37083 12.2835 3.58038 12.159 3.8295L11.073 6H6C5.60218 6 5.22064 6.15804 4.93934 6.43934C4.65804 6.72064 4.5 7.10218 4.5 7.5C4.5 7.89782 4.65804 8.27936 4.93934 8.56066C5.22064 8.84196 5.60218 9 6 9V24C6 24.7956 6.31607 25.5587 6.87868 26.1213C7.44129 26.6839 8.20435 27 9 27H21C21.7956 27 22.5587 26.6839 23.1213 26.1213C23.6839 25.5587 24 24.7956 24 24V9C24.3978 9 24.7794 8.84196 25.0607 8.56066C25.342 8.27936 25.5 7.89782 25.5 7.5C25.5 7.10218 25.342 6.72064 25.0607 6.43934C24.7794 6.15804 24.3978 6 24 6H18.927L17.841 3.8295C17.7165 3.58038 17.5251 3.37083 17.2883 3.22433C17.0514 3.07782 16.7785 3.00015 16.5 3H13.5ZM10.5 12C10.5 11.6022 10.658 11.2206 10.9393 10.9393C11.2206 10.658 11.6022 10.5 12 10.5C12.3978 10.5 12.7794 10.658 13.0607 10.9393C13.342 11.2206 13.5 11.6022 13.5 12V21C13.5 21.3978 13.342 21.7794 13.0607 22.0607C12.7794 22.342 12.3978 22.5 12 22.5C11.6022 22.5 11.2206 22.342 10.9393 22.0607C10.658 21.7794 10.5 21.3978 10.5 21V12ZM18 10.5C17.6022 10.5 17.2206 10.658 16.9393 10.9393C16.658 11.2206 16.5 11.6022 16.5 12V21C16.5 21.3978 16.658 21.7794 16.9393 22.0607C17.2206 22.342 17.6022 22.5 18 22.5C18.3978 22.5 18.7794 22.342 19.0607 22.0607C19.342 21.7794 19.5 21.3978 19.5 21V12C19.5 11.6022 19.342 11.2206 19.0607 10.9393C18.7794 10.658 18.3978 10.5 18 10.5Z" fill="#E11D48" />
                                            </svg>
                                        </button>
                                        <% } %>
                                    </div>
                                </div>
                                <!-- Bottom -->
                                <div class="flex flex-col">
                                    <span class="text-coolGray-500 font-SourceSansPro flex flex-row items-baseline">
                                        <span class="articleCard_price font-semibold text-3xl"><%= article.getPrixArticle() %></span>
                                        <span class="font-normal text-xl">DH</span>
                                    </span>
                                    <span class="articleCard_name mt-0.5 font-Kollektif font-bold text-2xl text-warmGray-700 truncate whitespace-pre"><%= article.getNomArticle() %></span>
                                </div>
                            </div>
                            <%}%>                            
                            </div>
                        </div>
                        <!-- footer -->
                        <div class="w-full p-10 rounded-40 bg-warmGray-50 text-center">
                            <span class="font-Kollektif font-normal text-warmGray-700 tracking-wide text-lg">Made with 💜 by Ali HMIMS</span>
                        </div>
                </div>
                    <!-- Side bar -->
                    <div id="sideBar" class="w-650 bg-white sticky top-9 border-3 border-coolGray-100 rounded-40 py-9 px-11 hidden" style="height: fit-content;">
                        <!-- Product details -->
                        <div id="state_1" class="w-full h-full flex flex-col space-y-5">
                            <!-- image -->
                            <div class="w-4/6 h-auto mx-auto">
                                <img id="af_img" src="../../images/1358355462-tgj460a.jpg" alt="">
                            </div>
                            <!-- Name -->
                            <div class="flex flex-row items-center">
                                <span id="af_name" class="font-Kollektif font-bold text-4xl text-coolGray-800 truncate whitespace-pre">Tail Raku Vase</span>
                            </div>
                            <!-- Desc -->
                            <div class="pr-3 max-h-28 overflow-y-auto scrollbar-thumb-rounded scrollbar-thin scrollbar-thumb-coolGray-300 hover:scrollbar-thumb-coolGray-400 scrollbar-track-coolGray-100">
                                <span id="af_desc" class="font-SourceSansPro font-normal text-coolGray-600 text-lg">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer lacus, ante ultricies nibh diam facilisis accumsan, morbi vulputate. Nisi, eget Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer lacus, ante ultricies nibh diam facilisis accumsan, morbi vulputate. Nisi, eget netus facilisi amet velit semper facilisi nunc vitae. Sodales feugiat tempus semper diam ornare vivamus aliquam faucibus magna. Felis nisl egestas nunc etiam pretium donec cum.</span>
                            </div>
                            <!-- More -->
                            <div class="flex flex-row h-20 space-x-4" style="margin-top: 35px;">
                                <!-- Prix -->
                                <div class="rounded-3xl py-2 px-5 bg-amber-100 flex flex-col justify-center items-center font-SourceSansPro text-amber-600">
                                    <span class="flex flex-row items-baseline">
                                        <span id="af_votesNb" class="text-3xl font-semibold">99</span>
                                        <span class="text-lg">DH</span>
                                    </span>
                                </div>
                                <!-- NB produits -->
                                <div class="rounded-3xl py-2 px-5 bg-violet-100 flex flex-col justify-center items-center font-SourceSansPro text-violet-600">
                                    <span class="text-base">Quantité en stock</span>
                                    <span id="af_nbProduits" class="text-3xl font-semibold">13</span>
                                </div>
                                <!-- NB likes -->
                                <!-- TO-DO -->
                                <!-- Vote btn -->
                                <button id="af_voteBtn" class="flex-1 rounded-3xl py-2 px-5 bg-rose-100 flex flex-col justify-center font-SourceSansPro text-rose-600 relative cursor-pointer">
                                    <span class="text-2xl font-semibold ml-8">Annuler</span>
                                    <img src="./img/Saly-26.png" alt="" class="absolute w-20 bottom-2.5 right-5">
                                </button>
                                <!-- <button class="flex-1 rounded-3xl py-2 px-5 bg-coolGray-900 flex flex-col justify-center items-center font-SourceSansPro text-white cursor-pointer">
                                <span class="text-2xl font-semibold">Voter</span>
                            </button> -->
                            </div>
                        </div>
                        <!-- EDIT / ADD -->
                        <% if(user.getRoleUtilisateur().equals("admin")){ %>
                            <div id="state_2" class="w-full h-full flex flex-col space-y-13">
                                <!-- title EDIT-->
                                <div class="flex flex-row items-center">
                                    <span class="py-5 px-9 rounded-3xl bg-orange-100 mr-8">
                                        <svg width="44" height="44" viewBox="0 0 44 44" fill="none" xmlns="http://www.w3.org/2000/svg">
                                            <path d="M11.0001 6.6001C9.83315 6.6001 8.71399 7.06367 7.88883 7.88883C7.06367 8.71399 6.6001 9.83315 6.6001 11.0001V15.4001C6.6001 16.5671 7.06367 17.6862 7.88883 18.5114C8.71399 19.3365 9.83315 19.8001 11.0001 19.8001H15.4001C16.5671 19.8001 17.6862 19.3365 18.5114 18.5114C19.3365 17.6862 19.8001 16.5671 19.8001 15.4001V11.0001C19.8001 9.83315 19.3365 8.71399 18.5114 7.88883C17.6862 7.06367 16.5671 6.6001 15.4001 6.6001H11.0001ZM11.0001 24.2001C9.83315 24.2001 8.71399 24.6637 7.88883 25.4888C7.06367 26.314 6.6001 27.4331 6.6001 28.6001V33.0001C6.6001 34.1671 7.06367 35.2862 7.88883 36.1114C8.71399 36.9365 9.83315 37.4001 11.0001 37.4001H15.4001C16.5671 37.4001 17.6862 36.9365 18.5114 36.1114C19.3365 35.2862 19.8001 34.1671 19.8001 33.0001V28.6001C19.8001 27.4331 19.3365 26.314 18.5114 25.4888C17.6862 24.6637 16.5671 24.2001 15.4001 24.2001H11.0001ZM24.2001 11.0001C24.2001 9.83315 24.6637 8.71399 25.4888 7.88883C26.314 7.06367 27.4332 6.6001 28.6001 6.6001H33.0001C34.1671 6.6001 35.2862 7.06367 36.1114 7.88883C36.9365 8.71399 37.4001 9.83315 37.4001 11.0001V15.4001C37.4001 16.5671 36.9365 17.6862 36.1114 18.5114C35.2862 19.3365 34.1671 19.8001 33.0001 19.8001H28.6001C27.4332 19.8001 26.314 19.3365 25.4888 18.5114C24.6637 17.6862 24.2001 16.5671 24.2001 15.4001V11.0001Z" fill="#EA580C" />
                                            <path d="M36.9308 24.069C36.6308 23.7691 36.2239 23.6006 35.7996 23.6006C35.3753 23.6006 34.9685 23.7691 34.6684 24.069L28.5996 30.1378V32.4002H30.862L36.9308 26.3314C37.2308 26.0314 37.3993 25.6245 37.3993 25.2002C37.3993 24.776 37.2308 24.3691 36.9308 24.069Z" fill="#EA580C" />
                                            <path fill-rule="evenodd" clip-rule="evenodd" d="M24.5996 26.8002C24.5996 26.3758 24.7682 25.9689 25.0682 25.6688C25.3683 25.3688 25.7753 25.2002 26.1996 25.2002H29.3996C29.6118 25.2002 29.8153 25.2845 29.9653 25.4345C30.1153 25.5845 30.1996 25.788 30.1996 26.0002C30.1996 26.2124 30.1153 26.4159 29.9653 26.5659C29.8153 26.7159 29.6118 26.8002 29.3996 26.8002H26.1996V34.8002H34.1996V31.6002C34.1996 31.388 34.2839 31.1845 34.4339 31.0345C34.584 30.8845 34.7874 30.8002 34.9996 30.8002C35.2118 30.8002 35.4153 30.8845 35.5653 31.0345C35.7153 31.1845 35.7996 31.388 35.7996 31.6002V34.8002C35.7996 35.2245 35.631 35.6315 35.331 35.9316C35.0309 36.2316 34.624 36.4002 34.1996 36.4002H26.1996C25.7753 36.4002 25.3683 36.2316 25.0682 35.9316C24.7682 35.6315 24.5996 35.2245 24.5996 34.8002V26.8002Z" fill="#EA580C" />
                                        </svg>
                                    </span>
                                    <span class="font-Kollektif font-bold tracking-tight text-coolGray-800 text-5xl">Modifier l’article</span>
                                </div>
                                <!-- title ADD-->
                                <div class="flex flex-row items-center">
                                    <span class="py-5 px-9 rounded-3xl bg-emerald-100 mr-8">
                                        <svg width="44" height="44" viewBox="0 0 44 44" fill="none" xmlns="http://www.w3.org/2000/svg">
                                            <path d="M11.0001 6.6001C9.83315 6.6001 8.71399 7.06367 7.88883 7.88883C7.06367 8.71399 6.6001 9.83315 6.6001 11.0001V15.4001C6.6001 16.5671 7.06367 17.6862 7.88883 18.5114C8.71399 19.3365 9.83315 19.8001 11.0001 19.8001H15.4001C16.5671 19.8001 17.6862 19.3365 18.5114 18.5114C19.3365 17.6862 19.8001 16.5671 19.8001 15.4001V11.0001C19.8001 9.83315 19.3365 8.71399 18.5114 7.88883C17.6862 7.06367 16.5671 6.6001 15.4001 6.6001H11.0001ZM11.0001 24.2001C9.83315 24.2001 8.71399 24.6637 7.88883 25.4888C7.06367 26.314 6.6001 27.4331 6.6001 28.6001V33.0001C6.6001 34.1671 7.06367 35.2862 7.88883 36.1114C8.71399 36.9365 9.83315 37.4001 11.0001 37.4001H15.4001C16.5671 37.4001 17.6862 36.9365 18.5114 36.1114C19.3365 35.2862 19.8001 34.1671 19.8001 33.0001V28.6001C19.8001 27.4331 19.3365 26.314 18.5114 25.4888C17.6862 24.6637 16.5671 24.2001 15.4001 24.2001H11.0001ZM24.2001 11.0001C24.2001 9.83315 24.6637 8.71399 25.4888 7.88883C26.314 7.06367 27.4332 6.6001 28.6001 6.6001H33.0001C34.1671 6.6001 35.2862 7.06367 36.1114 7.88883C36.9365 8.71399 37.4001 9.83315 37.4001 11.0001V15.4001C37.4001 16.5671 36.9365 17.6862 36.1114 18.5114C35.2862 19.3365 34.1671 19.8001 33.0001 19.8001H28.6001C27.4332 19.8001 26.314 19.3365 25.4888 18.5114C24.6637 17.6862 24.2001 16.5671 24.2001 15.4001V11.0001ZM30.8001 24.2001C31.3836 24.2001 31.9432 24.4319 32.3557 24.8445C32.7683 25.257 33.0001 25.8166 33.0001 26.4001V28.6001H35.2001C35.7836 28.6001 36.3432 28.8319 36.7557 29.2445C37.1683 29.657 37.4001 30.2166 37.4001 30.8001C37.4001 31.3836 37.1683 31.9432 36.7557 32.3557C36.3432 32.7683 35.7836 33.0001 35.2001 33.0001H33.0001V35.2001C33.0001 35.7836 32.7683 36.3432 32.3557 36.7557C31.9432 37.1683 31.3836 37.4001 30.8001 37.4001C30.2166 37.4001 29.657 37.1683 29.2445 36.7557C28.8319 36.3432 28.6001 35.7836 28.6001 35.2001V33.0001H26.4001C25.8166 33.0001 25.257 32.7683 24.8445 32.3557C24.4319 31.9432 24.2001 31.3836 24.2001 30.8001C24.2001 30.2166 24.4319 29.657 24.8445 29.2445C25.257 28.8319 25.8166 28.6001 26.4001 28.6001H28.6001V26.4001C28.6001 25.8166 28.8319 25.257 29.2445 24.8445C29.657 24.4319 30.2166 24.2001 30.8001 24.2001Z" fill="#059669" />
                                        </svg>
                                    </span>
                                    <span class="font-Kollektif font-bold tracking-tight text-coolGray-800 text-5xl">Ajouter un article</span>
                                </div>
                                <!--  -->
                                <!-- Form -->
                                <div class="w-full flex flex-col space-y-7">
                                    <input id="_article_name" type="text" placeholder="Nom" class="w-full py-5 px-7 rounded-2xl bg-coolGray-100 font-SourceSansPro font-normal text-lg text-coolGray-700 placeholder-coolGray-400">
                                    <!-- Row -->
                                    <div class="w-full flex flex-row space-x-7">
                                        <input id="_article_price" type="text" placeholder="Prix" class="w-full py-5 px-7 rounded-2xl bg-coolGray-100 font-SourceSansPro font-normal text-lg text-coolGray-700 placeholder-coolGray-400">
                                        <input id="_article_nb" type="text" placeholder="Quantité en stock" class="w-full py-5 px-7 rounded-2xl bg-coolGray-100 font-SourceSansPro font-normal text-lg text-coolGray-700 placeholder-coolGray-400">
                                    </div>
                                    <textarea name="_article_desc" id="_article_desc" placeholder="Déscription" class="w-full h-40 min-h-full max-h-40 py-5 px-7 rounded-2xl bg-coolGray-100 font-SourceSansPro font-normal text-lg text-coolGray-700 placeholder-coolGray-400"></textarea>
                                    <!-- image input -->
                                    <label for="_article_img" class="rounded-2xl flex flex-col items-center justify-center w-full cursor-pointer py-6 px-9 border-3 border-dashed border-coolGray-100">
                                        <span class="font-SourceSansPro font-semibold text-coolGray-400 text-xl">Ajouter une photo d’article</span>
                                        <svg class="mt-2.5" width="46" height="46" viewBox="0 0 46 46" fill="none" xmlns="http://www.w3.org/2000/svg">
                                            <path fill-rule="evenodd" clip-rule="evenodd" d="M23 11.5C23.61 11.5 24.195 11.7423 24.6263 12.1737C25.0577 12.605 25.3 13.19 25.3 13.8V20.7H32.2C32.81 20.7 33.395 20.9423 33.8263 21.3737C34.2577 21.805 34.5 22.39 34.5 23C34.5 23.61 34.2577 24.195 33.8263 24.6263C33.395 25.0577 32.81 25.3 32.2 25.3H25.3V32.2C25.3 32.81 25.0577 33.395 24.6263 33.8263C24.195 34.2577 23.61 34.5 23 34.5C22.39 34.5 21.805 34.2577 21.3737 33.8263C20.9423 33.395 20.7 32.81 20.7 32.2V25.3H13.8C13.19 25.3 12.605 25.0577 12.1737 24.6263C11.7423 24.195 11.5 23.61 11.5 23C11.5 22.39 11.7423 21.805 12.1737 21.3737C12.605 20.9423 13.19 20.7 13.8 20.7H20.7V13.8C20.7 13.19 20.9423 12.605 21.3737 12.1737C21.805 11.7423 22.39 11.5 23 11.5Z" fill="#9CA3AF" />
                                        </svg>
                                    </label>
                                    <input type="file" name="_article_img" id="_article_img" class="hidden">
                                    <!-- Btn-->
                                    <button id="_article_validate" class="w-full p-7 rounded-20 font-Kollektif font-bold text-white text-2xl bg-coolGray-900">Ajouter</button>
                                </div>
                            </div>
                            <% } %>
                        </div>
                    </div>
                </div>
            </div>
            <script src="js/axios.min.js"></script>
            <script src="js/articles.js"></script>
            <script src="js/articles_<%= user.getRoleUtilisateur().equals("client") ? "CLIENT" : "ADMIN" %>.js"></script>
</body>

</html>