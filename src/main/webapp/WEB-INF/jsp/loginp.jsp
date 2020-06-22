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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/patient/css/app.css">

</head>

<body>
    <div class="loginHeader">
        <div class="headerData">
            <h1>My Hospitals</h1>
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
            <ul class="loginTab">
                <li><a href="#" class="loginTabActive" data-show="loginSection">
                        Patient Login
                    </a></li>
                <li><a href="#" data-show="registerUser">
                        Register
                    </a></li>
            </ul>
            <div id="loginSection" class="tabSec">

                <form  action="loginSubmit" method="post">
                    <label for="">Mobile Number / Email ID</label>
                    
                    <input type="text" name="mobile" id="" placeholder="Mobile Number/ Emai ID" class="form-control mb-15">
                   
                    <label for="">Password</label><small>${email}</small>
                    
                    <input type="password" name="pwd" id="" placeholder="Password" class="form-control mb-15">
                    <small>${pwd}</small>
                    <div class="row mb-15">
                        <div class="col-xs-6">
                            <input type="checkbox" name="rememberPassword" id="rememberPassword">
                            <label for="rememberPassword" style="font-weight: normal;">Remember Password</label>
                        </div>
                        <div class="col-xs-6 text-right">
                            <a href="/patient/forgotPassword">Forgot password?</a>
                        </div>
                    </div>
                    <button class="btn btn-primary btn-block" type="submit">Login</button>
                    <p>Or</p>
                    <button class="btn btn-primary btn-block fb-btn">Connect with Facebook</button>
                </form>
            </div>
            <div id="registerUser" class="tabSec" style="display: none;">
                <form>
                    <label for="">Full Name</label>
                    <input type="text" name="" id="name" placeholder="Enter Full Name" class="form-control mb-15">
                    <label for="">Mobile Number / Email ID </label>
                     <div class="row mb-15">
                     <!--   <div class="col-xs-3">
                            <select name="" id="" class="form-control">
                                <option value="">+91</option>
                            </select>
                        </div> -->
                        <div class="col-xs-12">
                            <input type="text" name="" id="mobile" placeholder="Enter Mobile" class="form-control">
                        </div>
                    </div>
                    <label for="">Create Password</label>
                    <input type="text" name="" id="password" placeholder="Enter Password" class="form-control mb-15">
                    <div class="row mb-15">
                        <div class="col-xs-12">
                            <input type="checkbox" name="rememberPassword" id="rememberPassword" checked>
                            <label for="rememberPassword" style="font-weight: normal;">By Signing up, I agree to
                                terms</label>
                        </div>
                    </div>
                    <button class="btn btn-primary btn-block" id="sendOtp">Send OTP</button>
                </form>
            </div>
            <div id="verifyOtp" class="otpVerify" style="display: none;">
                <h1>Verify Mobile</h1>
                <h2>We have sent you an OTP on</h2>
                <h3>
                    <div id="otpMob">+917338015782</div>
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
                <button class="btn btn-primary btn-block" id="verifyOtpBtn">Verify OTP</button>
            </div>
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
   <script src="${pageContext.request.contextPath}/jsp/patient/js/loginp.js"></script>
</body>

</html>