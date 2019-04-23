package io.taliox.zulip.calls.settings;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.calls.ZulipRestAPICall;

public class GetAllCustomEmoji extends ZulipRestAPICall {

	public GetAllCustomEmoji() {
		super();
		setZulipAPIUrl("/api/v1/realm/emoji");
	}

	public String execute() {
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		return performRequest(getParameters(), get);
	}
}
