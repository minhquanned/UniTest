package com.java.be;

public class Patient {
	String patientID;
	String patientName;
	String deseaseName;
	String phoneNumber;
	String address;
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDeseaseName() {
		return deseaseName;
	}
	public void setDeseaseName(String deseaseName) {
		this.deseaseName = deseaseName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Patient(String patientID, String patientName, String deseaseName, String phoneNumber, String address) {
		super();
		this.patientID = patientID;
		this.patientName = patientName;
		this.deseaseName = deseaseName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	public Patient() {
		super();
	}
}
