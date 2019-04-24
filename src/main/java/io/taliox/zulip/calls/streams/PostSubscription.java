package io.taliox.zulip.calls.streams;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.calls.ZulipRestAPICall;

public class PostSubscription extends ZulipRestAPICall {

	private String subscriptions;
	private boolean invite_only;
	private boolean announce;
	private String principals = "[]";
	private boolean authorization_errors_fatal = true;

	public PostSubscription(String subscriptions) {
		setZulipAPIUrl("/api/v1/users/me/subscriptions");
		this.subscriptions = subscriptions;
	}

	public String execute() {
		HttpPost post = new HttpPost(this.httpController.getServer() + getZulipAPIUrl());

		getParameters().put("subscriptions", subscriptions);
		getParameters().put("invite_only", Boolean.toString(invite_only));
		getParameters().put("announce",  Boolean.toString(announce));
		getParameters().put("principals", principals);
		getParameters().put("authorization_errors_fatal", Boolean.toString(authorization_errors_fatal));

		return performRequest(getParameters(), post);
	}

	public String getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(String subscriptions) {
		this.subscriptions = subscriptions;
	}

	public boolean isInvite_only() {
		return invite_only;
	}

	public void setInvite_only(boolean invite_only) {
		this.invite_only = invite_only;
	}

	public boolean isAnnounce() {
		return announce;
	}

	public void setAnnounce(boolean announce) {
		this.announce = announce;
	}

	public String getPrincipals() {
		return principals;
	}

	public void setPrincipals(String principals) {
		this.principals = principals;
	}

	public boolean isAuthorization_errors_fatal() {
		return authorization_errors_fatal;
	}

	public void setAuthorization_errors_fatal(boolean authorization_errors_fatal) {
		this.authorization_errors_fatal = authorization_errors_fatal;
	}
	
	
}
