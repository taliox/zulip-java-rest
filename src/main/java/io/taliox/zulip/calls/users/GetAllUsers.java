package io.taliox.zulip.calls.users;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.ZulipRestExecutor;
import io.taliox.zulip.calls.ZulipRestAPICall;

/**
 * <p>
 * Retrieve all users in a realm.
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/get-all-users">https://zulipchat.com/api/get-all-users</a>
 */
public class GetAllUsers extends ZulipRestAPICall {

	/**
	 * The client_gravatar field is set to true if clients can compute their own
	 * gravatars. Defaults to false.
	 */
	private boolean client_gravatar = false;

	/**
	 * Instantiates a new gets the all users.
	 */
	public GetAllUsers() {
		super();
		setZulipAPIUrl("/api/v1/users");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute(ZulipRestExecutor executor) {
		setHttpController(executor.httpController);
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
	 * @param client_gravatar
	 *            the new client gravatar
	 */
	public void setClient_gravatar(boolean client_gravatar) {
		this.client_gravatar = client_gravatar;
	}

}
