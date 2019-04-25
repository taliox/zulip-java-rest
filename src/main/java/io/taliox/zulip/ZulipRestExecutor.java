package io.taliox.zulip;

import io.taliox.zulip.calls.ZulipRestAPICall;
import io.taliox.zulip.calls.streams.PostCreateStream;
import io.taliox.zulip.controller.HttpController;

public class ZulipRestExecutor {

	private HttpController httpController;
	
	/**
	 * The constructor for the Zulip REST API executor. Is responsible for communicating with your Zulip server. 
	 * 
	 * @param userName Name of the user who is performing the call.
	 * @param password Password of the user who is performing the call.
	 * @param serverURL URL to the server which receives the call.
	 */
	public ZulipRestExecutor(String userName, String password, String serverURL) {
		this.httpController = new HttpController(userName, password, serverURL);
	}

	/**
	* Executes a HTTP call to a Zulip server.
	* 
	* @param call The call to the Zulip REST API to be executed.
	* 
	*/
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
