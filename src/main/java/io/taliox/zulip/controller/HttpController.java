package io.taliox.zulip.controller;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * The Class HttpController which is responsible for sending HTTP requests.
 */
public class HttpController {

	/** The name of the name which sends requests. */
	private String userName;

	/** The password of the user which sends requests. */
	private String password;

	/** The Zulip server URL which receives requests. */
	private String server;

	/** HTTP CredentialsProvider. */
	private CredentialsProvider provider;

	/** HTTP UsernamePasswordCredentlials */
	private UsernamePasswordCredentials credentials;

	/** The Apache HttpClient. */
	private HttpClient client;

	/**
	 * Instantiates a new http controller.
	 *
	 * @param userName
	 *            The name of the name which sends requests.
	 * @param password
	 *            The password of the user which sends requests.
	 * @param serverURL
	 *            The Zulip server URL which receives requests.
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
