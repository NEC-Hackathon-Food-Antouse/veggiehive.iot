package com.nec.foodstorage.vo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nec.foodstorage.serialize.LocalDateTimeDeserializer;
import com.nec.foodstorage.serialize.LocalDateTimeSerializer;

public abstract class SlotMetaData {

	public SlotMetaData() {
		super();
	}

	public SlotMetaData(String slotNo, String guid, LocalDateTime creationTimestamp, String location) {
		super();
		this.slotNo = slotNo;
		this.guid = guid;
		this.creationTimestamp = creationTimestamp;
		this.location = location;
	}

	public String getSlotNo() {
		return slotNo;
	}

	public void setSlotNo(String slotNo) {
		this.slotNo = slotNo;
	}

	public LocalDateTime getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(LocalDateTime creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	protected String slotNo;
	protected String guid;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	protected LocalDateTime creationTimestamp;
	protected String location;

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}