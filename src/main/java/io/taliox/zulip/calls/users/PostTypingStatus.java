package io.taliox.zulip.calls.users;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.ZulipRestExecutor;
import io.taliox.zulip.calls.ZulipRestAPICall;
import io.taliox.zulip.enums.TypingStatusOpTypes;

/**
 * <p>
 * Send an event indicating that the user has started or stopped typing on their
 * client. See the typing notification docs for details on Zulip's typing
 * notifications protocol.
 * 
 * @see <a href=
 *      "https://zulip.readthedocs.io/en/latest/subsystems/typing-indicators.html">https://zulip.readthedocs.io/en/latest/subsystems/typing-indicators.html</a>
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/typing">https://zulipchat.com/api/typing</a>
 */
public class PostTypingStatus extends ZulipRestAPICall {

	/**
	 * Whether the user has started (start) or stopped (stop) to type. Must be one
	 * of: start, stop.
	 */
	private TypingStatusOpTypes op;

	/**
	 * The recipients of the message being typed, in the same format used by the
	 * send_message API. Typing notifications are only supported for private
	 * messages, so this should be a JSON-encoded list of email addresses of the
	 * message's recipients.
	 */
	private String notification_to;

	/**
	 * Instantiates a new post typing status.
	 *
	 * @param op
	 *            Whether the user has started (start) or stopped (stop) to type. Must be one
	 * 			  of: start, stop.
	 * @param notification_to
	 *            The recipients of the message being typed, in the same format used by the
	 * 			  send_message API. Typing notifications are only supported for private
	 * 			  messages, so this should be a JSON-encoded list of email addresses of the
	 * 			  message's recipients.
	 */
	public PostTypingStatus(TypingStatusOpTypes op, String notification_to) {
		setZulipAPIUrl("/api/v1/typing");
		this.op = op;
		this.notification_to = notification_to;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute(ZulipRestExecutor executor) {
		setHttpController(executor.httpController);
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
	 * @param op
	 *            the new op
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
	 * @param notification_to
	 *            the new notification to
	 */
	public void setNotification_to(String notification_to) {
		this.notification_to = notification_to;
	}

}
