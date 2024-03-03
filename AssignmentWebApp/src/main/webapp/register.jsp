<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

	<div class=container>
		<h2>User Registration</h2>
		<div class="contentR content">

	    	<form method="post" action="register">
	    		<table>
	    			<tr>
			        	<td><label for="firstName">First Name:</label></td>
			        	<td><input type="text" id="firstName" name="firstName"><span id="error_firstName"></span></td>
			        </tr>
			        <tr>
				        <td><label for="lastName">Last Name:</label></td>
				        <td><input type="text" id="lastName" name="lastName"><span id="error_lastName"></span></td>
			        </tr>
			        <tr>
			        	<td><label for="username">Username:</label></td>
			        	<td><input type="text" id="username" name="username"><span id="error_username"></span></td>
			        </tr>
			        <tr>
			        	<td><label for="password">Password:</label></td>
			        	<td><input type="password" id="password" name="password"><span id="error_password"></span></td>
			        </tr>
			        <tr>
			        	<td><label for="repassword">Re-Password:</label></td>
			        	<td><input type="password" id="repassword" name="repassword"><span id="error_repassword"></span></td>
			        </tr>
			        <tr>
			        	<td colspan="2" class=buttonS>
			        		<input class=submit type="submit" value="Register" onclick="return checkInput()">
			        		<input class=reset type="reset" value="Reset">
			        	</td>
			        </tr>
		        </table>
    		</form>
    		<div id="errorMessage"></div>
		</div>
		<a href="index.jsp"><h3>Back to Login</h3></a>
	</div>

	<script src="script.js"></script>
</body>
</html>