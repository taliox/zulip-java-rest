package io.taliox.zulip.calls.messages;

import java.io.File;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.calls.ZulipRestAPICall;

public class PostUploadFile extends ZulipRestAPICall {

	private String filePath;
	private File file;

	public PostUploadFile(String filePath) {
		setZulipAPIUrl("/api/v1/user_uploads");
		this.filePath = filePath;
	}

	public PostUploadFile(File file) {
		setZulipAPIUrl("/api/v1/user_uploads");
		this.file = file;
	}

	public String execute() {
		HttpPost post = new HttpPost(this.httpController.getServer() + getZulipAPIUrl());		
		if(file == null) {
			return performUploadRequest(filePath, post);
		}
		else {
			return performUploadRequest(file, post);
		}
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
}
