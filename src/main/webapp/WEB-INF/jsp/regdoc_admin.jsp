<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/doctor/css/bootstrap-datepicker.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/doctor/css/app.css">
</head>

<body>
   <jsp:include page="header_dashboard.jsp" />
   <jsp:include page="navbar_dashboard.jsp" />

    <section class="dataContainer">
        <div class="pageHeader">
            <h1>Profile</h1>
            <button class="btn btn-primary ml-auto">Save Changes</button>
        </div>
        <div class="dataSection">

            <ul class="progressTabs">
                <li>
                    <a href="createdocter" class="completedProgress">Personal & <br />
                        Contact Details</a>
                </li>
                <li>
                    <a href="registration" class="activeProgress">Registration & <br />
                        Documents</a>
                </li>
                <li>
                    <a href="experience.html">Experience &<br />
                        Education</a>
                </li>
                <li>
                    <a href="services.html">Services<br />
                        Details</a>
                </li>
                <li>
                    <a href="awards.html">
                        Awards &<br />
                        Memberships
                    </a>
                </li>
            </ul>

            <div class="row">
                <div class="col-sm-8">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="inputGroup">
                                <label>Registration Number*</label>
                                <input type="text" id="regNo" class="form-control" placeholder="Registration Number">
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="inputGroup">
                                <label>Registration year*</label>
                                <input type="text" id="regYear" class="form-control" placeholder="Registration year">
                            </div>
                        </div>
                    </div>
                    <hr class="m-0">
                    <div class="filterSection" id="filter">

                        <button id="regdocUpdate" class="btn btn-primary  mb-10 ml-auto">Add Files</button>
                    </div>
                    <hr class="m-0">

                    <table class="themeTable">
                        <tbody>
                            <tr>
                                <td>Registration No</td>
                                <td>Registration Year</td>
                                <td></td>



                            </tr>
                            <tr>

                                <td>${userDoctor.regNo }</td>
                                <td>${userDoctor.regYear }</td>

                                <td>

                                    <a href="#" class="mr-5">
                                        <img src="images/editIcon.png" alt="">
                                    </a>
                                    <a href="#" class="mr-5">
                                        <img src="images/deleteIcon.png" alt="">
                                    </a>
                                </td>
                            </tr>


                        </tbody>
                    </table>
                  
                </div>
            </div>

        </div>

    </section>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
     <script src="${pageContext.request.contextPath}/jsp/doctor/js/jquery.nicescroll.min.js"></script>
    <script src="${pageContext.request.contextPath}/jsp/doctor/js/bootstrap-datepicker.min.js"></script>
    <script src="${pageContext.request.contextPath}/jsp/doctor/js/app.js"></script>
   <!--  <script>
        $(function () {
            $('#filter button').click(function () {
                $('.btn-primary').removeClass('btn-primary');
                $(this).removeClass('btn-default').addClass('btn-primary');
            })
        });
    </script> -->
</body>

</html>