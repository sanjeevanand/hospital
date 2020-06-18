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
                    <a href="settings.html">Change Password</a>
                </li>
                <li>
                    <a class="activeTab" href="notifications.html">Notifications</a>
                </li>
                <li>
                    <a href="#" class="delete">Delete Account</a>
                </li>

            </ul>
            <section class="mt-30">
                <h1 class="notificationHeading">Email Settings</h1>
                <p class="mb-20">You are currently receiving all promotional communications on stegphen.george@gmail.com
                    <a href="#">(Change)</a></p>
                <div class="row mb-20">
                    <div class="col-sm-4">
                        <div class="notificationGroup">
                            <input type="checkbox" id="disbale">
                            <label for="disbale">
                                I want to receive:
                                <span> You can disable these at any time</span>
                            </label>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="notificationGroup">
                            <input type="checkbox">
                            <label>
                                Announcements
                                <span> Most important updates on new and exciting products.
                                    Sent around once in a month.</span>
                            </label>
                        </div>
                        <div class="notificationGroup">
                            <input type="checkbox">
                            <label>
                                Savings
                                <span>Get exclusive discounts and offers to save money on
                                    your healthcare bill. Sent usually once in 15 days.</span>
                            </label>
                        </div>
                        <div class="notificationGroup">
                            <input type="checkbox">
                            <label>
                                Feedback
                                <span>Get beta invitations, surveys and feedback forms,
                                    for sharing your suggestions. Sent once in a month.</span>
                            </label>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="notificationGroup">
                            <input type="checkbox">
                            <label>
                                Health Tips
                                <span>Get the most insightful health tips and articles from
                                    verified doctors. Sent 1-2 times per week.</span>
                            </label>
                        </div>

                        <div class="notificationGroup">
                            <input type="checkbox">
                            <label>
                                Informational
                                <span>Get to know what's the latest through our newsletters,
                                    product updates and more! Sent once in a week.</span>
                            </label>
                        </div>
                    </div>
                </div>
                <h1 class="notificationHeading">SMS settings</h1>
                <p class="mb-20">You are currently receiving all promotional communications on +919739157239 (Change)
                </p>
                <div class="row mb-20">
                    <div class="col-sm-4">
                        <div class="notificationGroup">
                            <input type="checkbox" id="disbale">
                            <label for="disbale">
                                I want to receive:
                                <span> You can disable these at any time</span>
                            </label>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="notificationGroup">
                            <input type="checkbox">
                            <label>
                                Announcements
                                <span> Most important updates on new and exciting products.
                                    Sent around once in a month.</span>
                            </label>
                        </div>
                        <div class="notificationGroup">
                            <input type="checkbox">
                            <label>
                                Savings
                                <span>Get exclusive discounts and offers to save money on
                                    your healthcare bill. Sent usually once in 15 days.</span>
                            </label>
                        </div>
                        <div class="notificationGroup">
                            <input type="checkbox">
                            <label>
                                Feedback
                                <span>Get beta invitations, surveys and feedback forms,
                                    for sharing your suggestions. Sent once in a month.</span>
                            </label>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="notificationGroup">
                            <input type="checkbox">
                            <label>
                                Health Tips
                                <span>Get the most insightful health tips and articles from
                                    verified doctors. Sent 1-2 times per week.</span>
                            </label>
                        </div>

                        <div class="notificationGroup">
                            <input type="checkbox">
                            <label>
                                Informational
                                <span>Get to know what's the latest through our newsletters,
                                    product updates and more! Sent once in a week.</span>
                            </label>
                        </div>
                    </div>
                </div>
                <h1 class="notificationHeading">WhatsApp settings</h1>
                <p class="mb-20">You are currently receiving all communications on +919739137239 (Change)
                </p>
                <div class="row">
                    <div class="col-sm-6">
                        <div class="notificationGroup">
                            <input type="checkbox" id="disbale">
                            <label for="disbale">
                                I want to receive important notifications and updates via WhatsApp.
                                <span> You can disable these at any time</span>
                            </label>
                        </div>
                    </div>
                </div>
                <hr class="mt-0">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="notificationGroup">
                            <input type="radio" >
                            <label >
                                I want to unsubscribe entirely
                               
                            </label>
                        </div>
                    </div>
                </div>
                <hr class="mt-0">
                <div class="row">
                    <div class="col-sm-12 text-center">
                        <button class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </section>
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
        
        $(".delete").click(function () {
           
           var value = confirm("Do you want to delete this account" );
           if(value)
        	   $.get( 
                       "/rest/doctorDeactivate",
                       function(data) {
                       	 if(data){
                       		 alert("Account Deleted successfully !");
								 $(location).attr('href',"/doctor/");
							 }else{
								 alert("Contact to admin !");
							 }
                       }
                    );
        });
    </script>
</body>

</html>