package io.taliox.zulip.enums;

/**
 * The Enum MessageTypes.
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/send-message">https://zulipchat.com/api/send-message</a>
 */
public enum MessageTypes {

	/** The stream. */
	STREAM("stream"),

	/** The private. */
	PRIVATE("private");

	/** The type name. */
	private String typeName;

	/**
	 * Instantiates a new message types.
	 *
	 * @param type
	 *            the type
	 */
	MessageTypes(final String type) {
		this.typeName = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return typeName;
	}

}
