package io.taliox.zulip.calls.users;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.calls.ZulipRestAPICall;

/**
 * <p>
 * Get the presence status for a specific user.
 * 
 * This endpoint is most useful for embedding data about a user's presence
 * status in other sites (E.g. an employee directory). Full Zulip clients like
 * mobile/desktop apps will want to use the main presence endpoint, which
 * returns data for all active users in the organization, instead.
 * 
 * @see <a href=
 *      "https://zulip.readthedocs.io/en/latest/subsystems/presence.html">https://zulip.readthedocs.io/en/latest/subsystems/presence.html</a>
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/get-profile">https://zulipchat.com/api/get-profile</a>
 */
public class GetUserPresence extends ZulipRestAPICall {

	/** The email address of the user whose presence you want to fetch. */
	private String email;

	/**
	 * Instantiates a new gets the user presence.
	 *
	 * @param email
	 *            The email address of the user whose presence you want to fetch.
	 */
	public GetUserPresence(String email) {
		super();
		this.email = email;
		setZulipAPIUrl("/api/v1/users/" + email + "/presence");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute() {
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("stream", email);
		return performRequest(getParameters(), get);
	}
}