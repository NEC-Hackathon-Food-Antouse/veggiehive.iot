package com.nec.foodstorage.vo;

public class SensorData {
	private EnvironmentData envData;

	public SensorData() {
	}

	public SensorData(EnvironmentData envData) {
		super();
		this.envData = envData;
	}

	public EnvironmentData getEnvData() {
		return envData;
	}

	public void setEnvData(EnvironmentData envData) {
		this.envData = envData;
	}

}
