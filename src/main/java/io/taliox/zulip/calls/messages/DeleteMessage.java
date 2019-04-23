package io.taliox.zulip.calls.messages;

import org.apache.http.client.methods.HttpDelete;

import io.taliox.zulip.calls.ZulipRestAPICall;

public class DeleteMessage extends ZulipRestAPICall {

	private String message_id;

	public DeleteMessage(String message_id) {
		setZulipAPIUrl("/api/v1/messages/" + message_id);		
		this.message_id = message_id;
	}

	public String execute() {
		HttpDelete delete = new HttpDelete(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("message_id", message_id);
		return performRequest(getParameters(), delete);
	}
}
