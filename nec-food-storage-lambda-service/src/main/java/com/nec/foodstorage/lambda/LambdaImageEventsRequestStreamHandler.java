package com.nec.foodstorage.lambda;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nec.foodstorage.persistence.MongoDBOperations;
import com.nec.foodstorage.vo.SlotImageEvent;

public class LambdaImageEventsRequestStreamHandler implements RequestStreamHandler {
	private ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

	@Override
	public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {

		SlotImageEvent eventsData = objectMapper.readValue(inputStream, SlotImageEvent.class);
		context.getLogger().log("Recevied requst for Events Lambda:--> " + eventsData.getSlotId());
		boolean isInserted = MongoDBOperations.createImageEventsRecord(eventsData);
		context.getLogger().log("Stored events :--> " + eventsData.getSlotId()
				+ (isInserted ? "Events inserted successfully" : "DB Insertion Failed"));
		objectMapper.writeValue(outputStream, (isInserted ? "Events inserted successfully" : "DB Insertion Failed"));

	}
}