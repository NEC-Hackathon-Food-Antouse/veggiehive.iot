
package com.nec.foodstorage.persistence;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.nec.foodstorage.helper.GetPropertyValues;
import com.nec.foodstorage.vo.SlotEvent;

public class MongoDBOperations {
	static Logger log = Logger.getLogger(MongoDBOperations.class.getName());
	private static final String CONST_CONNECTION_STRING = "connectionstring";
	private static final String CONST_DB_NAME = "dbname";
	private static final String CONST_MACHINE_EVENTS = "slotEvents";
	private static MongoClient mongoClient;
	private static MongoDatabase database;

	private MongoDBOperations() {
	}

	static {
		try {
			GetPropertyValues getPropertyFileObject = new GetPropertyValues();
			mongoClient = new MongoClient(
					new MongoClientURI(getPropertyFileObject.getPropValues(CONST_CONNECTION_STRING)));
			CodecRegistry pojoCodecRegistry = org.bson.codecs.configuration.CodecRegistries.fromRegistries(
					MongoClientSettings.getDefaultCodecRegistry(), org.bson.codecs.configuration.CodecRegistries
							.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
			// ---------- Creating DataBase ---------------------------//
			database = mongoClient.getDatabase(getPropertyFileObject.getPropValues(CONST_DB_NAME))
					.withCodecRegistry(pojoCodecRegistry);
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

	public static boolean createMachineEventsRecord(SlotEvent event) {
		try {
			// ---------- Creating Collection -------------------------//
			MongoCollection<SlotEvent> table = database.getCollection(CONST_MACHINE_EVENTS, SlotEvent.class);
			// ----------- Inserting Data ------------------------------//
			table.insertOne(event);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}
}
