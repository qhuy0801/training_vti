package com.vti.railway08_training.finalAssignment.backend.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.vti.railway08_training.finalAssignment.entity.Candidate;
import com.vti.railway08_training.finalAssignment.entity.ExperiencedCandidate;
import com.vti.railway08_training.finalAssignment.entity.FresherCandidate;
import com.vti.railway08_training.finalAssignment.utils.JDBCUtils;

public class CandidateRepository implements ICandidateRepository {
	private JDBCUtils jdbcutils;

	public CandidateRepository() {
		jdbcutils = new JDBCUtils();
	}

// ------------------------------------------------------------------------------
// overload create candidate - fresher
	public void createUsers(String firstName, String lastName, String phone, String email, String gradRank,
			String password) throws Exception {
		// Create connection
		Connection connection = jdbcutils.connect();

		// Create statement object
		String create = "\r\n" + "INSERT INTO `candidate` (firstname, lastname, phone, email, gradrank, `password`)\r\n"
				+ "VALUES		           (?, ?, ?, ?, ?, ?)";
		PreparedStatement preStatement = connection.prepareStatement(create);

		// Set parameters in
		preStatement.setString(1, firstName);
		preStatement.setString(2, lastName);
		preStatement.setString(3, phone);
		preStatement.setString(4, email);
		preStatement.setString(5, gradRank);
		preStatement.setString(6, password);

		// Execute
		preStatement.executeUpdate();

		// Close connection
		connection.close();
	}

// overload create candidate - experienced
	public void createUsers(String firstName, String lastName, String phone, String email, int expInYear,
			String proSkill, String password) throws Exception {
		// Create connection
		Connection connection = jdbcutils.connect();

		// Create statement object
		String create = "\r\n"
				+ "INSERT INTO `candidate` (firstname, lastname, phone, email, expinyear, proskill, `password`)\r\n"
				+ "VALUES		           (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement preStatement = connection.prepareStatement(create);

		// Set parameters in
		preStatement.setString(1, firstName);
		preStatement.setString(2, lastName);
		preStatement.setString(3, phone);
		preStatement.setString(4, email);
		preStatement.setInt(5, expInYear);
		preStatement.setString(6, proSkill);
		preStatement.setString(7, password);

		// Execute
		preStatement.executeUpdate();

		// Close connection
		connection.close();
	}

// ------------------------------------------------------------------------------
	public boolean isEmailExists(String email) throws Exception {
		// Create connection
		Connection connection = jdbcutils.connect();

		// Step 3: Create statement object (string)
		String query = "SELECT email FROM `candidate`";
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
	public Candidate candidateLogin(String email, String password) throws Exception {
		// Create connection
		Connection connection = jdbcutils.connect();

		// Create statement object (string)
		String search = "SELECT *" + "FROM `candidate`" + " WHERE `email` = ?";
		PreparedStatement preStatement = connection.prepareStatement(search);

		// Set parameters in
		preStatement.setString(1, email);

		// Execute
		ResultSet resultSet = preStatement.executeQuery();

		// Create candidate parameter to store output
		Candidate candidate;

		// Check password
		resultSet.next();
		if (!resultSet.getString("password").equals(password)) {
			throw new Exception("Password is not correct, please check again!");
		} else {
			// Handling result
			if (resultSet.getInt("expinyear") > 0) {
				// If expInYear > 0, the candidate is a experienced candidate
				candidate = new ExperiencedCandidate(resultSet.getString("firstname"), resultSet.getString("lastname"),
						resultSet.getString("phone"), resultSet.getString("email"), resultSet.getInt("expinyear"),
						resultSet.getString("proskill"));
				connection.close();
				return candidate;
			} else {
				candidate = new FresherCandidate(resultSet.getString("firstname"), resultSet.getString("lastname"),
						resultSet.getString("phone"), resultSet.getString("email"), resultSet.getString("gradrank"));
				connection.close();
				return candidate;
			}
		}
	}
}
