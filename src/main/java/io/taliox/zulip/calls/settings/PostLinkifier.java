package io.taliox.zulip.calls.settings;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.ZulipRestExecutor;
import io.taliox.zulip.calls.ZulipRestAPICall;

/**
 * <p>
 * Configure linkifiers, regular expression patterns that are automatically
 * linkified when they appear in messages and topics.
 * 
 * @see <a href=
 *      "https://zulipchat.com/help/add-a-custom-linkification-filter">https://zulipchat.com/help/add-a-custom-linkification-filter</a>
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/add-linkifiers">https://zulipchat.com/api/add-linkifiers</a>
 */
public class PostLinkifier extends ZulipRestAPICall {

	/**
	 * The Python regular expression that should trigger the linkifier.
	 * 
	 * @see <a href=
	 *      "https://docs.python.org/3/howto/regex.html">https://docs.python.org/3/howto/regex.html</a>
	 */
	private String pattern;

	/**
	 * The URL used for the link. If you used named groups for the pattern, you can
	 * insert their content here with %(name_of_the_capturing_group)s.
	 */
	private String url_format_string;

	/**
	 * Instantiates a new post linkifier.
	 *
	 * @param pattern
	 *            The Python regular expression that should trigger the linkifier.
	 * @param url_format_string
	 *            The URL used for the link. If you used named groups for the
	 *            pattern, you can insert their content here with
	 *            %(name_of_the_capturing_group)s.
	 */
	public PostLinkifier(String pattern, String url_format_string) {
		setZulipAPIUrl("/api/v1/realm/filters");
		this.pattern = pattern;
		this.url_format_string = url_format_string;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute(ZulipRestExecutor executor) {
		setHttpController(executor.httpController);
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
	 * @param pattern
	 *            the new pattern
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
	 * @param url_format_string
	 *            the new url format string
	 */
	public void setUrl_format_string(String url_format_string) {
		this.url_format_string = url_format_string;
	}

}
