package io.taliox.zulip.calls.messages;

import org.apache.http.client.methods.HttpPatch;

import io.taliox.zulip.calls.ZulipRestAPICall;
import io.taliox.zulip.enums.UpdateMessageTypes;

public class PatchUpdateMessage extends ZulipRestAPICall {

	private String message_id;
	private String subject;
	private UpdateMessageTypes type = UpdateMessageTypes.change_one;
	private String content;

	public PatchUpdateMessage(String message_id) {
		setZulipAPIUrl("/api/v1/messages/" + message_id);		
		this.message_id = message_id;
	}

	public String execute() {
		HttpPatch patch = new HttpPatch(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("message_id", message_id);
		getParameters().put("subject", subject);
		getParameters().put("propagate_mode", type.toString());
		getParameters().put("content", content);
		return performRequest(getParameters(), patch);
	}

	public String getMessage_id() {
		return message_id;
	}

	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public UpdateMessageTypes getType() {
		return type;
	}

	public void setType(UpdateMessageTypes type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
