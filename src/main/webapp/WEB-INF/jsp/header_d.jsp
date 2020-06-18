<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <header class="primaryHeader">
        <h1>My Hospitals</h1>
        <a href="#" class="navIcon" data-toggle="tooltip" title="Show and hide menu" data-placement="bottom">
            <img src="${pageContext.request.contextPath}/jsp/doctor/images/nav.png">
        </a>
        <a href="#" class="notificationIcon">
            <img src="${pageContext.request.contextPath}/jsp/doctor/images/bell.png">
        </a>
        <p>Welcome
            <span>${userDoctor.firstname}</span>
        </p>
        <div class="profileImage">
            <img src="${pageContext.request.contextPath}/jsp/doctor/images/profile.jpg">
        </div>
    </header>