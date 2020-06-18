<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@100;200;300;400;500;600;700;800;900&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/doctor/css/app.css">

</head>

<body>
    <div class="loginHeader">
        <div class="headerData">
            <img src="${pageContext.request.contextPath}/jsp/doctor/images/logo.png">
            <ul>
                <li>
                    <a href="#">
                        Doctor Appointments
                    </a>
                </li>
                <li>
                    <a href="#" class="loginActiveMenu">
                        For Doctors
                    </a>
                </li>
                <li>
                    <a href="#" >
                        Login/Signup
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <section class="patientLoginContainer">
        <div class="patientLeft">
        </div>
        <div class="patientRight">
            <h2>Forgot Password</h2>
            <h4>
                Provide us the email id/ mobile of your practo account and we will send you an email/otp with
                instructions to reset your password.
            </h4>
            <form method="post" action="/doctor/forgotsubmit">
            <label for="">Email ID / Mobile Number</label>
            <small>${msg }</small>
            <input type="text" name="email" id="" placeholder="Email ID / Mobile Number" class="form-control mb-15">
            <button class="btn btn-primary btn-block" type="submit">Send Me Instructions</button>
             </form>
        </div>
    </section>
    <footer class="loginFooter">
        <div class="headerData">
            <p>Copyright © 2020, MyHospitals. All rights reserved.</p>
            <div>
                <a href="#">Help</a>
                <a href="#">Privacy Policy</a>
                <a href="#">Terms & Conditions</a>
                <a href="#">Healthcare directory</a>
            </div>

        </div>

    </footer>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/jsp/doctor/js/app.js"></script>
    <script src="${pageContext.request.contextPath}/jsp/doctor/js/forgotPasswordd.js"></script>
</body>

</html>