package com.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
		static Connection con ;							//databaseName
		static String url="jdbc:mysql://localhost:3306/Student";
		static String uname ="root";//default user name
		static String pwd="Rushi@1";// password of your MySQL_Server
		
public static Connection getConnection(){
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");//path to driver
				con = DriverManager.getConnection(url, uname, pwd);
			} 
			catch (ClassNotFoundException ex) {
				System.out.println(ex.getMessage());
			} 
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
			return con;
}
}
