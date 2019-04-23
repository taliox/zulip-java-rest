package io.taliox.zulip.calls.streams;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.calls.ZulipRestAPICall;

public class GetSubscribedStreams extends ZulipRestAPICall {

	public GetSubscribedStreams() {
		setZulipAPIUrl("/api/v1/users/me/subscriptions");
	}

	public String execute() {
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		return performRequest(getParameters(), get);
	}

}
