package io.taliox.zulip.calls.streams;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.calls.ZulipRestAPICall;

/**
 * <p>
 * Subscribe one or more users to one or more streams.
 * 
 * If any of the specified streams do not exist, they are automatically created,
 * and configured using the invite_only setting specified in the arguments.
 * 
 * @see <a href=
 *      https://zulipchat.com/api/add-subscriptions">https://zulipchat.com/api/add-subscriptions</a>
 */
public class PostSubscription extends ZulipRestAPICall {

	/**
	 * A list of dictionaries, where each dictionary contains key/value pairs
	 * specifying a particular stream to subscribe to. You can specify an initial
	 * description here when creating a new stream. Note: This argument is called
	 * streams and not subscriptions in our Python API.
	 */
	private String subscriptions;

	/**
	 * A boolean specifying whether the streams specified in subscriptions are
	 * invite-only or not. Defaults to false.
	 */
	private boolean invite_only;

	/**
	 * If announce is True and one of the streams specified in subscriptions has to
	 * be created (i.e. doesn't exist to begin with), an announcement will be made
	 * notifying that a new stream was created.
	 */
	private boolean announce;

	/**
	 * A list of email addresses of the users that will be subscribed to the streams
	 * specified in the subscriptions argument. If not provided, then the requesting
	 * user/bot is subscribed. Defaults to [].
	 */
	private String principals = "[]";

	/**
	 * A boolean specifying whether authorization errors (such as when the
	 * requesting user is not authorized to access a private stream) should be
	 * considered fatal or not. When True, an authorization error is reported as
	 * such. When set to False, the returned JSON payload indicates that there was
	 * an authorization error, but the response is still considered a successful
	 * one. Defaults to true.
	 */
	private boolean authorization_errors_fatal = true;

	/**
	 * Instantiates a new post subscription.
	 *
	 * @param subscriptions
	 *            	 A list of dictionaries, where each dictionary contains key/value pairs
	 * 				 specifying a particular stream to subscribe to. You can specify an initial
	 * 				 description here when creating a new stream. Note: This argument is called
	 * 				 streams and not subscriptions in our Python API.
	 */
	public PostSubscription(String subscriptions) {
		setZulipAPIUrl("/api/v1/users/me/subscriptions");
		this.subscriptions = subscriptions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute() {
		HttpPost post = new HttpPost(this.httpController.getServer() + getZulipAPIUrl());

		getParameters().put("subscriptions", subscriptions);
		getParameters().put("invite_only", Boolean.toString(invite_only));
		getParameters().put("announce", Boolean.toString(announce));
		getParameters().put("principals", principals);
		getParameters().put("authorization_errors_fatal", Boolean.toString(authorization_errors_fatal));

		return performRequest(getParameters(), post);
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
	 * Checks if is invite only.
	 *
	 * @return true, if is invite only
	 */
	public boolean isInvite_only() {
		return invite_only;
	}

	/**
	 * Sets the invite only.
	 *
	 * @param invite_only
	 *            the new invite only
	 */
	public void setInvite_only(boolean invite_only) {
		this.invite_only = invite_only;
	}

	/**
	 * Checks if is announce.
	 *
	 * @return true, if is announce
	 */
	public boolean isAnnounce() {
		return announce;
	}

	/**
	 * Sets the announce.
	 *
	 * @param announce
	 *            the new announce
	 */
	public void setAnnounce(boolean announce) {
		this.announce = announce;
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

	/**
	 * Checks if is authorization errors fatal.
	 *
	 * @return true, if is authorization errors fatal
	 */
	public boolean isAuthorization_errors_fatal() {
		return authorization_errors_fatal;
	}

	/**
	 * Sets the authorization errors fatal.
	 *
	 * @param authorization_errors_fatal
	 *            the new authorization errors fatal
	 */
	public void setAuthorization_errors_fatal(boolean authorization_errors_fatal) {
		this.authorization_errors_fatal = authorization_errors_fatal;
	}

}
