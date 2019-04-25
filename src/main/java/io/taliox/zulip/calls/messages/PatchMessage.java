package io.taliox.zulip.calls.messages;

import org.apache.http.client.methods.HttpPatch;

import io.taliox.zulip.ZulipRestExecutor;
import io.taliox.zulip.calls.ZulipRestAPICall;
import io.taliox.zulip.enums.UpdateMessageTypes;

/**
 * <p>
 * Edit/update the content or topic of a message.
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/update-message">https://zulipchat.com/api/update-message</a>
 *
 */
public class PatchMessage extends ZulipRestAPICall {

	/** The ID of the message that you wish to edit/update. */
	private String message_id;

	/**
	 * The topic of the message. Only required for stream messages. Maximum length
	 * of 60 characters.
	 */
	private String subject;

	/**
	 * Which message(s) should be edited: just the one indicated in message_id,
	 * messages in the same topic that had been sent after this one, or all of them.
	 * Must be one of: change_one, change_later, change_all. Defaults to
	 * "change_one".
	 */
	private UpdateMessageTypes type = UpdateMessageTypes.change_one;

	/** The content of the message. Maximum message size of 10000 bytes. */
	private String content;

	/**
	 * Instantiates a new patch update message.
	 *
	 * @param message_id
	 *            The ID of the message that you wish to edit/update.
	 */
	public PatchMessage(String message_id) {
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
		HttpPatch patch = new HttpPatch(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("message_id", message_id);
		if (subject != null && !subject.isEmpty()) {
			getParameters().put("subject", subject);
		}
		if (type != null) {
		getParameters().put("propagate_mode", type.toString());
		}
		if (content != null && !content.isEmpty()) {
		getParameters().put("content", content);
		}
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
	 * @param message_id
	 *            the new message id
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
	 * @param subject
	 *            the new subject
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
	 * @param type
	 *            the new type
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
	 * @param content
	 *            the new content
	 */
	public void setContent(String content) {
		this.content = content;
	}

}
