package io.taliox.zulip.calls.messages;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.calls.ZulipRestAPICall;

/**
 * <p>
 * Get the raw content of a message. This is a rarely-used endpoint relevant for
 * clients that primarily work with HTML-rendered messages but might need to
 * occasionally fetch the message's raw markdown (e.g. for pre-filling message-editing UI).
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/get-raw-message">https://zulipchat.com/api/get-raw-message</a>
 *
 */
public class GetRawMessage extends ZulipRestAPICall {

	/** The message id. */
	private String message_id;

	/**
	 * Instantiates a new gets the raw message.
	 *
	 * @param message_id
	 *            the message id
	 */
	public GetRawMessage(String message_id) {
		setZulipAPIUrl("/api/v1/messages/" + message_id);
		this.message_id = message_id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute() {
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
