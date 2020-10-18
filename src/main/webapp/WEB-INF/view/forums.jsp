<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Layer7 | Forums</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/indexStyles.css">
    <link href="https://fonts.googleapis.com/css2?family=Piazzolla:wght@100&display=swap" rel="stylesheet">
</head>
<body>
    <div id="particles-js"></div>
    <nav class="navbar">
        <ul id="navlinks">
            <li><a class="links" href="/links">Links</a></li>
            <li><a class="links" href="/playlists">Playlists</a></li>
            <li><a class="links active-nav" href="">Forums</a></li>
            <li><a class="links" href="/users">Users</a></li>
            <li><a class="links" href="/profile">Profile</a></li>
        </ul>
        <span class="nav-add-content"><a href="/addPost" class="links" id="nav-add">Add post</a></span>
    </nav>
    <h1 id="hero-text">Forums</h1>
    <hr>
    <div class="post-container">
        <c:forEach var="post" items="${posts}">
            <div class="post">
                <div class="post-header">
                    <a class="post-title" href="/forums/${post.id}">${post.title}</a>
                </div>
                <div class="post-content">
                        ${fn:substring(post.content,0,300)}
                </div>
                <div class="post-interactions">
                </div>
            </div>
        </c:forEach>
    </div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/particles.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/app.js"></script>
</body>
</html>