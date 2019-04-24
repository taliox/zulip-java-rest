package io.taliox.zulip.calls.streams;

import org.apache.http.client.methods.HttpDelete;

import io.taliox.zulip.calls.ZulipRestAPICall;

public class DeleteSubscription extends ZulipRestAPICall {

	private String subscriptions;
	private String principals;

	public DeleteSubscription(String subscriptions) {
		setZulipAPIUrl("/api/v1/users/me/subcriptions");
		this.subscriptions = subscriptions;
	}

	public String execute() {
		HttpDelete delete = new HttpDelete(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("subscriptions", subscriptions);
		if (principals != null) {
			getParameters().put("principals", principals);
		}
		return performRequest(getParameters(), delete);
	}

	public String getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(String subscriptions) {
		this.subscriptions = subscriptions;
	}

	public String getPrincipals() {
		return principals;
	}

	public void setPrincipals(String principals) {
		this.principals = principals;
	}
	
}