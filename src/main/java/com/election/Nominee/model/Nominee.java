package com.election.Nominee.model;

public class Nominee {
	private String firstName;
	private String familyName;
	private String emailId;
	private String phoneNumber;
	private String hostel;
	private String roomNumber;
	private String batch;
	private String branch;
	private String cgpa;
	private String position;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getHostel() {
		return hostel;
	}
	public void setHostel(String hostel) {
		this.hostel = hostel;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCgpa() {
		return cgpa;
	}
	public void setCgpa(String cgpa) {
		this.cgpa = cgpa;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "Nominee [firstName=" + firstName + ", familyName=" + familyName + ", emailId=" + emailId
				+ ", phoneNumber=" + phoneNumber + ", hostel=" + hostel + ", roomNumber=" + roomNumber + ", batch="
				+ batch + ", branch=" + branch + ", cgpa=" + cgpa + ", position=" + position + "]";
	}
	
	
	
}	
