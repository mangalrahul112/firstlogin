package com.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OptimizeCodeJDBC 
{
	public static void main(String[] args) 
	{
		String dbUrl="jdbc:mysql://localhost:3306/techies_db"
				+ "?user=root&password=root";
		String sql = "select * from students_info";
		
		try(Connection con =DriverManager.getConnection(dbUrl);
			Statement stmt =con.createStatement();
			ResultSet rs =stmt.executeQuery(sql)) {
			/*
			 * 4. Process the results
			 */

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

		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	}