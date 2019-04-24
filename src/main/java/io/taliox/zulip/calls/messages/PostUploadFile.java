package io.taliox.zulip.calls.messages;

import java.io.File;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.calls.ZulipRestAPICall;

// TODO: Auto-generated Javadoc
/**
 * The Class PostUploadFile.
 */
public class PostUploadFile extends ZulipRestAPICall {

	/** The file path. */
	private String filePath;
	
	/** The file. */
	private File file;

	/**
	 * Instantiates a new post upload file.
	 *
	 * @param filePath the file path
	 */
	public PostUploadFile(String filePath) {
		setZulipAPIUrl("/api/v1/user_uploads");
		this.filePath = filePath;
	}

	/**
	 * Instantiates a new post upload file.
	 *
	 * @param file the file
	 */
	public PostUploadFile(File file) {
		setZulipAPIUrl("/api/v1/user_uploads");
		this.file = file;
	}

	/* (non-Javadoc)
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute() {
		HttpPost post = new HttpPost(this.httpController.getServer() + getZulipAPIUrl());		
		if(file == null) {
			return performUploadRequest(filePath, post);
		}
		else {
			return performUploadRequest(file, post);
		}
	}

	/**
	 * Gets the file path.
	 *
	 * @return the file path
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * Sets the file path.
	 *
	 * @param filePath the new file path
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * Gets the file.
	 *
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * Sets the file.
	 *
	 * @param file the new file
	 */
	public void setFile(File file) {
		this.file = file;
	}
	
}
