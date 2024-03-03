import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class addressBookDAO {
	public boolean insertUser(addressBooksBean address) {
		String SQL = "INSERT INTO [AddressBooks] (FirstName, LastName, Street, City, State, Zip)"
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		try (Connection con = DBUtil.getConnection(); PreparedStatement pstmt = con.prepareStatement(SQL)) {
			pstmt.setString(1, address.getFirstName());
			pstmt.setString(2, address.getLastName());
			pstmt.setString(3, address.getStreet());
			pstmt.setString(4, address.getCity());
			pstmt.setString(5, address.getState());
			pstmt.setString(6, address.getZip());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
