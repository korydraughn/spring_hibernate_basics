package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) 
	{
		String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		System.out.println("Connecting to database: " + url);

		try (Connection myConn = DriverManager.getConnection(url, user, pass))
		{
			System.out.println("Connection successful!!!");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
