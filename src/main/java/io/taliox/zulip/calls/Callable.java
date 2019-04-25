package io.taliox.zulip.calls;

/**
 * The Interface Callable which has to be implemented by all HTTP call objects.
 * These calls can be performed by the ZulipRestExecutor.
 */
public abstract interface Callable {
	
	/**
	 * Executes the call.
	 *
	 * @return The response of the Zulip server.
	 */
	public String execute();

}
