package io.taliox.zulip.calls.messages;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.calls.ZulipRestAPICall;
import io.taliox.zulip.enums.MessageTypes;

public class PostMessage extends ZulipRestAPICall {
	
	private MessageTypes type;
	private String to;
	private String subject;
	private String content;
	
	public PostMessage(String toEmail, String content) {
		setZulipAPIUrl("/api/v1/messages");		
		this.type = MessageTypes.PRIVATE;
		this.to = toEmail;
		this.content = content;
	}
	
	public PostMessage(String toStream, String topic, String content) {
		setZulipAPIUrl("/api/v1/messages");		
		type = MessageTypes.STREAM;
		this.to = toStream;
		this.subject = topic;
		this.content = content;
	}

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

	public MessageTypes getType() {
		return type;
	}

	public void setType(MessageTypes type) {
		this.type = type;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
