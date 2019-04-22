package calls.streams;

import org.apache.http.client.methods.HttpGet;

import calls.ZulipRestAPICall;

public class GetSubscribedStreams extends ZulipRestAPICall {

	public GetSubscribedStreams() {
		setZulipAPIUrl("/api/v1/users/me/subscriptions");
	}

	public String execute() {
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		return performRequest(getParameters(), get);
	}

}
