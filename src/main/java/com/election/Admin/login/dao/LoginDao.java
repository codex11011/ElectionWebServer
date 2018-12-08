package com.election.Admin.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.election.DatabaseConn.DbConnection;
public class LoginDao {
	
	private Connection conn = null;
	private String sql = "select * from Admin where username=? and password=?";
	public LoginDao(){
		DbConnection db = new DbConnection();
		conn = db.getConn();
	}
	
	public boolean check(String username, String password) {
		try { 
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
}
