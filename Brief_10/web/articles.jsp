<%@ page import="beans.Article" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.Vote" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
</head>

<body>
    <span>${__user_in}</span>
    <h1>ARTICLES</h1>
    <% for (Article article : (ArrayList<Article>) request.getAttribute("_articles_data")) { %>
        <% boolean voted = false; %>
        <% for (Vote vote : (ArrayList<Vote>) request.getAttribute("_votes_data")){ %>
            <% if(vote.getIdArticle() == article.getIdarticle()){ %>
                <% voted = true; %>
            <% } %>
        <% } %>
        <div data-article="<%= article.getIdarticle() %>">
            <img src="<%= article.getImageArticle() %>" width="100px">
            <span><%= article.getNomArticle() %></span>
            <span><%= article.getPrixArticle() %>DH</span>
            <button class="voteBtn" data-toggle="<%=voted %>">
                <span><%= voted ? "unVOTE" : "VOTE"%></span>
            </button>
        </div>
    <%}%>
    <script src="js/axios.min.js"></script>
    <script src="js/articles.js"></script>
</body>
</html>