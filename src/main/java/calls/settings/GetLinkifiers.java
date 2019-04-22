package calls.settings;

import org.apache.http.client.methods.HttpGet;

import calls.ZulipRestAPICall;

public class GetLinkifiers extends ZulipRestAPICall {

	public GetLinkifiers() {
		super();
		setZulipAPIUrl("api/v1/realm/filters");
	}

	public String execute() {
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		return performRequest(getParameters(), get);
	}
}
