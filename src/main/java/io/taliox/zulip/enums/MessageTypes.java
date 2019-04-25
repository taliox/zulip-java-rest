package io.taliox.zulip.enums;

// TODO: Auto-generated Javadoc
/**
 * The Enum MessageTypes.
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
