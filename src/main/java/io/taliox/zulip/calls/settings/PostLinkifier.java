package io.taliox.zulip.calls.settings;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.calls.ZulipRestAPICall;

public class PostLinkifier extends ZulipRestAPICall {

	private String pattern;
	private String url_format_string;

	public PostLinkifier(String pattern, String url_format_string) {
		setZulipAPIUrl("/api/v1/realm/filters");		
		this.pattern = pattern;
		this.url_format_string = url_format_string;
	}

	public String execute() {
		HttpPost post = new HttpPost(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("pattern", this.pattern);
		getParameters().put("url_format_string", this.url_format_string);
		return performRequest(getParameters(), post);
	}
}
