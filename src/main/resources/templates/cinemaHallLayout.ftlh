<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/static/hallLay.css">

</head>
<body>
<div class="section">
    <div class="screen">
        <div class="content">
            Tytuł: ${movieTitle}
            <br>
            Data: ${day}
            <br>
            Godzina: ${hour}
            <br>
            Czas trwania: ${duration} minut
            <br>
            Opis: ${description}
        </div>
    </div>
</div>
<div class="theatre">
    <div class="cinema-seats left">
        <div class="cinema-row row-1">
            <div class="seat" id="1"></div>
            <div class="seat" id="15"></div>
            <div class="seat" id="29"></div>
            <div class="seat" id="43"></div>
            <div class="seat" id="57"></div>
            <div class="seat" id="71"></div>
            <div class="seat" id="85"></div>
        </div>

        <div class="cinema-row row-2">
            <div class="seat" id="2"></div>
            <div class="seat" id="16"></div>
            <div class="seat" id="30"></div>
            <div class="seat" id="44"></div>
            <div class="seat" id="58"></div>
            <div class="seat" id="72"></div>
            <div class="seat" id="86"></div>
        </div>

        <div class="cinema-row row-3">
            <div class="seat" id="3"></div>
            <div class="seat" id="17"></div>
            <div class="seat" id="31"></div>
            <div class="seat" id="45"></div>
            <div class="seat" id="59"></div>
            <div class="seat" id="73"></div>
            <div class="seat" id="87"></div>
        </div>

        <div class="cinema-row row-4">
            <div class="seat" id="4"></div>
            <div class="seat" id="18"></div>
            <div class="seat" id="32"></div>
            <div class="seat" id="46"></div>
            <div class="seat" id="60"></div>
            <div class="seat" id="74"></div>
            <div class="seat" id="88"></div>
        </div>

        <div class="cinema-row row-5">
            <div class="seat" id="5"></div>
            <div class="seat" id="19"></div>
            <div class="seat" id="33"></div>
            <div class="seat" id="47"></div>
            <div class="seat" id="61"></div>
            <div class="seat" id="75"></div>
            <div class="seat" id="89"></div>
        </div>

        <div class="cinema-row row-6">
            <div class="seat" id="6"></div>
            <div class="seat" id="20"></div>
            <div class="seat" id="34"></div>
            <div class="seat" id="48"></div>
            <div class="seat" id="62"></div>
            <div class="seat" id="76"></div>
            <div class="seat" id="90"></div>
        </div>

        <div class="cinema-row row-7">
            <div class="seat" id="7"></div>
            <div class="seat" id="21"></div>
            <div class="seat" id="35"></div>
            <div class="seat" id="49"></div>
            <div class="seat" id="63"></div>
            <div class="seat" id="77"></div>
            <div class="seat" id="91"></div>
        </div>
    </div>

    <div class="cinema-seats right">
        <div class="cinema-row row-1">
            <div class="seat" id="8"></div>
            <div class="seat" id="22"></div>
            <div class="seat" id="36"></div>
            <div class="seat" id="50"></div>
            <div class="seat" id="64"></div>
            <div class="seat" id="78"></div>
            <div class="seat" id="92"></div>
        </div>

        <div class="cinema-row row-2">
            <div class="seat" id="9"></div>
            <div class="seat" id="23"></div>
            <div class="seat" id="37"></div>
            <div class="seat" id="51"></div>
            <div class="seat" id="65"></div>
            <div class="seat" id="79"></div>
            <div class="seat" id="93"></div>
        </div>

        <div class="cinema-row row-3">
            <div class="seat" id="10"></div>
            <div class="seat" id="24"></div>
            <div class="seat" id="38"></div>
            <div class="seat" id="52"></div>
            <div class="seat" id="66"></div>
            <div class="seat" id="80"></div>
            <div class="seat" id="94"></div>
        </div>

        <div class="cinema-row row-4">
            <div class="seat" id="11"></div>
            <div class="seat" id="25"></div>
            <div class="seat" id="39"></div>
            <div class="seat" id="53"></div>
            <div class="seat" id="67"></div>
            <div class="seat" id="81"></div>
            <div class="seat" id="95"></div>
        </div>

        <div class="cinema-row row-5">
            <div class="seat" id="12"></div>
            <div class="seat" id="26"></div>
            <div class="seat" id="40"></div>
            <div class="seat" id="54"></div>
            <div class="seat" id="68"></div>
            <div class="seat" id="82"></div>
            <div class="seat" id="96"></div>
        </div>

        <div class="cinema-row row-6">
            <div class="seat" id="13"></div>
            <div class="seat" id="27"></div>
            <div class="seat" id="41"></div>
            <div class="seat" id="55"></div>
            <div class="seat" id="69"></div>
            <div class="seat" id="83"></div>
            <div class="seat" id="97"></div>
        </div>

        <div class="cinema-row row-7">
            <div class="seat" id="14"></div>
            <div class="seat" id="28"></div>
            <div class="seat" id="42"></div>
            <div class="seat" id="56"></div>
            <div class="seat" id="70"></div>
            <div class="seat" id="84"></div>
            <div class="seat" id="98" ></div>
        </div>
    </div>

</div>
<div class="buttonSection">
    <button class="reserveBtn effect" id="getID">Zarezerwuj</button>
</div>
<div class="legend">
    <div class="legend-seat">
        <div class="cinema-col">
            <div class="seat-test"></div>
        </div>
        <div class="cinema-col">
            <div class="seat-test active-test"></div>
        </div>
        <div class="cinema-col">
            <div class="seat-test taken-test"></div>
        </div>
    </div>
</div>
<div class="text-box">
    <p class="text">WOLNE</p>
    <p class="text">WYBRANE</p>
    <p class="text">ZAJĘTE</p>
</div>
<#assign a = 0>
<#list seatState as ss>
    <#assign a = a+1>
    <#if ss.isTaken()==true>
        <script>
            document.getElementById('${a}').classList.add('taken');
        </script>
    </#if>
</#list>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script type="application/javascript">
    $('.cinema-seats .seat').on('click', function () {
        if (!$(this).hasClass('taken') && $(this).attr('id') !== undefined){
            $(this).toggleClass('active');
        }
    });
</script>
<script type="application/javascript">
    $('#getID').click(function () {

        let arr = $(".active").toArray();
        let newArr = [];
        $.each(arr, function (){
            newArr.push($(this).attr("id"))
        });
        const reservationDetails = {
            "seats" : newArr,
            "movieDate" : "${date}",
            "movieTitle" : "${movieTitle}"
        }

        let xhr = new XMLHttpRequest();
        let url = "/book/reserve";
        xhr.open("PUT", url, true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.send(JSON.stringify(reservationDetails));

        $(".active").addClass('taken');
        console.log(newArr);
        console.log("${date}");
        console.log("${movieTitle}");
        $(".active").toggleClass('active');

    });
</script>


</body>
</html>