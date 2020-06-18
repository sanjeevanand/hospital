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
            })
        });
