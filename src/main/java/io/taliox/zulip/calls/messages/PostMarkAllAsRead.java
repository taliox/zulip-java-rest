package io.taliox.zulip.calls.messages;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.calls.ZulipRestAPICall;

public class PostMarkAllAsRead extends ZulipRestAPICall {
	
	public PostMarkAllAsRead() {
		setZulipAPIUrl("/api/v1/mark_all_as_read");		
	}

	public String execute() {
		HttpPost post = new HttpPost(this.httpController.getServer() + getZulipAPIUrl());
		return performRequest(getParameters(), post);
	}
}
