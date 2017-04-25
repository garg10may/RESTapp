/**
 * 
 */
package org.tanmay.restApi.messenger.resources;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.tanmay.restApi.messenger.model.Message;
import org.tanmay.restApi.messenger.service.MessageService;

/**
 * @author garg10may
 *
 */

@Path("/messages")
public class MessageResources{

	MessageService messageService = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@QueryParam(value = "year") int year,
									 @QueryParam("start") int start,
									 @QueryParam("size") int size) {

		if (year >0) {
			return messageService.getAllMessagesForYear(year);
		}
		
		if (size > 0 && start >0) {
			return messageService.getAllMessagesPaginated(start, size);
		}
		
		return messageService.getAllMessages();
	}

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {

		return "This works fine";
	}

	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getSingleMessage(@PathParam("messageId") long messageId) {

		return messageService.getMessage(messageId);

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String addMessage(Message message) {

		messageService.addMessage(message);

		long id = message.getId();
		Date created = message.getCreated();
		return String.format("Message added successfully at %s with id %s", created, id);

		// return "Message added successfully";
	}

	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateMessage(@PathParam("messageId") long messageId, Message message) {

		messageService.updateMessage(messageId, message);

		return String.format("Message updated successfully");
	}

	@DELETE
	@Path("/{messageId}")
	public String deleteMessage(@PathParam("messageId") long messageId) {

		messageService.removeMessage(messageId);

		return "Message deleted successfully";
	}

}
