package io.taliox.zulip.calls.settings;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.ZulipRestExecutor;
import io.taliox.zulip.calls.ZulipRestAPICall;

/**
 * <p>
 * Fetch global settings for a Zulip server.
 * 
 * <b>Note:</b> this endpoint does not require any authentication at all, and
 * you can use it to check: • If this is a Zulip server, and if so, what version
 * of Zulip it's running. • What a Zulip client (e.g. a mobile app or
 * zulip-terminal) needs to know in order to display a login prompt for the
 * server (e.g. what authentication methods are available).
 * 
 * @see <a href=
 *      "https://github.com/zulip/zulip-terminal/">https://github.com/zulip/zulip-terminal/</a>
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/server-settings">https://zulipchat.com/api/server-settings</a>
 */
public class GetServerSettings extends ZulipRestAPICall {

	/**
	 * Instantiates a new gets the server settings.
	 */
	public GetServerSettings() {
		super();
		setZulipAPIUrl("/api/v1/server_settings");
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
