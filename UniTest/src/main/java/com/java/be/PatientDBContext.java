package com.java.be;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PatientDBContext {

	Connection c;

	// Test connection
	public PatientDBContext() {
		try {
			c = dbConnect.initializeDatabase();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Test
	public static void main(String[] args) throws ClassNotFoundException {
		PatientDBContext bConnect = new PatientDBContext();
//		Medicine bSubject = new Medicine("M04", "Never Depression", "Treat Depression", "pill", 4, 6);
		List<Patient> patients = bConnect.getAllPatients();
		System.out.println(patients);
//		bConnect.updateMedicine(bSubject);
	}

	// Take all Subject
	public List<Patient> getAllPatients() throws ClassNotFoundException {
		List<Patient> patients = new ArrayList<>();

		try {
			c = dbConnect.initializeDatabase();
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM [PATIENT]");

			while (rs.next()) {
				String patientID = rs.getString("patientID");
				String patientName = rs.getString("patientName");
				String deseaseName = rs.getString("deseaseName");
				String phoneNumber = rs.getString("phoneNumber");
				String address = rs.getString("address");

				Patient patient = new Patient(patientID, patientName, deseaseName, phoneNumber, address);

				patients.add(patient);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return patients;
	}

	public Patient getPatientbyID(String id) throws ClassNotFoundException {
		try {
			c = dbConnect.initializeDatabase();
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM [PATIENT] WHERE patientID = '" + id + "'");

			while (rs.next()) {
				String patientID = rs.getString("patientID");
				String patientName = rs.getString("patientName");
				String deseaseName = rs.getString("deseaseName");
				String phoneNumber = rs.getString("phoneNumber");
				String address = rs.getString("address");

				return new Patient(patientID, patientName, deseaseName, phoneNumber, address);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// Add Subject
	public void addPatient(String patientID, String patientName, String phoneNumber) throws ClassNotFoundException {
		try {
			c = dbConnect.initializeDatabase();
			PreparedStatement pstm = c.prepareStatement(
					"INSERT INTO [PATIENT] (patientID, patientName, deseaseName, phoneNumber, address) values (?, ?, ?, ?, ?)");
			pstm.setString(1, patientID);
			pstm.setString(2, patientName);
			pstm.setString(3, phoneNumber);

			pstm.executeUpdate();
			System.out.println("add success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Update Subject
	public void updatePatient(Patient patient) {
		try {
			c = dbConnect.initializeDatabase();
			PreparedStatement pstm = c.prepareStatement(
					"UPDATE [PATIENT] SET patientName = ?, deseaseName = ?, phoneNumber = ?, address = ? WHERE patientID = ?");
			pstm.setString(1, patient.getPatientID());
			pstm.setString(2, patient.getPatientName());
			pstm.setString(3, patient.getDeseaseName());
			pstm.setString(4, patient.getPhoneNumber());
			pstm.setString(5, patient.getAddress());

			pstm.executeUpdate();
			System.out.println("update success!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Delete Subject
	public void deletePatient(String patientID) {
		try {
			c = dbConnect.initializeDatabase();
			PreparedStatement pstm = c.prepareStatement("DELETE FROM [PATIENT] WHERE patientID = ?");
			pstm.setString(1, patientID);

			pstm.executeUpdate();
			System.out.println("delete success!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
