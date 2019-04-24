package io.taliox.zulip.calls.streams;

import org.apache.http.client.methods.HttpPatch;

import io.taliox.zulip.calls.ZulipRestAPICall;
import io.taliox.zulip.enums.MessageFlagsOpTypes;

// TODO: Auto-generated Javadoc
/**
 * The Class PatchTopicMuting.
 */
public class PatchTopicMuting extends ZulipRestAPICall {

	/** The stream. */
	private String stream;
	
	/** The topic. */
	private String topic;
	
	/** The op. */
	private MessageFlagsOpTypes op;

	/**
	 * Instantiates a new patch topic muting.
	 *
	 * @param stream the stream
	 * @param topic the topic
	 * @param op the op
	 */
	public PatchTopicMuting(String stream, String topic, MessageFlagsOpTypes op) {
		setZulipAPIUrl("/api/v1/users/me/subscriptions/muted_topics");		
		this.stream = stream;
		this.topic = topic;
		this.op = op;
	}

	/* (non-Javadoc)
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute() {
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
	 * @param stream the new stream
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
	 * @param topic the new topic
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
	 * @param op the new op
	 */
	public void setOp(MessageFlagsOpTypes op) {
		this.op = op;
	}
		
}