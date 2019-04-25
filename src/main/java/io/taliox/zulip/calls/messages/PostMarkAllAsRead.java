package io.taliox.zulip.calls.messages;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.calls.ZulipRestAPICall;

/**
 * <p>
 * Marks all of the current user's unread messages as read.
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/mark-as-read-bulk">https://zulipchat.com/api/mark-as-read-bulk</a>
 *
 */
public class PostMarkAllAsRead extends ZulipRestAPICall {
	
	/**
	 * Instantiates a new post mark all as read.
	 */
	public PostMarkAllAsRead() {
		setZulipAPIUrl("/api/v1/mark_all_as_read");		
	}

	/* (non-Javadoc)
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute() {
		HttpPost post = new HttpPost(this.httpController.getServer() + getZulipAPIUrl());
		return performRequest(getParameters(), post);
	}
	
}
