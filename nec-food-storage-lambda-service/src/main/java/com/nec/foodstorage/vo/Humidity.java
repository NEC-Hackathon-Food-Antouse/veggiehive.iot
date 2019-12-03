package com.nec.foodstorage.vo;

public class Humidity {

	private double value;
	private String unit;

	public Humidity() {
	}

	public Humidity(double value, String unit) {
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
