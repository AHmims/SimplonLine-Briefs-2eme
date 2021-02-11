<%@ page import="beans.Article" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
    <script src="js/axios.min.js"></script>
    <script src="./js/articles.js"></script>

</head>

<body>
    <span>${__user_in}</span>
    <h1>ARTICLES</h1>
    <% for (Article article : (ArrayList<Article>) request.getAttribute("_articles_data")) { %>
    <div data-article="<%= article.getIdarticle() %>">
        <img src="<%= article.getImageArticle() %>" width="100px">
        <span><%= article.getNomArticle() %></span>
        <span><%= article.getPrixArticle() %>DH</span>
        <button onclick="voteArticle()">
            <span>VOTE</span>
        </button>
    </div>
    <%}%>
</body>
</html>