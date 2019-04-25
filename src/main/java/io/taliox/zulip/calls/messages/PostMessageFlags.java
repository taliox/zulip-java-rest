package io.taliox.zulip.calls.messages;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.ZulipRestExecutor;
import io.taliox.zulip.calls.ZulipRestAPICall;
import io.taliox.zulip.enums.MessageFlagTypes;
import io.taliox.zulip.enums.MessageFlagsOpTypes;

/**
 * <p>
 * Add or remove flags in a list of messages.
 * For updating the read flag on common collections of messages.
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/mark-as-read-bulk">https://zulipchat.com/api/mark-as-read-bulk</a>
 * @see <a href=
 *      "https://zulipchat.com/api/update-message-flags">https://zulipchat.com/api/update-message-flags</a>
 *
 */
public class PostMessageFlags extends ZulipRestAPICall {

	/** An string as array containing the IDs of the target messages. */
	private String messages;
	
	/** Whether to add the flag or remove it. Must be one of: add, remove. */
	private MessageFlagsOpTypes op;
	
	/** The flag that should be added/removed. Must be one of: read, starred,  collapsed, mentioned, wildcard_mentioned, summarize_in_home,  summarize_in_stream, force_expand, force_collapse, has_alert_word,  historical. */
	private MessageFlagTypes flag;

	/**
	 * Instantiates a new post message flags.
	 *
	 * @param messages An string as array containing the IDs of the target messages.
	 * @param op Whether to add the flag or remove it. Must be one of: add, remove.
	 * @param flag The flag that should be added/removed. Must be one of: read, starred,  collapsed, mentioned, wildcard_mentioned, summarize_in_home,  summarize_in_stream, force_expand, force_collapse, has_alert_word,  historical.
	 */
	public PostMessageFlags(String messages, MessageFlagsOpTypes op, MessageFlagTypes flag) {
		super();
		setZulipAPIUrl("/api/v1/messages/flags");		
		this.messages = messages;
		this.op = op;
		this.flag = flag;
	}

	/* (non-Javadoc)
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute(ZulipRestExecutor executor) {
		setHttpController(executor.httpController);
		HttpPost post = new HttpPost(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("messages", messages);
		getParameters().put("op", op.toString());
		getParameters().put("flag", flag.toString());
		return performRequest(getParameters(), post);
	}

	/**
	 * Gets the messages.
	 *
	 * @return the messages
	 */
	public String getMessages() {
		return messages;
	}

	/**
	 * Sets the messages.
	 *
	 * @param messages the new messages
	 */
	public void setMessages(String messages) {
		this.messages = messages;
	}

	/**
	 * Gets the op.
	 *
	 * @return the op
	 */
	public MessageFlagsOpTypes getOp() {
		return op;
	}

	/**
	 * Sets the op.
	 *
	 * @param op the new op
	 */
	public void setOp(MessageFlagsOpTypes op) {
		this.op = op;
	}

	/**
	 * Gets the flag.
	 *
	 * @return the flag
	 */
	public MessageFlagTypes getFlag() {
		return flag;
	}

	/**
	 * Sets the flag.
	 *
	 * @param flag the new flag
	 */
	public void setFlag(MessageFlagTypes flag) {
		this.flag = flag;
	}
	
}

