/*
 * 
 */
package io.taliox.zulip.calls.settings;

import org.apache.http.client.methods.HttpDelete;

import io.taliox.zulip.calls.ZulipRestAPICall;

// TODO: Auto-generated Javadoc
/**
 * The Class DeleteLinkifiers.
 */
public class DeleteLinkifiers extends ZulipRestAPICall {

	/** The filter id. */
	private String filter_id;

	/**
	 * Instantiates a new delete linkifiers.
	 *
	 * @param filter_id the filter id
	 */
	public DeleteLinkifiers(String filter_id) {
		setZulipAPIUrl("/api/v1/realm/filters/" + filter_id);		
		this.filter_id = filter_id;
	}

	/* (non-Javadoc)
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute() {
		HttpDelete delete = new HttpDelete(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("filter_id", this.filter_id);
		return performRequest(getParameters(), delete);
	}

	/**
	 * Gets the filter id.
	 *
	 * @return the filter id
	 */
	public String getFilter_id() {
		return filter_id;
	}

	/**
	 * Sets the filter id.
	 *
	 * @param filter_id the new filter id
	 */
	public void setFilter_id(String filter_id) {
		this.filter_id = filter_id;
	}
	
	
}
