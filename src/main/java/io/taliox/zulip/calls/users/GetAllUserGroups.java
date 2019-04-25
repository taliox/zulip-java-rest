package io.taliox.zulip.calls.users;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.ZulipRestExecutor;
import io.taliox.zulip.calls.ZulipRestAPICall;

/**
 * <p>
 * Fetches all of the user groups in the organization.
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/get-user-groups">https://zulipchat.com/api/get-user-groups</a>
 */
public class GetAllUserGroups extends ZulipRestAPICall {

	/**
	 * Instantiates a new gets the all user groups.
	 */
	public GetAllUserGroups() {
		super();
		setZulipAPIUrl("/api/v1/user_groups");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute(ZulipRestExecutor executor) {
		setHttpController(executor.httpController);
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		return performRequest(getParameters(), get);
	}

}