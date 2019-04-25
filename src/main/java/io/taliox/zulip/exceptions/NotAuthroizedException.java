package io.taliox.zulip.exceptions;

/**
 * Thrown when the user credentials you provided are not valid for the Zulip
 * server.
 */
public class NotAuthroizedException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The message which is displayed when raising this exception. */
	private static String message;

	/**
	 * Instantiates a new not authroized exception.
	 *
	 * @param message
	 *            the message
	 */
	public NotAuthroizedException(String message) {
		NotAuthroizedException.message = message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#toString()
	 */
	public String toString() {
		return message;
	}

}
