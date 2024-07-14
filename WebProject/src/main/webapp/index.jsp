<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Date"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Personal Information Form</title>
</head>
<body>

<h2>Personal Information Form</h2>

	<form action="register" method="post">
		  <label for="firstName">First Name:</label><br>
		  <input type="text" id="firstName" name="firstName" required><br>
		  
		  <label for="lastName">Last Name:</label><br>
		  <input type="text" id="lastName" name="lastName" required><br>
		  
		  <label for="street">Street:</label><br>
		  <input type="text" id="street" name="street" required><br>
		  
		  <label for="city">City:</label><br>
		  <input type="text" id="city" name="city" required><br>
		  
		  <label for="state">State:</label><br>
		  <input type="text" id="state" name="state" required><br>
		  
		  <label for="zipcode">Zip Code:</label><br>
		  <input type="text" id="zipcode" name="zipcode" required><br><br>
		  
		  <input type="submit" value="Submit">
	</form> 

</body>
</html>
