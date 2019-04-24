package io.taliox.zulip.calls.messages;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.calls.ZulipRestAPICall;

public class PostRenderMessage extends ZulipRestAPICall {
	
	private String content;
	
	public PostRenderMessage(String content) {
		setZulipAPIUrl("/api/v1/messages/render");		
		this.content = content;
	}
	
	public String execute() {
		HttpPost post = new HttpPost(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("content", this.content);
		return performRequest(getParameters(), post);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}

