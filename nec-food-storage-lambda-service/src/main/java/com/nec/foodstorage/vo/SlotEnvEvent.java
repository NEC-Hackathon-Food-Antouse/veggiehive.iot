package com.nec.foodstorage.vo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nec.foodstorage.serialize.LocalDateTimeDeserializer;
import com.nec.foodstorage.serialize.LocalDateTimeSerializer;

public class SlotEnvEvent {
	protected String slotId;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	protected LocalDateTime creationTimestamp;
	private EnvironmentData environmentData;

	public SlotEnvEvent() {

	}

	public SlotEnvEvent(String slotId, LocalDateTime creationTimestamp, EnvironmentData environmentData) {
		super();
		this.slotId = slotId;
		this.creationTimestamp = creationTimestamp;
		this.environmentData = environmentData;
	}

	public String getSlotId() {
		return slotId;
	}

	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}

	public LocalDateTime getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(LocalDateTime creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public EnvironmentData getEnvironmentData() {
		return environmentData;
	}

	public void setEnvironmentData(EnvironmentData environmentData) {
		this.environmentData = environmentData;
	}

}
