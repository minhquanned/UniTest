package com.java.be;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedicineDBContext {

	Connection c;

	// Test connection
	public MedicineDBContext() {
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
		MedicineDBContext bConnect = new MedicineDBContext();
//		Medicine bmedicine = new Medicine("M04", "Never Depression", "Treat Depression", "pill", 4, 6);
		List<Medicine> medicines = bConnect.getAllMedicines();
		System.out.println(medicines);
//		bConnect.updateMedicine(bmedicine);
	}

	// Take all medicine
	public List<Medicine> getAllMedicines() throws ClassNotFoundException {
		List<Medicine> medicines = new ArrayList<>();

		try {
			c = dbConnect.initializeDatabase();
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM [MEDICINE]");

			while (rs.next()) {
				String medicineID = rs.getString("medicineID");
				String medicineName = rs.getString("MedicineName");
				String medicineFunction = rs.getString("MedicineFunction");
				String unit = rs.getString("unit");
				float doseMin = rs.getFloat("doseMin");
				float doseMax = rs.getFloat("doseMax");

				Medicine medicine = new Medicine(medicineID, medicineName, medicineFunction, unit, doseMin, doseMax);

				medicines.add(medicine);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return medicines;
	}

	public Medicine getMedicinebyID(String id) throws ClassNotFoundException {
		try {
			c = dbConnect.initializeDatabase();
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM [MEDICINE] WHERE medicineID = '" + id + "'");

			while (rs.next()) {
				String medicineID = rs.getString("medicineID");
				String medicineName = rs.getString("medicineName");
				String medicineFunction = rs.getString("noC");
				String unit = rs.getString("unit");
				float doseMin = rs.getFloat("doseMin");
				float doseMax = rs.getFloat("doseMax");

				return new Medicine(medicineID, medicineName, medicineFunction, unit, doseMin, doseMax);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// Add medicine
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

	// Update medicine
	public void updateMedicine(Medicine medicine) {
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

	// Delete medicine
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
