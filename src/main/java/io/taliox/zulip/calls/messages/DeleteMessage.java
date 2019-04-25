package io.taliox.zulip.calls.messages;

import org.apache.http.client.methods.HttpDelete;

import io.taliox.zulip.ZulipRestExecutor;
import io.taliox.zulip.calls.ZulipRestAPICall;

/**
 * <p>
 * Permanently delete a message. This API corresponds to the delete a message
 * completely feature documented in the Zulip Help Center.
 *
 * @see <a href=
 *      "https://zulipchat.com/api/delete-message">https://zulipchat.com/api/delete-message</a>
 * @see <a href=
 *      "https://zulipchat.com/help/edit-or-delete-a-message#delete-a-message-completely">https://zulipchat.com/help/edit-or-delete-a-message#delete-a-message-completely</a>
 *
 */
public class DeleteMessage extends ZulipRestAPICall {

	/**
	 * The ID of the message to delete..
	 */
	private String message_id;

	/**
	 * Constructor for DeleteMessage.
	 *
	 * @param message_id
	 *            the ID of the message to delete.
	 */
	public DeleteMessage(String message_id) {
		setZulipAPIUrl("/api/v1/messages/" + message_id);
		this.message_id = message_id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute(ZulipRestExecutor executor) {
		setHttpController(executor.httpController);
		HttpDelete delete = new HttpDelete(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("message_id", message_id);
		return performRequest(getParameters(), delete);
	}

	/**
	 * Gets the message id.
	 *
	 * @return the message id
	 */
	public String getMessage_id() {
		return message_id;
	}

	/**
	 * Sets the message id.
	 *
	 * @param message_id
	 *            the new message id
	 */
	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}

}
