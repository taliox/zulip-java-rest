package io.taliox.zulip.calls.streams;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.calls.ZulipRestAPICall;

// TODO: Auto-generated Javadoc
/**
 * The Class GetAllStreams.
 */
public class GetAllStreams extends ZulipRestAPICall {

	/** The include public. */
	private boolean include_public = true;
	
	/** The include subscribed. */
	private boolean include_subscribed = true;
	
	/** The include all active. */
	private boolean include_all_active = false;
	
	/** The include default. */
	private boolean include_default = false;
	
	/** The include owner subscribed. */
	private boolean include_owner_subscribed = false;
	
	/**
	 * Instantiates a new gets the all streams.
	 */
	public GetAllStreams() {
		setZulipAPIUrl("/api/v1/streams");		
	}

	/* (non-Javadoc)
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute() {
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("include_public", Boolean.toString(include_public));
		getParameters().put("include_subscribed", Boolean.toString(include_subscribed));
		getParameters().put("include_all_active", Boolean.toString(include_all_active));
		getParameters().put("include_default", Boolean.toString(include_default));
		getParameters().put("include_owner_subscribed", Boolean.toString(include_owner_subscribed));
		return performRequest(getParameters(), get);
	}

	/**
	 * Checks if is include public.
	 *
	 * @return true, if is include public
	 */
	public boolean isInclude_public() {
		return include_public;
	}

	/**
	 * Sets the include public.
	 *
	 * @param include_public the new include public
	 */
	public void setInclude_public(boolean include_public) {
		this.include_public = include_public;
	}

	/**
	 * Checks if is include subscribed.
	 *
	 * @return true, if is include subscribed
	 */
	public boolean isInclude_subscribed() {
		return include_subscribed;
	}

	/**
	 * Sets the include subscribed.
	 *
	 * @param include_subscribed the new include subscribed
	 */
	public void setInclude_subscribed(boolean include_subscribed) {
		this.include_subscribed = include_subscribed;
	}

	/**
	 * Checks if is include all active.
	 *
	 * @return true, if is include all active
	 */
	public boolean isInclude_all_active() {
		return include_all_active;
	}

	/**
	 * Sets the include all active.
	 *
	 * @param include_all_active the new include all active
	 */
	public void setInclude_all_active(boolean include_all_active) {
		this.include_all_active = include_all_active;
	}

	/**
	 * Checks if is include default.
	 *
	 * @return true, if is include default
	 */
	public boolean isInclude_default() {
		return include_default;
	}

	/**
	 * Sets the include default.
	 *
	 * @param include_default the new include default
	 */
	public void setInclude_default(boolean include_default) {
		this.include_default = include_default;
	}

	/**
	 * Checks if is include owner subscribed.
	 *
	 * @return true, if is include owner subscribed
	 */
	public boolean isInclude_owner_subscribed() {
		return include_owner_subscribed;
	}

	/**
	 * Sets the include owner subscribed.
	 *
	 * @param include_owner_subscribed the new include owner subscribed
	 */
	public void setInclude_owner_subscribed(boolean include_owner_subscribed) {
		this.include_owner_subscribed = include_owner_subscribed;
	}
	
}
