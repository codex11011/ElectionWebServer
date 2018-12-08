package com.election.DatabaseConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	private Connection conn = null;
	private Statement stmt = null;
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
	private static final String USER = "root";
	private static final String PASSWORD = "123456789";
	
	public DbConnection(){
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			stmt =  conn.createStatement();
			String sql;
			sql = "create database IF NOT EXISTS restdb;";
			stmt.executeUpdate(sql);
			sql= "use restdb;";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	public Connection getConn() {
		return conn;
	}
	
}
