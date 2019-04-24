package io.taliox.zulip.calls.streams;

import org.apache.http.client.methods.HttpPatch;

import io.taliox.zulip.calls.ZulipRestAPICall;
import io.taliox.zulip.enums.MessageFlagsOpTypes;

public class PatchTopicMuting extends ZulipRestAPICall {

	private String stream;
	private String topic;
	private MessageFlagsOpTypes op;

	public PatchTopicMuting(String stream, String topic, MessageFlagsOpTypes op) {
		setZulipAPIUrl("/api/v1/users/me/subscriptions/muted_topics");		
		this.stream = stream;
		this.topic = topic;
		this.op = op;
	}

	public String execute() {
		HttpPatch patch = new HttpPatch(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("stream", stream);
		getParameters().put("topic", topic);
		getParameters().put("op", op.toString());
		return performRequest(getParameters(), patch);
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public MessageFlagsOpTypes getOp() {
		return op;
	}

	public void setOp(MessageFlagsOpTypes op) {
		this.op = op;
	}
		
}