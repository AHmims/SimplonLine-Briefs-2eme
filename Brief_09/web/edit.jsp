<%@ page import="model.Pepiniere" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Ali HMIMS
  Date: 2/2/2021
  Time: 9:08 AM
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
    <% if (request.getAttribute("edit_res") != null) { %>
    <% boolean res = Boolean.parseBoolean((String) request.getAttribute("edit_res")); %>
    <% if (res) { %>
    <div>Modified</div>
    <% } else { %>
    <div>Not Modified</div>
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
        <div>
            <label for="nom_p">Nom Pepiniere: </label>
            <input type="text" name="nom_p" id="nom_p">
        </div>
        <div>
            <label for="cap_p">Capacite Pepiniere: </label>
            <input type="text" name="cap_p" id="cap_p">
        </div>
        <button>Edit</button>
    </form>
</body>

</html>