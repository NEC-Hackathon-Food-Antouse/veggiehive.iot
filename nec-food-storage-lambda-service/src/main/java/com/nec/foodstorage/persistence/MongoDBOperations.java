
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
import com.nec.foodstorage.vo.SlotAnalysisEvent;
import com.nec.foodstorage.vo.SlotEnvEvent;
import com.nec.foodstorage.vo.SlotImageEvent;

public class MongoDBOperations {
	static Logger log = Logger.getLogger(MongoDBOperations.class.getName());
	private static final String CONST_CONNECTION_STRING = "connectionstring";
	private static final String CONST_DB_NAME = "dbname";
	private static final String CONST_ENVIRONMENT_EVENTS = "slotEnvEvent";
	private static final String CONST_IMAGE_EVENT = "slotImageEvent";
	private static final String CONST_VISION_EVENT = "slotAnalysisEvent";
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

	public static boolean createEnvironmentEventsRecord(SlotEnvEvent event) {
		try {
			// ---------- Creating Collection -------------------------//
			MongoCollection<SlotEnvEvent> table = database.getCollection(CONST_ENVIRONMENT_EVENTS, SlotEnvEvent.class);
			// ----------- Inserting Data ------------------------------//
			table.insertOne(event);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}

	public static boolean createImageEventsRecord(SlotImageEvent event) {
		try {
			// ---------- Creating Collection -------------------------//
			MongoCollection<SlotImageEvent> table = database.getCollection(CONST_IMAGE_EVENT, SlotImageEvent.class);
			// ----------- Inserting Data ------------------------------//
			table.insertOne(event);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}

	public static boolean createVisionResponseRecord(SlotAnalysisEvent event) {
		try {
			// ---------- Creating Collection -------------------------//
			MongoCollection<SlotAnalysisEvent> table = database.getCollection(CONST_VISION_EVENT, SlotAnalysisEvent.class);
			// ----------- Inserting Data ------------------------------//
			table.insertOne(event);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}
}
