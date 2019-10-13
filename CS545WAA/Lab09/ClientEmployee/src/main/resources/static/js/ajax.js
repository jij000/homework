(function ($) {
    $.fn.serializeFormJSON = function () {

        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };
})(jQuery);

$(document).ready(function() {


	$("#ajaxBtn").click(function(event){
		event.preventDefault();
//$("#bookForm").serializeFormJSON();
// {name: "Spring MVC", isbn: "111"}
//		JSON.stringify
		//{"name": "Spring MVC", "isbn" : "111"}
		let employeeJSON = JSON.stringify($("#employeeForm").serializeFormJSON());

		$.ajax({
			type: "POST",
			url: "http://127.0.0.1:8081/addEmployee",
			data: employeeJSON,
			contentType: "application/json",
			dataType: "json",
			success: function(result){
				console.log('success');
				console.log(result);
				$('#errors').hide();
				$('#formInput').show();
				$('#formInput').append('<h3>New Employee Information</h3>');
				$('#formInput').append('<p>First Name: ' + result.firstName + '</p>');
				$('#formInput').append('<p>Last Name: ' + result.lastName + '</p>');
				$('#formInput').append('<p>Email Name: ' + result.email + '</p>');
			},
			error: function (XMLHttpRequest, textStatus, errorThrown) {
				console.log('error');
				$('#errors').empty();
				$('#errors').show();
				$('#formInput').hide();
				let errorObj = XMLHttpRequest.responseJSON;
				if(errorObj.errorType === 'ValidationError'){
					let errorArray = errorObj.fieldErrors;

					let errorMessage = "<h3>Errors!!</h3>";

					$.each(errorArray, function(index, e){
						errorMessage += "<p>";
						errorMessage = errorMessage + e.field +" : " + e.message;
						errorMessage += "</p>";
					});

					$('#errors').append(errorMessage);

				}else{
					alert("error happened not because of validation")
				}


			}
		});

	});

});