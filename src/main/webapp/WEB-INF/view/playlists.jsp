<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Layer7 | Playlists</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/indexStyles.css">
    <link href="https://fonts.googleapis.com/css2?family=Piazzolla:wght@100&display=swap" rel="stylesheet">
</head>
<body>
<div id="particles-js"></div>
<nav class="navbar">
    <ul id="navlinks">
        <li><a class="links" href="/links">Links</a></li>
        <li><a class="links active-nav" href="/playlists">Playlists</a></li>
        <li><a class="links" href="/forums">Forums</a></li>
        <li><a class="links" href="/users">Users</a></li>
        <li><a class="links" href="/profile">Profile</a></li>
    </ul>
    <span class="nav-add-content"><a href="/addPlaylist" class="links" id="nav-add">Add Playlist</a></span>
</nav>
<h1 id="hero-text">Playlists</h1>
<hr>
<div class="playlist-container">
    <c:forEach var="playlist" items="${playlists}">
        <div class="playlist">
            <div class="playlist-frame">
                <iframe src="${playlist.playlistLink}" title="Playlist"></iframe>
            </div>
            <div class="playlist-genre">${playlist.genre}</div>
        </div>
    </c:forEach>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/particles.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/app.js"></script>
</body>
</html>