<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/patient/css/app.css">
</head>

<body>
   <jsp:include page="header_p.jsp" />
   <jsp:include page="navbar_p.jsp" />
       <section class="dataContainer">
        <div class="pageHeader">
            <h1>My Appointments</h1>
        </div>
        <div class="dataSection">
         
            <div class="filterSection mb-10" id="filter">
               
                <button class="btn btn-primary ml-auto mr-10 ">
                    Today
                </button>
                <button class="btn btn-default mr-10 ">
                    Upcoming
                </button>
             
            </div>
            <div id="scrollTable" style="max-height:300px;">
                <table class="themeTable" style="min-width: 1203px;">
                    <tr>
                        <th width="10%">Id</th>
                        <th width="20%">Doctor Name</th>
                        <th width="10%">Speciality</th>
                        <th width="20%">Apointment Date &Time</th>
                        <th width="10%">Type</th>
                        <th width="10%">Amount</th>
                        <th width="10%">Status</th>
                    </tr>
                    <tr>
                        <td>
                            <a href="#">App01</a>
                        </td>
                        <td>
                            <div class="profileSec">
                                <div class="tableProfile">
                                    <img src="${pageContext.request.contextPath}/jsp/patient/images/profile.jpg">
                                </div>
                                <a href="doctor.html">Dr. Maria Lupin James</a>
                            </div>
                        </td>
                        <td>Dental</td>
                        
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
                            <a href="#">App01</a>
                        </td>
                        <td>
                            <div class="profileSec">
                                <div class="tableProfile">
                                    <img src="${pageContext.request.contextPath}/jsp/patient/images/profile.jpg">
                                </div>
                                <a href="doctor.html">Dr. Maria Lupin James</a>
                            </div>
                        </td>
                        <td>Dental</td>
                        
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
                        <td class="red">
                            Cancelelled
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a href="#">App01</a>
                        </td>
                        <td>
                            <div class="profileSec">
                                <div class="tableProfile">
                                    <img src="${pageContext.request.contextPath}/jsp/patient/images/profile.jpg">
                                </div>
                                <a href="doctor.html">Dr. Maria Lupin James</a>
                            </div>
                        </td>
                        <td>Dental</td>
                        
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
                        <td class="red">
                            Closed
                        </td>
                    </tr>
                    
                </table>
            </div>
        </div>
    </section>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/jsp/patient/js/jquery.nicescroll.min.js"></script>
    <script src="${pageContext.request.contextPath}/jsp/patient/js/app.js"></script>
    <!-- <script>
        $(function () {
            $('#filter button').click(function () {
                $('.btn-primary').removeClass('btn-primary');
                $(this).removeClass('btn-default').addClass('btn-primary');
            })
        });
    </script> -->
</body>

</html>