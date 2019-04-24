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

	public boolean isInclude_public() {
		return include_public;
	}

	public void setInclude_public(boolean include_public) {
		this.include_public = include_public;
	}

	public boolean isInclude_subscribed() {
		return include_subscribed;
	}

	public void setInclude_subscribed(boolean include_subscribed) {
		this.include_subscribed = include_subscribed;
	}

	public boolean isInclude_all_active() {
		return include_all_active;
	}

	public void setInclude_all_active(boolean include_all_active) {
		this.include_all_active = include_all_active;
	}

	public boolean isInclude_default() {
		return include_default;
	}

	public void setInclude_default(boolean include_default) {
		this.include_default = include_default;
	}

	public boolean isInclude_owner_subscribed() {
		return include_owner_subscribed;
	}

	public void setInclude_owner_subscribed(boolean include_owner_subscribed) {
		this.include_owner_subscribed = include_owner_subscribed;
	}
	
}
