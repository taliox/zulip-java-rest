package io.taliox.zulip.calls.messages;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.ZulipRestExecutor;
import io.taliox.zulip.calls.ZulipRestAPICall;

/**
 * <p>
 * Render a message to HTML.
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/render-message">https://zulipchat.com/api/render-message</a>
 *
 */
public class PostRenderMessage extends ZulipRestAPICall {
	
	/** The content of the message. */
	private String content;
	
	/**
	 * Instantiates a new post render message.
	 *
	 * @param content The content of the message.
	 */
	public PostRenderMessage(String content) {
		setZulipAPIUrl("/api/v1/messages/render");		
		this.content = content;
	}
	
	/* (non-Javadoc)
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute(ZulipRestExecutor executor) {
		setHttpController(executor.httpController);
		HttpPost post = new HttpPost(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("content", this.content);
		return performRequest(getParameters(), post);
	}

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
}

