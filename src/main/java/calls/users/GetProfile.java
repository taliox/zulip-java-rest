package calls.users;

import org.apache.http.client.methods.HttpGet;

import calls.ZulipRestAPICall;

public class GetProfile extends ZulipRestAPICall {

	public GetProfile() {
		super();
		setZulipAPIUrl("/api/v1/users/me");
	}

	public String execute() {
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		return performRequest(getParameters(), get);
	}
}
