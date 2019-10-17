
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


$( document ).ready(function(){

    $('#reviewBtn').click(function(event){
        event.preventDefault();

        var data = JSON.stringify($("#reviewForm").serializeFormJSON());
        // var data = JSON.stringify({id:$('#id').val(),content:$('#content').text()});

        $.ajax({
            type: 'POST',
            url: '/saveReview/' + $('#bookid').val(),
            data: data,
            contentType: 'application/json',
            dataType: 'json',
            success: function(review){
                //append to review list
                // $('#result').empty();
                $('#result').append(review.id + ', ' + review.content + '</br> ');
            },
            error: function (xmlResponse) {
                $('#result').empty();
                var responseJson = xmlResponse.responseJSON;

                if(responseJson.errorType === 'ValidationError'){
                    var errorList = responseJson.fieldErrors;

                    $.each(errorList, function(index, error){
                        $('#result').append('<p>' + error.field + ', ' + error.message + '</p>');
                    });

                }else{
                    alert("other errors");
                }

            }

        });

    });

});