package io.taliox.zulip.calls.users;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.ZulipRestExecutor;
import io.taliox.zulip.calls.ZulipRestAPICall;

/**
 * <p>
 * Get the profile of the user/bot that requests this endpoint.
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/get-profile">https://zulipchat.com/api/get-profile</a>
 */
public class GetProfile extends ZulipRestAPICall {

	/**
	 * Instantiates a new gets the profile.
	 */
	public GetProfile() {
		super();
		setZulipAPIUrl("/api/v1/users/me");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute(ZulipRestExecutor executor) {
		setHttpController(executor.httpController);
		setHttpController(executor.httpController);
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		return performRequest(getParameters(), get);
	}

}
