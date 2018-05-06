/*
$('#hulk').prop('disabled' , true);
$('#cnfpassword').on('keyup', function () {
    var password = $("#password").val();
    var confirmPassword = $("#cnfpassword").val();

    if (password != confirmPassword) {
        $("#divCheckPassword").html("Passwords do not match!");
    } else {
        $("#divCheckPassword").html("Passwords match.");
        $('#hulk').prop('disabled' , false);
    }
});
*/

function isPasswordMatch() {
    var password = $("#password").val();
    var confirmPassword = $("#cnfpassword").val();

    if (password != confirmPassword)
    {
		$("#divCheckPassword").html("Passwords do not match!");
		//$('#submit-button').prop('disabled', false);
		document.getElementById("submit-button").disabled = true;
    }
	else
	{
		$("#divCheckPassword").html("Passwords match.");
		//$('#submit-button').prop('disabled', true);
		document.getElementById("submit-button").disabled = false;
	}
}

$(document).ready(function () {
    $("#cnfpassword").keyup(isPasswordMatch);
});

/*
function validate() {
    var password1 = $("#password").val();
    var password2 = $("#cnfpassword").val();
    if(password1 == password2) {
         $("#validate-status").text("Passwords Match!");
         $('#submit-button').prop('disabled', false);
    }
    else {
         $("#validate-status").text("Passwords Do Not Match!");  
         $('#submit-button').prop('disabled', true);
    }
}
*/