<%--
  Created by IntelliJ IDEA.
  User: Ali HMIMS
  Date: 2/1/2021
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
</head>

<body>
<% if (request.getAttribute("insert_res") != null) { %>
<% boolean res = Boolean.parseBoolean((String) request.getAttribute("insert_res")); %>
<% if (res) { %>
<div>Added</div>
<% } else { %>
<div>Not added</div>
<% } %>
<% } %>
<form method="POST">
    <table>
        <tr>
            <td><Label for="input_nom">Nom:</Label></td>
            <td><input type="text" name="input_nom" id="input_nom"></td>
        </tr>
        <tr>
            <td><Label for="input_cap">Capacité:</Label></td>
            <td><input type="text" name="input_cap" id="input_cap"></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <Button>Add</Button>
            </td>
        </tr>
    </table>
</form>
</body>

</html>