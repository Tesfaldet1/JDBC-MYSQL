package lexicon.se;

import java.sql.*;

public class App {

	public static void main(String[] args) throws SQLException {

		Connection connection = null;
		Statement stetment = null;
		ResultSet resultSet = null;

		String dbUrl = "jdbc:mysql://localhost:3306/demo";
		String user = "Tesfaldet";
		String password = "Tesfaldet@19";

		try {
			// 1. Get a connection to database
			connection = DriverManager.getConnection(dbUrl, user, password);

			// 2. Create a statement
			stetment = connection.createStatement();

			// 3. Execute SQL query
			resultSet = stetment.executeQuery("select * from employees");

			// 4. Process the result set
			while (resultSet.next()) {
				System.out.println(resultSet.getString("last_name") + ", " + resultSet.getString("first_name"));
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (resultSet != null) {
				resultSet.close();
			}

			if (stetment != null) {
				stetment.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}
}
