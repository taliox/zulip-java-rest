package io.taliox.zulip.calls.streams;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.ZulipRestExecutor;
import io.taliox.zulip.calls.ZulipRestAPICall;

/**
 * <p>
 * Get all streams that the user is subscribed to.
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/get-subscribed-streams">https://zulipchat.com/api/get-subscribed-streams</a>
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
	public String execute(ZulipRestExecutor executor) {
		setHttpController(executor.httpController);
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		return performRequest(getParameters(), get);
	}

}
