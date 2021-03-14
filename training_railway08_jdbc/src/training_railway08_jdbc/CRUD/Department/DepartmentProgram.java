package training_railway08_jdbc.CRUD.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import training_railway08_jdbc.ConnectProtocol;

public class DepartmentProgram {

	public List<Department> getListDepartment() throws ClassNotFoundException, SQLException {
//	Connect to database	
		ConnectProtocol protocol = new ConnectProtocol();
		Connection connection = protocol.connect();

//	Create list to store data
		List<Department> data = new ArrayList<>();

//	Create query	
		String query = "SELECT * FROM department;";
		Statement statement = connection.createStatement();

//	Execute the query
		ResultSet resultSet = statement.executeQuery(query);

//	Handling result set
		while (resultSet.next()) {
			data.add(new Department(resultSet.getInt(1), resultSet.getString(2)));
		}

		connection.close();
		return data;
	}

	public List<Department> getIDDepartment() throws ClassNotFoundException, SQLException {
//		Connect to database	
		ConnectProtocol protocol = new ConnectProtocol();
		Connection connection = protocol.connect();

//		Create list to store data
		List<Department> data = new ArrayList<>();

//		Create query	
		String query = "SELECT * FROM department " + "WHERE DepartmentID = ?";
		PreparedStatement preStatement = connection.prepareStatement(query);

//		Create id parameter
		System.out.println("Please enter the department ID to search: ");
		Scanner in = new Scanner(System.in);
		int id = in.nextInt();
		preStatement.setInt(1, id);

//		Execute the query
		ResultSet resultSet = preStatement.executeQuery();

//		Handling result set
		while (resultSet.next()) {
			data.add(new Department(resultSet.getInt(1), resultSet.getString(2)));
		}

		connection.close();
		return data;
	}

	public boolean isDepartmentNameExists(String name) throws ClassNotFoundException, SQLException {
//		Connect to database	
		ConnectProtocol protocol = new ConnectProtocol();
		Connection connection = protocol.connect();

//		Create list to store data
		List<Department> data = new ArrayList<>();

//		Create query	
		String query = "SELECT * FROM department " + "WHERE DepartmentName = ?";
		PreparedStatement preStatement = connection.prepareStatement(query);

//		Create id parameter
		preStatement.setString(1, name);

//		Execute the query
		ResultSet resultSet = preStatement.executeQuery();

//		Handling result set
		while (resultSet.next()) {
			data.add(new Department(resultSet.getInt(1), resultSet.getString(2)));
		}

		connection.close();
		if (data.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void createDepartment(String name) throws ClassNotFoundException, SQLException {
//		Connect to database	
		ConnectProtocol protocol = new ConnectProtocol();
		Connection connection = protocol.connect();

//	Check if department name exits
		DepartmentProgram program = new DepartmentProgram();
		if (program.isDepartmentNameExists(name) == true) {
			System.out.println("Name already exists");
			return;
		} else {
//	Create prepared statement
			String update = "INSERT INTO department (DepartmentName) VALUES (?)";
			PreparedStatement preStatement = connection.prepareStatement(update);

//	Set parameters in
			preStatement.setString(1, name);

//	Execute
			int affectedRecordCount = preStatement.executeUpdate();

//	Handling affected results
			System.out.println(affectedRecordCount);

//	Close connection
			connection.close();
		}
	}

	public boolean isDepartmentIDExists(int id) throws ClassNotFoundException, SQLException {
//		Connect to database	
		ConnectProtocol protocol = new ConnectProtocol();
		Connection connection = protocol.connect();

//		Create list to store data
		List<Department> data = new ArrayList<>();

//	Create statement object
		Statement statement = connection.createStatement();

//		Create query	
		String query = ("SELECT * FROM department " + "WHERE DepartmentID = " + id);

//		Execute the query
		ResultSet resultSet = statement.executeQuery(query);

//		Handling result set
		while (resultSet.next()) {
			data.add(new Department(resultSet.getInt(1), resultSet.getString(2)));
		}

		connection.close();
		if (data.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void updateDepartmentName(int id, String newName) throws ClassNotFoundException, SQLException {
//	Connect to database	
		ConnectProtocol protocol = new ConnectProtocol();
		Connection connection = protocol.connect();

//Check if department name exits
		DepartmentProgram program = new DepartmentProgram();
		if (program.isDepartmentIDExists(id) == false) {
			System.out.println("The department ID is not exist, can't update!");
		} else {
//		Create statement object
			Statement statement = connection.createStatement();

//			Create update line
			String update = ("UPDATE department SET DepartmentName = '" + newName + "' WHERE DepartmentID = " + id);

//			Execute
			int affectedRecordCount = statement.executeUpdate(update);

//			Handling affected results
			System.out.println(affectedRecordCount);

//			Close connection
			connection.close();
		}
	}

	public void deleteDepartment(int id) throws ClassNotFoundException, SQLException {
//		Connect to database	
		ConnectProtocol protocol = new ConnectProtocol();
		Connection connection = protocol.connect();

		// Check if department name exits
		DepartmentProgram program = new DepartmentProgram();
		if (program.isDepartmentIDExists(id) == false) {
			System.out.println("The department ID is not exist, can't delete!");
		} else {
//			Create statement object
			Statement statement = connection.createStatement();

//				Create update line
			String delete = ("DELETE FROM department WHERE DepartmentID = " + id);

//				Execute
			int affectedRecordCount = statement.executeUpdate(delete);

//				Handling affected results
			System.out.println(affectedRecordCount);

//				Close connection
			connection.close();
		}
	}

	public void deleteDepartmentUsingProcedure(int id) throws ClassNotFoundException, SQLException {
//		Connect to database	
		ConnectProtocol protocol = new ConnectProtocol();
		Connection connection = protocol.connect();

		// Check if department name exits
		DepartmentProgram program = new DepartmentProgram();
		if (program.isDepartmentIDExists(id) == false) {
			System.out.println("The department ID is not exist, can't delete!");
		} else {
//			Create statement object
			Statement statement = connection.createStatement();

//				Create update line
			String delete = ("CALL sp_delete_department(" + id +")");

//				Execute
			int affectedRecordCount = statement.executeUpdate(delete);

//				Handling affected results
			System.out.println(affectedRecordCount);

//				Close connection
			connection.close();
		}
	}
	
}
