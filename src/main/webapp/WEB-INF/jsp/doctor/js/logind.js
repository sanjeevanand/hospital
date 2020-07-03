$(function() {
	$('.loginTab a').click(function() {
		$('#verifyOtp').hide();
		$('.loginTab a').removeClass('loginTabActive')
		$(this).addClass('loginTabActive');
		$('.tabSec').hide();
		$(`#${$(this).attr('data-show')}`).show();
	});
	$('#sendOtp').click(function(e) {
		e.preventDefault();
		$.post("/rest/doctorRegistration", {
			"firstname" : $("#firstname").val(),
			"mobile" : $("#mobile").val(),
			"password" : $("#password").val()
		}, function(data) {
			if (data.firstname === "exist") {
				alert("user already exists")
			} else {
				$('#registerUser').hide();
				if (data.mobile.length == 0){
					$("#otpMob").text(data.email);
					$('.loginTab').hide();
					$('#emailConfirm').show();
					}
				else{
					$("#otpMob").text(data.mobile);
					$('#verifyOtp').show();}
			}
		});
		//  $('#registerUser').hide();
		//  $('#verifyOtp').show();
	});
	$('#verifyOtpBtn').click(function(e) {
		//validateForm();
		$.post("/rest/doctorOtpVerify", {
			"otp" : $("#otp").val(),
			"mobile" : $("#mobile").val()
		}, function(data) {
			if (data) {
				//alert(data);
				$(location).attr('href', "/doctor/dashboard");
			} else {
				alert("Invalid Otp");
			}
		});
	});
	$('#login').click(function(e) {
		//validateForm();
		var email_mobile = $('#mobile').val();
		var pwd = $('#pwd').val();
		if(email_mobile===''){
			 alert("Email/Phone Field should not be empty !");
			    return false;
		}
		if(pwd===''){
			 alert("Password must be filled out");
			    return false;
		}
	});
	
});