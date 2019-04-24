package io.taliox.zulip;

import io.taliox.zulip.calls.ZulipRestAPICall;
import io.taliox.zulip.calls.streams.PostCreateStream;
import io.taliox.zulip.controller.HttpController;

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
		
		PostCreateStream pcs = new PostCreateStream("[{\"description\":\"Italian City\",\"name\":\"Verona342\"}]");
		pcs.setPrincipals("[\"tim.klimasch@taliox.io\"]");
		System.out.println(z.executeCall(pcs));
	}
	
}
