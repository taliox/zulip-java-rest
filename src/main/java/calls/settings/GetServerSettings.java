package calls.settings;

import org.apache.http.client.methods.HttpGet;

import calls.ZulipRestAPICall;

public class GetServerSettings extends ZulipRestAPICall {

	public GetServerSettings() {
		super();
		setZulipAPIUrl("/api/v1/server_settings");
	}

	public String execute() {
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		return performRequest(getParameters(), get);
	}
}
