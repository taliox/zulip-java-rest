package io.taliox.zulip.enums;

public enum MessageTypes {
	
	STREAM("stream"),
	PRIVATE("private");
	
	private String typeName;
	
	MessageTypes(final String type) {
		this.typeName = type;
	}
	
    @Override
    public String toString() {
        return typeName;
    }

}
