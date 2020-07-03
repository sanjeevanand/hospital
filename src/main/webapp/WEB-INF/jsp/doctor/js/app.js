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
  
  /*  $('.date').datepicker();
    */
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
    	var awards = $("#Awards").val();
    	$.post( 
                "/rest/doctorAwardsDoc",
                {"awards": awards},
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
    $('#addMemberships').click(function(e){
    	var memberships = $("#Memberships").val();
    	$.post( 
                "/rest/doctorMembershipsDoc",
                {"member": memberships},
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
    
    
    $('#serviceDoctorDocUpdate').click(function(e){
    	var service = $("#serviceMaster option:selected").text();
    	$.post( 
                "/rest/serviceDoctorDoc",
                {"service": service},
                function(data) {
                	 if(data){
                		// alert(data);
						 $(location).attr('href',"/doctor/services");
					 }else{
						 alert("Invalid ");
					 }
                }
             );
    });
    $('#specializationDoctorDocUpdate').click(function(e){
    	var specialization = $("#specializationMaster option:selected").text();
    	$.post( 
                "/rest/specializationDoctorDoc",
                {"specialization": specialization},
                function(data) {
                	 if(data){
                		// alert(data);
						 $(location).attr('href',"/doctor/services");
					 }else{
						 alert("Invalid ");
					 }
                }
             );
    });
})

