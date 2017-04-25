package org.tanmay.restApi.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.tanmay.restApi.messenger.model.Message;
import org.tanmay.restApi.messenger.model.Profile;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();

	public static Map<Long, Message> getMessages() {

		messages.put(1L, new Message(1, "hello", "tanmay"));
		messages.put(2L, new Message(2, "how are you", "tanmay"));

		return messages;
	}

	public static Map<String, Profile> getProfiles() {

		profiles.put("garg10may", new Profile(1L, "garg10may", "tanmay", "garg"));

		return profiles;
	}

}
