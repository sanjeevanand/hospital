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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/patient/css/app.css">
</head>

<body>
     <jsp:include page="header_p.jsp" />
   <jsp:include page="navbar_p.jsp" />
  
     <section class="dataContainer">
        <div class="pageHeader">
            <h1>Profile</h1>
        </div>
        <div class="dataSection">

            <div>
                <form:form action="savePatient" modelAttribute="patient" method="POST" class="form-horizontal" encType='multipart/form-data'>
				<form:hidden path="patientId"  />
                <div class="patientBasic mb-15">
                    <div class="docProfile">
                        <img src="${pageContext.request.contextPath}/jsp/patient/images/doctorSample.jpg" alt="">
                    </div>
                    <div class="inputGroup ml-50">
                        <label>Name</label>
                        <form:input type="text" path="name" class="form-control" placeholder="Yogeswaran"/>
                    </div>
					
                </div>

                <div class="patientFormGroup">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="inputGroup">
                                <label>Phone</label>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <select name="" id="" class="form-control">
                                            <option value="">+91</option>
                                        </select>
                                    </div>
                                    <div class="col-sm-9">
                                        <form:input path="mobile" type="text" class="form-control" placeholder="9742225501"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="inputGroup">
                                <label>Email Address</label>
                                <form:input type="text" path="email" class="form-control" placeholder="Yogeswaran@gmail.com"/>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="inputGroup">
                                <label>Gender</label>
                                <form:select path="gender" id="gender" class="form-control">
                                    <!-- <option value="male">Male</option>
                                    <option value="male">female</option> -->
                                    <form:options items="${genders}" />
                                </form:select>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="inputGroup">
                                <label>Date Of Birth</label>
                                <form:input type="text" path="dob" class="form-control date" placeholder="15/03/1993"/>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="inputGroup">
                                <label>Blood Group</label>
                                <form:select path="bloodGroup"  id="bloodGroup" class="form-control">
                                   <!--  <option value="male">A1+</option> -->
									 <form:options items="${bloodgrp}" />
                                </form:select>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="inputGroup">
                                <label>TimeZone</label>
                                <form:select path="timeZone" name="" id="" class="form-control">
                                    <option value="male">(UTC+05:30) Asia/Kolkata</option>

                                </form:select>
                            </div>
                        </div>
                    </div>
                </div>

                <h1 class="form-title">
                    Address
                </h1>
                <div class="patientFormGroup">
                <form:hidden path="address.id" />
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="inputGroup">
                                <label>House No./ Street Name/ Area</label>
                                <form:input path="address.houseNo" type="text" class="form-control"/>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="inputGroup">
                                <label>Colony / Street / Locality</label>
                                <form:input path="address.colony" type="text" class="form-control"/>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="inputGroup">
                                <label>City</label>
                                <form:input path="address.city" type="text" class="form-control" placeholder="Enter City"/>
                            </div>
                        </div>

                        <div class="col-sm-4">
                            <div class="inputGroup">
                                <label>State</label>
                                <form:input path="address.state" type="text" class="form-control" placeholder="Enter State"/>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="inputGroup">
                                <label>PinCode</label>
                                <form:input path="address.pincode" type="text" class="form-control" placeholder="Enter PinCode"/>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="inputGroup">
                                <label>Country</label>
                                <form:input path="address.country" type="text" class="form-control" placeholder="Enter Country"/>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="inputGroup">
                                <label>Landmark</label>
                                <form:input path="address.landmark" type="text" class="form-control" placeholder="Enter Landmark"/>
                            </div>
                        </div>
                    </div>
                </div>
                <h1 class="form-title">
                    Other Information
                </h1>
                <div class="patientFormGroup">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="inputGroup">
                                <label>Extra phone numbers</label>
                                <form:input path="extraPhone" type="text" class="form-control"/>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="inputGroup">
                                <label>Language</label>
                                <form:select path="language" name="" id="language" class="form-control">
                                     <form:options items="${lang}" />
                                </form:select>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="text-center mb-10">
                   <!--  <a href="#" class="btn btn-primary ml-auto mr-10"><span>Save Changes</span> </a>
                    -->
                     <button type="submit" class="btn btn-primary ml-auto mr-10" id="btn-submit" name="submit">Save Changes</button>
          			
                     <a href="#" class="btn btn-primary"><span>Back</span> </a>
                </div>
                </form:form>
            </div>
        </div>
    </section>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/jsp/patient/js/jquery.nicescroll.min.js"></script>
    <script src="${pageContext.request.contextPath}/jsp/patient/js/app.js"></script>
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