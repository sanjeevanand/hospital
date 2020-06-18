<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@100;200;300;400;500;600;700;800;900&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/admin/css/app.css">
    <style>
        body{
            font-family: 'Raleway', sans-serif !important;
        }
    </style>
</head>

<body>
    <section class="loginContainer">
        <div class="leftPanel">
            <img src="${pageContext.request.contextPath}/jsp/admin/images/loginImg.png" alt="">
        </div>
        <div class="rightPanel">
            <form action="loginSubmit" class="loginForm" method="post">
                <h1>My Hospitals</h1>
                <h2>Admin Sign In</h2>
                <label for="userName">Username</label>
                <input type="text" class="form-control mb-10" placeholder="Username" id="userName" name="userName">
                <small>${email}</small>
                <label for="password">Password</label>
                <input type="password" class="form-control mb-10" id="password" placeholder="Password" name="password">
                <small>${pwd}</small>
                <div class="row">
                    <div class="col-xs-7">
                        <input type="checkbox" id="rememberPassword">
                        <label for="rememberPassword" class="mb-0 ml-10">Remember Password</label>
                    </div>
                    <div class="col-sm-5 text-right">
                        <a href="#">Forgot password?</a>
                    </div>
                </div>
                <input type="submit" value="Login" class="btn btn-primary btn-block mt-15">
            </form>
        </div>
    </section>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/jsp/admin/js/app.js"></script>
</body>

</html>