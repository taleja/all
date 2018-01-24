package example;

/**
 * @author olena.viliuzhanina
 *
 */
import java.sql.*;

public class JDBCExample {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/jdbc_test";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			
//			conn.commit();
//			conn.rollback();

		
			String sql;
			sql = "SELECT first_name, last_name, phone, email FROM register";
			ResultSet rs = stmt.executeQuery(sql);
			
//			String sql_ins;
//			sql_ins = "INSERT INTO register (first_name, last_name, phone, email) VALUES('Olena','Viliuzhanina','9999','mail_1')";			
//			stmt.executeUpdate(sql_ins);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String phone = rs.getString("phone");
				String email = rs.getString("email");

				// Display values
				System.out.print("First name: " + first_name);
				System.out.print(", Last name: " + last_name);
				System.out.print(", Phone: " + phone);
				System.out.println(", Email: " + email);
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}
}
