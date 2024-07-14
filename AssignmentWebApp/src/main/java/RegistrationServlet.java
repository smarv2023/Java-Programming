

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		// Call method if user already exist
		UserDao userCheck = new UserDao();
		if (userCheck.isUsernameExists(user)) {
            out.println("<div style='text-align: center;'>");
            out.println("<font color=red size=5>Username already exists!<br/>");
            out.println("<a href='register.jsp'>Try Again</a>");
            out.println("</div>");
            return; // Exit the method if the user name already exists
		}
		
		User userRegister = new User();
		userRegister.setFirstName(firstName);
		userRegister.setLastName(lastName);
		userRegister.setUser(user);
		userRegister.setPass(pass);
		
		UserDao registerDao = new UserDao();
		
		boolean newUserAdded = registerDao.insertUser(userRegister);
		
		if (newUserAdded) {
			System.out.println("New user added");
			out.println("<div style='text-align: center;'>");
			out.println("<font color=green size=5>User successfully registered!<br/>");
			out.println("<a href='register.jsp'>Back</a>");
			out.println("</div>");
		} else {
			System.out.println("Failed");
			out.println("<div style='text-align: center;'>");
			out.println("<font color=red size=5>Register Failed!!<br/>");
			out.println("<a href='register.jsp'>Try Again</a>");
			out.println("</div>");
		}
	}

}
