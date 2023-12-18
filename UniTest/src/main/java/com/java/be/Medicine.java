package com.java.be;

public class Medicine {
	private String medicineID;
	private String medicineName;
	private String medicineFunction;
	private String unit;
	private float doseMin;
	private float doseMax;
	public String getMedicineID() {
		return medicineID;
	}
	public void setMedicineID(String medicineID) {
		this.medicineID = medicineID;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getMedicineFunction() {
		return medicineFunction;
	}
	public void setMedicineFunction(String medicineFunction) {
		this.medicineFunction = medicineFunction;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public float getDoseMin() {
		return doseMin;
	}
	public void setDoseMin(float doseMin) {
		this.doseMin = doseMin;
	}
	public float getDoseMax() {
		return doseMax;
	}
	public void setDoseMax(float doseMax) {
		this.doseMax = doseMax;
	}
	public Medicine() {
		super();
	}
	public Medicine(String medicineID, String medicineName, String medicineFunction, String unit, float doseMin,
			float doseMax) {
		super();
		this.medicineID = medicineID;
		this.medicineName = medicineName;
		this.medicineFunction = medicineFunction;
		this.unit = unit;
		this.doseMin = doseMin;
		this.doseMax = doseMax;
	}
}
