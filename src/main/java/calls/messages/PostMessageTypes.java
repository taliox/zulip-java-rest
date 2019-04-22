package calls.messages;

public enum PostMessageTypes {
	
	STREAM("stream"),
	PRIVATE("private");
	
	private String typeName;
	
	PostMessageTypes(final String type) {
		this.typeName = type;
	}
	
    @Override
    public String toString() {
        return typeName;
    }

}
