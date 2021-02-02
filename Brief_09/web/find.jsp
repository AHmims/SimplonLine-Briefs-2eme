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
    <form method="POST" class="w-10/12 mx-auto">
        <label for="input_value">ID Pepiniere</label>
        <select name="input_value" id="input_value">
            <% if (request.getAttribute("pepinieres") != null) { %>
            <% for (Pepiniere pep : (ArrayList<Pepiniere>) request.getAttribute("pepinieres")) { %>
            <option value="<%= pep.getIdPepiniere() %>">
                <%= pep.getNomPepiniere() %>
            </option>
            <% } %>
            <% } %>
        </select>
        <button>Find</button>
    </form>
    <% if (request.getAttribute("pepiniere") != null) {
    Pepiniere pepiniere = (Pepiniere) request.getAttribute("pepiniere");%>
    <table border="1">
        <thead>
            <th>Id</th>
            <th>Nom</th>
            <th>Capacité</th>
        </thead>
        <tr>
            <td><%= pepiniere.getIdPepiniere() %>
            </td>
            <td><%= pepiniere.getNomPepiniere() %>
            </td>
            <td><%= pepiniere.getCapacitePepiniere() %>
            </td>
        </tr>
    </table>
    <% } %>
</body>

</html>