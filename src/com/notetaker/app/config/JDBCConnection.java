package com.notetaker.app.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
	
	private static String jdbcURL = "jdbc:mysql://localhost:3306/notetakeradv";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "root";
    
    public static Connection getConnection()
    {
    	Connection connection =null;
    	try 
    	{
    		Class.forName("com.mysql.jdbc.Driver");
    		connection=DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
    	}
    	catch (Exception e) {
			// TODO: handle exception
    		System.out.println(e);
		}
    	return connection;
    }

}
