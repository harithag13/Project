package net.program.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.program.registration.model.Employee;

public class EmployeeDao {
	
	public int register(Employee employee) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO employee" +
	"(id, first_name, last_name, user_name, password, address, contact) VALUES " +
				" (?, ?, ?, ?, ?, ?, ?);";
		
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false", "root", "ShweNivi@13");
				
				//step2:create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setInt(1,  1);
			preparedStatement.setString(2, employee.getFirstName());
			preparedStatement.setString(3, employee.getLasttName());
			preparedStatement.setString(4, employee.getUserName());
			preparedStatement.setString(5, employee.getPassword());
			preparedStatement.setString(6, employee.getAddress());
			preparedStatement.setString(7, employee.getContact());
			
			System.out.println(preparedStatement);
			//step3:execute the query or update query
			result = preparedStatement.executeUpdate();
			
		}catch (SQLException e) {
			//press sql exception
			e.printStackTrace();
		}
		return result;
		}
	}


