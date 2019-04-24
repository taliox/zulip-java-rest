package io.taliox.zulip.calls.messages;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.calls.ZulipRestAPICall;

// TODO: Auto-generated Javadoc
/**
 * The Class PostRenderMessage.
 */
public class PostRenderMessage extends ZulipRestAPICall {
	
	/** The content. */
	private String content;
	
	/**
	 * Instantiates a new post render message.
	 *
	 * @param content the content
	 */
	public PostRenderMessage(String content) {
		setZulipAPIUrl("/api/v1/messages/render");		
		this.content = content;
	}
	
	/* (non-Javadoc)
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute() {
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

