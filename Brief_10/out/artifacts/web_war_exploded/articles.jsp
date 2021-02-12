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
            <img src="<%= article.getImageArticle() %>" width="100px" class="articleCard_image">
            <span class="articleCard_name"><%= article.getNomArticle() %></span>
            <span class="articleCard_price"><%= article.getPrixArticle() %>DH</span>
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
    <div>
        <input type="text" id="_article_name" placeholder="nom article">
        <input type="text" id="_article_price" placeholder="prix article">
        <input type="text" id="_article_nb" placeholder="nb article">
        <textarea id="_article_desc" placeholder="desc article"></textarea>
        <input type="file" id="_article_img" placeholder="image article">
        <button id="_article_validate">add / edit</button>
    </div>
    <script src="js/axios.min.js"></script>
    <script src="js/articles_<%= user.getRoleUtilisateur().equals("client") ? "CLIENT" : "ADMIN" %>.js"></script>
</body>

</html>