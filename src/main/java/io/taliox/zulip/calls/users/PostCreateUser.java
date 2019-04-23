package io.taliox.zulip.calls.users;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.calls.ZulipRestAPICall;

public class PostCreateUser extends ZulipRestAPICall {

	private String email;
	private String password;
	private String full_name;
	private String short_name;

	public PostCreateUser(String email, String password, String full_name, String short_name) {
		setZulipAPIUrl("/api/v1/users");
		this.email = email;
		this.password = password;
		this.full_name = full_name;
		this.short_name = short_name;
	}

	public String execute() {
		HttpPost post = new HttpPost(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("email", this.email);
		getParameters().put("password", this.password);
		getParameters().put("full_name", this.full_name);
		getParameters().put("short_name", this.short_name);
		return performRequest(getParameters(), post);
	}
}
