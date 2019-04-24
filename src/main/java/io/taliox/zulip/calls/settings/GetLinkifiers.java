package io.taliox.zulip.calls.settings;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.calls.ZulipRestAPICall;

// TODO: Auto-generated Javadoc
/**
 * The Class GetLinkifiers.
 */
public class GetLinkifiers extends ZulipRestAPICall {

	/**
	 * Instantiates a new gets the linkifiers.
	 */
	public GetLinkifiers() {
		super();
		setZulipAPIUrl("api/v1/realm/filters");
	}

	/* (non-Javadoc)
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute() {
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		return performRequest(getParameters(), get);
	}
}
