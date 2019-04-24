package io.taliox.zulip.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class NotAuthroizedException.
 */
public class NotAuthroizedException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The message. */
	private static String message;

	/**
	 * Instantiates a new not authroized exception.
	 *
	 * @param message the message
	 */
	public NotAuthroizedException(String message) {
		NotAuthroizedException.message = message;
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	public String toString() {
		return message;
	}

}
