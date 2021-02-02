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
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
    <!--  -->
    <jsp:include page="components/navbar.jsp" />
    <!--  -->
    <div class="px-24 lg:px-32 xl:px-96 w-full max-w-8xl mx-auto">
        <% if (request.getAttribute("insert_res") != null) { %>
        <% boolean res = Boolean.parseBoolean((String) request.getAttribute("insert_res")); %>
        <div class="flex flex-col items-center">
            <% if (res) { %>
            <span class="py-4 px-12 bg-green-100 rounded-lg ring-4 ring-green-400 ring-inset text-green-900 font-medium mb-4 -mt-4">Element ajoute avec succès</span>
            <% } else { %>
            <span class="py-4 px-12 bg-red-100 rounded-lg ring-4 ring-red-400 ring-inset text-red-900 font-medium mb-4 -mt-4">Element n'a pas été ajoutée</span>
            <% } %>
        </div>
        <% } %>
        <form method="POST" class="flex flex-col rounded-2xl border border-gray-300 p-12 items-center">
            <div class="mb-2">
                <Label for="input_nom">Nom:</Label>
                <input type="text" name="input_nom" id="input_nom" class="border border-gray-300 rounded-md pl-2 text-sm ml-2 py-1">
            </div>
            <div class="mb-2">
                <Label for="input_cap">Capacité:</Label>
                <input type="text" name="input_cap" id="input_cap" class="border border-gray-300 rounded-md pl-2 text-sm ml-2 py-1">
            </div>
            <Button class="py-4 px-6 border border-gray-300 rounded-lg mt-4">Ajouter</Button>
        </form>
    </div>
</body>

</html>