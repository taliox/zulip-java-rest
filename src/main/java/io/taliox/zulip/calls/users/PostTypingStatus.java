package io.taliox.zulip.calls.users;

import java.util.Arrays;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.calls.ZulipRestAPICall;
import io.taliox.zulip.enums.TypingStatusOpTypes;

public class PostTypingStatus extends ZulipRestAPICall{
	
	private TypingStatusOpTypes op;
	private String[] notification_to;
	
	public PostTypingStatus(TypingStatusOpTypes op, String[] notification_to) {
		setZulipAPIUrl("/api/v1/typing");		
		this.op = op;
		this.notification_to = notification_to;
		System.out.println(Arrays.toString(notification_to));
	}
	

	public String execute() {
		HttpPost post = new HttpPost(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("op", this.op.toString());	
		getParameters().put("to", Arrays.toString(notification_to));	
		return performRequest(getParameters(), post);
	}

}
