package com.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class BatchProcessingStatement 
{
	public static void main(String[] args)
	{
		Connection con = null;
		Statement stmt = null;
		
		try
		{
			java.sql.Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			System.out.println("Driver Loaded...");
			
			String dbUrl="jdbc:mysql://localhost:3306/techies_db"
					+ "?user=root&password=root";
			con = DriverManager.getConnection(dbUrl); 
			System.out.println("Connected...");
			
			stmt = con.createStatement();
			con.setAutoCommit(false);
			
			String sql = "insert into students_info values(7,'Gg','Ghh','root')";
			stmt.addBatch(sql);
			
			sql = "insert into students_info values(8,'Hh','Hii','root')";
			stmt.addBatch(sql);
			
			sql = "insert into students_info values(9,'Ii','ijj','root')";
			stmt.addBatch(sql);
			
			int count[]= stmt.executeBatch();
			for(int i=0;i<count.length;i++)
			{
				System.out.println(count[i]);
			}
			con.commit();
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			
			if(con!=null)
				try
			{
					con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			if(stmt!=null)
				try
			{
					stmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		
		}
		
		
	}

}
