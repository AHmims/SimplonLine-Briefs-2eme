<%@ page import="model.Pepiniere" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Ali HMIMS
  Date: 2/2/2021
  Time: 9:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
    <!--  -->
    <jsp:include page="components/navbar.jsp" />
    <!--  -->
    <div class="px-24 lg:px-32 xl:px-96 w-full">
        <% if (request.getAttribute("remove_res") != null) { %>
        <% boolean res = Boolean.parseBoolean((String) request.getAttribute("remove_res")); %>
        <div class="flex flex-col items-center">
            <% if (res) { %>
            <span class="py-4 px-12 bg-green-100 rounded-lg ring-4 ring-green-400 ring-inset text-green-900 font-medium mb-4 -mt-4">Pepiniere supprimé avec succès</span>
            <% } else { %>
            <span class="py-4 px-12 bg-red-100 rounded-lg ring-4 ring-red-400 ring-inset text-red-900 font-medium mb-4 -mt-4">Pepiniere n'a pas été supprimé</span>
            <% } %>
        </div>
        <% } %>
        <form method="POST" class="flex flex-col rounded-2xl border border-gray-300 p-12 items-center">
            <div class="mb-4">
                <label for="input_value" class="mr-2">Pepiniere: </label>
                <select name="input_value" id="input_value" class="p-2 border border-gray-200 rounded-md">
                    <% if (request.getAttribute("pepinieres") != null) { %>
                    <% for (Pepiniere pep : (ArrayList<Pepiniere>) request.getAttribute("pepinieres")) { %>
                    <option value="<%= pep.getIdPepiniere() %>">
                        <%= pep.getNomPepiniere() %>
                    </option>
                    <% } %>
                    <% } %>
                </select>
            </div>
            <button class="py-4 px-6 border border-gray-300 rounded-lg mt-4">Supprimer</button>
        </form>
    </div>
</body>

</html>