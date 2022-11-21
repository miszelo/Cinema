<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../static/homePage.css">
</head>
<body>
<button onclick="location.href = 'http://localhost:8080/cinema';" id="myButton" class="float-left submit-button" >cinema</button>
<#list movies as m>
    <div class = "movieContainer">
        <div class = "movieBox">
            <p>${m.title}<br>${m.dateOfScreening}</p>
            <!--<p>${m.dateOfScreening}</p>-->
        </div>
    </div>
    <br>
</#list>

</body>
</html>