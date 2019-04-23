package io.taliox.zulip.calls.messages;

import java.util.Arrays;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.calls.ZulipRestAPICall;
import io.taliox.zulip.enums.MessageFlagTypes;
import io.taliox.zulip.enums.MessageFlagsOpTypes;

public class PostMessageFlags extends ZulipRestAPICall {

	private String[] messages;
	private MessageFlagsOpTypes op;
	private MessageFlagTypes flag;

	public PostMessageFlags(String[] messages, MessageFlagsOpTypes op, MessageFlagTypes flag) {
		super();
		setZulipAPIUrl("/api/v1/messages/flags");		
		this.messages = messages;
		this.op = op;
		this.flag = flag;
		
		System.out.println(Arrays.toString(messages));
	}

	public String execute() {
		HttpPost post = new HttpPost(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("messages", Arrays.toString(messages));
		getParameters().put("op", op.toString());
		getParameters().put("flag", flag.toString());
		return performRequest(getParameters(), post);
	}
}

