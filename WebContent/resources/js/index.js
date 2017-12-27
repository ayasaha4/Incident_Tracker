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
                required: "username is required!"
            },
            "password": {
                required: "Please enter a password"
            }
        },
        submitHandler: function (form) {
            form.submit(); // <-- this is default
            
        }
    });
    
});