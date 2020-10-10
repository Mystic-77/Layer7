<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Layer7: Login</title>
    <link rel="stylesheet" href="indexStyles.css">
    <link href="https://fonts.googleapis.com/css2?family=Piazzolla:wght@100&display=swap" rel="stylesheet">
</head>
<body>
    <div id="particles-js"></div>
    <header>
        <h1 id="hero-text">Layer7</h1>
        <hr>
    </header>
    <form action="/profile" method="post">
        <input type="text" class="fields" name="username" placeholder="Username"><br>
        <input type="password" class="fields" name="password" placeholder="Password"><br>
        <input type="submit" class="btn btn-submit" value="Login">
    </form>
    <script type="text/javascript" src="particles.js"></script>
    <script type="text/javascript" src="app.js"></script>
</body>
</html>