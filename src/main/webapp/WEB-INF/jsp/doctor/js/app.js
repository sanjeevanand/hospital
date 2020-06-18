$(function(){
    $('[data-toggle="tooltip"]').tooltip();   
    $('.hasChild').click(function(){
        $(this).next('.childMenu').slideToggle();
    })
    $('.navIcon').click(function(){
        $('.navigation').toggleClass('navigationClose')
        $('.dataContainer').toggleClass('dataContainerOpen')
    })
    $("#scrollTable").getNiceScroll().resize();
    $("#scrollTable").niceScroll({
        cursorcolor: "#333",
        cursorborder: "0px",
        cursorwidth: "8px",
        zindex: "9999"
    });
    $('#filterIcon').click(function(){
        $('#filterSec').slideToggle()
    });
  
    $('.date').datepicker();
    
    $('#regdocUpdate').click(function(e){
    	$.post( 
                "/rest/doctorRegistrationDoc",
                {"regNo": $("#regNo").val(),"regYear":$("#regYear").val()},
                function(data) {
                	 if(data){
                		 alert(data);
						 $(location).attr('href',"/doctor/dashboard");
					 }else{
						 alert("Invalid Otp");
					 }
                }
             );
    });
})