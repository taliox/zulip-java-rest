package calls.users;

import org.apache.http.client.methods.HttpGet;

import calls.ZulipRestAPICall;

public class GetAllUserGroups extends ZulipRestAPICall {

	public GetAllUserGroups() {
		super();
		setZulipAPIUrl("/api/v1/user_groups");
	}

	public String execute() {
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		return performRequest(getParameters(), get);
	}
}