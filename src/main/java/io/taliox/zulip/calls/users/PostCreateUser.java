package io.taliox.zulip.calls.users;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.calls.ZulipRestAPICall;

// TODO: Auto-generated Javadoc
/**
 * The Class PostCreateUser.
 */
public class PostCreateUser extends ZulipRestAPICall {

	/** The email. */
	private String email;
	
	/** The password. */
	private String password;
	
	/** The full name. */
	private String full_name;
	
	/** The short name. */
	private String short_name;

	/**
	 * Instantiates a new post create user.
	 *
	 * @param email the email
	 * @param password the password
	 * @param full_name the full name
	 * @param short_name the short name
	 */
	public PostCreateUser(String email, String password, String full_name, String short_name) {
		setZulipAPIUrl("/api/v1/users");
		this.email = email;
		this.password = password;
		this.full_name = full_name;
		this.short_name = short_name;
	}

	/* (non-Javadoc)
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute() {
		HttpPost post = new HttpPost(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("email", this.email);
		getParameters().put("password", this.password);
		getParameters().put("full_name", this.full_name);
		getParameters().put("short_name", this.short_name);
		return performRequest(getParameters(), post);
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the full name.
	 *
	 * @return the full name
	 */
	public String getFull_name() {
		return full_name;
	}

	/**
	 * Sets the full name.
	 *
	 * @param full_name the new full name
	 */
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	/**
	 * Gets the short name.
	 *
	 * @return the short name
	 */
	public String getShort_name() {
		return short_name;
	}

	/**
	 * Sets the short name.
	 *
	 * @param short_name the new short name
	 */
	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}
		
}
