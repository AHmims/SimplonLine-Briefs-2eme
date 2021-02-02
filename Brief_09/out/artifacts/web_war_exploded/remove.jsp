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
    <% if (request.getAttribute("remove_res") != null) { %>
    <% boolean res = Boolean.parseBoolean((String) request.getAttribute("remove_res")); %>
    <% if (res) { %>
    <div>Removed</div>
    <% } else { %>
    <div>Not Removed</div>
    <% } %>
    <% } %>
    <form method="POST">
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
        <button>Remove</button>
    </form>
</body>

</html>