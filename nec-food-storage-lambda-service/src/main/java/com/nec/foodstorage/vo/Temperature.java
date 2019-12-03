package com.nec.foodstorage.vo;

public class Temperature {

	private double value;
	private String unit;

	public Temperature() {
	}

	public Temperature(double value, String unit) {
		super();
		this.value = value;
		this.unit = unit;
	}

	// Getter Methods

	public double getValue() {
		return value;
	}

	public String getUnit() {
		return unit;
	}

	// Setter Methods

	public void setValue(double value) {
		this.value = value;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
