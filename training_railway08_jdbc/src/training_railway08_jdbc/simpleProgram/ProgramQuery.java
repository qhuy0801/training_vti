package training_railway08_jdbc.simpleProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProgramQuery {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String dbUrl = "jdbc:mysql://localhost:3306/Testingsystem?useSSL=false";
		String user = "root";
		String pass = "root";

		// Step 1: register the driver class with DriverManager
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2: Get connection to database
		Connection connection = DriverManager.getConnection(dbUrl, user, pass);
		System.out.println("Connect successfully!");

		// Step 3: Create statement object (string)
		String query = "SELECT	id, username, email FROM `user`";
		Statement statement = connection.createStatement();

		// Step 4: Execute the query
		ResultSet resultSet = statement.executeQuery(query);

		// Step 5: Handling result set
		while (resultSet.next()) {
			System.out.print(resultSet.getInt("id") + " "); // or 1
			System.out.print(resultSet.getString("username") + " "); // or 2
			System.out.print(resultSet.getString("email") + " \n"); // or 3
		}

		connection.close();
	}
}
