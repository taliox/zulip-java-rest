package calls.messages;

import org.apache.http.client.methods.HttpGet;

import calls.ZulipRestAPICall;

public class GetMessages extends ZulipRestAPICall {
	
	private int anchor = -1;
	private boolean use_first_unread_anchor = false;
	private int num_before = 0;
	private int num_after = 0;
	private String narrow = "[]";
	private boolean client_gravatar = false;
	private boolean apply_markdown = false;
	
	public GetMessages(int num_before, int num_after) {
		setZulipAPIUrl("/api/v1/messages");		
		this.use_first_unread_anchor = true;
		this.num_before = num_before;
		this.num_after = num_after;
	}

	public GetMessages(int num_before, int num_after, int anchor) {
		setZulipAPIUrl("/api/v1/messages");	
		this.anchor = anchor;
		this.num_before = num_before;
		this.num_after = num_after;
	}

	public String execute() {
		HttpGet get = new HttpGet(this.httpController.getServer() + getZulipAPIUrl());
		getParameters().put("anchor", Integer.toString(anchor));
		getParameters().put("use_first_unread_anchor", Boolean.toString(use_first_unread_anchor));
		getParameters().put("num_before", Integer.toString(num_before));
		getParameters().put("num_after", Integer.toString(num_after));
		getParameters().put("narrow", narrow);
		getParameters().put("client_gravatar", Boolean.toString(client_gravatar));
		getParameters().put("apply_markdown", Boolean.toString(apply_markdown));
		
		return performRequest(getParameters(), get);
	}

	public int getAnchor() {
		return anchor;
	}

	public void setAnchor(int anchor) {
		this.anchor = anchor;
	}

	public boolean isUse_first_unread_anchor() {
		return use_first_unread_anchor;
	}

	public void setUse_first_unread_anchor(boolean use_first_unread_anchor) {
		this.use_first_unread_anchor = use_first_unread_anchor;
	}

	public int getNum_before() {
		return num_before;
	}

	public void setNum_before(int num_before) {
		this.num_before = num_before;
	}

	public int getNum_after() {
		return num_after;
	}

	public void setNum_after(int num_after) {
		this.num_after = num_after;
	}

	public String getNarrow() {
		return narrow;
	}

	public void setNarrow(String narrow) {
		this.narrow = narrow;
	}

	public boolean isClient_gravatar() {
		return client_gravatar;
	}

	public void setClient_gravatar(boolean client_gravatar) {
		this.client_gravatar = client_gravatar;
	}

	public boolean isApply_markdown() {
		return apply_markdown;
	}

	public void setApply_markdown(boolean apply_markdown) {
		this.apply_markdown = apply_markdown;
	}
	
	

}
