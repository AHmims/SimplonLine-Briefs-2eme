<%@ page import="beans.Article" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.Vote" %>
<%@ page import="beans.Utilisateur" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
</head>

<body>
    <span>${__user_in}</span>
    <h1>ARTICLES</h1>
    <% Utilisateur user = (Utilisateur) request.getSession(false).getAttribute("__user_data"); %>
    <% for (Article article : (ArrayList<Article>) request.getAttribute("_articles_data")) { %>
        <% boolean voted = false; %>
        <% for (Vote vote : (ArrayList<Vote>) request.getAttribute("_votes_data")){ %>
            <% if(vote.getIdArticle() == article.getIdarticle()){ %>
                <% voted = true; %>
            <% } %>
        <% } %>
        <div class="articleCard">
            <img src="<%= article.getImageArticle() %>" width="100px">
            <span><%= article.getNomArticle() %></span>
            <span><%= article.getPrixArticle() %>DH</span>
            <% if(user.getRoleUtilisateur().equals("client")){ %>
                <button class="voteBtn" data-article="<%= article.getIdarticle() %>" data-toggle="<%=voted %>">
                    <span><%= voted ? "unVOTE" : "VOTE"%></span>
                </button>
            <% }else { %>
                <div>
                    <button class="editBtn" data-article="<%= article.getIdarticle() %>">Edit</button>
                    <button class="deleteBtn">Delete</button>
                </div>
            <% } %>
        </div>
    <%}%>
    <script src="js/axios.min.js"></script>
    <script src="js/articles_<%= user.getRoleUtilisateur().equals("client") ? "CLIENT" : "ADMIN" %>.js"></script>
</body>
</html>