package io.taliox.zulip.exceptions;

/**
 * Thrown when an argument for a HTTP call is invalid. For instance when it is
 * null.
 */
public class InvalidArgumentException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The message which is displayed when raising this exception. */
	private static String message;

	/**
	 * Instantiates a new invalid argument exception.
	 *
	 * @param message
	 *            the message
	 */
	public InvalidArgumentException(String message) {
		InvalidArgumentException.message = message;
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
