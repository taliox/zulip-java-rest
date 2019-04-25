package io.taliox.zulip.calls.streams;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.ZulipRestExecutor;
import io.taliox.zulip.calls.ZulipRestAPICall;

/**
 * <p>
 * Get the unique ID of a given stream.
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/get-stream-id">https://zulipchat.com/api/get-stream-id</a>
 */
public class GetStreamID extends ZulipRestAPICall {

	/** The name of the stream to retrieve the ID for. */
	private String stream_name;

	/**
	 * Instantiates a new gets the stream ID.
	 *
	 * @param stream_name
	 *            the stream name
	 */
	public GetStreamID(String stream_name) {
		this.stream_name = stream_name;
		setZulipAPIUrl("/api/v1/get_stream_id");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute(ZulipRestExecutor executor) {
		setHttpController(executor.httpController);
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("stream", stream_name);
		return performRequest(getParameters(), get);

	}

	/**
	 * Gets the stream name.
	 *
	 * @return the stream name
	 */
	public String getStream_name() {
		return stream_name;
	}

	/**
	 * Sets the stream name.
	 *
	 * @param stream_name
	 *            the new stream name
	 */
	public void setStream_name(String stream_name) {
		this.stream_name = stream_name;
	}

}