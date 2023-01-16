<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CinemaVillage</title>
    <link rel="stylesheet" href="/static/homePage.css">
</head>
<body>
<div class="topnav">
    <a class="active" href="/home">Home</a>
    <a href="/logout">Log out</a>
    <input type="date" id="date" class="date" value=${date}>
</div>
<br>
<div class="listBox">
    <div class="movieList">
        <#assign movie = []>
        <#list screenings as ss>
            <#assign mov = ss.movie.title>
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
                        <div class="buttons">
                            <#list screenings as s>
                                <#if s.movie.title==m.title>
                                    <button class="pickBtn effect" id="${date}_${s.screeningTime.toLocalTime()}_${s.movie.title}" onclick="goToScreening(this)">${s.screeningTime.toLocalTime()}</button>
                                </#if>
                            </#list>
                        </div>
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
        window.location.replace("/home/" + formattedDate.toString());
    });
</script>
<script type="application/javascript">
    function goToScreening(button) {
        let id = button.id;
        let arr = id.split("_");
        console.log(id);
        console.log(arr);
        let date = arr[0];
        let time = arr[1];
        let movie = arr[2];
        console.log(date+"T"+time)
        window.location.href = "/book/"+date+"T"+time+"/"+movie;
    }
</script>
</html>