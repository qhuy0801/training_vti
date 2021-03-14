package training_railway08_jdbc.simpleProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ProgramInsert {
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
		String insert = "	INSERT INTO `Group` (`name` , `author_ID`) "
				+ "			VALUE 				('Java Senior', 5)";
		Statement statement = connection.createStatement();

		// Step 4: Execute the update
		int affectedRecordsCount = statement.executeUpdate(insert);

		// Step 5: Handling result set
		System.out.println(affectedRecordsCount);
		
		connection.close();
	}
}
