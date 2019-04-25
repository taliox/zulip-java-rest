package io.taliox.zulip.calls.streams;

import org.apache.http.client.methods.HttpPatch;

import io.taliox.zulip.ZulipRestExecutor;
import io.taliox.zulip.calls.ZulipRestAPICall;
import io.taliox.zulip.enums.MessageFlagsOpTypes;

/**
 * <p>
 * This endpoint mutes/unmutes a topic within a stream that the current user is
 * subscribed to. Muted topics are displayed faded in the Zulip UI, and are not
 * included in the user's unread count totals.
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/mute-topics">https://zulipchat.com/api/mute-topics</a>
 */
public class PatchTopicMuting extends ZulipRestAPICall {

	/** The name of the stream in which to mute the topic. */
	private String stream;

	/**
	 * The topic to (un)mute. Note that the request will succeed regardless of
	 * whether any messages have been sent to the specified topic.
	 */
	private String topic;

	/**
	 * Whether to mute (add) or unmute (remove) the provided topic. Must be one of:
	 * add, remove.
	 */
	private MessageFlagsOpTypes op;

	/**
	 * Instantiates a new patch topic muting.
	 *
	 * @param stream
	 *            The name of the stream in which to mute the topic.
	 * @param topic
	 *            The topic to (un)mute. Note that the request will succeed
	 *            regardless of whether any messages have been sent to the specified
	 *            topic.
	 * @param op
	 *            Whether to mute (add) or unmute (remove) the provided topic. Must
	 *            be one of: add, remove.
	 */
	public PatchTopicMuting(String stream, String topic, MessageFlagsOpTypes op) {
		setZulipAPIUrl("/api/v1/users/me/subscriptions/muted_topics");
		this.stream = stream;
		this.topic = topic;
		this.op = op;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute(ZulipRestExecutor executor) {
		setHttpController(executor.httpController);
		HttpPatch patch = new HttpPatch(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("stream", stream);
		getParameters().put("topic", topic);
		getParameters().put("op", op.toString());
		return performRequest(getParameters(), patch);
	}

	/**
	 * Gets the stream.
	 *
	 * @return the stream
	 */
	public String getStream() {
		return stream;
	}

	/**
	 * Sets the stream.
	 *
	 * @param stream
	 *            the new stream
	 */
	public void setStream(String stream) {
		this.stream = stream;
	}

	/**
	 * Gets the topic.
	 *
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * Sets the topic.
	 *
	 * @param topic
	 *            the new topic
	 */
	public void setTopic(String topic) {
		this.topic = topic;
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
	 * @param op
	 *            the new op
	 */
	public void setOp(MessageFlagsOpTypes op) {
		this.op = op;
	}

}