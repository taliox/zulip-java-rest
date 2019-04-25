package io.taliox.zulip.calls.streams;

/**
 * <p>
 * You can create a stream using Zulip's REST API by submitting a subscribe
 * request with a stream name that doesn't yet exist. You can specify the
 * initial configuration of the stream using the invite_only and announce
 * arguments to that request.
 * 
 * @see io.taliox.zulip.calls.streams.PostCreateStream
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/create-stream">https://zulipchat.com/api/create-stream</a>
 */
public class PostCreateStream extends PostSubscription {

	/**
	 * Instantiates a new post create stream.
	 *
	 * @param subscriptions
	 *            A list of dictionaries, where each dictionary contains key/value
	 *            pairs specifying a particular stream to subscribe to. You can
	 *            specify an initial description here when creating a new stream.
	 *            Note: This argument is called streams and not subscriptions in our
	 *            Python API.
	 */
	public PostCreateStream(String subscriptions) {
		super(subscriptions);
	}

}
