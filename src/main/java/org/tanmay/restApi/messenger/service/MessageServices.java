package org.tanmay.restApi.messenger.service;

import java.util.List;

import org.tanmay.restApi.messenger.model.Message;

public interface MessageServices {
	
	public List<Message> getAllMessages();
	
	public List<Message> getAllMessagesForYear(int year);
	
	
	
	public void addMessage(Message msg);
	
	public void removeMessage(long id);

	Message getMessage(long id);

	void updateMessage(long id, Message msg);
	
	public List<Message> getAllMessagesPaginated(int start, int end);

}
