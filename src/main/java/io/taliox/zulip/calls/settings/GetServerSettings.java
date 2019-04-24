package io.taliox.zulip.calls.settings;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.calls.ZulipRestAPICall;

// TODO: Auto-generated Javadoc
/**
 * The Class GetServerSettings.
 */
public class GetServerSettings extends ZulipRestAPICall {

	/**
	 * Instantiates a new gets the server settings.
	 */
	public GetServerSettings() {
		super();
		setZulipAPIUrl("/api/v1/server_settings");
	}

	/* (non-Javadoc)
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute() {
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		return performRequest(getParameters(), get);
	}
}
