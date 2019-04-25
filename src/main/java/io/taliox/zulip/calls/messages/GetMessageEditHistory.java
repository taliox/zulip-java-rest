package io.taliox.zulip.calls.messages;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.ZulipRestExecutor;
import io.taliox.zulip.calls.ZulipRestAPICall;

/**
 * <p>
 * Permanently delete a message. Fetch the message edit history of a previously
 * edited message. Note that edit history may be disabled in some organizations.
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/get-message-history">https://zulipchat.com/api/get-message-history</a>
 * @see <a href=
 *      "https://zulipchat.com/help/view-a-messages-edit-history">https://zulipchat.com/help/view-a-messages-edit-history</a>
 *
 */
public class GetMessageEditHistory extends ZulipRestAPICall {

	/**
	 * The ID of the message you want to fetch the history of.
	 */
	private String message_id;

	/**
	 * Constructor for DeleteMessage.
	 *
	 * @param message_id
	 *            The ID of the message you want to fetch the history of.
	 */
	public GetMessageEditHistory(String message_id) {
		setZulipAPIUrl("/api/v1/messages/" + message_id + "/history");
		this.message_id = message_id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute(ZulipRestExecutor executor) {
		setHttpController(executor.httpController);
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("message_id", message_id);
		return performRequest(getParameters(), get);
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
