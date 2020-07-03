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
            <div id="emailConfirm" class="patientRight">
           <!--  <h2 style="font-size:30px;">Verify your email address</h2> -->
            <h4 style="line-height:24px">
               Password reset link has been sent to
					"${email}".
					Please click the link in your email to set a new password.  </h4>
			<p>&nbsp;</p>
			 <a  href="/doctor/" class="btn btn-primary btn-block" type="submit">Login</a>
          
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
   <%--  <script src="${pageContext.request.contextPath}/jsp/doctor/js/app.js"></script>
    <script src="${pageContext.request.contextPath}/jsp/doctor/js/logind.js"></script> --%>
</body>

</html>