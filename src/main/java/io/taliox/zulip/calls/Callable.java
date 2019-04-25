package io.taliox.zulip.calls;

import io.taliox.zulip.ZulipRestExecutor;

/**
 * The Interface Callable which has to be implemented by all HTTP call objects.
 * These calls can be performed by the ZulipRestExecutor.
 */
public abstract interface Callable {

	/**
	 * Executes the call.
	 * 
	 * @param executor
	 *            The instance which is responsible for executing the call.
	 *
	 * @return The response of the Zulip server.
	 */
	public String execute(ZulipRestExecutor executor);

}
