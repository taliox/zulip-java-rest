package io.taliox.zulip.calls.streams;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.calls.ZulipRestAPICall;

// TODO: Auto-generated Javadoc
/**
 * The Class PostSubscription.
 */
public class PostSubscription extends ZulipRestAPICall {

	/** The subscriptions. */
	private String subscriptions;
	
	/** The invite only. */
	private boolean invite_only;
	
	/** The announce. */
	private boolean announce;
	
	/** The principals. */
	private String principals = "[]";
	
	/** The authorization errors fatal. */
	private boolean authorization_errors_fatal = true;

	/**
	 * Instantiates a new post subscription.
	 *
	 * @param subscriptions the subscriptions
	 */
	public PostSubscription(String subscriptions) {
		setZulipAPIUrl("/api/v1/users/me/subscriptions");
		this.subscriptions = subscriptions;
	}

	/* (non-Javadoc)
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute() {
		HttpPost post = new HttpPost(this.httpController.getServer() + getZulipAPIUrl());

		getParameters().put("subscriptions", subscriptions);
		getParameters().put("invite_only", Boolean.toString(invite_only));
		getParameters().put("announce",  Boolean.toString(announce));
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
	 * @param subscriptions the new subscriptions
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
	 * @param invite_only the new invite only
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
	 * @param announce the new announce
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
	 * @param principals the new principals
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
	 * @param authorization_errors_fatal the new authorization errors fatal
	 */
	public void setAuthorization_errors_fatal(boolean authorization_errors_fatal) {
		this.authorization_errors_fatal = authorization_errors_fatal;
	}
	
}
