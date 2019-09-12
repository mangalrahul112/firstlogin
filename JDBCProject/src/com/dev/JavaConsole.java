package com.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.Driver; //required for jdbc to connect to mySql database


public class JavaConsole {


	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			/*
			 * 1. Load the Driver
			 */
			java.sql.Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			System.out.println("Driver Loaded...");

			/*
			 * 2. Get the DB Connection via Driver
			 */
			String dbUrl="jdbc:mysql://localhost:3306/techies_db"
					+ "?user=root&password=root";
			con = DriverManager.getConnection(dbUrl); 
			System.out.println("Connected...");

			/*
			 * 3. Issue the SQL query via connection
			 */
			Scanner sc = new Scanner(System.in);
			String sql = sc.nextLine();
			sc.close();

			stmt = con.createStatement();
			boolean state= stmt.execute(sql);
			
			if(state)
			{
				rs = stmt.getResultSet();
				
				while(rs.next()){
					int regno = rs.getInt("regno");
					String firstname = rs.getString("firstname");
					String lastname = rs.getString("lastname");
					String passwd = rs.getString("password");

					System.out.println(regno);
					System.out.println(firstname);
					System.out.println(lastname);
					System.out.println(passwd);
					System.out.println("*********************");
				}
				
			}
			else
			{
				int count = stmt.getUpdateCount();
				System.out.println("Query ok "+ count+ " rows Affected");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(con != null) {
					con.close();
				} 
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}