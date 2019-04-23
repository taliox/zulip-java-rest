package io.taliox.zulip.controller;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpController {

	private String userName;
	private String password;
	private String server;

	private CredentialsProvider provider;
	private UsernamePasswordCredentials credentials;
	private HttpClient client;

	public HttpController(String userName, String password, String serverURL) {
		this.userName = userName;
		this.password = password;
		this.server = serverURL;

		provider = new BasicCredentialsProvider();
		credentials = new UsernamePasswordCredentials(this.userName, this.password);
		provider.setCredentials(AuthScope.ANY, credentials);
		client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getServer() {
		return server;
	}

	public HttpClient getClient() {
		return client;
	}

}
