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
            <label for="identifiant">Identifiant: </label>
            <input type="text" name="identifiant" id="identifiant">
        </div>
        <div>
            <label for="mdp">Password: </label>
            <input type="password" name="mdp" id="mdp">
        </div>
        <button>Login</button>
    </form>
</body>

</html>