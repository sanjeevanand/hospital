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
                $('#registerUser').hide();
                $('#verifyOtp').show();
            });
            $('#provideEmail').click(function(e) {
        		//validateForm();
        		var email_mobile = $('#email').val();
        		if(email_mobile===''){
        			 alert("Email/Phone Field should not be empty !");
        			    return false;
        		}
        		
        	});
        });
