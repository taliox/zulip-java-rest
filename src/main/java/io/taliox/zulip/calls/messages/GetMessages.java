package io.taliox.zulip.calls.messages;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.ZulipRestExecutor;
import io.taliox.zulip.calls.ZulipRestAPICall;

/**
 * <p>
 * Fetch message history from a Zulip server. This GET /api/v1/messages endpoint
 * is the primary way to fetch message history from a Zulip server. It is useful
 * both for Zulip clients (e.g. the web, desktop, mobile, and terminal clients)
 * as well as bots, API clients, backup scripts, etc. By specifying a narrow
 * filter, you can use this endpoint to fetch the messages matching any search
 * query that is supported by Zulip's powerful full-text search backend. When a
 * narrow is not specified, it can be used to fetch a user's message history (We
 * recommend paginating to 1000 messages at a time). In either case, you specify
 * an anchor message (or ask the server to calculate the first unread message
 * for you and use that as the anchor), as well as a number of messages before
 * and after the anchor message. The server returns those messages, sorted by
 * message ID, as well as some metadata that makes it easy for a client to
 * determine whether there are more messages matching the query that were not
 * returned due to the num_before and num_after limits. We recommend using
 * num_before <= 1000 and num_after <= 1000 to avoid generating very large HTTP
 * responses. A maximum of 5000 messages can be obtained per request; attempting
 * to exceed this will result in an error.
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/get-messages">https://zulipchat.com/api/get-messages</a>
 *
 */
public class GetMessages extends ZulipRestAPICall {

	/**
	 * The message ID to fetch messages near. Required unless
	 * use_first_unread_anchor is set to true.
	 */
	private int anchor = -1;

	/**
	 * Whether to use the (computed by the server) first unread message matching the
	 * narrow as the anchor. Mutually exclusive with anchor. Defaults to false.
	 */
	private boolean use_first_unread_anchor = false;

	/** The number of messages with IDs less than the anchor to retrieve. */
	private int num_before = 0;

	/** The number of messages with IDs greater than the anchor to retrieve. */
	private int num_after = 0;

	/**
	 * The narrow where you want to fetch the messages from. See how to construct a
	 * narrow. Defaults to [].
	 * 
	 * @see <a href=
	 *      "https://zulipchat.com/api/construct-narrow">https://zulipchat.com/api/construct-narrow</a>
	 */
	private String narrow = "[]";

	/**
	 * Whether the client supports computing gravatars URLs. If enabled, avatar_url
	 * will be included in the response only if there is a Zulip avatar, and will be
	 * null for users who are using gravatar as their avatar. This option
	 * significantly reduces the compressed size of user data, since gravatar URLs
	 * are long, random strings and thus do not compress well. Defaults to false.
	 */
	private boolean client_gravatar = false;

	/**
	 * If true, message content is returned in the rendered HTML format. If false,
	 * message content is returned in the raw markdown-format text that user
	 * entered. Defaults to true.
	 */
	private boolean apply_markdown = false;

	/**
	 * Instantiates a new gets the messages.
	 *
	 * @param num_before
	 *            the num before
	 * @param num_after
	 *            the num after
	 */
	public GetMessages(int num_before, int num_after) {
		setZulipAPIUrl("/api/v1/messages");
		this.use_first_unread_anchor = true;
		this.num_before = num_before;
		this.num_after = num_after;
	}

	/**
	 * Instantiates a new gets the messages.
	 *
	 * @param num_before
	 *            the num before
	 * @param num_after
	 *            the num after
	 * @param anchor
	 *            the anchor
	 */
	public GetMessages(int num_before, int num_after, int anchor) {
		setZulipAPIUrl("/api/v1/messages");
		this.anchor = anchor;
		this.num_before = num_before;
		this.num_after = num_after;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute(ZulipRestExecutor executor) {
		setHttpController(executor.httpController);
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("anchor", Integer.toString(anchor));
		getParameters().put("use_first_unread_anchor", Boolean.toString(use_first_unread_anchor));
		getParameters().put("num_before", Integer.toString(num_before));
		getParameters().put("num_after", Integer.toString(num_after));
		getParameters().put("narrow", narrow);
		getParameters().put("client_gravatar", Boolean.toString(client_gravatar));
		getParameters().put("apply_markdown", Boolean.toString(apply_markdown));

		return performRequest(getParameters(), get);
	}

	/**
	 * Gets the anchor.
	 *
	 * @return the anchor
	 */
	public int getAnchor() {
		return anchor;
	}

	/**
	 * Sets the anchor.
	 *
	 * @param anchor
	 *            the new anchor
	 */
	public void setAnchor(int anchor) {
		this.anchor = anchor;
	}

	/**
	 * Checks if is use first unread anchor.
	 *
	 * @return true, if is use first unread anchor
	 */
	public boolean isUse_first_unread_anchor() {
		return use_first_unread_anchor;
	}

	/**
	 * Sets the use first unread anchor.
	 *
	 * @param use_first_unread_anchor
	 *            the new use first unread anchor
	 */
	public void setUse_first_unread_anchor(boolean use_first_unread_anchor) {
		this.use_first_unread_anchor = use_first_unread_anchor;
	}

	/**
	 * Gets the num before.
	 *
	 * @return the num before
	 */
	public int getNum_before() {
		return num_before;
	}

	/**
	 * Sets the num before.
	 *
	 * @param num_before
	 *            the new num before
	 */
	public void setNum_before(int num_before) {
		this.num_before = num_before;
	}

	/**
	 * Gets the num after.
	 *
	 * @return the num after
	 */
	public int getNum_after() {
		return num_after;
	}

	/**
	 * Sets the num after.
	 *
	 * @param num_after
	 *            the new num after
	 */
	public void setNum_after(int num_after) {
		this.num_after = num_after;
	}

	/**
	 * Gets the narrow.
	 *
	 * @return the narrow
	 */
	public String getNarrow() {
		return narrow;
	}

	/**
	 * Sets the narrow.
	 *
	 * @param narrow
	 *            the new narrow
	 */
	public void setNarrow(String narrow) {
		this.narrow = narrow;
	}

	/**
	 * Checks if is client gravatar.
	 *
	 * @return true, if is client gravatar
	 */
	public boolean isClient_gravatar() {
		return client_gravatar;
	}

	/**
	 * Sets the client gravatar.
	 *
	 * @param client_gravatar
	 *            the new client gravatar
	 */
	public void setClient_gravatar(boolean client_gravatar) {
		this.client_gravatar = client_gravatar;
	}

	/**
	 * Checks if is apply markdown.
	 *
	 * @return true, if is apply markdown
	 */
	public boolean isApply_markdown() {
		return apply_markdown;
	}

	/**
	 * Sets the apply markdown.
	 *
	 * @param apply_markdown
	 *            the new apply markdown
	 */
	public void setApply_markdown(boolean apply_markdown) {
		this.apply_markdown = apply_markdown;
	}

}
