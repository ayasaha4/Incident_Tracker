
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
    
    jQuery.validator.addMethod("laxEmail", function(value, element) {
    	  // allow any non-whitespace characters as the host part
    	  return this.optional( element ) || /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/.test( value );
    	}, 'Please enter a valid email address.');

    
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
                laxEmail: true
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
                required: "Please enter Email address",
                laxEmail: "Please enter valid Email address"
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