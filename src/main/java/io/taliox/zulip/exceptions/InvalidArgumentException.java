package io.taliox.zulip.exceptions;

public class InvalidArgumentException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private static String message;

	public InvalidArgumentException(String message) {
		InvalidArgumentException.message = message;
	}

	public String toString() {
		return message;
	}

}
