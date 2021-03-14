package com.vti.training_railway08_maven.backend.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.training_railway08_maven.backend.entity.Group;
import com.vti.training_railway08_maven.utils.ConnectProtocol;

public class GroupRepository {
	private ConnectProtocol jdbcUtils;

	public GroupRepository() {
		jdbcUtils = new ConnectProtocol();
	}

	public List<Group> getListGroups() throws SQLException, ClassNotFoundException {
		// Step 1: Create list to store the data
		List<Group> groups = new ArrayList<>();

		// Step 2: Create connection
		Connection connection = jdbcUtils.getConnection();

		// Step 3: Create statement object (string)
		String query = "SELECT	GroupID, GroupName FROM `group`";
		Statement statement = connection.createStatement();

		// Step 4: Execute the query
		ResultSet resultSet = statement.executeQuery(query);

		// Step 5: Handling result set
		while (resultSet.next()) {
			groups.add(new Group(resultSet.getInt(1), resultSet.getString(2)));
		}

		connection.close();
		return groups;

	}

	public Group getGroupID(int id) throws Exception {
		// Step 1: Create connection
		Connection connection = jdbcUtils.getConnection();

		// Step 2: Create statement object (string)
		String query = "SELECT GroupName FROM `group` WHERE GroupID = ?";
		PreparedStatement preStatement = connection.prepareStatement(query);
		preStatement.setInt(1, id);

		// Step 3: Execute the query
		ResultSet resultSet = preStatement.executeQuery();

		// Step 4: Handling and print
		if (resultSet.next()) {
			return (new Group(id, resultSet.getString(1)));
		} else {
			throw new Exception("Can't find matched data");
		}
	}

	public boolean isGroupNameExists(String name) throws ClassNotFoundException, SQLException {
		// Step 1: Create connection
		Connection connection = jdbcUtils.getConnection();

//		Create query	
		String query = "SELECT * FROM `group` " + "WHERE GroupName = ?";
		PreparedStatement preStatement = connection.prepareStatement(query);

//		Create id parameter
		preStatement.setString(1, name);

//		Execute the query
		ResultSet resultSet = preStatement.executeQuery();

//		Handling result set
		if (resultSet.next()) {
			connection.close();
			return true;
		}
		connection.close();
		return false;
	}

	public void createGroup(String name) throws ClassNotFoundException, SQLException {
		// Step 1: Create connection
		Connection connection = jdbcUtils.getConnection();

		// Create prepared statement
		String update = "INSERT INTO `group` (GroupName) VALUES (?)";
		PreparedStatement preStatement = connection.prepareStatement(update);

		// Set parameters in
		preStatement.setString(1, name);

		// Execute
		preStatement.executeUpdate();

		// Close connection
		connection.close();
	}

	public boolean isGroupIDExists(int id) throws ClassNotFoundException, SQLException {
		// Step 1: Create connection
		Connection connection = jdbcUtils.getConnection();

//		Create query	
		String query = "SELECT * FROM `group` " + "WHERE GroupID = ?";
		PreparedStatement preStatement = connection.prepareStatement(query);

//		Create id parameter
		preStatement.setInt(1, id);

//		Execute the query
		ResultSet resultSet = preStatement.executeQuery();

//		Handling result set
		if (resultSet.next()) {
			connection.close();
			return true;
		}
		connection.close();
		return false;

	}

	public void updateGroup(int id, String newName) throws ClassNotFoundException, SQLException {
		// Step 1: Create connection
		Connection connection = jdbcUtils.getConnection();

		// Create prepared statement
		String update = "UPDATE `group` SET GroupName = ? WHERE	GroupID = ?";
		PreparedStatement preStatement = connection.prepareStatement(update);

		// Set parameters in
		preStatement.setString(1, newName);
		preStatement.setInt(2, id);

		// Execute
		int affectedRecordCount = preStatement.executeUpdate();

		// Handling affected results
		System.out.println("Group updated successfully!: " + affectedRecordCount);

		// Close connection
		connection.close();
	}

	public void deleteGroup(int id) throws ClassNotFoundException, SQLException {
		// Step 1: Create connection
		Connection connection = jdbcUtils.getConnection();

		// Create prepared statement
		String update = "DELETE FROM `group` WHERE GroupID = ?";
		PreparedStatement preStatement = connection.prepareStatement(update);

		// Set parameters in
		preStatement.setInt(1, id);

		// Execute
		int affectedRecordCount = preStatement.executeUpdate();

		// Handling affected results
		System.out.println("Group deleted successfully!: " + affectedRecordCount);

		// Close connection
		connection.close();
	}
}
