package com.notetaker.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.notetaker.app.config.JDBCConnection;

import com.notetaker.app.entity.Regbean;

public class LoginDao {
	
	public static boolean validate(Regbean regbean) throws ClassNotFoundException
	{
		boolean status=false;
		Class.forName("com.mysql.jdbc.Driver");
		try (Connection connection= JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection
			            .prepareStatement("select * from user where username = ? and password = ? "))
		{
			preparedStatement.setString(1, regbean.getUsername());
            preparedStatement.setString(2, regbean.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}

}
