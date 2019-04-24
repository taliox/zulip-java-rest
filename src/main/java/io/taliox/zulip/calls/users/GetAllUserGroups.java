package io.taliox.zulip.calls.users;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.calls.ZulipRestAPICall;

// TODO: Auto-generated Javadoc
/**
 * The Class GetAllUserGroups.
 */
public class GetAllUserGroups extends ZulipRestAPICall {

	/**
	 * Instantiates a new gets the all user groups.
	 */
	public GetAllUserGroups() {
		super();
		setZulipAPIUrl("/api/v1/user_groups");
	}

	/* (non-Javadoc)
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute() {
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		return performRequest(getParameters(), get);
	}
		
}