<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profile | ${user.username}</title>
    <link rel="stylesheet" href="indexStyles.css">
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
            <li><a class="links active-nav" href="">Profile</a></li>
        </ul>
    </nav>
    <h1 id="hero-text">Profile</h1>
    <hr>
    <div class="user-details">
        <span class="labels">Username   : </span><span class="info">${user.username}</span><br>
        <span class="labels">First Name : </span><span class="info">${user.firstName}</span><br>
        <span class="labels">Last Name  : </span><span class="info">${user.lastName}</span><br>
        <span class="labels">Email Id   : </span><span class="info">${user.email}</span><br>
        <span class="labels">Role      : </span><span class="info">${user.role}</span><br>
    </div>
<%--    //add a feature to change details/pswd later on--%>
    <div class="buttons">
        <a href="/editProfile" class="btn-profile">Edit Details</a>
        <a href="/changePassword" class="btn-profile">Change Password</a>
    </div>

    <h1 id="myposts">My Posts</h1>
    <hr>
    <c:if test="${user.posts.size() == 0}">
        <div class="message">
            You haven't written any posts
        </div>
        <div class="message">
            <a href="/addPost" class="btn" id="btn-add-post">Write a post</a>
        </div>

    </c:if>
    <c:if test="${user.posts.size() > 0}">
        <c:forEach var="post" items="user.posts">
            <div class="post"></div>
        </c:forEach>
    </c:if>
<script type="text/javascript" src="particles.js"></script>
<script type="text/javascript" src="app.js"></script>
</body>
</html>