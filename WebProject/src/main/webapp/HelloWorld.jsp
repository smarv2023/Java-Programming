<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="refresh" content="60">
<title>Hello World</title>
</head>
<body>
<h1>Hello World</h1>
 <%
        Date currentTime = new Date();
        out.println("<p>The current time is: " + currentTime + "</p>");
    %>
    
    <!--  <form method="get" action="HelloServlet">
    	<pre>
    		Enter your name: <input type="text" name=t1>
    		
    		<input type="submit">	<input type="reset">
    	</pre>
    </form>-->
</body>
</html>