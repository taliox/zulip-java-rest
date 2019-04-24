package io.taliox.zulip.calls.streams;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.calls.ZulipRestAPICall;

public class GetStreamID extends ZulipRestAPICall {

	private String stream_name;

	public GetStreamID(String stream_name) {
		this.stream_name = stream_name;
		setZulipAPIUrl("/api/v1/get_stream_id");
	}

	public String execute() {

		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("stream", stream_name);
		return performRequest(getParameters(), get);

	}

	public String getStream_name() {
		return stream_name;
	}

	public void setStream_name(String stream_name) {
		this.stream_name = stream_name;
	}
	
}