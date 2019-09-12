package com.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class SearchStudentByID {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a Reg. No: ");
		int regno = Integer.parseInt(in.nextLine());
		in.close();
		
		Connection con = null;
		PreparedStatement pstmt = null;
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
			String sql = "select * from students_info"
					+ " where regno=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,regno);
			rs = pstmt.executeQuery();

			/*
			 * 4. Process the results
			 */

			if(rs.next()){
				regno = rs.getInt("regno");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String passwd = rs.getString("password");

				System.out.println(regno);
				System.out.println(firstname);
				System.out.println(lastname);
				System.out.println(passwd);
				System.out.println("*********************");
			}
			else
			{
				System.out.println("No Data Available");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
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