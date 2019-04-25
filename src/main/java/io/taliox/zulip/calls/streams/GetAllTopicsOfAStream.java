package io.taliox.zulip.calls.streams;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.ZulipRestExecutor;
import io.taliox.zulip.calls.ZulipRestAPICall;

/**
 * <p>
 * Get all the topics in a specific stream.
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/get-stream-topics">https://zulipchat.com/api/get-stream-topics</a>
 */
public class GetAllTopicsOfAStream extends ZulipRestAPICall {

	/** The unique ID of the stream. */
	private String stream_id;

	/**
	 * Instantiates a new gets the all topics of A stream.
	 *
	 * @param stream_id
	 *            The unique ID of the stream.
	 */
	public GetAllTopicsOfAStream(String stream_id) {
		super();
		this.stream_id = stream_id;
		setZulipAPIUrl("/api/v1/users/me/" + stream_id + "/topics");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute(ZulipRestExecutor executor) {
		setHttpController(executor.httpController);
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("stream_id", stream_id);
		return performRequest(getParameters(), get);
	}

	/**
	 * Gets the stream id.
	 *
	 * @return the stream id
	 */
	public String getStream_id() {
		return stream_id;
	}

	/**
	 * Sets the stream id.
	 *
	 * @param stream_id
	 *            the new stream id
	 */
	public void setStream_id(String stream_id) {
		this.stream_id = stream_id;
	}

}
