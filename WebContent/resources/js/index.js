
$(document).ready(function() {
    
    $("#loginForm").validate({
        rules: {
            "userName": {
                required: true
            },
            "password": {
                required: true
            }
        },
        messages: {
            "userName": {
                required: "Please enter User Name"
            },
            "password": {
                required: "Please enter Password"
            }
        },
        errorPlacement: function (error, element) {
            //    error.appendTo($(element).parent().next());
                  var container = $(element).closest(".row").find(".error_msg");
                  error.appendTo(container);
            },
        submitHandler: function (form) {
            form.submit(); // <-- this is default
            
        }
    });
    
    
    $("#registerForm").validate({
        rules: {
            "userName": {
                required: true
            },
            "password": {
                required: true
            },
            "email": {
                required: true,
                eamil: true
            },
            "phone": {
                required: true
            },
            "location": {
                required: true
            }
        },
        messages: {
            "userName": {
                required: "Please enter User Name"
            },
            "password": {
                required: "Please enter Password"
            },
            "email": {
                required: "Please enter Email address"
            },
            "phone": {
                required: "Please enter Phone number"
            },
            "location": {
                required: "Please enter Location"
            }
        },
        errorPlacement: function (error, element) {
            //    error.appendTo($(element).parent().next());
                  var container = $(element).closest(".row").find(".error_msg");
                  error.appendTo(container);
            },
        submitHandler: function (form) {
            form.submit(); // <-- this is default
            
        }
    });
    
});