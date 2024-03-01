
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get values from the login form
		PrintWriter out = response.getWriter();
		String user = request.getParameter("txtUser");
		String pass = request.getParameter("txtPass");
		
		// Create a object to hold the value
		User loginGetSet = new User();
		loginGetSet.setUser(user);
		loginGetSet.setPass(pass);
		
		// Create a Dao instance to validate
		UserDao loginDao = new UserDao();
		
		// Validate email and password
		boolean isValidUser = loginDao.validateUser(loginGetSet);

		if (isValidUser) {
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			
			rd.forward(request, response);
		} else {
			System.out.println("Failed");
			out.println("<div style='text-align: center;'>");
			out.println("<font color=red size=5>Login Failed!!<br/>");
			out.println("<a href='index.jsp'>Try Again</a>");
			out.println("</div>");
		}
	}
}
