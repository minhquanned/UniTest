package com.java.be;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DoctorDBContext {

	Connection c;

	// Test connection
	public DoctorDBContext() {
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
		DoctorDBContext bConnect = new DoctorDBContext();
//		Medicine bSubject = new Medicine("M04", "Never Depression", "Treat Depression", "pill", 4, 6);
		List<Doctor> doctors = bConnect.getAllDoctors();
		System.out.println(doctors);
//		bConnect.updateMedicine(bSubject);
	}

	// Take all Subject
	public List<Doctor> getAllDoctors() throws ClassNotFoundException {
		List<Doctor> doctors = new ArrayList<>();

		try {
			c = dbConnect.initializeDatabase();
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM [DOCTOR]");

			while (rs.next()) {
				String doctorID = rs.getString("doctorID");
				String doctorName = rs.getString("doctorName");
				String phoneNumber = rs.getString("phoneNumber");

				Doctor doctor = new Doctor(doctorID, doctorName, phoneNumber);

				doctors.add(doctor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return doctors;
	}

	public Doctor getDoctorbyID(String id) throws ClassNotFoundException {
		try {
			c = dbConnect.initializeDatabase();
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM [DOCTOR] WHERE doctorID = '" + id + "'");

			while (rs.next()) {
				String doctorID = rs.getString("doctorID");
				String doctorName = rs.getString("doctorName");
				String phoneNumber = rs.getString("phoneNumber");

				return new Doctor(doctorID, doctorName, phoneNumber);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// Add Subject
	public void addMedicine(String medicineID, String medicineName, String medicineFunction, String unit, float doseMin,
			float doseMax) throws ClassNotFoundException {
		try {
			c = dbConnect.initializeDatabase();
			PreparedStatement pstm = c.prepareStatement(
					"INSERT INTO [MEDICINE] (medicineID, medicineName, medicineFunction, unit, doseMin, doseMax) values (?, ?, ?, ?, ?, ?)");
			pstm.setString(1, medicineID);
			pstm.setString(2, medicineName);
			pstm.setString(3, medicineFunction);
			pstm.setString(4, unit);
			pstm.setFloat(5, doseMin);
			pstm.setFloat(6, doseMax);

			pstm.executeUpdate();
			System.out.println("add success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Update Subject
	public void updateSubject(Medicine medicine) {
		try {
			c = dbConnect.initializeDatabase();
			PreparedStatement pstm = c
					.prepareStatement("UPDATE [MEDICINE] SET medicineName = ?, medicineFunction = ?, unit = ?, doseMin = ?, doseMax = ? WHERE medicineID = ?");
			pstm.setString(1, medicine.getMedicineID());
			pstm.setString(2, medicine.getMedicineName());
			pstm.setString(3, medicine.getMedicineFunction());
			pstm.setString(4, medicine.getUnit());
			pstm.setFloat(5, medicine.getDoseMin());
			pstm.setFloat(6, medicine.getDoseMax());

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
	public void deleteMedicine(String medicineID) {
		try {
			c = dbConnect.initializeDatabase();
			PreparedStatement pstm = c.prepareStatement("DELETE FROM [MEDICINE] WHERE medicineID = ?");
			pstm.setString(1, medicineID);

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
