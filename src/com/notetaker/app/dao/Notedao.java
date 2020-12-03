package com.notetaker.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.notetaker.app.config.JDBCConnection;
import com.notetaker.app.entity.Note;

public class Notedao {
	
	public static int add(Note note)
	{
		int status=0;
		try(
				Connection connection= JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection
			            .prepareStatement("INSERT INTO note (`uname`, `note_heading`, `note_content`) VALUES (?,?,?);")	)
		{
			
			preparedStatement.setString(1, note.getUname());
			preparedStatement.setString(2, note.getNote_heading());
			preparedStatement.setString(3, note.getNote_content());
			System.out.println(preparedStatement);
            status = preparedStatement.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
	public static boolean Checknotes (String uname,String nid) throws ClassNotFoundException
	{
		boolean status =false;
		Class.forName("com.mysql.jdbc.Driver");
		String sqlstatement="select * from note where nid= ? and uname= ?";
		try(Connection connection= JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection
			            .prepareStatement(sqlstatement))
		{
			preparedStatement.setString(1, nid);
            preparedStatement.setString(2, uname);
			
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static int deletenote(String nid)
	{
		int result=0;
		String sqlstatement="DELETE FROM note WHERE (`nid` = ?)";
		try (Connection connection= JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection
			            .prepareStatement(sqlstatement))
		{
			preparedStatement.setString(1, nid);
			
			result = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public static Note retrivenote(String nid)
	{
		Note n=new Note();
		String sqlstatement="select * from note where nid=?";
		try(Connection connection= JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection
			            .prepareStatement(sqlstatement)) {
			preparedStatement.setString(1, nid);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
			n.setNote_heading(rs.getString("note_heading"));
			n.setNote_content(rs.getString("note_content"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;
	}

	public static int edit(Note note)
	{
		int status=0;
		String sqlstatement="UPDATE `note` SET `note_heading` = ?, `note_content` = ? WHERE (`nid` = ?)";
		try(Connection connection= JDBCConnection.getConnection();
				PreparedStatement preparedStatement = connection
			            .prepareStatement(sqlstatement)){
			preparedStatement.setString(1, note.getNote_heading());
			preparedStatement.setString(2, note.getNote_content());
			preparedStatement.setString(3, Integer.toString(note.getNid()));
			System.out.println(note);
			System.out.println(preparedStatement);
			System.out.println(note.getNote_heading());
			System.out.println(note.getNote_content());
			status = preparedStatement.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
}
