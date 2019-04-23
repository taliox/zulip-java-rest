package io.taliox.zulip.calls.settings;

import org.apache.http.client.methods.HttpDelete;

import io.taliox.zulip.calls.ZulipRestAPICall;

public class DeleteLinkifiers extends ZulipRestAPICall {

	private String filter_id;

	public DeleteLinkifiers(String filter_id) {
		setZulipAPIUrl("/api/v1/realm/filters/" + filter_id);		
		this.filter_id = filter_id;
	}

	public String execute() {
		HttpDelete delete = new HttpDelete(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("filter_id", this.filter_id);
		return performRequest(getParameters(), delete);
	}
}
