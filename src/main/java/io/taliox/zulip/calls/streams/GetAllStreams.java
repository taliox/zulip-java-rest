package io.taliox.zulip.calls.streams;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.calls.ZulipRestAPICall;

public class GetAllStreams extends ZulipRestAPICall {

	private boolean include_public = true;
	private boolean include_subscribed = true;
	private boolean include_all_active = false;
	private boolean include_default = false;
	private boolean include_owner_subscribed = false;
	
	public GetAllStreams() {
		setZulipAPIUrl("/api/v1/streams");		
	}

	public String execute() {
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("include_public", Boolean.toString(include_public));
		getParameters().put("include_subscribed", Boolean.toString(include_subscribed));
		getParameters().put("include_all_active", Boolean.toString(include_all_active));
		getParameters().put("include_default", Boolean.toString(include_default));
		getParameters().put("include_owner_subscribed", Boolean.toString(include_owner_subscribed));
		return performRequest(getParameters(), get);
	}

}
