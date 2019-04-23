package io.taliox.zulip.calls.streams;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.calls.ZulipRestAPICall;

public class GetAllTopicsOfAStream extends ZulipRestAPICall {
	
	private String stream_id;
	
	public GetAllTopicsOfAStream(String stream_id) {
		super();
		this.stream_id = stream_id;
		setZulipAPIUrl("/api/v1/users/me/"+stream_id+"/topics");		
	}

	public String execute() {
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("stream_id", stream_id);
		return performRequest(getParameters(), get);
	}

}

