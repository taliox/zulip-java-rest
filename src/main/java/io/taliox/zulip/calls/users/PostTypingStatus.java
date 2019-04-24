package io.taliox.zulip.calls.users;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.calls.ZulipRestAPICall;
import io.taliox.zulip.enums.TypingStatusOpTypes;

// TODO: Auto-generated Javadoc
/**
 * The Class PostTypingStatus.
 */
public class PostTypingStatus extends ZulipRestAPICall {

	/** The op. */
	private TypingStatusOpTypes op;
	
	/** The notification to. */
	private String notification_to;

	/**
	 * Instantiates a new post typing status.
	 *
	 * @param op the op
	 * @param notification_to the notification to
	 */
	public PostTypingStatus(TypingStatusOpTypes op, String notification_to) {
		setZulipAPIUrl("/api/v1/typing");
		this.op = op;
		this.notification_to = notification_to;
	}

	/* (non-Javadoc)
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute() {
		HttpPost post = new HttpPost(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("op", this.op.toString());
		getParameters().put("to", notification_to);
		return performRequest(getParameters(), post);
	}

	/**
	 * Gets the op.
	 *
	 * @return the op
	 */
	public TypingStatusOpTypes getOp() {
		return op;
	}

	/**
	 * Sets the op.
	 *
	 * @param op the new op
	 */
	public void setOp(TypingStatusOpTypes op) {
		this.op = op;
	}

	/**
	 * Gets the notification to.
	 *
	 * @return the notification to
	 */
	public String getNotification_to() {
		return notification_to;
	}

	/**
	 * Sets the notification to.
	 *
	 * @param notification_to the new notification to
	 */
	public void setNotification_to(String notification_to) {
		this.notification_to = notification_to;
	}
	
}
