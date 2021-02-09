<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Home</title>
</head>

<body>
    <jsp:include page="layout/navbar_common.jsp" />
    <!--  -->
    <h1>Login</h1>
    <form method="POST">
        <div>
            <label for="email">Identifiant: </label>
            <input type="text" name="email" id="email">
        </div>
        <div>
            <label for="password">Password: </label>
            <input type="password" name="password" id="password">
        </div>
        <button>Login</button>
    </form>
</body>

</html>