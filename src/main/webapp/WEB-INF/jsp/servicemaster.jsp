<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Doctor Master</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@100;200;300;400;500;600;700;800;900&display=swap"
        rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@200;300;400;600;700;900&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/admin/css/bootstrap-datepicker.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/admin/css/app.css">
</head>

<body>
<header class="primaryHeader">
        <h1>My Hospitals</h1>
        <a href="#" class="navIcon" data-toggle="tooltip" title="Show and hide menu" data-placement="bottom">
            <img src="${pageContext.request.contextPath}/jsp/admin/images/nav.png">
        </a>
        <a href="#" class="notificationIcon">
            <img src="${pageContext.request.contextPath}/jsp/admin/images/bell.png">
        </a>
        <p>Welcome
            <span>Admin</span>
        </p>
        <div class="profileImage">
            <img src="${pageContext.request.contextPath}/jsp/admin/images/profile.jpg">
        </div>
    </header>
    <section class="navigation">
        <ul>
            <li>
                <a href="dashboard">
                    <img src="${pageContext.request.contextPath}/jsp/admin/images/menuIcons/icon1.png">
                    <span class="menuText">Dashboard</span>

                </a>
            </li>
            <li>
                <a href="appointments" class="activeMenu">
                    <img src="${pageContext.request.contextPath}/jsp/admin/images/menuIcons/icon2.png">
                    <span class="menuText">Appointments</span>
                </a>
            </li>
            <li>
                <a href="#" class="hasChild">
                    <img src="${pageContext.request.contextPath}/jsp/admin/images/menuIcons/icon3.png">
                    <span class="menuText">Doctors</span>
                    <span class="icon">
                        <img src="${pageContext.request.contextPath}/jsp/admin/images/leftArrow.png">
                    </span>
                </a>
                <ul class="childMenu" style="display: block;">
                    <li>
                        <a href="doctorslist" >
                            <span class="menuText">Doctors List</span>

                        </a>
                    </li>
                    <li>
                        <a href="createdocter">
                            <span class="menuText">Add Doctors</span>

                        </a>
                    </li>
                    <li>
                        <a href="doctersmaster" >
                            <span class="menuText">Masters</span>

                        </a>
                    </li>
                    <li>
                        <a href="servicemaster" class="activeMenu">
                            <span class="menuText">Service</span>

                        </a>
                    </li>
                    <li>
                        <a href="specializationmaster">
                            <span class="menuText">Specialization</span>

                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#" class="hasChild">
                    <img src="${pageContext.request.contextPath}/jsp/admin/images/menuIcons/icon4.png">
                    <span class="menuText">Patients</span>
                    <span class="icon">
                        <img src="${pageContext.request.contextPath}/jsp/admin/images/leftArrow.png">
                    </span>

                </a>
                <ul class="childMenu">
                    <li>
                        <a href="patientslist">
                            <span class="menuText">Patients List</span>

                        </a>
                    </li>
                    <li>
                        <a href="createpatients">
                            <span class="menuText">Add Patients</span>

                        </a>
                    </li>

                </ul>
            </li>
            </li>
            <li>
                <a href="#">
                    <img src="${pageContext.request.contextPath}/jsp/admin/images/menuIcons/icon5.png">
                    <span class="menuText">Transactions</span>
                    <span class="icon">
                        <img src="${pageContext.request.contextPath}/jsp/admin/images/leftArrow.png">
                    </span>

                </a>
            </li>
            <li>
                <a href="#">
                    <img src="${pageContext.request.contextPath}/jsp/admin/images/menuIcons/icon6.png">
                    <span class="menuText">Laboratory</span>
                    <span class="icon">
                        <img src="${pageContext.request.contextPath}/jsp/admin/images/leftArrow.png">
                    </span>

                </a>
            </li>
            <li>
                <a href="#">
                    <img src="${pageContext.request.contextPath}/jsp/admin/images/menuIcons/icon7.png">
                    <span class="menuText">Profile</span>
                    <span class="icon">
                        <img src="${pageContext.request.contextPath}/jsp/admin/images/leftArrow.png">
                    </span>

                </a>
            </li>
            <li>
                <a href="#">
                    <img src="${pageContext.request.contextPath}/jsp/admin/images/menuIcons/icon8.png">
                    <span class="menuText">Settings</span>
                    <span class="icon">
                        <img src="${pageContext.request.contextPath}/jsp/admin/images/leftArrow.png">
                    </span>
                </a>
            </li>
        </ul>
    </section>
 <section class="dataContainer">
        <div class="pageHeader">
            <h1>Service Master</h1>
        </div>
        <div class="addSpeciality">
            <input type="text" name="" id="service" class="form-control mr-10 max-300" placeholder="Enter Speciality">
            <button class="btn btn-primary" id="addService">Add</button>
           
        </div>
        <div class="dataSection">
            <div id="scrollTable" style="max-height: 300px; overflow: hidden; outline: none;" tabindex="5000">
                <table class="themeTable" style="min-width: 1203px;">
              
                    <tr>
                        <th width="80%">Service Name</th>
                        <th></th>
                    </tr>
                        <c:forEach var="master" items="${specialityList}">
                        
                        <c:url var="deleteLink" value="/admin/delete/speciality">
						<c:param name="selectId" value="${master.selectId}" />
					  </c:url>
                    <tr>
                        <td>${master.service}</td>

                        <td class="text-right">
                            <a href="#">
                                <img src="${pageContext.request.contextPath}/jsp/admin/images/editIcon.png" class="mr-5" alt="">
                            </a>
                            <a href="#">
                                <img src="${pageContext.request.contextPath}/jsp/admin/images/activeIcon.png" class="mr-5" alt="">
                            </a>
                            <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this speciality?'))) return false">
                                <img src="${pageContext.request.contextPath}/jsp/admin/images/deleteIcon.png" alt="">
                            </a>
                        </td>
                    </tr>
                     </c:forEach>
                    <tr>
                        <td>Dentist</td>

                        <td class="text-right">
                            <a href="#">
                                <img src="${pageContext.request.contextPath}/jsp/admin/images/editIcon.png" class="mr-5" alt="">
                            </a>
                            <a href="#">
                                <img src="${pageContext.request.contextPath}/jsp/admin/images/activeIcon.png" class="mr-5" alt="">
                            </a>
                            <a href="#">
                                <img src="${pageContext.request.contextPath}/jsp/admin/images/deleteIcon.png" alt="">
                            </a>
                        </td>
                    </tr>
                   



                </table>
            </div>
        </div>
    </section>

    <script src=" https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/jsp/admin/js/moment.min.js"></script>
    <script src="${pageContext.request.contextPath}/jsp/admin/js/bootstrap-datepicker.min.js"></script>
     <script src="${pageContext.request.contextPath}/jsp/admin/js/jquery.nicescroll.min.js"></script>
    <script src="${pageContext.request.contextPath}/jsp/admin/js/app.js"></script>
    <script src="${pageContext.request.contextPath}/jsp/admin/js/master.js"></script>
   
</body>

</html>