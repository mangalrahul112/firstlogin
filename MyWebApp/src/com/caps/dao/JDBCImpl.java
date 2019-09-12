package com.caps.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.caps.dto.Student;

public class JDBCImpl implements StudentsInfoDAO
{
	public JDBCImpl()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	private static final String DBURL="jdbc:mysql://localhost:3306/techies_db"
			+ "?user=root&password=root";
	
	

	
	@Override
	public Student login(int regno,String pass)
	{
		String sql = "select * from students_info"
				+ " where regno=? and password=?";
		try(Connection con =DriverManager.getConnection(DBURL);
			PreparedStatement pstmt = con.prepareStatement(sql)
			)
		{
			
			Student s = new Student();
			pstmt.setInt(1,regno);
			pstmt.setString(2,pass);
			try(ResultSet rs =pstmt.executeQuery())
			{

				if(rs.next())
				{
					
					s.setRegNo(rs.getInt("regno"));
					s.setFname(rs.getString("firstname"));
					s.setLname(rs.getString("lastname"));
					s.setPassword( rs.getString("password"));
					
			}
			
				return s;

			}

			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}



}

