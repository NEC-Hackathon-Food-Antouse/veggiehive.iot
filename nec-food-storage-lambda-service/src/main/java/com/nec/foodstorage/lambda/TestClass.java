package com.nec.foodstorage.lambda;

import java.io.IOException;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nec.foodstorage.vo.EnvironmentData;
import com.nec.foodstorage.vo.Humidity;
import com.nec.foodstorage.vo.SlotEnvEvent;
import com.nec.foodstorage.vo.SlotImageEvent;
import com.nec.foodstorage.vo.Temperature;

@Deprecated
public class TestClass {

	public static void main(String[] args) {
		SlotEnvEvent eventData = new SlotEnvEvent("1", LocalDateTime.now(),
				new EnvironmentData(new Temperature(10d, "°C"), new Humidity(10d, "RH")));
		SlotImageEvent imageEventData = new SlotImageEvent("1", LocalDateTime.now(),
				"https://s3.amazonaws.com/www.balachandarp.me/img/Infosys.png");
		ObjectMapper Obj = new ObjectMapper();
		try {
			// Displaying JSON String
			System.out.println("=========== EventsData ===========");
			System.out.println(Obj.writeValueAsString(eventData));
			System.out.println(Obj.writeValueAsString(imageEventData));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
