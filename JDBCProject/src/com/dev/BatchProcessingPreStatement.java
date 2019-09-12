package com.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.mysql.jdbc.Driver;

public class BatchProcessingPreStatement 
{
	public static void main(String[] args)
	{
		/*Scanner in = new Scanner(System.in);
		System.out.println("Regno: ");
		int regno = Integer.parseInt(in.nextLine());
		String fname = in.nextLine();
		String lname = in.nextLine();
		String pw = in.nextLine();*/
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try
		{
			java.sql.Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			System.out.println("Driver Loaded...");
			
			String dbUrl="jdbc:mysql://localhost:3306/techies_db"
					+ "?user=root&password=root";
			con = DriverManager.getConnection(dbUrl); 
			System.out.println("Connected...");
			
			
			
			
			String sql = "insert into students_info values(?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			
			con.setAutoCommit(false);
			
			pstmt.setInt(1,21);
			pstmt.setString(2,"kj");
			pstmt.setString(3,"jki");
			pstmt.setString(4,"root");
			
			pstmt.addBatch();
			
			
			pstmt.setInt(1,22);
			pstmt.setString(2,"li");
			pstmt.setString(3,"gh");
			pstmt.setString(4,"root");
			
			pstmt.addBatch();
			
			
			pstmt.setInt(1,23);
			pstmt.setString(2,"mm");
			pstmt.setString(3,"nmm");
			pstmt.setString(4,"root");
			
			pstmt.addBatch();
			
			
			//in.close();
			
			int count[]= pstmt.executeBatch();
			con.commit();
			for(int i=0;i<count.length;i++)
			{
				System.out.println(count[i]);
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
			if(pstmt!=null)
				try
			{
					pstmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		
		}
		
		
	}

}
