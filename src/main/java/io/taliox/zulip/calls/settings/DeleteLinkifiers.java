package io.taliox.zulip.calls.settings;

import org.apache.http.client.methods.HttpDelete;

import io.taliox.zulip.ZulipRestExecutor;
import io.taliox.zulip.calls.ZulipRestAPICall;

/**
 * <p>
 * Remove linkifiers, regular expression patterns that are automatically
 * linkified when they appear in messages and topics.
 * 
 * @see <a href=
 *      "https://zulipchat.com/help/add-a-custom-linkification-filter">https://zulipchat.com/help/add-a-custom-linkification-filter</a>
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/remove-linkifiers">https://zulipchat.com/api/remove-linkifiers</a>
 */
public class DeleteLinkifiers extends ZulipRestAPICall {

	/** The ID of the filter that you want to remove. */
	private String filter_id;

	/**
	 * Instantiates a new delete linkifiers.
	 *
	 * @param filter_id
	 *            the filter id
	 */
	public DeleteLinkifiers(String filter_id) {
		setZulipAPIUrl("/api/v1/realm/filters/" + filter_id);
		this.filter_id = filter_id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute(ZulipRestExecutor executor) {
		setHttpController(executor.httpController);
		HttpDelete delete = new HttpDelete(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("filter_id", this.filter_id);
		return performRequest(getParameters(), delete);
	}

	/**
	 * Gets the filter ID of the filter that you want to remove.
	 *
	 * @return the filter id
	 */
	public String getFilter_id() {
		return filter_id;
	}

	/**
	 * Sets the filter ID of the filter that you want to remove.
	 *
	 * @param filter_id
	 *            the new filter id
	 */
	public void setFilter_id(String filter_id) {
		this.filter_id = filter_id;
	}

}
