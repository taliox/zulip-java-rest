package io.taliox.zulip.calls.users;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.calls.ZulipRestAPICall;

public class GetAllUsers extends ZulipRestAPICall {

	private boolean client_gravatar = false;

	public GetAllUsers() {
		super();
		setZulipAPIUrl("/api/v1/users");
	}

	public String execute() {
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("stream", Boolean.toString(client_gravatar));
		return performRequest(getParameters(), get);
	}

	public boolean isClient_gravatar() {
		return client_gravatar;
	}

	public void setClient_gravatar(boolean client_gravatar) {
		this.client_gravatar = client_gravatar;
	}
		
}
