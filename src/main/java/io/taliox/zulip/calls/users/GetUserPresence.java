package io.taliox.zulip.calls.users;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.calls.ZulipRestAPICall;

// TODO: Auto-generated Javadoc
/**
 * The Class GetUserPresence.
 */
public class GetUserPresence extends ZulipRestAPICall {

	/** The email. */
	private String email;

	/**
	 * Instantiates a new gets the user presence.
	 *
	 * @param email the email
	 */
	public GetUserPresence(String email) {
		super();
		this.email = email;
		setZulipAPIUrl("/api/v1/users/" + email +"/presence");
	}

	/* (non-Javadoc)
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute() {
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("stream", email);
		return performRequest(getParameters(), get);
	}
}