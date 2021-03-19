package training_railway08_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class JDBCUtils {
	Scanner in = new Scanner(System.in);

	public Connection connect() throws Exception {
		String databaseName = "testingsystem2";
		
		String dbUrl = "jdbc:mysql://localhost:3306/" + databaseName
				+ "?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String user = "root";
		String pass = "root";

		// Step 1: register the driver class with DriverManager
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2: Get connection to database
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(dbUrl, user, pass);
			System.out.println("Connect successfully!");
			return connection;
		} catch (Exception e) {
			throw new Exception("Can't connect to the server, please check the database name or connection URL!");
		}
	}
}
