<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../static/register.css">
    <title>Document</title>
</head>
<body>
<div class="text">REJESTRACJA</div>
<form class="input" method="POST" action="http://localhost:8080/register">
    <input id="userEmail" type="email" name="userEmail" placeholder="E-mail">
    <input id="userPassword" type="password" name="userPassword" placeholder="Password">
    <input type="submit" value="Zarejestruj"/>
</form>

<script>
    window.addEventListener("submit", async function registerUser(event) {
        event.preventDefault()
        const userEmail = document.getElementById('userEmail').value
        const userPassword = document.getElementById('userPassword').value
        const result = await fetch('/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                userEmail,
                userPassword
            })
        }).then(res => {
            if (res.status === 200) {
                alert('success');
                console.log(res)
                window.location.href = 'http://localhost:8080/login';
            } else {
                alert("zle")
                console.log(res)
            }

        })
    })
</script>

</body>
</html>
