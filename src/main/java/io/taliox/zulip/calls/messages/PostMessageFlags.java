package io.taliox.zulip.calls.messages;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.calls.ZulipRestAPICall;
import io.taliox.zulip.enums.MessageFlagTypes;
import io.taliox.zulip.enums.MessageFlagsOpTypes;

// TODO: Auto-generated Javadoc
/**
 * The Class PostMessageFlags.
 */
public class PostMessageFlags extends ZulipRestAPICall {

	/** The messages. */
	private String messages;
	
	/** The op. */
	private MessageFlagsOpTypes op;
	
	/** The flag. */
	private MessageFlagTypes flag;

	/**
	 * Instantiates a new post message flags.
	 *
	 * @param messages the messages
	 * @param op the op
	 * @param flag the flag
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
	public String execute() {
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

