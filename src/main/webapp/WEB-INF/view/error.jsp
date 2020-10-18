<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/indexStyles.css">
    <link href="https://fonts.googleapis.com/css2?family=Piazzolla:wght@100&display=swap" rel="stylesheet">

    <title>Error OwO</title>
</head>
<body>
    <div id="particles-js"></div>
    <h1 id="hero-text" class="error">Error!</h1>
    <hr>
    <div id="description">
        Page Not Found
    </div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/particles.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/app.js"></script>
</body>
</html>