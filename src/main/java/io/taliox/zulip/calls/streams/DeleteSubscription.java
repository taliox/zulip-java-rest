package io.taliox.zulip.calls.streams;

import org.apache.http.client.methods.HttpDelete;

import io.taliox.zulip.calls.ZulipRestAPICall;

// TODO: Auto-generated Javadoc
/**
 * The Class DeleteSubscription.
 */
public class DeleteSubscription extends ZulipRestAPICall {

	/** The subscriptions. */
	private String subscriptions;
	
	/** The principals. */
	private String principals;

	/**
	 * Instantiates a new delete subscription.
	 *
	 * @param subscriptions the subscriptions
	 */
	public DeleteSubscription(String subscriptions) {
		setZulipAPIUrl("/api/v1/users/me/subcriptions");
		this.subscriptions = subscriptions;
	}

	/* (non-Javadoc)
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute() {
		HttpDelete delete = new HttpDelete(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("subscriptions", subscriptions);
		if (principals != null) {
			getParameters().put("principals", principals);
		}
		return performRequest(getParameters(), delete);
	}

	/**
	 * Gets the subscriptions.
	 *
	 * @return the subscriptions
	 */
	public String getSubscriptions() {
		return subscriptions;
	}

	/**
	 * Sets the subscriptions.
	 *
	 * @param subscriptions the new subscriptions
	 */
	public void setSubscriptions(String subscriptions) {
		this.subscriptions = subscriptions;
	}

	/**
	 * Gets the principals.
	 *
	 * @return the principals
	 */
	public String getPrincipals() {
		return principals;
	}

	/**
	 * Sets the principals.
	 *
	 * @param principals the new principals
	 */
	public void setPrincipals(String principals) {
		this.principals = principals;
	}
	
}