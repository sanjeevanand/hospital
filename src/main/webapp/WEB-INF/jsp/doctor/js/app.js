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
                		// alert(data);
						 $(location).attr('href',"/doctor/registration");
					 }else{
						 alert("Invalid ");
					 }
                }
             );
    });
    
    $('#educationDocUpdate').click(function(e){
    	//var education = prompt("Please Enter Your Education Details", "");
    	$.post( 
                "/rest/doctorEducationDoc",
                {"education": $('#education').val()},
                function(data) {
                	 if(data){
                		// alert(data);
						 $(location).attr('href',"/doctor/experience");
					 }else{
						 alert("Invalid ");
					 }
                }
             );
    });
    
    $('#workExperienceDocUpdate').click(function(e){
    	//var workExperience = prompt("Please Enter Your workExperience Details", "");
    	$.post( 
                "/rest/doctorExperiencedDoc",
                {"experience": $('#workExperience').val()},
                function(data) {
                	 if(data){
                		// alert(data);
						 $(location).attr('href',"/doctor/experience");
					 }else{
						 alert("Invalid ");
					 }
                }
             );
    });
    
    
    
    $('#addAwards').click(function(e){
    	var awards = $("Awards").val();
    	$.post( 
                "/rest/doctorExperiencedDoc",
                {"workExperience": workExperience},
                function(data) {
                	 if(data){
                		// alert(data);
						 $(location).attr('href',"/doctor/awards");
					 }else{
						 alert("Invalid ");
					 }
                }
             );
    });
})