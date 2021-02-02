<%@ page import="model.Pepiniere" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Ali HMIMS
  Date: 2/1/2021
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Rechercher</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
    <!--  -->
    <jsp:include page="components/navbar.jsp" />
    <!--  -->
    <div class="px-24 lg:px-32 xl:px-96 w-full max-w-8xl mx-auto">
        <form method="POST" class="flex flex-col rounded-2xl border border-gray-300 p-12 items-center">
            <div class="mb-4">
                <label for="input_value" class="mr-2">ID Pepiniere:</label>
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
            <button class="py-4 px-6 border border-gray-300 rounded-lg mt-4">rechercher</button>
        </form>
        <% if (request.getAttribute("pepiniere") != null) { Pepiniere pepiniere = (Pepiniere) request.getAttribute("pepiniere");%>
        <div class="w-80 flex flex-col border border-gray-300 rounded-lg p-4 mx-auto">
            <span class="font-medium text-lg text-gray-700 mb-1"><%= pepiniere.getNomPepiniere() %></span>
            <span class="text-gray-600">Id: <%= pepiniere.getIdPepiniere() %></span>
            <span class="text-gray-600">Capacité: <%= pepiniere.getCapacitePepiniere() %></span>
        </div>
        <% } %>
    </div>
</body>

</html>