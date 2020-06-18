 $(function () {
            $('.loginTab a').click(function () {
                $('#verifyOtp').hide();
                $('.loginTab a').removeClass('loginTabActive')
                $(this).addClass('loginTabActive');
                $('.tabSec').hide();
                $(`#${$(this).attr('data-show')}`).show();
            });
            $('#sendOtp').click(function (e) {
                e.preventDefault();
                $.post( 
                        "/rest/doctorRegistration",
                        {"firstname": $("#firstname").val(),"mobile":$("#mobile").val(),"password":$("#password").val() },
                        function(data) {
                        	if(data.name==="exist"){
                        		alert("user already exists")
                        	}else{
                        	 $('#registerUser').hide();
                        	 $("#otpMob").text(data.mobile);
                             $('#verifyOtp').show();
                        	}
                        }
                     );
              //  $('#registerUser').hide();
              //  $('#verifyOtp').show();
            });
            $('#verifyOtpBtn').click(function(e){
            	$.post( 
                        "/rest/doctorOtpVerify",
                        {"otp": $("#otp").val(),"mobile":$("#mobile").val()},
                        function(data) {
                        	 if(data){
                        		 //alert(data);
								 $(location).attr('href',"/doctor/dashboard");
							 }else{
								 alert("Invalid Otp");
							 }
                        }
                     );
            });
        });