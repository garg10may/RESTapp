package org.tanmay.restApi.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.tanmay.restApi.messenger.database.DatabaseClass;
import org.tanmay.restApi.messenger.model.Message;

public class MessageService implements MessageServices {

	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public void addMessage(Message msg) {
		msg.setId(messages.size() + 1);
		msg.setCreated(new Date());
		messages.put(msg.getId(), msg);

	}

	public void updateMessage(long id, Message msg) {
		msg.setCreated(new Date());
		// need to set it since our HashMap keys are same as messages ID
		// if you won't override it, it will store that message but with 0 as
		// default id
		msg.setId(id);
		messages.put(id, msg);

	}

	public void removeMessage(long id) {
		messages.remove(id);

	}

	public Message getMessage(long id) {
		return messages.get(id);
	}

	public List<Message> getAllMessagesForYear(int year) {
		// TODO Auto-generated method stub
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size) {
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if (start + size > list.size()) return new ArrayList<Message>();
		return list.subList(start, start+size);
	}

}
