package io.taliox.zulip.controller;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class HttpController.
 */
public class HttpController {

	/** The user name. */
	private String userName;
	
	/** The password. */
	private String password;
	
	/** The server. */
	private String server;

	/** The provider. */
	private CredentialsProvider provider;
	
	/** The credentials. */
	private UsernamePasswordCredentials credentials;
	
	/** The client. */
	private HttpClient client;

	/**
	 * Instantiates a new http controller.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @param serverURL the server URL
	 */
	public HttpController(String userName, String password, String serverURL) {
		this.userName = userName;
		this.password = password;
		this.server = serverURL;

		provider = new BasicCredentialsProvider();
		credentials = new UsernamePasswordCredentials(this.userName, this.password);
		provider.setCredentials(AuthScope.ANY, credentials);
		client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
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
	 * Gets the server.
	 *
	 * @return the server
	 */
	public String getServer() {
		return server;
	}

	/**
	 * Gets the client.
	 *
	 * @return the client
	 */
	public HttpClient getClient() {
		return client;
	}

}
