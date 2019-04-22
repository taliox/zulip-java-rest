package calls.settings;

import org.apache.http.client.methods.HttpGet;

import calls.ZulipRestAPICall;

public class GetAllCustomEmoji extends ZulipRestAPICall {

	public GetAllCustomEmoji() {
		super();
		setZulipAPIUrl("/api/v1/realm/emoji");
	}

	public String execute() {
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		return performRequest(getParameters(), get);
	}
}
