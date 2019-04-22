package calls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;

import controller.HttpController;

public abstract class ZulipRestAPICall implements Callable {

	public HttpController httpController;
	private String zulipAPIUrl;
	private StringBuilder builder;
	private HashMap<String, String> parameters;

	public ZulipRestAPICall() {
		builder = new StringBuilder();
		parameters = new HashMap<String, String>();
	}

	public String performRequest(HashMap<String, String> parameters, HttpRequestBase base) {
		URI uri = null;

		try {
			URIBuilder uriBuilder = new URIBuilder(base.getURI());

			for (Entry<String, String> e : parameters.entrySet()) {
				uriBuilder.addParameter(e.getKey(), e.getValue());
			}

			uri = uriBuilder.build();

		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}

		base.setURI(uri);

		try {
			HttpResponse response = this.httpController.getClient().execute(base);

			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

			String output;
			while ((output = br.readLine()) != null) {
				builder.append(output);
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return builder.toString();
	}

	public HttpController getHttpController() {
		return httpController;
	}

	public void setHttpController(HttpController httpController) {
		this.httpController = httpController;
	}

	public String getZulipAPIUrl() {
		return zulipAPIUrl;
	}

	public void setZulipAPIUrl(String zulipAPIUrl) {
		this.zulipAPIUrl = zulipAPIUrl;
	}

	public HashMap<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(HashMap<String, String> parameters) {
		this.parameters = parameters;
	}

}
