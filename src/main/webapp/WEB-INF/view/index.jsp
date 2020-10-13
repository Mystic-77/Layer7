<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Layer7</title>
        <link rel="stylesheet" href="indexStyles.css">
        <link href="https://fonts.googleapis.com/css2?family=Piazzolla:wght@100&display=swap" rel="stylesheet">
    </head>
    <body>
    <div id="particles-js"></div>
        <header>
            <h1 id="hero-text">Layer7</h1>
            <hr>
            <div id="description">Layer7 is a simple social website that allows small communities to share stuff</div>
            <div class="buttons">
                <a href="/login" class="btn">Login</a>
                <a href="/signup" class="btn">Sign Up</a>
            </div>
        </header>

        <script type="text/javascript" src="particles.js"></script>
        <script type="text/javascript" src="app.js"></script>
    </body>
</html>