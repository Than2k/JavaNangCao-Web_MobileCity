package com.mobilecity.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoi {

	public static Connection cn;
	public static void ketNoi() throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("kết nối");
		String sql ="jdbc:sqlserver://MSI:1433;databaseName=MobileCity;user=sa;password=123";
		cn = DriverManager.getConnection(sql);
		System.out.println("kết nối thành công");
	}
	
}
