<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
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
                 <a href="http://ec2-18-223-25-107.us-east-2.compute.amazonaws.com/web/doctorsList.html">Doctor Appointments</a>
                </li>
                <li>
                    <a href="#">Lab Tests</a>
                </li>
                <li>
                    <a href="http://ec2-18-223-25-107.us-east-2.compute.amazonaws.com/doctor/">For Doctors</a>
                </li>
                <li>
                    <a href="http://ec2-18-223-25-107.us-east-2.compute.amazonaws.com/patient/">Login/Signup</a>
                </li>
            </ul>
        </div>
    </div>
    <section class="patientLoginContainer">
        <div class="patientLeft">
        </div>
        <div class="patientRight">
           
          
       
            <div id="forgotverifyOtp" class="otpVerify" style="">
                <h1>Verify Mobile</h1>
                <h2>We have sent you an OTP on</h2>
                <h3>
                    <div id="mobile">${email}</div>
                </h3>
                <label for="">OTP</label>
                <input type="text" name="" id="otp" placeholder="Please enter 6digit OTP here Only"
                    class="form-control mb-15">
                <div class="row mb-15">
                    <div class="col-xs-4">
                        <a href="#">Resend OTP</a>
                    </div>
                    <div class="col-xs-8 text-right">
                        <a href="#">Still not received OTP? Get via call</a>
                    </div>
                </div>
                <button class="btn btn-primary btn-block" id="forgotVerifyOtpBtn">Verify OTP</button>
            </div>
          
        </div>
    </section>
    <footer class="loginFooter">
        <div class="headerData">
            <p>Copyright © 2020, Digiklinik. All rights reserved.</p>
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
   <%--  <script src="${pageContext.request.contextPath}/jsp/doctor/js/app.js"></script> --%>
    <script src="${pageContext.request.contextPath}/jsp/doctor/js/forgot_otp_send.js"></script>
</body>

</html>