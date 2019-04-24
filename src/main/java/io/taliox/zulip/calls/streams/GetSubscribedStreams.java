package io.taliox.zulip.calls.streams;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.calls.ZulipRestAPICall;

// TODO: Auto-generated Javadoc
/**
 * The Class GetSubscribedStreams.
 */
public class GetSubscribedStreams extends ZulipRestAPICall {

	/**
	 * Instantiates a new gets the subscribed streams.
	 */
	public GetSubscribedStreams() {
		setZulipAPIUrl("/api/v1/users/me/subscriptions");
	}

	/* (non-Javadoc)
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute() {
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		return performRequest(getParameters(), get);
	}

}
