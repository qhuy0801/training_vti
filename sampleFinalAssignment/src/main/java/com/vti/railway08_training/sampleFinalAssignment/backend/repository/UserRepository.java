package com.vti.railway08_training.sampleFinalAssignment.backend.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.vti.railway08_training.finalAssignment.utils.JDBCUtils;
import com.vti.railway08_training.sampleFinalAssignment.backend.entities.Admin;
import com.vti.railway08_training.sampleFinalAssignment.backend.entities.Employee;
import com.vti.railway08_training.sampleFinalAssignment.backend.entities.User;

public class UserRepository implements IUserRepository {
	private JDBCUtils jdbcutils;

	public UserRepository() {
		jdbcutils = new JDBCUtils();
	}

// ------------------------------------------------------------------------------ 
// overload create users - employee
	public void createUsers(String fullName, String email, String password, String proSkill) throws Exception {
		// Create connection
		Connection connection = jdbcutils.connect();

		// Create statement object
		String create = "INSERT INTO `User` (`fullname`, `email`, `password`, `proskill`)" + "VALUES (?, ?, ?, ?)";
		PreparedStatement preStatement = connection.prepareStatement(create);

		// Set parameters in
		preStatement.setString(1, fullName);
		preStatement.setString(2, email);
		preStatement.setString(3, password);
		preStatement.setString(4, proSkill);

		// Execute
		preStatement.executeUpdate();

		// Close connection
		connection.close();
	}

// overload create users - admin
	public void createUsers(String fullName, String email, String password, int expInYear) throws Exception {
		// Create connection
		Connection connection = jdbcutils.connect();

		// Create statement object
		String create = "INSERT INTO `User` (`fullname`, `email`, `password`, `expinyear`)" + "VALUES (?, ?, ?, ?)";
		PreparedStatement preStatement = connection.prepareStatement(create);

		// Set parameters in
		preStatement.setString(1, fullName);
		preStatement.setString(2, email);
		preStatement.setString(3, password);
		preStatement.setInt(4, expInYear);

		// Execute
		preStatement.executeUpdate();

		// Close connection
		connection.close();
	}

// ------------------------------------------------------------------------------ 
	public boolean isIDExists(int id) throws Exception {
		// Create connection
		Connection connection = jdbcutils.connect();

		// Step 3: Create statement object (string)
		String query = "SELECT id FROM `User`";
		Statement statement = connection.createStatement();

		// Step 4: Execute the query
		ResultSet resultSet = statement.executeQuery(query);
		boolean isIDExists = false;

		// Step 5: Handling result set
		while (resultSet.next()) {
			if (resultSet.getInt(1) == id) {
				isIDExists = true;
				break;
			}
		}
		connection.close();
		return isIDExists;
	}

	public boolean isEmailExists(String email) throws Exception {
		// Create connection
		Connection connection = jdbcutils.connect();

		// Step 3: Create statement object (string)
		String query = "SELECT email FROM `User`";
		Statement statement = connection.createStatement();

		// Step 4: Execute the query
		ResultSet resultSet = statement.executeQuery(query);
		boolean isEmailExists = false;

		// Step 5: Handling result set
		while (resultSet.next()) {
			if (resultSet.getString(1).equals(email)) {
				isEmailExists = true;
				break;
			}
		}

		connection.close();
		return isEmailExists;
	}

// ------------------------------------------------------------------------------ 
// get list users
	public List<User> getUserList() throws Exception {
		// Create connection
		Connection connection = jdbcutils.connect();

		// Create list to store the data
		List<User> users = new ArrayList<>();

		// Step 3: Create statement object (string)
		String query = "SELECT * FROM `User`";
		Statement statement = connection.createStatement();

		// Step 4: Execute the query
		ResultSet resultSet = statement.executeQuery(query);

		// Step 5: Handling result set
		while (resultSet.next()) {
			if (resultSet.getInt(5) > 0) {
				users.add(new Admin(resultSet.getInt("id"), resultSet.getString("fullname"),
						resultSet.getString("email"), resultSet.getInt("expinyear")));
			} else {
				users.add(new Employee(resultSet.getInt("id"), resultSet.getString("fullname"),
						resultSet.getString("email"), resultSet.getString("proskill")));
			}
		}
		connection.close();
		return users;

	}

// search by id	
	public User searchID(int id) throws Exception {
		// Check if id exists
		if (!isIDExists(id)) {
			throw new Exception("This ID is not exists!");
		}

		// Create connection
		Connection connection = jdbcutils.connect();

		// Create statement object (string)
		String search = "SELECT *" + "FROM `User`" + " WHERE id = ?";
		PreparedStatement preStatement = connection.prepareStatement(search);

		// Set parameters in
		preStatement.setInt(1, id);

		// Execute
		ResultSet resultSet = preStatement.executeQuery();

		// Handling result
		User user;
		resultSet.next();
		if (resultSet.getInt(5) > 0) {
			user = new Admin(resultSet.getInt("id"), resultSet.getString("fullname"), resultSet.getString("email"),
					resultSet.getInt("expinyear"));
		} else {
			user = new Employee(resultSet.getInt("id"), resultSet.getString("fullname"), resultSet.getString("email"),
					resultSet.getString("proskill"));
		}

		// Close connection
		connection.close();
		return user;
	}

// delete by id	
	public void deleteID(int id) throws Exception {
		// Check if id exists
		if (!isIDExists(id)) {
			throw new Exception("This ID is not exists!");
		}

		// Create connection
		Connection connection = jdbcutils.connect();

		// Create statement object (string)
		String delete = "DELETE " + "FROM `user`" + "WHERE id = ?";
		PreparedStatement preStatement = connection.prepareStatement(delete);

		// Set parameters in
		preStatement.setInt(1, id);

		// Execute
		preStatement.executeUpdate();

		// Close connection
		connection.close();
	}

// check password and return
	public boolean isAdmin(String email, String password) throws Exception {
		// Create connection
		Connection connection = jdbcutils.connect();

		// Create statement object (string)
		String search = "SELECT *" + "FROM `User`" + " WHERE `email` = ?";
		PreparedStatement preStatement = connection.prepareStatement(search);

		// Set parameters in
		preStatement.setString(1, email);

		// Execute
		ResultSet resultSet = preStatement.executeQuery();

		// Handling result
		resultSet.next();
		if (!resultSet.getString(4).equals(password)) {
			throw new Exception("Password is not correct!");
		} else {
			if (resultSet.getInt("expinyear") > 0) {
				connection.close();
				return true;

			} else {
				connection.close();
				return false;
			}
		}

	}
}