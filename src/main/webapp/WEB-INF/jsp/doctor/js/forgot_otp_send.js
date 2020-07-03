$(function() {
	
	
	$('#forgotVerifyOtpBtn').click(function(e) {
		$.post("/rest/doctorOtpVerify", {
			"otp" : $("#otp").val(),
			"mobile" : $("#mobile").text()
		}, function(data) {
			if (data) {
				//alert(data);
				$(location).attr('href', "/doctor/reset/"+$("#mobile").text());
			} else {
				alert("Invalid Otp");
			}
		});
	});
});