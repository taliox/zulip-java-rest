package io.taliox.zulip.calls.settings;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.calls.ZulipRestAPICall;

// TODO: Auto-generated Javadoc
/**
 * The Class PostLinkifier.
 */
public class PostLinkifier extends ZulipRestAPICall {

	/** The pattern. */
	private String pattern;
	
	/** The url format string. */
	private String url_format_string;

	/**
	 * Instantiates a new post linkifier.
	 *
	 * @param pattern the pattern
	 * @param url_format_string the url format string
	 */
	public PostLinkifier(String pattern, String url_format_string) {
		setZulipAPIUrl("/api/v1/realm/filters");		
		this.pattern = pattern;
		this.url_format_string = url_format_string;
	}

	/* (non-Javadoc)
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute() {
		HttpPost post = new HttpPost(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("pattern", this.pattern);
		getParameters().put("url_format_string", this.url_format_string);
		return performRequest(getParameters(), post);
	}

	/**
	 * Gets the pattern.
	 *
	 * @return the pattern
	 */
	public String getPattern() {
		return pattern;
	}

	/**
	 * Sets the pattern.
	 *
	 * @param pattern the new pattern
	 */
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	/**
	 * Gets the url format string.
	 *
	 * @return the url format string
	 */
	public String getUrl_format_string() {
		return url_format_string;
	}

	/**
	 * Sets the url format string.
	 *
	 * @param url_format_string the new url format string
	 */
	public void setUrl_format_string(String url_format_string) {
		this.url_format_string = url_format_string;
	}
	
	
}
