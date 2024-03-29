<%--
  Created by IntelliJ IDEA.
  User: Ali HMIMS
  Date: 2/15/2021
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./css/style.css">
  <link rel="stylesheet" href="./css/toast.css">
  <script src="./js/toast.js"></script>
  <script src="./js/toastsHandler.js"></script>
  <title>S'enregistrer</title>
</head>

<body class="bg-white p-9 h-screen">
  <% if(request.getAttribute("_server_error") == "unknown"){ %>
  <script>
    logServerError();
  </script>
  <% }else{ %>
  <% if(request.getAttribute("_email_value") != null){ %>
  <script>
    logErrorActive("Form invalide");
  </script>
  <% } %>
  <% } %>
  <div class="w-full h-full flex flex-col">
    <!-- banner -->
    <div class="w-full h-full flex flex-col space-y-16 px-16 pt-12 relative">
      <!-- navBar -->
      <div class="w-full flex flex-row items-center justify-between">
        <svg width="116" height="28" viewBox="0 0 116 28" fill="none" xmlns="http://www.w3.org/2000/svg">
          <path d="M16.928 13.86C17.936 14.46 18.704 15.228 19.232 16.164C19.76 17.1 20.024 18.18 20.024 19.404C20.024 20.556 19.748 21.636 19.196 22.644C18.644 23.628 17.864 24.504 16.856 25.272C15.944 25.968 14.9 26.508 13.724 26.892C12.572 27.252 11.348 27.444 10.052 27.468C8.756 27.468 7.52 27.288 6.344 26.928C5.168 26.568 4.124 26.028 3.212 25.308C1.844 24.276 0.908 23.028 0.404 21.564L5.444 19.224C5.444 19.464 5.528 19.764 5.696 20.124C5.864 20.484 6.128 20.832 6.488 21.168C6.848 21.504 7.316 21.792 7.892 22.032C8.468 22.272 9.176 22.392 10.016 22.392C10.688 22.392 11.276 22.308 11.78 22.14C12.308 21.972 12.74 21.768 13.076 21.528C13.436 21.264 13.7 20.976 13.868 20.664C14.06 20.328 14.156 19.992 14.156 19.656C14.156 19.272 14.024 18.912 13.76 18.576C13.52 18.24 13.136 17.976 12.608 17.784C11.648 17.448 10.628 17.172 9.548 16.956C8.492 16.716 7.46 16.428 6.452 16.092C5.444 15.732 4.508 15.264 3.644 14.688C2.78 14.112 2.096 13.308 1.592 12.276C1.136 11.364 0.908 10.392 0.908 9.36C0.908 8.208 1.172 7.092 1.7 6.012C2.252 4.932 2.996 4.02 3.932 3.276C4.82 2.58 5.816 2.052 6.92 1.692C8.024 1.308 9.188 1.116 10.412 1.116C11.636 1.116 12.8 1.296 13.904 1.656C15.032 2.016 16.04 2.544 16.928 3.24C17.792 3.888 18.476 4.644 18.98 5.508L14.876 8.316C14.372 7.62 13.736 7.068 12.968 6.66C12.224 6.228 11.384 6.012 10.448 6.012C9.152 6.012 8.144 6.3 7.424 6.876C6.728 7.452 6.38 8.208 6.38 9.144C6.38 9.576 6.572 9.96 6.956 10.296C7.364 10.632 7.88 10.932 8.504 11.196C9.152 11.46 9.872 11.7 10.664 11.916C11.456 12.108 12.236 12.312 13.004 12.528C13.796 12.72 14.54 12.924 15.236 13.14C15.932 13.356 16.496 13.596 16.928 13.86ZM38.8596 13.104C39.8676 13.8 40.6716 14.7 41.2716 15.804C41.8716 16.884 42.1716 18.084 42.1716 19.404C42.1716 20.46 41.9676 21.456 41.5596 22.392C41.1516 23.304 40.5996 24.108 39.9036 24.804C39.2076 25.476 38.3916 26.016 37.4556 26.424C36.5436 26.808 35.5596 27 34.5036 27H22.9116V1.476H34.1436C35.1036 1.476 36.0036 1.668 36.8436 2.052C37.6836 2.412 38.4156 2.904 39.0396 3.528C39.6876 4.152 40.1916 4.884 40.5516 5.724C40.9116 6.564 41.0916 7.464 41.0916 8.424C41.0916 9.456 40.8876 10.368 40.4796 11.16C40.0956 11.928 39.5556 12.576 38.8596 13.104ZM28.3836 11.052H34.1436C34.7916 11.052 35.3436 10.824 35.7996 10.368C36.2556 9.912 36.4836 9.36 36.4836 8.712C36.4836 8.064 36.2556 7.524 35.7996 7.092C35.3436 6.66 34.7916 6.444 34.1436 6.444H28.3836V11.052ZM34.5036 22.068C35.2236 22.068 35.8356 21.768 36.3396 21.168C36.8436 20.544 37.0956 19.824 37.0956 19.008C37.0956 18.168 36.8436 17.46 36.3396 16.884C35.8356 16.308 35.2236 16.02 34.5036 16.02H28.3836V22.068H34.5036ZM63.7767 9.144V27H59.4927L58.9887 25.092C58.2927 26.028 57.4527 26.652 56.4687 26.964C55.5087 27.276 54.5007 27.432 53.4447 27.432C52.1727 27.432 50.9967 27.192 49.9167 26.712C48.8607 26.208 47.9367 25.536 47.1447 24.696C46.3527 23.832 45.7287 22.836 45.2727 21.708C44.8407 20.556 44.6247 19.332 44.6247 18.036C44.6247 16.74 44.8407 15.528 45.2727 14.4C45.7287 13.248 46.3527 12.252 47.1447 11.412C47.9367 10.548 48.8607 9.876 49.9167 9.396C50.9967 8.892 52.1727 8.64 53.4447 8.64C54.5967 8.64 55.6527 8.82 56.6127 9.18C57.5727 9.54 58.3647 10.116 58.9887 10.908L59.4927 9.144H63.7767ZM58.8087 18.108C58.8087 17.172 58.6767 16.392 58.4127 15.768C58.1727 15.12 57.8367 14.604 57.4047 14.22C56.9967 13.812 56.5047 13.524 55.9287 13.356C55.3767 13.164 54.7767 13.068 54.1287 13.068C53.4807 13.068 52.8687 13.2 52.2927 13.464C51.7407 13.728 51.2487 14.088 50.8167 14.544C50.3847 14.976 50.0487 15.504 49.8087 16.128C49.5687 16.728 49.4487 17.364 49.4487 18.036C49.4487 18.732 49.5687 19.38 49.8087 19.98C50.0487 20.58 50.3847 21.108 50.8167 21.564C51.2487 21.996 51.7407 22.344 52.2927 22.608C52.8687 22.872 53.4807 23.004 54.1287 23.004C55.4247 23.004 56.5167 22.608 57.4047 21.816C58.3167 21 58.7847 19.764 58.8087 18.108ZM76.931 8.64C78.107 8.64 79.199 8.892 80.207 9.396C81.239 9.876 82.127 10.548 82.871 11.412C83.615 12.252 84.191 13.248 84.599 14.4C85.031 15.528 85.247 16.74 85.247 18.036V27H80.387V23.724C80.387 22.812 80.387 21.876 80.387 20.916C80.411 19.932 80.423 19.092 80.423 18.396C80.423 17.724 80.315 17.064 80.099 16.416C79.883 15.768 79.583 15.204 79.199 14.724C78.815 14.22 78.359 13.824 77.831 13.536C77.327 13.224 76.787 13.068 76.211 13.068C75.659 13.068 75.131 13.176 74.627 13.392C74.123 13.584 73.679 13.884 73.295 14.292C72.911 14.676 72.599 15.168 72.359 15.768C72.143 16.368 72.035 17.076 72.035 17.892V27H67.031V0.719999H72.035V10.512C72.659 9.912 73.367 9.456 74.159 9.144C74.975 8.808 75.899 8.64 76.931 8.64ZM93.0711 27H88.1031V9.144H93.0711V27ZM94.7271 1.44L92.4591 7.884H88.7871L89.2911 1.44H94.7271ZM115.597 9.144V27H111.313L110.809 25.092C110.113 26.028 109.273 26.652 108.289 26.964C107.329 27.276 106.321 27.432 105.265 27.432C103.993 27.432 102.817 27.192 101.737 26.712C100.681 26.208 99.757 25.536 98.965 24.696C98.173 23.832 97.549 22.836 97.093 21.708C96.661 20.556 96.445 19.332 96.445 18.036C96.445 16.74 96.661 15.528 97.093 14.4C97.549 13.248 98.173 12.252 98.965 11.412C99.757 10.548 100.681 9.876 101.737 9.396C102.817 8.892 103.993 8.64 105.265 8.64C106.417 8.64 107.473 8.82 108.433 9.18C109.393 9.54 110.185 10.116 110.809 10.908L111.313 9.144H115.597ZM110.629 18.108C110.629 17.172 110.497 16.392 110.233 15.768C109.993 15.12 109.657 14.604 109.225 14.22C108.817 13.812 108.325 13.524 107.749 13.356C107.197 13.164 106.597 13.068 105.949 13.068C105.301 13.068 104.689 13.2 104.113 13.464C103.561 13.728 103.069 14.088 102.637 14.544C102.205 14.976 101.869 15.504 101.629 16.128C101.389 16.728 101.269 17.364 101.269 18.036C101.269 18.732 101.389 19.38 101.629 19.98C101.869 20.58 102.205 21.108 102.637 21.564C103.069 21.996 103.561 22.344 104.113 22.608C104.689 22.872 105.301 23.004 105.949 23.004C107.245 23.004 108.337 22.608 109.225 21.816C110.137 21 110.605 19.764 110.629 18.108Z" fill="#292524" />
        </svg>
        <!-- nav links -->
        <div class="text-warmGray-700 font-Kollektif font-normal text-2xl flex flex-row space-x-10">
          <a href="/">
            <span>Accueil</span>
          </a>
          <a href="/articles">
            <span>Articles</span>
          </a>
          <a href="/authentification">
            <span>Authentification</span>
          </a>
          <a href="/register">
            <span class="text-amber-900 px-9 py-5 rounded-3xl bg-amber-200">Enregistrer</span>
          </a>
        </div>
      </div>
      <!-- content -->
      <div class="w-full h-full flex flex-row items-center justify-end">
        <!-- form -->
        <div class="px-36 space-y-10">
          <div class="w-456">
            <!-- header -->
            <div class="text-center">
              <h1 class="font-Kollektif text-5xl text-warmGray-900">Bienvenue sur SBahía</h1>
              <span class="font-SourceSansPro text-warmGray-700 mt-1 text-2xl">Créez votre compte, et commencez à explorer nos produits dès maintenant !</span>
            </div>
            <!-- form -->
            <form method="POST" class="w-full flex flex-col mt-10">
              <!-- row -->
              <div class="w-full flex flex-row space-x-3">
                <input value="<%= request.getAttribute("_nom_value") != null ? request.getAttribute("_nom_value") : "" %>" name="nom" type="text" placeholder="Nom" class="w-full py-5 px-7 rounded-20 bg-coolGray-100 font-SourceSansPro font-normal text-lg text-coolGray-700 placeholder-coolGray-500">
                <input value="<%= request.getAttribute("_prenom_value") != null ? request.getAttribute("_prenom_value") : "" %>" name="prenom" type="text" placeholder="Prénom" class="w-full py-5 px-7 rounded-20 bg-coolGray-100 font-SourceSansPro font-normal text-lg text-coolGray-700 placeholder-coolGray-500">
              </div>
              <div class="w-full flex flex-row space-x-3 mt-4 ">
                <input value="<%= request.getAttribute("_email_value") != null ? request.getAttribute("_email_value") : "" %>" name="email" type="text" placeholder="Email" class="w-full py-5 px-7 rounded-20 bg-coolGray-100 font-SourceSansPro font-normal text-lg text-coolGray-700 placeholder-coolGray-500">
                <select name="sexe" id="" class="w-auto py-5 px-7 rounded-20 bg-coolGray-100 font-SourceSansPro font-normal text-lg text-coolGray-700">
                  <option value="D" disabled selected>Sexe</option>
                  <option value="H">Homme</option>
                  <option value="F">Femme</option>
                  <option value="O">Autre</option>
                </select>
              </div>
              <input name="pass" type="password" placeholder="Mot de passe" class="mt-4 w-full py-5 px-7 rounded-20 bg-coolGray-100 font-SourceSansPro font-normal text-lg text-coolGray-700 placeholder-coolGray-500">
              <input name="passCon" type="password" placeholder="Confirmation de mot de passe" class="mt-4 w-full py-5 px-7 rounded-20 bg-coolGray-100 font-SourceSansPro font-normal text-lg text-coolGray-700 placeholder-coolGray-500">
              <button class="mt-10 p-6 bg-amber-200 text-amber-900 rounded-20 font-Kollektif font-normal text-2xl">Enregistrer</button>
            </form>
          </div>
        </div>
      </div>
      <!-- abs -->
      <div class="h-full w-719 rounded-40 bg-amber-100 absolute top-0 left-0 -z-1" style="margin: 0;">
        <div class="w-full h-full relative">
          <img src="./img/Saly-25.png" alt="" class="absolute max-w-none -bottom-36 -right-60">
        </div>
      </div>
    </div>
    <!-- white space -->
    <div class="h-14 flex-none"></div>
    <!-- footer -->
    <div class="w-full p-10 rounded-40 bg-warmGray-50 text-center">
      <span class="font-Kollektif font-normal text-warmGray-700 tracking-wide text-lg">Made with 💜 by Ali HMIMS</span>
    </div>
  </div>
</body>

</html>