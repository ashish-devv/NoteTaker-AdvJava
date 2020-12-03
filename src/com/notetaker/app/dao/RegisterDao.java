package com.notetaker.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.notetaker.app.config.JDBCConnection;
import com.notetaker.app.entity.Regbean;


public class RegisterDao {
	public static int register(Regbean user)
	{
		int result=0;
		String sqlquery ="INSERT INTO user" +
	            "  (name,username, password) VALUES " +
	            " (?, ?,?);";
		try (Connection connection=JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sqlquery))
		{
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

}
