package io.taliox.zulip.calls.streams;

import org.apache.http.client.methods.HttpPatch;

import io.taliox.zulip.calls.ZulipRestAPICall;

// TODO: Auto-generated Javadoc
/**
 * The Class PatchSubscriptionSettings.
 */
public class PatchSubscriptionSettings extends ZulipRestAPICall {

	/** The subscription data. */
	private String subscription_data;

	/**
	 * Instantiates a new patch subscription settings.
	 *
	 * @param subscription_data the subscription data
	 */
	public PatchSubscriptionSettings(String subscription_data) {
		setZulipAPIUrl("/api/v1/users/me/subscriptions/properties");		
		this.subscription_data = subscription_data;
	}

	/* (non-Javadoc)
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute() {
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
	 * @param subscription_data the new subscription data
	 */
	public void setSubscription_data(String subscription_data) {
		this.subscription_data = subscription_data;
	}
		
}
