package com.nec.foodstorage.vo;

import java.time.LocalDateTime;

public class SlotEvent extends SlotMetaData {
	private SensorData sensorData;

	public SlotEvent() {

	}

	public SlotEvent(String slotNo, String guid, LocalDateTime creationTimestamp, String location) {
		super(slotNo, guid, creationTimestamp, location);
	}

	public SensorData getSensorData() {
		return sensorData;
	}

	public void setSensorData(SensorData sensorData) {
		this.sensorData = sensorData;
	}

}
