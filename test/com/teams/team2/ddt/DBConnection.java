package com.teams.team2.ddt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DBConnection {
	@Test
	public void testDB() throws ClassNotFoundException, SQLException
	{
		
		//load the database driver which will help to connect with database
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver Loaded");
		
		//establish a connection to given database url
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium","root","password");
		//3306 is port number, if database is on other machine the provide ip address of machine in place of localhost
		
		System.out.println("Connected to mysql db");
		
		Statement smt=con.createStatement();
		//with this statemnet we can execute any sql query
		
		ResultSet rs=smt.executeQuery("select * from seleniumuser;");
		
		while(rs.next())
		{
			String firstname=rs.getString("firstname");
			System.out.println("Database record is :" +firstname);
			
			String emailaddress=rs.getString("email");
			System.out.println("Database record is :" +emailaddress);
		}
		
		
		
		
	}

}
