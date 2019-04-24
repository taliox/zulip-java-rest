package io.taliox.zulip.calls.users;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.calls.ZulipRestAPICall;
import io.taliox.zulip.enums.TypingStatusOpTypes;

public class PostTypingStatus extends ZulipRestAPICall {

	private TypingStatusOpTypes op;
	private String notification_to;

	public PostTypingStatus(TypingStatusOpTypes op, String notification_to) {
		setZulipAPIUrl("/api/v1/typing");
		this.op = op;
		this.notification_to = notification_to;
	}

	public String execute() {
		HttpPost post = new HttpPost(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("op", this.op.toString());
		getParameters().put("to", notification_to);
		return performRequest(getParameters(), post);
	}

	public TypingStatusOpTypes getOp() {
		return op;
	}

	public void setOp(TypingStatusOpTypes op) {
		this.op = op;
	}

	public String getNotification_to() {
		return notification_to;
	}

	public void setNotification_to(String notification_to) {
		this.notification_to = notification_to;
	}
	
}
