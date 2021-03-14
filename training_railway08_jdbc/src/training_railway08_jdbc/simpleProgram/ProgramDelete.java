package training_railway08_jdbc.simpleProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ProgramDelete {
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
		String delete = "DELETE "
						+ "FROM `group`"
						+ "WHERE id = ?";
		PreparedStatement preStatement = connection.prepareStatement(delete);
		
		// Step 3.5: Input data for ? parameters
		Scanner in = new Scanner(System.in);
		System.out.print("\nInput group ID which you want to delete: ");
		int groupID = in.nextInt();
	
		
		preStatement.setInt(1, groupID);

		// Step 4: Execute the update
		int affectedRecordsCount = preStatement.executeUpdate();

		// Step 5: Handling result set
		System.out.println(affectedRecordsCount);
		
		connection.close();
	}
}
