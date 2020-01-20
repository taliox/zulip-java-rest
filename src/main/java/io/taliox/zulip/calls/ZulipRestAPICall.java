package io.taliox.zulip.calls;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;

import io.taliox.zulip.controller.HttpController;
import io.taliox.zulip.exceptions.BadRequestException;
import io.taliox.zulip.exceptions.InvalidArgumentException;
import io.taliox.zulip.exceptions.NotAuthorizedException;

public abstract class ZulipRestAPICall implements Callable {

	/**
	 * The http controller which is responsible for communicating with the Zulip
	 * REST API of your server..
	 */
	protected HttpController httpController;

	/** The zulip API url of your server. */
	private String zulipAPIUrl;

	/** The builder StringBuilder which is used process data. */
	private StringBuilder builder;

	/** The parameters which are send to your Zulip REST API. */
	private HashMap<String, String> parameters;

	/**
	 * The abstract constructor for a ZulipRestAPICall.
	 */
	protected ZulipRestAPICall() {
		builder = new StringBuilder();
		parameters = new HashMap<String, String>();
	}

	/**
	 * Perform HTTP upload request.
	 *
	 * @param file
	 *            The file which is supposed to be upoaded.
	 * @param post
	 *            The HTTP post object which is used for the upload.
	 * @return The response String of the server after receiving and handling the
	 *         request.
	 */
	protected String performUploadRequest(File file, HttpPost post) {
		return handleHttpUpload(file, post);
	}

	/**
	 * Perform HTTP upload request.
	 *
	 * @param filePath
	 *            The path of the file to be uploaded.
	 * @param post
	 *            The HTTP post object which is used for the upload.
	 * @return The response String of the server after receiving and handling the
	 *         request.
	 */
	protected String performUploadRequest(String filePath, HttpPost post) {
		File toUpload = new File(filePath);
		return handleHttpUpload(toUpload, post);
	}

	/**
	 * Perform HTTP request.
	 *
	 * @param parameters
	 *            The parameters which are send to your Zulip REST API.
	 * @param base
	 *            The HTTP base object. Might be a HttpPost or a HttpGet for
	 *            instance.
	 * @return The response String of the server after receiving and handling the
	 *         request.
	 */
	protected String performRequest(HashMap<String, String> parameters, HttpRequestBase base) {
		URI uri = null;
		BufferedReader br = null;
		URIBuilder uriBuilder = null;

		try {
			uriBuilder = new URIBuilder(base.getURI());

			for (Entry<String, String> e : parameters.entrySet()) {

				if (e.getKey() == null || e.getValue() == null) {
					throw new InvalidArgumentException("Map parameters are now allowed to be null.");
				}

				uriBuilder.addParameter(e.getKey(), e.getValue());
			}

			uri = uriBuilder.build();

		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		} catch (InvalidArgumentException e1) {
			e1.printStackTrace();
		}

		base.setURI(uri);

		try {
			HttpResponse response = this.httpController.getClient().execute(base);
			br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			String output;

			while ((output = br.readLine()) != null) {
				builder.append(output);
			}

			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_UNAUTHORIZED) {
				throw new NotAuthorizedException(
						"Unauthorized request. Please check server settings and your provided credentials :"
								+ builder.toString());
			}

			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_BAD_REQUEST) {

				throw new BadRequestException(
						"Bad request. The server could not process your request sucessfully: " + builder.toString());
			}

		base.releaseConnection();	
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NotAuthorizedException e) {
			e.printStackTrace();
		} catch (BadRequestException e) {
			e.printStackTrace();
		}

		return builder.toString();
	}

	/**
	 * Handle HTTP upload.
	 *
	 * @param file
	 *            The file which is supposed to be upoaded.
	 * @param post
	 *            The HTTP post object which is used for the upload.
	 * @return The response String of the server after receiving and handling the
	 *         request.
	 */
	private String handleHttpUpload(File file, HttpPost post) {
		HttpClient client = getHttpController().getClient();
		MultipartEntityBuilder multipartBuilder = MultipartEntityBuilder.create();

		multipartBuilder.addPart("user_uploads", new FileBody(file));

		HttpEntity entity = multipartBuilder.build();
		post.setEntity(entity);

		try {
			HttpResponse response = client.execute(post);

			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_UNAUTHORIZED) {
				throw new NotAuthorizedException(
						"Unauthorized request. Please check server settings and your provided credentials :"
								+ response.getStatusLine());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

			String output;
			while ((output = br.readLine()) != null) {
				builder.append(output);
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NotAuthorizedException e) {
			e.printStackTrace();
		}

		return builder.toString();
	}

	/**
	 * Gets the http controller.
	 *
	 * @return the http controller
	 */
	protected HttpController getHttpController() {
		return httpController;
	}

	/**
	 * Sets the http controller.
	 *
	 * @param httpController
	 *            the new http controller
	 */
	protected void setHttpController(HttpController httpController) {
		this.httpController = httpController;
	}

	/**
	 * Gets the zulip API url.
	 *
	 * @return the zulip API url
	 */
	protected String getZulipAPIUrl() {
		return zulipAPIUrl;
	}

	/**
	 * Sets the zulip API url.
	 *
	 * @param zulipAPIUrl
	 *            the new zulip API url
	 */
	protected void setZulipAPIUrl(String zulipAPIUrl) {
		this.zulipAPIUrl = zulipAPIUrl;
	}

	/**
	 * Gets the parameters.
	 *
	 * @return the parameters
	 */
	protected HashMap<String, String> getParameters() {
		return parameters;
	}

	/**
	 * Sets the parameters.
	 *
	 * @param parameters
	 *            the parameters
	 */
	protected void setParameters(HashMap<String, String> parameters) {
		this.parameters = parameters;
	}

}