package io.taliox.zulip.calls.messages;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.ZulipRestExecutor;
import io.taliox.zulip.calls.ZulipRestAPICall;
import io.taliox.zulip.enums.MessageTypes;

/**
 * <p>
 * Send a stream or a private message.
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/send-message">https://zulipchat.com/api/send-message</a>
 *
 */
public class PostMessage extends ZulipRestAPICall {

	/**
	 * The type of message to be sent. private for a private message and stream for
	 * a stream message. Must be one of: private, stream.
	 */
	private MessageTypes type;

	/**
	 * The destination stream, or a CSV/JSON-encoded list containing the usernames
	 * (emails) of the recipients.
	 */
	private String to;

	/**
	 * The topic of the message. Only required if type is stream, ignored otherwise.
	 * Maximum length of 60 characters.
	 */
	private String subject;

	/** The content of the message. Maximum message size of 10000 bytes. */
	private String content;

	/**
	 * Instantiates a new post message.
	 *
	 * @param toEmail
	 *            The to email or a CSV/JSON-encoded list containing the usernames
	 *            (emails) of the recipients.
	 * @param content
	 *            The content of the message. Maximum message size of 10000 bytes.
	 */
	public PostMessage(String toEmail, String content) {
		setZulipAPIUrl("/api/v1/messages");
		this.type = MessageTypes.PRIVATE;
		this.to = toEmail;
		this.content = content;
	}

	/**
	 * Instantiates a new post message.
	 *
	 * @param toStream
	 *            The destination stream
	 * @param topic
	 *            The topic of the message. Only required if type is stream, ignored
	 *            otherwise. Maximum length of 60 characters.
	 * @param content
	 *            The content of the message. Maximum message size of 10000 bytes.
	 */
	public PostMessage(String toStream, String topic, String content) {
		setZulipAPIUrl("/api/v1/messages");
		type = MessageTypes.STREAM;
		this.to = toStream;
		this.subject = topic;
		this.content = content;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute(ZulipRestExecutor executor) {
		setHttpController(executor.httpController);
		HttpPost post = new HttpPost(this.httpController.getServer() + getZulipAPIUrl());

		if (type == MessageTypes.PRIVATE) {
			getParameters().put("type", type.toString());
			getParameters().put("to", this.to);
			getParameters().put("content", this.content);
		} else {
			getParameters().put("type", type.toString());
			getParameters().put("to", this.to);
			getParameters().put("subject", this.subject);
			getParameters().put("content", this.content);
		}

		return performRequest(getParameters(), post);
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public MessageTypes getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type
	 *            the new type
	 */
	public void setType(MessageTypes type) {
		this.type = type;
	}

	/**
	 * Gets the to.
	 *
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * Sets the to.
	 *
	 * @param to
	 *            the new to
	 */
	public void setTo(String to) {
		this.to = to;
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
