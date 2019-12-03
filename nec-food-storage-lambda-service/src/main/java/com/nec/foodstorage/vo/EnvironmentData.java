package com.nec.foodstorage.vo;

public class EnvironmentData {

	Temperature temperature;
	Humidity humidity;

	public EnvironmentData() {
	}

	public Temperature getTemperature() {
		return temperature;
	}

	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}

	public Humidity getHumidity() {
		return humidity;
	}

	public void setHumidity(Humidity humidity) {
		this.humidity = humidity;
	}

	public EnvironmentData(Temperature temperature, Humidity humidity) {
		super();
		this.temperature = temperature;
		this.humidity = humidity;
	}

}
