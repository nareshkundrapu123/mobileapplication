package mobileapp;

import java.sql.*;
public class JDBC

{
	
	static String Driver="com.mysql.cj.jdbc.Driver"; 
	static String url="jdbc:mysql://localhost:3306/mobileapplication";
	static String username="root";
	static String password="Naresh@1998";
	public static Connection getcon() throws Exception
	{
		Class.forName(Driver);
		Connection res=DriverManager.getConnection(url,username,password);
		
		return res;
	}
}
