<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <li><a class="links" href="/forums">Forums</a></li>
        <li><a class="links" href="/users">Users</a></li>
        <li><a class="links" href="/profile">Profile</a></li>
    </ul>
</nav>
<h1 id="hero-text">Forums</h1>
<hr><br>
<div class="post">
    <div class="post-title">
        ${post.title}
            <div class="tag-container">
                <c:forEach var="tag" items="${post.tags}">
                    <span class="tags">${tag}</span>
                </c:forEach>
            </div>

            <div class="post-details">
                <span class="author">Posted by : ${username}</span>
                <c:if test="${cookie.userid.value == post.user}">
                <span
                        class="deletePost"><a class="del-link" href="/deletePost/${post.id}">Delete Post</a></span>
                </c:if>
            </div>
    </div>
    <div class="post-content">
        ${post.content}
    </div>
</div>
<%--@elvariable id="comment" type="com.mystic.layer7.entity.Comment"--%>
<form:form id="comment-form" method="post" action="/addComment/${post.id}" modelAttribute="comment">
    <textarea name="commentContent" rows="2" class="comment-field" placeholder="Enter a comment here..."></textarea>
    <input type="submit" value="Send" id="comment-send-btn">
</form:form>
<c:if test="${comments.size() != 0}">
    <div class="comments">
        <c:forEach var="comment" items="${comments}">
            <div class="comment-container">
                <div class="comment-info">
                        ${comment.user}
                </div>
                <div class="comment-content">
                        ${comment.commentContent}
                </div>
            </div>
        </c:forEach>
    </div>
</c:if>
<script type="text/javascript" src="${pageContext.request.contextPath}/particles.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/app.js"></script>
</body>
</html>