package com.java.be;

public class Doctor {
	private String doctorID;
	private String doctorName;
	private String phoneNumber;
	public String getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Doctor(String doctorID, String doctorName, String phoneNumber) {
		super();
		this.doctorID = doctorID;
		this.doctorName = doctorName;
		this.phoneNumber = phoneNumber;
	}
	public Doctor() {
		super();
	}
}
