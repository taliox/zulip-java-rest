package io.taliox.zulip.exceptions;

/**
 * The Class InvalidArgumentException.
 */
public class InvalidArgumentException extends Exception {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The message. */
	private static String message;

	/**
	 * Instantiates a new invalid argument exception.
	 *
	 * @param message the message
	 */
	public InvalidArgumentException(String message) {
		InvalidArgumentException.message = message;
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	public String toString() {
		return message;
	}

}
