
package com.dev;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


import com.mysql.jdbc.Driver; //required for jdbc to connect to mySql database


public class MyFirstJDBCProgramGetConnection3rdVersion {


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
			//1st Version of getConnection(str)
//			String dbUrl="jdbc:mysql://localhost:3306/techies_db"
//					+ "?user=root&password=root";
//			con = DriverManager.getConnection(dbUrl); 
			
			//2nd Version of getConnection(str,str,str)
		//String dbUrl="jdbc:mysql://localhost:3306/techies_db";
		//Scanner in = new Scanner(System.in);
		//System.out.println("Enter username of DB: ");
		//String user = in.nextLine();
	//	System.out.println("Enter Password: ");
		//String passwd = in.nextLine();
		//in.close();
		//con = DriverManager.getConnection(dbUrl, user, passwd);
			
			//3rd Version of getConnection(str,prop);
			String dbUrl="jdbc:mysql://localhost:3306/techies_db";
			FileReader reader = new FileReader("C:\\Users\\ATUL\\Desktop\\JavaEE CapG\\db.properties");
		Properties prop = new Properties();
			prop.load(reader);
			
			con = DriverManager.getConnection(dbUrl,prop);
			
			System.out.println("Connected...");

			/*
			 * 3. Issue the SQL query via connection
			 */
			String sql = "select * from students_info";

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

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

		} catch (SQLException |IOException e) {
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
	