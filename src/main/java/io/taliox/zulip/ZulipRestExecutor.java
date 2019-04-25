package io.taliox.zulip;

import io.taliox.zulip.calls.ZulipRestAPICall;
import io.taliox.zulip.calls.messages.PostMessage;
import io.taliox.zulip.calls.settings.GetAllCustomEmoji;
import io.taliox.zulip.calls.users.GetProfile;
import io.taliox.zulip.controller.HttpController;

/**
 * The Class ZulipRestExecutor which is responsible for executing requests and
 * providing credentials for authentication with the Zulip server.
 */
public class ZulipRestExecutor {

	/** The local http controller of the ZulipRestExecutor. */
	public HttpController httpController;

	/**
	 * The constructor for the Zulip REST API executor. Is responsible for
	 * communicating with your Zulip server.
	 * 
	 * @param userName
	 *            Name of the user who is performing the call.
	 * @param password
	 *            Password of the user who is performing the call.
	 * @param serverURL
	 *            URL to the server which receives the call.
	 */
	public ZulipRestExecutor(String userName, String password, String serverURL) {
		this.httpController = new HttpController(userName, password, serverURL);
	}

	/**
	 * Executes a HTTP call to a Zulip server.
	 * 
	 * @param call
	 *            The call to the Zulip REST API to be executed.
	 * 
	 */
	public String executeCall(ZulipRestAPICall call) {
		return call.execute(this);
	}

	public static void main(String[] args) {
		ZulipRestExecutor z = new ZulipRestExecutor("Cookie-bot@zulip.taliox.io", "huAL10ED8dOz1CfqIHxVDVyCo2Ursjiw",
				"https://zulip.taliox.io/");

		
		PostMessage p = new PostMessage("marcel@taliox.io", "Na du");
	
		
		System.out.println(z.executeCall(p));	
	}

	
}
