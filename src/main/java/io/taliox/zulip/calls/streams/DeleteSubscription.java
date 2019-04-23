package io.taliox.zulip.calls.streams;

import java.util.Arrays;

import org.apache.http.client.methods.HttpDelete;

import io.taliox.zulip.calls.ZulipRestAPICall;

public class DeleteSubscription extends ZulipRestAPICall {

	private String[] subscriptions;
	private String[] principals;

	public DeleteSubscription(String[] subscriptions) {
		setZulipAPIUrl("/api/v1/users/me/subcriptions");		
		this.subscriptions = subscriptions;
	}

	public String execute() {
		HttpDelete delete = new HttpDelete(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("subscriptions", Arrays.toString(subscriptions));
		getParameters().put("principals", Arrays.toString(principals));
		return performRequest(getParameters(), delete);
	}
}