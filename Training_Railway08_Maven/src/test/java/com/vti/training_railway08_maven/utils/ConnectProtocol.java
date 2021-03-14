package com.vti.training_railway08_maven.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectProtocol {
	Scanner in = new Scanner(System.in);

	public Connection getConnection() throws ClassNotFoundException, SQLException {
//		System.out.print("Please enter name of the data base that you want to connect: ");
//		String databaseName = in.nextLine();
		String databaseName = "testingsystem2";
		
		String dbUrl = "jdbc:mysql://localhost:3306/" + databaseName
				+ "?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String user = "root";
		String pass = "root";

		// Step 1: register the driver class with DriverManager
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2: Get connection to database
		Connection connection = DriverManager.getConnection(dbUrl, user, pass);
		System.out.println("Connect successfully!");
		return connection;
	}
}
