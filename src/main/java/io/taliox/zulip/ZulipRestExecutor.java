package io.taliox.zulip;


import java.io.File;

import io.taliox.zulip.calls.ZulipRestAPICall;
import io.taliox.zulip.calls.messages.PostMarkAllAsRead;
import io.taliox.zulip.calls.messages.PostUploadFile;
import io.taliox.zulip.calls.messages.UpdateMessageFlags;
import io.taliox.zulip.calls.streams.GetAllTopicsOfAStream;
import io.taliox.zulip.controller.HttpController;
import io.taliox.zulip.enums.MessageFlagTypes;
import io.taliox.zulip.enums.MessageOpTypes;

public class ZulipRestExecutor {

	private HttpController httpController;
	
	public ZulipRestExecutor(String userName, String password, String serverURL) {
		this.httpController = new HttpController(userName, password, serverURL);
	}

	public String executeCall(ZulipRestAPICall call) {
		call.setHttpController(httpController);
		return call.execute();
	}
	
	public static void main(String[] args) {
		ZulipRestExecutor z = new ZulipRestExecutor("Cookie-bot@zulip.taliox.io", "huAL10ED8dOz1CfqIHxVDVyCo2Ursjiw", "https://zulip.taliox.io/");
	
		System.out.println(z.executeCall(new PostUploadFile(new File("pom.xml"))));
	}
	
}
