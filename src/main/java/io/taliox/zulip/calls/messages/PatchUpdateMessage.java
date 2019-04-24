package io.taliox.zulip.calls.messages;

import org.apache.http.client.methods.HttpPatch;

import io.taliox.zulip.calls.ZulipRestAPICall;
import io.taliox.zulip.enums.UpdateMessageTypes;

// TODO: Auto-generated Javadoc
/**
 * The Class PatchUpdateMessage.
 */
public class PatchUpdateMessage extends ZulipRestAPICall {

	/** The message id. */
	private String message_id;
	
	/** The subject. */
	private String subject;
	
	/** The type. */
	private UpdateMessageTypes type = UpdateMessageTypes.change_one;
	
	/** The content. */
	private String content;

	/**
	 * Instantiates a new patch update message.
	 *
	 * @param message_id the message id
	 */
	public PatchUpdateMessage(String message_id) {
		setZulipAPIUrl("/api/v1/messages/" + message_id);		
		this.message_id = message_id;
	}

	/* (non-Javadoc)
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute() {
		HttpPatch patch = new HttpPatch(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("message_id", message_id);
		getParameters().put("subject", subject);
		getParameters().put("propagate_mode", type.toString());
		getParameters().put("content", content);
		return performRequest(getParameters(), patch);
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
	 * @param message_id the new message id
	 */
	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}

	/**
	 * Gets the subject.
	 *
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Sets the subject.
	 *
	 * @param subject the new subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public UpdateMessageTypes getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(UpdateMessageTypes type) {
		this.type = type;
	}

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
}
