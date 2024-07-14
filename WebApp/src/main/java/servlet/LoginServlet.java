package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=Users;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
		try(Connection con = DriverManager.getConnection(connectionString)) {
			PrintWriter out = response.getWriter();
			System.out.println("Connection established.");
			String email = request.getParameter("txtUser");
			String pass = request.getParameter("txtPwd");
			
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM [user] WHERE Email=? AND Password =?");
			
			pstmt.setString(1, email);
			pstmt.setString(2, pass);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("SystemConnected");
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			} else {
				System.out.println("SystemFailed");
				out.println("<font color=red size=18>Login Failed!!<br/>");
				out.println("<a href=index.jsp>Try Again</a>");
			}
			
		} catch(SQLException sqlE) {
			sqlE.printStackTrace();
		}
	}

}
