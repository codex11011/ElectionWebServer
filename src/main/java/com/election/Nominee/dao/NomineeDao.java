package com.election.Nominee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.election.DatabaseConn.DbConnection;
import com.election.Nominee.model.Nominee;

public class NomineeDao {
	private Connection conn = null;
	private Statement stmt = null;
	
	public NomineeDao(){
		try {
			DbConnection db = new DbConnection();
			conn = db.getConn();
			stmt =  conn.createStatement();
			String sql;
			sql = "create table IF NOT EXISTS NomineeDetails(first_name VARCHAR(30),family_name VARCHAR(50),email NVARCHAR(50) PRIMARY KEY,phone_number VARCHAR(10),hostel VARCHAR(15),room_number VARCHAR(6),batch VARCHAR(5),branch VARCHAR(5),cgpa VARCHAR(5),position VARCHAR(20));";
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
	
	
// Saving Nominee data to database	
	public void saveNomineeDetails(Nominee n1) throws SQLException {
		
		String sql = "INSERT INTO NomineeDetails(first_name,family_name,email,phone_number,hostel,room_number,batch,branch,cgpa,position) VALUES('"+ n1.getFirstName() +"','"
					 +n1.getFamilyName()+"','"+ (String)n1.getEmailId() +"','"+n1.getPhoneNumber()+"','"
					 +n1.getHostel()+"','"+n1.getRoomNumber()+"','"+n1.getBatch()+"','"+n1.getBranch()+"','"
					 +n1.getCgpa()+"','"+n1.getPosition()+"')";
		
		stmt.executeUpdate(sql);
		
	}
	
//	public Nominee getNominee(int id) {	
//		String sql = "select * from Nominee where id="+ id +";";
//		Nominee n1 = new Nominee();
//		try {
//		    stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(sql);
//			if(rs.next()) {
//				n1.setId((rs.getInt(1)));
//				n1.setName(rs.getString(2));
//				n1.setBatch(rs.getString(3));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return n1;
//	}
//	
	public ArrayList<Nominee> getAllNomineeDetails(){
		String sql = "select * from NomineeDetails";
		ArrayList<Nominee> nominee_details = new ArrayList<Nominee>();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Nominee n1 = new Nominee();
				n1.setFirstName(rs.getString(1));
				n1.setFamilyName(rs.getString(2));
				n1.setEmailId(rs.getString(3));
				n1.setPhoneNumber(rs.getString(4));
				n1.setHostel(rs.getString(5));
				n1.setRoomNumber(rs.getString(6));
				n1.setBatch(rs.getString(7));
				n1.setBranch(rs.getString(8));
				n1.setCgpa(rs.getString(9));
				n1.setPosition(rs.getString(10));
				nominee_details.add(n1);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return nominee_details;
		
	}
}
