package io.taliox.zulip;

import io.taliox.zulip.calls.ZulipRestAPICall;
import io.taliox.zulip.calls.settings.PostCustomEmoji;
import io.taliox.zulip.calls.settings.PostLinkifier;
import io.taliox.zulip.calls.streams.PatchTopicMuting;
import io.taliox.zulip.controller.HttpController;
import io.taliox.zulip.enums.MessageFlagsOpTypes;

public class ZulipRestExecutor {

	private HttpController httpController;
	
	public ZulipRestExecutor(String userName, String password, String serverURL) {
		this.httpController = new HttpController(userName, password, serverURL);
	}

	public String executeCall(ZulipRestAPICall call) {
		call.setHttpController(httpController);
		return call.execute();
	}
	
	//todo json encoding posttyping, message flags
	public static void main(String[] args) {
		ZulipRestExecutor z = new ZulipRestExecutor("Cookie-bot@zulip.taliox.io", "huAL10ED8dOz1CfqIHxVDVyCo2Ursjiw", "https://zulip.taliox.io/");	
		System.out.println(z.executeCall(new PatchTopicMuting("watercooler", "hello", MessageFlagsOpTypes.add)));
	}
	
}
