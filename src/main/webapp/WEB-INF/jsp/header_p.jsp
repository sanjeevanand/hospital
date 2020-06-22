<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <header class="primaryHeader">
        <h1>My Hospitals</h1>
        <a href="#" class="navIcon" data-toggle="tooltip" title="Show and hide menu" data-placement="bottom">
            <img src="${pageContext.request.contextPath}/jsp/patient/images/nav.png">
        </a>
        <a href="#" class="notificationIcon">
            <img src="${pageContext.request.contextPath}/jsp/patient/images/bell.png">
        </a>
        <p>Welcome
            <span>${userPatient.name}</span>
        </p>
        <div class="profileImage">
            <img src="${pageContext.request.contextPath}/jsp/patient/images/profile.jpg">
        </div>
    </header>
   