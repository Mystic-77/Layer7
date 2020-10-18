<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Layer7 | New Playlist</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/indexStyles.css">
    <link href="https://fonts.googleapis.com/css2?family=Piazzolla:wght@100&display=swap" rel="stylesheet">
</head>
<body>
<div id="particles-js"></div>
<nav class="navbar">
    <ul id="navlinks">
        <li><a class="links" href="/links">Links</a></li>
        <li><a class="links" href="/playlists">Playlists</a></li>
        <li><a class="links" href="/forums">Forums</a></li>
        <li><a class="links" href="/users">Users</a></li>
        <li><a class="links" href="/profile">Profile</a></li>
    </ul>
</nav>
<h1 id="hero-text">New Playlist</h1>
<hr>

<%--@elvariable id="playlist" type="com.mystic.layer7.entity.Playlist"--%>
<form:form class="input-form" action="/addPlaylist" method="post" modelAttribute="playlist">
    <input type="text" class="form-fields" name="genre" placeholder="Genre"><br>
    <input type="text" class="form-fields" name="playlistLink" placeholder="Paste link here..."><br>
    <input type="submit" class="btn btn-submit" value="Add PlayList">
</form:form>
<script type="text/javascript" src="${pageContext.request.contextPath}/particles.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/app.js"></script>
</body>
</html>