package com.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class UpdatePassword
{
	public static void main(String[] args)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Reg no:");
		int regno = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter Old Password");
		String oldpass = sc.nextLine();
		
		System.out.println("Enter New Password");
		String newpass = sc.nextLine();
		try
		{
			
			
			java.sql.Driver ref = new Driver();
			DriverManager.registerDriver(ref);
			
			String dbUrl ="jdbc:mysql://localhost:3306/techies_db"
					+"?user=root&password=root";
			con = DriverManager.getConnection(dbUrl);
			
			String sql = "update students_info set password=? where regno=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,newpass);
			pstmt.setInt(2,regno);
			pstmt.setString(3,oldpass);
			int n =pstmt.executeUpdate();
			
			if(n>0)
			{
				System.out.println("Succesful Change");
			}
			else
			{
				System.out.println("Failed");
			}
			
		}
		catch(Exception e)
		{
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

