
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {	
	public boolean validateUser(User loginGetSet) {
		String SQL = "SELECT * FROM [user] WHERE username = ? AND password = ?";
		// Auto close connection
		try (Connection connection = DBUtil.getConnection(); PreparedStatement pstmt = connection.prepareStatement(SQL)) {
			pstmt.setString(1, loginGetSet.getUser());
			pstmt.setString(2, loginGetSet.getPass());
			ResultSet result = pstmt.executeQuery();
			return result.next();
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
			return false;
		}
	}
	
	public boolean insertUser(User user) {
		String SQL = "INSERT INTO [user] (FirstName, LastName, username, password) "
				+ "VALUES (?,?,?,?)";
		try (Connection connection = DBUtil.getConnection(); PreparedStatement pstmt = connection.prepareStatement(SQL)) {
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getUser());
			pstmt.setString(4, user.getPass());
			//int affectedRows = pstmt.executeUpdate();
			pstmt.executeUpdate();
			return true;
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
			return false;
		}
	}
	
	//check if it is already existing
	public boolean isUsernameExists(String user) {
		String SQL = "SELECT COUNT(*) FROM [user] WHERE username = ?";
		try(Connection connection = DBUtil.getConnection(); PreparedStatement pstmt = connection.prepareStatement(SQL)) {
			pstmt.setString(1, user);
			ResultSet result = pstmt.executeQuery();
			if (result.next()) {
				int count = result.getInt(1);
				return count > 0;
			}
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
		}
		return false;
	}
}
