package io.taliox.zulip.calls.streams;

import org.apache.http.client.methods.HttpPatch;

import io.taliox.zulip.ZulipRestExecutor;
import io.taliox.zulip.calls.ZulipRestAPICall;

/**
 * <p>
 * This endpoint is used to update the user's personal settings for the streams
 * they are subscribed to, including muting, color, pinning, and per-stream
 * notification settings.
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/update-subscription-properties">https://zulipchat.com/api/update-subscription-properties</a>
 */
public class PatchSubscriptionSettings extends ZulipRestAPICall {

	/**
	 * A list of objects that describe the changes that should be applied in each
	 * subscription. Each object represents a subscription, and must have a
	 * stream_id key that identifies the stream, as well as the property being
	 * modified and its new value..
	 */
	private String subscription_data;

	/**
	 * Instantiates a new patch subscription settings.
	 *
	 * @param subscription_data
	 * 
	 *            A list of objects that describe the changes that should be applied
	 *            in each subscription. Each object represents a subscription, and
	 *            must have a stream_id key that identifies the stream, as well as
	 *            the property being modified and its new value.
	 */
	public PatchSubscriptionSettings(String subscription_data) {
		setZulipAPIUrl("/api/v1/users/me/subscriptions/properties");
		this.subscription_data = subscription_data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute(ZulipRestExecutor executor) {
		setHttpController(executor.httpController);
		HttpPatch patch = new HttpPatch(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("subscription_data", subscription_data);
		return performRequest(getParameters(), patch);
	}

	/**
	 * Gets the subscription data.
	 *
	 * @return the subscription data
	 */
	public String getSubscription_data() {
		return subscription_data;
	}

	/**
	 * Sets the subscription data.
	 *
	 * @param subscription_data
	 *            the new subscription data
	 */
	public void setSubscription_data(String subscription_data) {
		this.subscription_data = subscription_data;
	}

}
