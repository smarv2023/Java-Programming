

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class addressRegister
 */
public class addressRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String fistName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zipcode");
		
		addressBooksBean address = new addressBooksBean();
		address.setFirstName(fistName);
		address.setLastName(lastName);
		address.setStreet(street);
		address.setCity(city);
		address.setState(state);
		address.setZip(zip);
		
		addressBookDAO registerAddress = new addressBookDAO();
		boolean newAddressAdded = registerAddress.insertUser(address);
		
		if (newAddressAdded) {
			System.out.println("New user added");
			out.println("<div style='text-align: center;'>");
			out.println("<font color=green size=5>User successfully registered!<br/>");
			out.println("<a href='index.jsp'>Back</a>");
			out.println("</div>");
		} else {
			System.out.println("Failed");
			out.println("<div style='text-align: center;'>");
			out.println("<font color=red size=5>Register Failed!!<br/>");
			out.println("<a href='index.jsp'>Try Again</a>");
			out.println("</div>");
		}
	}
}
