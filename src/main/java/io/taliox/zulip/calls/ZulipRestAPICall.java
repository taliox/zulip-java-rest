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
import io.taliox.zulip.exceptions.InvalidArgumentException;
import io.taliox.zulip.exceptions.NotAuthroizedException;

public abstract class ZulipRestAPICall implements Callable {

	/** The http controller. */
	public HttpController httpController;
	
	/** The zulip API url. */
	private String zulipAPIUrl;
	
	/** The builder. */
	private StringBuilder builder;
	
	/** The parameters. */
	private HashMap<String, String> parameters;

	/**
	 * The abstract constructor for a ZulipRestAPICall.
	 */
	public ZulipRestAPICall() {
		builder = new StringBuilder();
		parameters = new HashMap<String, String>();
	}

	/**
	 * Perform upload request.
	 *
	 * @param file the file
	 * @param post the post
	 * @return the string
	 */
	public String performUploadRequest(File file, HttpPost post) {
		return handleHttpUpload(file, post);
	}

	/**
	 * Perform upload request.
	 *
	 * @param filePath the file path
	 * @param post the post
	 * @return the string
	 */
	public String performUploadRequest(String filePath, HttpPost post) {
		File toUpload = new File(filePath);
		return handleHttpUpload(toUpload, post);
	}

	/**
	 * Perform request.
	 *
	 * @param parameters the parameters
	 * @param base the base
	 * @return the string
	 */
	public String performRequest(HashMap<String, String> parameters, HttpRequestBase base) {
		URI uri = null;

		try {
			URIBuilder uriBuilder = new URIBuilder(base.getURI());

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

			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_UNAUTHORIZED) {
				throw new NotAuthroizedException(
						"Unauthroized request. Please check server settings and your provided credentials :"
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
		} catch (NotAuthroizedException e) {
			e.printStackTrace();
		}

		return builder.toString();
	}

	/**
	 * Handle http upload.
	 *
	 * @param file the file to upload.
	 * @param post the post object
	 * @return the string
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
				throw new NotAuthroizedException(
						"Unauthroized request. Please check server settings and your provided credentials :"
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
		} catch (NotAuthroizedException e) {
			e.printStackTrace();
		}

		return builder.toString();
	}

	/**
	 * Gets the http controller.
	 *
	 * @return the http controller
	 */
	public HttpController getHttpController() {
		return httpController;
	}

	/**
	 * Sets the http controller.
	 *
	 * @param httpController the new http controller
	 */
	public void setHttpController(HttpController httpController) {
		this.httpController = httpController;
	}

	/**
	 * Gets the zulip API url.
	 *
	 * @return the zulip API url
	 */
	public String getZulipAPIUrl() {
		return zulipAPIUrl;
	}

	/**
	 * Sets the zulip API url.
	 *
	 * @param zulipAPIUrl the new zulip API url
	 */
	public void setZulipAPIUrl(String zulipAPIUrl) {
		this.zulipAPIUrl = zulipAPIUrl;
	}

	/**
	 * Gets the parameters.
	 *
	 * @return the parameters
	 */
	public HashMap<String, String> getParameters() {
		return parameters;
	}

	/**
	 * Sets the parameters.
	 *
	 * @param parameters the parameters
	 */
	public void setParameters(HashMap<String, String> parameters) {
		this.parameters = parameters;
	}

}
