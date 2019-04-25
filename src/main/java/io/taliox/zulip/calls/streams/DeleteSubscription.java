package io.taliox.zulip.calls.streams;

import org.apache.http.client.methods.HttpDelete;

import io.taliox.zulip.ZulipRestExecutor;
import io.taliox.zulip.calls.ZulipRestAPICall;

/**
 * <p>
 * Unsubscribe yourself or other users from one or more streams.
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/remove-subscriptions">https://zulipchat.com/api/remove-subscriptions</a>
 */
public class DeleteSubscription extends ZulipRestAPICall {

	/**
	 * A list of stream names to unsubscribe from.
	 */
	private String subscriptions;

	/**
	 * A list of email addresses of the users that will be unsubscribed from the
	 * streams specified in the subscriptions argument. If not provided, then the
	 * requesting user/bot is unsubscribed.
	 */
	private String principals;

	/**
	 * Instantiates a new delete subscription.
	 *
	 * @param subscriptions
	 *             A list of stream names to unsubscribe from.
	 */
	public DeleteSubscription(String subscriptions) {
		setZulipAPIUrl("/api/v1/users/me/subcriptions");
		this.subscriptions = subscriptions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute(ZulipRestExecutor executor) {
		setHttpController(executor.httpController);
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
	 * @param subscriptions
	 *            the new subscriptions
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
	 * @param principals
	 *            the new principals
	 */
	public void setPrincipals(String principals) {
		this.principals = principals;
	}

}