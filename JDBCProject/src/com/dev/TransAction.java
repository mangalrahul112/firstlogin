package com.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class TransAction 
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
			
			String sql = "insert into students_info values(177,'Gg','Ghh','root')";
			int c1 = stmt.executeUpdate(sql);
			
			sql = "insert into students_info values(178,'Hh','Hii','root')";
			int c2 = stmt.executeUpdate(sql);
			int i =1/0;
			sql = "insert into students_info values(79,'Ii','ijj','root')";
			int c3 = stmt.executeUpdate(sql);
			con.commit();
			
			if(c1==1 && c2==1 && c3==1)
			{
				System.out.println("Success");
			}
			else
			{
				System.out.println("Failed");
			}
				
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
