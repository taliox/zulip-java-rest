package io.taliox.zulip.calls.messages;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.calls.ZulipRestAPICall;
import io.taliox.zulip.enums.PostMessageTypes;

public class PostMessage extends ZulipRestAPICall {
	
	private PostMessageTypes type;
	private String to;
	private String subject;
	private String content;
	
	public PostMessage(String toEmail, String content) {
		setZulipAPIUrl("/api/v1/messages");		
		this.type = PostMessageTypes.PRIVATE;
		this.to = toEmail;
		this.content = content;
	}
	
	public PostMessage(String toStream, String topic, String content) {
		setZulipAPIUrl("/api/v1/messages");		
		type = PostMessageTypes.STREAM;
		this.to = toStream;
		this.subject = topic;
		this.content = content;
	}

	public String execute() {
		HttpPost post = new HttpPost(this.httpController.getServer() + getZulipAPIUrl());
		
		if(type == PostMessageTypes.PRIVATE) {
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
}
