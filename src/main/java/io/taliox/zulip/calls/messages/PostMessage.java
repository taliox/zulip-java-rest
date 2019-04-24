package io.taliox.zulip.calls.messages;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.calls.ZulipRestAPICall;
import io.taliox.zulip.enums.MessageTypes;

// TODO: Auto-generated Javadoc
/**
 * The Class PostMessage.
 */
public class PostMessage extends ZulipRestAPICall {
	
	/** The type. */
	private MessageTypes type;
	
	/** The to. */
	private String to;
	
	/** The subject. */
	private String subject;
	
	/** The content. */
	private String content;
	
	/**
	 * Instantiates a new post message.
	 *
	 * @param toEmail the to email
	 * @param content the content
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
	 * @param toStream the to stream
	 * @param topic the topic
	 * @param content the content
	 */
	public PostMessage(String toStream, String topic, String content) {
		setZulipAPIUrl("/api/v1/messages");		
		type = MessageTypes.STREAM;
		this.to = toStream;
		this.subject = topic;
		this.content = content;
	}

	/* (non-Javadoc)
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute() {
		HttpPost post = new HttpPost(this.httpController.getServer() + getZulipAPIUrl());
		
		if(type == MessageTypes.PRIVATE) {
			getParameters().put("type", type.toString());
			getParameters().put("to", this.to);
			getParameters().put("content", this.content);
		}
		else {
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
	 * @param type the new type
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
	 * @param to the new to
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
	 * @param subject the new subject
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
	 * @param content the new content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
}
