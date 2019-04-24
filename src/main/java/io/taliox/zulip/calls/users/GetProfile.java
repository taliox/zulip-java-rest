package io.taliox.zulip.calls.users;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.calls.ZulipRestAPICall;

// TODO: Auto-generated Javadoc
/**
 * The Class GetProfile.
 */
public class GetProfile extends ZulipRestAPICall {

	/**
	 * Instantiates a new gets the profile.
	 */
	public GetProfile() {
		super();
		setZulipAPIUrl("/api/v1/users/me");
	}

	/* (non-Javadoc)
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute() {
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		return performRequest(getParameters(), get);
	}
		
}
