package io.taliox.zulip.calls.messages;


import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.calls.ZulipRestAPICall;

public class GetRawMessage extends ZulipRestAPICall {
	
	private String message_id;
	
	public GetRawMessage(String message_id) {
		setZulipAPIUrl("/api/v1/messages/"+message_id);		
		this.message_id = message_id;
	}

	public String execute() {
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("message_id", message_id);
		return performRequest(getParameters(), get);
	}
}
