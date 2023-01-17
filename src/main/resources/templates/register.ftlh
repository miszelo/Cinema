<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../static/register.css">
    <title>Registration Page</title>
</head>
<body>
<div class="container">
    <h1 class="title">Registration</h1>
    <form class="form" method="POST" action="/register">
        <div class="form-control">
            <label for="userEmail">Email:</label>
            <input id="userEmail" type="email" name="userEmail" placeholder="Enter email">
        </div>
        <div class="form-control">
            <label for="userPassword">Password:</label>
            <input id="userPassword" type="password" name="userPassword" placeholder="Enter password">
        </div>
        <div class="form-control">
            <input type="submit" value="Register"/>
        </div>
    </form>
</div>
</body>
</html>

<script>
    window.addEventListener("submit", async function registerUser(event) {
        event.preventDefault()
        const userEmail = document.getElementById('userEmail').value
        const userPassword = document.getElementById('userPassword').value
        await fetch('/register', {
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
                alert('Success');
                window.location.href = '/login';
            } else {
                alert("Ups... Something gone wrong. Please try again.")
            }
        })
    })
</script>