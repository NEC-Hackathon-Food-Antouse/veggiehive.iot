package com.nec.foodstorage.lambda;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nec.foodstorage.persistence.MongoDBOperations;
import com.nec.foodstorage.vo.SlotEvent;

public class LambdaEventsRequestStreamHandler implements RequestStreamHandler {
	private ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

	@Override
	public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
		SlotEvent eventsData = objectMapper.readValue(inputStream, SlotEvent.class);
		context.getLogger().log("Recevied requst for Events Lambda:--> " + eventsData.getGuid());
		boolean isInserted = MongoDBOperations.createMachineEventsRecord(eventsData);
		context.getLogger().log("Stored events :--> " + eventsData.getGuid()
				+ (isInserted ? "Events inserted successfully" : "DB Insertion Failed"));
		objectMapper.writeValue(outputStream, (isInserted ? "Events inserted successfully" : "DB Insertion Failed"));
	}
}