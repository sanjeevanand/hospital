$(function(){
    
	 $('#addspeciality').click(function(e){
     	$.post("/rest/addSpeciality",
                 {"speciality": $("#speciality").val()},
                 function(data) {
                 	 if(data){
                 		 alert("Record added !");
							 $(location).attr('href',"/admin/doctersmaster");
						 }else{
							 alert("Invalid Operation");
						 }
                 }
              );
     });
	 $('#addSpecialization').click(function(e){
	     	$.post("/rest/addSpecialization",
	                 {"specialization": $("#specialization").val()},
	                 function(data) {
	                 	 if(data){
	                 		 alert("Record added !");
								 $(location).attr('href',"/admin/specializationmaster");
							 }else{
								 alert("Invalid Operation");
							 }
	                 }
	              );
	     });
	 $('#addService').click(function(e){
	     	$.post("/rest/addService",
	                 {"service": $("#service").val()},
	                 function(data) {
	                 	 if(data){
	                 		 alert("Record added !");
								 $(location).attr('href',"/admin/servicemaster");
							 }else{
								 alert("Invalid Operation");
							 }
	                 }
	              );
	     });
});