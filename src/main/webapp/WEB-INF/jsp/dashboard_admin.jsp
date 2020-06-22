<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@100;200;300;400;500;600;700;800;900&display=swap"
        rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@200;300;400;600;700;900&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/admin/css/app.css">
</head>

<body>
    <jsp:include page="header_dashboard.jsp" />
   <jsp:include page="navbar_dashboard.jsp" />
       <section class="dataContainer">
        <div class="pageHeader">
            <h1>Dashboard</h1>
        </div>
        <div class="dataSection">
            <div class="row">
                <div class="col-sm-6 col-md-3">
                    <div class="countBox">
                        <div class="countHeader">
                            <h1>Doctors</h1>
                            <img src="${pageContext.request.contextPath}/jsp/admin/images/add.png">
                        </div>
                        <div class="countInfo">
                            <img src="${pageContext.request.contextPath}/jsp/admin/images/doctor.png">
                            <p>${doctor}</p>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-3">
                    <div class="countBox">
                        <div class="countHeader">
                            <h1>Patients</h1>
                            <img src="${pageContext.request.contextPath}/jsp/admin/images/add.png">
                        </div>
                        <div class="countInfo">
                            <img src="${pageContext.request.contextPath}/jsp/admin/images/patient.png">
                            <p>Todays<br />${patient}</p>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-3">
                    <div class="countBox">
                        <div class="countHeader">
                            <h1>Appointments</h1>
                            <img src="${pageContext.request.contextPath}/jsp/admin/images/add.png">
                        </div>
                        <div class="countInfo">
                            <img src="${pageContext.request.contextPath}/jsp/admin/images/calender.png">
                            <p>Todays<br />50</p>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-3">
                    <div class="countBox">
                        <div class="countHeader">
                            <h1>Transactionstments</h1>
                            <img src="${pageContext.request.contextPath}/jsp/admin/images/add.png">
                        </div>
                        <div class="countInfo">
                            <img src="${pageContext.request.contextPath}/jsp/admin/images/money.png">
                            <p>50,400</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="filterSection" id="filter">
                <h1>
                    Appointments
                </h1>
                <button class="btn btn-primary mr-10 mb-10">
                    Today
                </button>
                <button class="btn btn-default mr-10  mb-10">
                    Upcoming
                </button>
                <button class="btn btn-default  mb-10 ml-auto">
                    Viewll Appointments
                </button>
            </div>
            <div id="scrollTable" style="max-height:300px;">
                <table class="themeTable" style="min-width: 1203px;">
                    <tr>
                        <th width="20%">Doctor Name</th>
                        <th width="10%">Speciality</th>
                        <th width="20%">Patient Name</th>
                        <th width="20%">Apointment Date &Time</th>
                        <th width="10%">Type</th>
                        <th width="10%">Amount</th>
                        <th width="10%">Status</th>
                    </tr>
                    <tr>
                        <td>
                            <div class="profileSec">
                                <div class="tableProfile">
                                    <img src="${pageContext.request.contextPath}/jsp/admin/images/profile.jpg">
                                </div>
                                <a href="doctor">Dr. Maria Lupin James</a>
                            </div>
                        </td>
                        <td>Dental</td>
                        <td>
                            <div class="profileSec">
                                <div class="tableProfile">
                                    <img src="${pageContext.request.contextPath}/jsp/admin/images/profile.jpg">
                                </div>
                                <a href="patient">Maria Lupin James</a>
                            </div>
                        </td>
                        <td>
                            May 10, 2020<br />
                            11.00 AM - 11.15 AM
                        </td>
                        <td>
                            Online Consult
                        </td>
                        <td>
                            300
                        </td>
                        <td>
                            Active
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="profileSec">
                                <div class="tableProfile">
                                    <img src="${pageContext.request.contextPath}/jsp/admin/images/profile.jpg">
                                </div>
                                <a href="doctor">Dr. Maria Lupin James</a>
                            </div>
                        </td>
                        <td>Dental</td>
                        <td>
                            <div class="profileSec">
                                <div class="tableProfile">
                                    <img src="${pageContext.request.contextPath}/jsp/admin/images/profile.jpg">
                                </div>
                                <a href="patient">Maria Lupin James</a>
                            </div>
                        </td>
                        <td>
                            May 10, 2020<br />
                            11.00 AM - 11.15 AM
                        </td>
                        <td>
                            Online Consult
                        </td>
                        <td>
                            300
                        </td>
                        <td>
                            Active
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="profileSec">
                                <div class="tableProfile">
                                    <img src="${pageContext.request.contextPath}/jsp/admin/images/profile.jpg">
                                </div>
                                <a href="doctor">Dr. Maria Lupin James</a>
                            </div>
                        </td>
                        <td>Dental</td>
                        <td>
                            <div class="profileSec">
                                <div class="tableProfile">
                                    <img src="${pageContext.request.contextPath}/jsp/admin/images/profile.jpg">
                                </div>
                                <a href="patient">Maria Lupin James</a>
                            </div>
                        </td>
                        <td>
                            May 10, 2020<br />
                            11.00 AM - 11.15 AM
                        </td>
                        <td>
                            Online Consult
                        </td>
                        <td>
                            300
                        </td>
                        <td>
                            Active
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="profileSec">
                                <div class="tableProfile">
                                    <img src="${pageContext.request.contextPath}/jsp/admin/images/profile.jpg">
                                </div>
                                <a href="doctor">Dr. Maria Lupin James</a>
                            </div>
                        </td>
                        <td>Dental</td>
                        <td>
                            <div class="profileSec">
                                <div class="tableProfile">
                                    <img src="${pageContext.request.contextPath}/jsp/admin/images/profile.jpg">
                                </div>
                                <a href="patient">Maria Lupin James</a>
                            </div>
                        </td>
                        <td>
                            May 10, 2020<br />
                            11.00 AM - 11.15 AM
                        </td>
                        <td>
                            Online Consult
                        </td>
                        <td>
                            300
                        </td>
                        <td>
                            Active
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="profileSec">
                                <div class="tableProfile">
                                    <img src="${pageContext.request.contextPath}/jsp/admin/images/profile.jpg">
                                </div>
                                <a href="doctor">Dr. Maria Lupin James</a>
                            </div>
                        </td>
                        <td>Dental</td>
                        <td>
                            <div class="profileSec">
                                <div class="tableProfile">
                                    <img src="${pageContext.request.contextPath}/jsp/admin/images/profile.jpg">
                                </div>
                                <a href="patient">Maria Lupin James</a>
                            </div>
                        </td>
                        <td>
                            May 10, 2020<br />
                            11.00 AM - 11.15 AM
                        </td>
                        <td>
                            Online Consult
                        </td>
                        <td>
                            300
                        </td>
                        <td>
                            Active
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="profileSec">
                                <div class="tableProfile">
                                    <img src="${pageContext.request.contextPath}/jsp/admin/images/profile.jpg">
                                </div>
                                <a href="doctor">Dr. Maria Lupin James</a>
                            </div>
                        </td>
                        <td>Dental</td>
                        <td>
                            <div class="profileSec">
                                <div class="tableProfile">
                                    <img src="${pageContext.request.contextPath}/jsp/admin/images/profile.jpg">
                                </div>
                                <a href="patient">Maria Lupin James</a>
                            </div>
                        </td>
                        <td>
                            May 10, 2020<br />
                            11.00 AM - 11.15 AM
                        </td>
                        <td>
                            Online Consult
                        </td>
                        <td>
                            300
                        </td>
                        <td>
                            Active
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="profileSec">
                                <div class="tableProfile">
                                    <img src="${pageContext.request.contextPath}/jsp/admin/images/profile.jpg">
                                </div>
                                <a href="doctor">Dr. Maria Lupin James</a>
                            </div>
                        </td>
                        <td>Dental</td>
                        <td>
                            <div class="profileSec">
                                <div class="tableProfile">
                                    <img src="${pageContext.request.contextPath}/jsp/admin/images/profile.jpg">
                                </div>
                                <a href="patient">Maria Lupin James</a>
                            </div>
                        </td>
                        <td>
                            May 10, 2020<br />
                            11.00 AM - 11.15 AM
                        </td>
                        <td>
                            Online Consult
                        </td>
                        <td>
                            300
                        </td>
                        <td>
                            Active
                        </td>
                    </tr>

                </table>
            </div>
        </div>
    </section>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/jsp/admin/js/jquery.nicescroll.min.js"></script>
    <script src="${pageContext.request.contextPath}/jsp/admin/js/app.js"></script>
       
</body>

</html>