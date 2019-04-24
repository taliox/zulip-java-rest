package io.taliox.zulip.calls.streams;

import org.apache.http.client.methods.HttpPatch;

import io.taliox.zulip.calls.ZulipRestAPICall;

public class PatchSubscriptionSettings extends ZulipRestAPICall {

	private String subscription_data;

	public PatchSubscriptionSettings(String subscription_data) {
		setZulipAPIUrl("/api/v1/users/me/subscriptions/properties");		
		this.subscription_data = subscription_data;
	}

	public String execute() {
		HttpPatch patch = new HttpPatch(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("subscription_data", subscription_data);
		return performRequest(getParameters(), patch);
	}

	public String getSubscription_data() {
		return subscription_data;
	}

	public void setSubscription_data(String subscription_data) {
		this.subscription_data = subscription_data;
	}
		
}
