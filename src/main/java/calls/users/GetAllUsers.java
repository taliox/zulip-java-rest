package calls.users;

import org.apache.http.client.methods.HttpGet;

import calls.ZulipRestAPICall;

public class GetAllUsers extends ZulipRestAPICall {

	private boolean client_gravatar = false;

	public GetAllUsers() {
		super();
		setZulipAPIUrl("/api/v1/users");
	}

	public String execute() {
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("stream", Boolean.toString(client_gravatar));
		return performRequest(getParameters(), get);
	}
}
