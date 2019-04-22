package controller;

import calls.ZulipRestAPICall;
import calls.messages.GetMessageEditHistory;
import calls.messages.PostMessage;
import calls.messages.PostRenderMessage;
import calls.settings.GetAllCustomEmoji;
import calls.settings.GetLinkifiers;
import calls.users.GetAllUserGroups;
import calls.users.GetUserPresence;

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
		
		
		System.out.println(z.executeCall(new GetAllCustomEmoji()));
	}
	
}
