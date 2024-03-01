<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome To My Assignment</h1>
	<div class="content">
		<h2>User Login</h2>
		<form action=LoginServlet method=post>
			<label for="email"></label><br/>
			<input type=text name=txtUser><br/>
			
			<label for="password"></label><br/>
			<input type=text name=txtPwd><br/>
			
			<input type=submit value=Login><input type=reset>
			
			<div>
				<a href=>Register User</a>
			</div>
			
		</form>
	</div>
</body>
</html>