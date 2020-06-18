<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reset Password</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@100;200;300;400;500;600;700;800;900&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/patient/css/app.css">

</head>

<body>
    <div class="loginHeader">
        <div class="headerData">
            <h1>My Hospitals</h1>
            <ul>
                <li>
                    <a href="#">
                        Doctor Appointments
                    </a>
                </li>
                <li>
                    <a href="#">
                        For Doctors
                    </a>
                </li>
                <li>
                    <a href="login.html" class="loginActiveMenu">
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
            <h2>Reset Password</h2>
            <form method="post" action="/patient/savePatientSubmit">
            <input type="hidden" name="mobile" value="${mobile}">
            <label for="">New Password</label>
            <input type="text" name="pass" id="" placeholder="New Password" class="form-control mb-15">
            <label for="">Confirm New Password</label>
            <input type="text" name="repass" id="" placeholder="Confirm New Password" class="form-control mb-15">
            <button class="btn btn-primary btn-block" type="submit">Change Password</button>
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
    <script src="${pageContext.request.contextPath}/jsp/patient/js/app.js"></script>
    <script src="${pageContext.request.contextPath}/jsp/patient/js/resetPasswordp.js"></script>
</body>

</html>