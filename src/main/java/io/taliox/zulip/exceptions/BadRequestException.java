package io.taliox.zulip.exceptions;

/**
 * Thrown when the server responds with a bad request. Which means the server
 * could not handle your request properly. For instance because you do not have
 * needed privileges.
 */
public class BadRequestException extends Exception {

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
	public BadRequestException(String message) {
		BadRequestException.message = message;
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
