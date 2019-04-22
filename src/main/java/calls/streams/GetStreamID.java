package calls.streams;

import org.apache.http.client.methods.HttpGet;

import calls.ZulipRestAPICall;

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
}