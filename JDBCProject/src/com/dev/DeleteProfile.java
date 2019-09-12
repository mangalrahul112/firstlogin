package com.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Driver;
import java.sql.PreparedStatement;

public class DeleteProfile {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Regno: ");
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
			String sql = "Delete from students_info "
					+ " where regno=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, regno);
			
			
			int count = pstmt.executeUpdate();

			/*
			 * 4. Process the results
			 */

			if(count > 0) {
				System.out.println("Success in Profile Deletion");
			}else {
				System.out.println("Failed in Profile Deletion");
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
