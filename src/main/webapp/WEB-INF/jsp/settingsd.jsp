<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Change Password</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@100;200;300;400;500;600;700;800;900&display=swap"
        rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@200;300;400;600;700;900&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/doctor/css/app.css">
</head>

<body>
     <jsp:include page="header_d.jsp" />
   <jsp:include page="navbar_d.jsp" />
    <section class="dataContainer">
        <div class="pageHeader">
            <h1>Settings</h1>
        </div>
        <div class="dataSection">
            <ul class="tabs noTopBorder">
                <li>
                    <a class="activeTab" href="/doctor/settings">Change Password</a>
                </li>
                <li>
                    <a href="/doctor/notifications">Notifications</a>
                </li>
                <li>
                    <a href="#">Delete Account</a>
                </li>

            </ul>
            <form action="/doctor/changePassword" method="post">
            <div class="row mt-30">
                <div class="col-sm-6">
                    <div class="inputGroup">
                        <label>Current Password</label>
                        <input name="password" type="password" class="form-control" placeholder="Current Password">
                   	<span>${msg}</span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6">
                    <div class="inputGroup">
                        <label>New Password</label>
                        <input name="newPassword" type="password" class="form-control" placeholder="New Password">
                    	<span>${msg}</span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6">
                    <div class="inputGroup">
                        <label>Confirm Password</label>
                        <input name="newRepassword" type="password" class="form-control" placeholder="Confirm Password">
                    	
                    </div>
                </div>
            </div>
            <button class="btn btn-primary">Submit</button>
            </form>
        </div>
    </section>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/jsp/doctor/js/jquery.nicescroll.min.js"></script>
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