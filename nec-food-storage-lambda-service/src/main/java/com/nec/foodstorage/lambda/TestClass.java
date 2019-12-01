package com.nec.foodstorage.lambda;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nec.foodstorage.vo.EnvironmentData;
import com.nec.foodstorage.vo.SensorData;
import com.nec.foodstorage.vo.SlotEvent;

@Deprecated
public class TestClass {

	public static void main(String[] args) {
		SlotEvent eventData = new SlotEvent("1", UUID.randomUUID().toString(), LocalDateTime.now(), "Bangalore");
		eventData.setSensorData(new SensorData(new EnvironmentData("10 F", "10 g/m3")));
		ObjectMapper Obj = new ObjectMapper();

		try {
			// Displaying JSON String
			System.out.println("=========== EventsData ===========");
			System.out.println(Obj.writeValueAsString(eventData));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
