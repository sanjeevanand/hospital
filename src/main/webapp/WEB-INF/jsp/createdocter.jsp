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
                    <a href="createdocter" class="activeProgress">Personal & <br />
                        Contact Details</a>
                </li>
                <li>
                    <a href="registration">Registration & <br />
                        Documents</a>
                </li>
                <li>
                    <a href="experiencedoc">Experience &<br />
                        Education</a>
                </li>
                <li>
                    <a href="servicedoc">Services<br />
                        Details</a>
                </li>
                <li>
                    <a href="awardsdoc">
                        Awards &<br />
                        Memberships
                    </a>
                </li>
            </ul>
            <h1 class="form-title">
                Basic Details
            </h1>
            <div class="row">
               <form:form action="saveDoctor" modelAttribute="doctor" method="POST" class="form-horizontal" encType='multipart/form-data'>
				<form:hidden path="doctorId"  />
        
                <div class="col-sm-8">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="inputGroup">
                                <label>Prefix</label>
                               <form:input type="text" path="prefix" class="form-control searchBox" placeholder="Dr."/>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="inputGroup">
                                <label>First Name</label>
                                <form:input type="text" path="firstname" class="form-control" placeholder="Enter Name"/>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="inputGroup">
                                <label>Gender</label>
                                <div class="checkboxGropup mr-10">
                                    <input type="radio" name="gender" id="male">
                                    <label for="male">Male</label>
                                </div>
                                <div class="checkboxGropup mr-10">
                                    <input type="radio" name="gender" id="female">
                                    <label for="female">Female</label>
                                </div>
                                <div class="checkboxGropup mr-10">
                                    <input type="radio" name="gender" id="others">
                                    <label for="others">Others</label>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="inputGroup">
                                <label>Date of birth</label>
                                 <form:input type="text" path="dob" class="form-control date" placeholder="MM/DD/YYYY"/>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="inputGroup">
                                <label>Phone</label>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <select name="" id="" class="form-control">
                                            <option value="">+91</option>
                                        </select>
                                    </div>
                                    <div class="col-sm-9">
                                         <form:input type="text" path="mobile" class="form-control" placeholder="9742225501"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="inputGroup">
                                <label>Email Address</label>
                                <form:input type="text" path="email" class="form-control" placeholder="Yogeswaran@gmail.com"/>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="inputGroup">
                                <label>City</label>
                                 <form:input type="text" path="city" class="form-control" placeholder="Enter City"/>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="inputGroup">
                                <label>Years of Experience</label>
                                  <form:input type="text" path="experience" class="form-control" placeholder="Enter Years of Experience"/>
                            </div>
                        </div>
                        <div class="col-sm-12">
                            <div class="inputGroup">
                                <label>Doctor Description</label>
                                <form:textarea path="description" name="" id="" cols="30" rows="6" placeholder="Enter Description"
                                    class="form-control"/>
                        </div>
                    </div>
                    <h1 class="form-title">
                        Contact Details
                    </h1>
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="inputGroup">
                                <label>Location</label>
                                <form:input type="text" path="location" class="form-control" placeholder="Enter Location"/>
                            </div>
                            <div class="inputGroup">
                                <label>City</label>
                               <form:input type="text" path="address_city" class="form-control" placeholder="Enter City"/>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="inputGroup">
                                <label>Address</label>
                                <form:textarea name="" id="" path="address" cols="30" rows="5" class="form-control"
                                    placeholder="Enter Address"/>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="inputGroup">
                                <label>State</label>
                                <form:input type="text" path="state" class="form-control" placeholder="Enter State"/>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="inputGroup">
                                <label>PinCode</label>
                                <form:input type="text" path="pincode" class="form-control" placeholder="Enter PinCode"/>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="inputGroup">
                                <label>Country</label>
                                <form:input type="text" path="country" class="form-control" placeholder="Enter Country"/>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="inputGroup">
                                <label>Landmark</label>
                                <form:input type="text" path="landmark" class="form-control" placeholder="Enter Landmark"/>
                            </div>
                        </div>
                    </div>
                    <div class="text-center mb-10">
                       <button type="submit"  class="btn btn-primary ml-auto mr-10">Update </button>
                        <a href="#" class="btn btn-primary"><span>Cancel</span> </a>
                    </div>
                </div>
		</form:form>
                <div class="col-sm-4">
                    <div class="doctorProfile mb-20">
                        <img src="${pageContext.request.contextPath}/jsp/doctor/images/patientProfile.jpg">
                    </div>
                    <button class="btn btn-primary mr-10">Upload</button>
                    <button class="btn btn-default">Cancel</button>
                </div>

            </div>


        </div>

    </section>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/jsp/doctor/js/jquery.nicescroll.min.js"></script>
    <script src="${pageContext.request.contextPath}/jsp/doctor/js/bootstrap-datepicker.min.js"></script>
    <script src="${pageContext.request.contextPath}/jsp/doctor/js/app.js"></script>
    <script>
        $(function () {
            $('#filter button').click(function () {
                $('.btn-primary').removeClass('btn-primary');
                $(this).removeClass('btn-default').addClass('btn-primary');
            })
        });
    </script>
</body>

</html>