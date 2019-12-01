package com.nec.foodstorage.vo;

public class EnvironmentData {
	private String temp;
	private String humidity;

	public EnvironmentData() {
	}

	public EnvironmentData(String temp, String humidity) {
		super();
		this.temp = temp;
		this.humidity = humidity;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

}
