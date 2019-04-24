package io.taliox.zulip.calls.users;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.calls.ZulipRestAPICall;

// TODO: Auto-generated Javadoc
/**
 * The Class GetAllUsers.
 */
public class GetAllUsers extends ZulipRestAPICall {

	/** The client gravatar. */
	private boolean client_gravatar = false;

	/**
	 * Instantiates a new gets the all users.
	 */
	public GetAllUsers() {
		super();
		setZulipAPIUrl("/api/v1/users");
	}

	/* (non-Javadoc)
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute() {
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("stream", Boolean.toString(client_gravatar));
		return performRequest(getParameters(), get);
	}

	/**
	 * Checks if is client gravatar.
	 *
	 * @return true, if is client gravatar
	 */
	public boolean isClient_gravatar() {
		return client_gravatar;
	}

	/**
	 * Sets the client gravatar.
	 *
	 * @param client_gravatar the new client gravatar
	 */
	public void setClient_gravatar(boolean client_gravatar) {
		this.client_gravatar = client_gravatar;
	}
		
}
