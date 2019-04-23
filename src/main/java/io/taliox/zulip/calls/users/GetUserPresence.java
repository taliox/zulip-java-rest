package io.taliox.zulip.calls.users;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.calls.ZulipRestAPICall;

public class GetUserPresence extends ZulipRestAPICall {

	private String email = "";

	public GetUserPresence(String email) {
		super();
		this.email = email;
		setZulipAPIUrl("/api/v1/users/" + email +"/presence");
	}

	public String execute() {
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("stream", email);
		return performRequest(getParameters(), get);
	}
}