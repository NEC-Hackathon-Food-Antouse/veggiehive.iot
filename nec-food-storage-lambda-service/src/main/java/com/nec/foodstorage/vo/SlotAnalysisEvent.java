package com.nec.foodstorage.vo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nec.foodstorage.serialize.LocalDateTimeDeserializer;
import com.nec.foodstorage.serialize.LocalDateTimeSerializer;

import lombok.Data;

@Data
public class SlotAnalysisEvent {
	protected String slotId;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	protected LocalDateTime creationTimestamp;
	private AnalysisData analysisData;

	public SlotAnalysisEvent(String slotId, LocalDateTime creationTimestamp, AnalysisData analysisData) {
		super();
		this.slotId = slotId;
		this.creationTimestamp = creationTimestamp;
		this.analysisData = analysisData;
	}

	public SlotAnalysisEvent() {
		super();
		// TODO Auto-generated constructor stub
	}

}
