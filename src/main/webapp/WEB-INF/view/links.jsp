<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Layer7 | Links</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/indexStyles.css">
    <link href="https://fonts.googleapis.com/css2?family=Piazzolla:wght@100&display=swap" rel="stylesheet">
</head>
<body>
<div id="particles-js"></div>
<nav class="navbar">
    <ul id="navlinks">
        <li><a class="links active-nav" href="/links">Links</a></li>
        <li><a class="links" href="/playlists">Playlists</a></li>
        <li><a class="links" href="/forums">Forums</a></li>
        <li><a class="links" href="/users">Users</a></li>
        <li><a class="links" href="/profile">Profile</a></li>
    </ul>
    <span class="nav-add-content"><a href="/addLink" class="links" id="nav-add">Add Link</a></span>
</nav>
<h1 id="hero-text">Links</h1>
<hr>
<div class="links-container">
    <c:forEach var="link" items="${links}">
        <div class="link">
            <div class="link-name">
                ${link.groupName}
            </div>
            <div class="link-desc">
                ${link.description}
            </div>
            <a class="link-btn" href="${link.link}" target="_blank">Open Link</a>
        </div>
    </c:forEach>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/particles.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/app.js"></script>
</body>
</html>