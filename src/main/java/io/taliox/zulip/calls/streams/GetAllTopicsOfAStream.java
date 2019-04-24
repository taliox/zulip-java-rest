package io.taliox.zulip.calls.streams;

import org.apache.http.client.methods.HttpGet;

import io.taliox.zulip.calls.ZulipRestAPICall;

// TODO: Auto-generated Javadoc
/**
 * The Class GetAllTopicsOfAStream.
 */
public class GetAllTopicsOfAStream extends ZulipRestAPICall {
	
	/** The stream id. */
	private String stream_id;
	
	/**
	 * Instantiates a new gets the all topics of A stream.
	 *
	 * @param stream_id the stream id
	 */
	public GetAllTopicsOfAStream(String stream_id) {
		super();
		this.stream_id = stream_id;
		setZulipAPIUrl("/api/v1/users/me/"+stream_id+"/topics");		
	}

	/* (non-Javadoc)
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute() {
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
	 * @param stream_id the new stream id
	 */
	public void setStream_id(String stream_id) {
		this.stream_id = stream_id;
	}

	
}

