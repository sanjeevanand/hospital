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
     <jsp:include page="header_d.jsp" />
   <jsp:include page="navbar_d.jsp" />
  
   <section class="dataContainer">
        <div class="pageHeader">
            <h1>Profile</h1>
            
        </div>
        <div class="dataSection">

            <ul class="progressTabs">
                <li>
                    <a href="profile" class="completedProgress">Personal & <br />
                        Contact Details</a>
                </li>
                <li>
                    <a href="registration" class="completedProgress">Registration & <br />
                        Documents</a>
                </li>
                <li>
                    <a href="experience" class="activeProgress">Experience &<br />
                        Education</a>
                </li>
                <li>
                    <a href="services">Services<br />
                        Details</a>
                </li>
                <li>
                    <a href="awards">
                        Awards &<br />
                        Memberships
                    </a>
                </li>
            </ul>



            <div class="row">
                <div class="col-sm-6">
                    <div class="filterSection" id="filter">
                    
                    <div class="col-sm-10">
						 <h1>
                            Experience
                        </h1>
                            <div class="inputGroup">
                                <input id ="workExperience" type="text" class="form-control" placeholder="Enter Experience">
                            </div>
                        </div>
                        <button id="workExperienceDocUpdate" class="btn btn-primary  mb-10 ml-auto">Add</button>
                  
                       

                    </div>
                    <hr class="m-0">

                    <table class="themeTable">
                        <tbody>
							 <c:forEach var="workExperience" items="${workExperienceList}">
                        
                        <c:url var="deleteLink" value="/rest/deleteDoctorExperiencedDoc/${workExperience.experience}">
					  </c:url>
                            <tr>

                                <td>${workExperience.experience}</td>


                                <td class="text-right">

                                   
                                    <a href="${deleteLink}" class="mr-5">
                                        <img src="${pageContext.request.contextPath}/jsp/doctor/images/deleteIcon.png" alt="">
                                    </a>
                                </td>
                            </tr>
                            </c:forEach>
                           
                           
                        </tbody>
                    </table>
                </div>
                <div class="col-sm-6">
                    <div class="filterSection" id="filter">
                                        <div class="col-sm-10">
                    
                     <h1>
                            Education
                        </h1>
                            <div class="inputGroup">
                                <input id ="education" type="text" class="form-control" placeholder="Enter Education">
                            </div>
                        </div>
                        <button id="educationDocUpdate" class="btn btn-primary  mb-10 ml-auto">Add</button>
                    </div>
                    <hr class="m-0">

                    <table class="themeTable">
                        <tbody>
							 <c:forEach var="education" items="${educationList}">
                        
                        <c:url var="deleteLink" value="/rest/deleteDoctorEducationDoc/${education.education}">
					  </c:url>
                            <tr>

                                <td>${education.education}</td>
                                <td class="text-right" width="30%">

                                   
                                    <a href="${ deleteLink}" class="mr-5">
                                        <img src="${pageContext.request.contextPath}/jsp/doctor/images/deleteIcon.png" alt="">
                                    </a>
                                </td>
                            </tr>
                            </c:forEach>
                            


                        </tbody>
                    </table>
                </div>
               
            </div>

            <div class="text-center mb-10 mt-20">
                <a href="#" class="btn btn-primary ml-auto mr-10"><span>Update</span> </a>
                <a href="#" class="btn btn-primary"><span>Cancel</span> </a>
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