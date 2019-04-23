package io.taliox.zulip.exceptions;

public class NotAuthroizedException extends Exception {

	private static final long serialVersionUID = 1L;
	private static String message;

	public NotAuthroizedException(String message) {
		NotAuthroizedException.message = message;
	}

	public String toString() {
		return message;
	}

}
