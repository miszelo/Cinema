<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../static/homePage.css">
    <script src="https://jsuites.net/v4/jsuites.js"></script>
    <script src="https://jsuites.net/v4/jsuites.webcomponents.js"></script>
    <link rel="stylesheet" href="https://jsuites.net/v4/jsuites.css" type="text/css" />
</head>
<body>

<div class="topnav">
    <a class="active" href="http://localhost:8080/home">Home</a>
    <a onclick="location.href = 'http://localhost:8080/cinema';" id="myButton" class="float-left submit-button" >TESTESTEST</a>
    <a href="#logout">Log out</a>
    <jsuites-calendar  id="calendar" value=${today}></jsuites-calendar>
</div>
<br>
<div class="movieList">
<!--<button onclick="location.href = 'http://localhost:8080/cinema';" id="myButton" class="float-left submit-button" >cinema</button>-->
<#list movies as m>
    <div class = "movieContainer">
        <div class = "movieBox">
            <p class="title"><b>${m.title}</b></p>
            <p class="description"><i>${m.description}</i></p>
        </div>
    </div>
    <br>
</#list>
</div>
</body>
<script>
    document.querySelector('jsuites-calendar').addEventListener('onchange', function(e) {
        console.log('New value: ' + e.target.value);
    });
    document.querySelector('jsuites-calendar').addEventListener('onclose', function(e) {
        console.log('Calendar is closed');
    });
</script>
</html>