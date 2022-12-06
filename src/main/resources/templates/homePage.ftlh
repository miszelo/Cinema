<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../static/homePage.css">
</head>
<body>
<div class="topnav">
    <a class="active" href="http://localhost:8080/home">Home</a>
    <a onclick="location.href = 'http://localhost:8080/cinema';" id="myButton" class="float-left submit-button" >Cinema</a>
    <a href="http://localhost:8080/logout">Log out</a>
    <input type="date" value="siema">
</div>
<br>
<div class="listBox">
<div class="movieList">
<!--<button onclick="location.href = 'http://localhost:8080/cinema';" id="myButton" class="float-left submit-button" >cinema</button>-->
<#list movies as m>
    <div class = "movieContainer">
        <div class = "movieBox">
            <p class="title"><b>${m.title}</b></p>
            <p class="description"><i>${m.description}</i></p>
            <!-- Klikniecie w button musi brać movieTitle oraz date z gory by na ich podstawie zwracać godziny seansów-->
        </div>
        <button class="pickBtn effect" id="pickMovie">Wybierz</button>
    </div>
    <br>
</#list>
</div>
</div>
</body>
</html>