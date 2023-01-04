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
    <a onclick="location.href = 'http://localhost:8080/cinema';" id="myButton" class="float-left submit-button">TESTESTEST</a>
    <a href="http://localhost:8080/logout">Log out</a>
    <input type="date" id="date" value=${date}>
</div>
<br>
<div class="listBox">
    <div class="movieList">
        <#assign movie = []>
        <#list screenings as ss>
            <#assign mov = ss.movie>
            <#if movie?seq_contains(mov)>
            <#else>
            <#assign movie = movie + [mov]>
            <#list movies as m>
                <#if ss.movie.title == m.title>
                    <div class="movieContainer">
                        <div class="movieBox">
                            <p class="title"><b>${m.title}</b></p>
                            <p class="description"><i>${m.description}</i></p>
                        </div>
                        <#list screenings as s>
                            <#if s.movie.title==m.title>
                                <button class="pickBtn effect" id="${date} ${s.screeningTime.toLocalTime()} ${s.movie.title}">${s.screeningTime.toLocalTime()}</button>
                            </#if>
                        </#list>
                    </div>
                    <br>
                </#if>
            </#list>
            </#if>
        </#list>

    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script type="application/javascript">

    $('#date').on('input', function () {
        let date = document.getElementById("date").value;
        console.log(date);
        let dateFormatted = new Date(date);
        let day = dateFormatted.getDate();
        if (day < 10) {
            day = '0' + day;
        }
        let month = dateFormatted.getMonth() + 1;
        if (month < 10) {
            month = '0' + month;
        }
        let year = dateFormatted.getFullYear();
        let formattedDate = day + "-" + month + "-" + year;
        window.location.replace("http://localhost:8080/home/" + formattedDate.toString());
    });
</script>
</html>