package io.taliox.zulip.calls.settings;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.ZulipRestExecutor;
import io.taliox.zulip.calls.ZulipRestAPICall;

/**
 * <p>
 * List all of an organization's configured linkifiers, regular expression
 * patterns that are automatically linkified when they appear in messages and
 * topics.
 * 
 * @see <a href=
 *      "https://zulipchat.com/help/add-a-custom-linkification-filter">https://zulipchat.com/help/add-a-custom-linkification-filter</a>
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/list-linkifiers">https://zulipchat.com/api/list-linkifiers</a>
 */
public class GetLinkifiers extends ZulipRestAPICall {

	/**
	 * Instantiates a new gets the linkifiers.
	 */
	public GetLinkifiers() {
		super();
		setZulipAPIUrl("api/v1/realm/filters");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute(ZulipRestExecutor executor) {
		setHttpController(executor.httpController);
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		return performRequest(getParameters(), get);
	}
}
