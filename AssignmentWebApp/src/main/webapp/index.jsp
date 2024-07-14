<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Assignment Week 4</title>
</head>
<body class=body>
	<div class=container>
		<h1>Welcome to my Assignment</h1>
		<div class=content>
			<form method="post" action="login">
				<table>
					<tr>
						<th colspan="2">User Login</th>
					</tr>
					<tr>
						<td>Username:</td>
						<td><input type=text name=txtUser id=txtUser></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type=password name=txtPass id=txtPass></td>
					</tr>
					<tr>
						<td colspan="2"class=buttonS>
							<input class=submit type=submit onclick="return validateForm() && ifNull()">
							<input class=reset type=reset>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<h3><a href="register.jsp">Register New User</a></h3>
	</div>
	<script src="script.js"></script>
</body>
</html>