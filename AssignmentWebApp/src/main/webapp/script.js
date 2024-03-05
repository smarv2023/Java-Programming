/**
 * Front end validation
 */
function validateUser() {
    var txtUser = document.getElementById("txtUser").value;
    var regex = /^\S+$/;;
    return regex.test(txtUser);
}

function validateForm() {
    if (!validateUser()) {
        alert("Please enter a valid username.");
        return false;
    }
    return true;
}

function ifNull() {
	var txtPass = document.getElementById("txtPass").value;
	
	if (txtPass == "") {
		alert("Please enter password")
		return false;
	}
	return true;
}
	
function stripInjection(input) {
// Regular expression to remove potentially harmful characters and script tags
	return input.replace(/<[^>]*>/g, '') // Remove all HTML tags
}

function checkInput() {
    var firstname = document.getElementById("firstName").value;
    var lastname = document.getElementById("lastName").value;
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var rePassword = document.getElementById("repassword").value;
    var alphaRegex = /^[a-zA-Z]+$/;
    var errorMsg = "";

    // Check if any input field is empty
    if (firstname === '') {
		document.getElementById("error_firstName").innerHTML = "*";
		errorMsg += "Enter first name.<br/>";	
	} else {
		    // Check if firstname contains only alphabetic characters
	    if (!alphaRegex.test(firstname)) {
	        errorMsg += "First name should be letters only.<br/>";
	        document.getElementById("error_firstName").innerHTML = "*";
	    } else {
			document.getElementById("error_firstName").innerHTML = "";
		}

	}
	
	// Check firstname
	if (lastname === '') {
		document.getElementById("error_lastName").innerHTML = "*";
		errorMsg += "Enter last name.<br/>";
	} else {
		// Check if lastname contains only alphabetic characters
	    if (!alphaRegex.test(lastname)) {
	        errorMsg += "Last name should be letters only.<br/>";
	        document.getElementById("error_lastName").innerHTML = "*";
	    } else {
			document.getElementById("error_lastName").innerHTML = "";
	    }
	}
	// Check username
	if (username === '') {
		document.getElementById("error_username").innerHTML = "*";
		errorMsg += "Enter username.<br/>";
	} else {
		document.getElementById("error_username").innerHTML = "";
	}
	
	// Check password
	if (password === '') {
		document.getElementById("error_password").innerHTML = "*";
		errorMsg += "Enter password.<br/>";
	} else {
		document.getElementById("error_password").innerHTML = "";
	}
	
	// Check retype password
	if (rePassword === '') {
		document.getElementById("error_repassword").innerHTML = "*";
		errorMsg += "Re-type password.<br/>";
	} else {
		    // Check if password and re-password match
		    if (password !== rePassword) {
		        document.getElementById("error_repassword").innerHTML = "*";
		        errorMsg += "Password did not match.<br/>";
		        
		    } else {
		        document.getElementById("error_repassword").innerHTML = "";
		    }
		//document.getElementById("error_repassword").innerHTML = "";
	}

    // Display error message if there are any errors
    document.getElementById("errorMessage").innerHTML = errorMsg;

    // Return false if there are errors, otherwise allow form submission
    if (errorMsg !== "") {
        return false; // Prevent form submission
    }
    return true; // Allow form submission
}