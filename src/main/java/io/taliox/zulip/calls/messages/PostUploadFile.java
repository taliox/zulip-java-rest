package io.taliox.zulip.calls.messages;

import java.io.File;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.ZulipRestExecutor;
import io.taliox.zulip.calls.ZulipRestAPICall;

/**
 * <p>
 * Upload a single file and get the corresponding URI.
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/upload-file">https://zulipchat.com/api/upload-file</a>
 *
 */
public class PostUploadFile extends ZulipRestAPICall {

	/** The file path to be uploaded. */
	private String filePath;

	/** The file to be uploaded. */
	private File file;

	/**
	 * Instantiates a new post upload file.
	 *
	 * @param filePath
	 *            The file to be uploaded.
	 */
	public PostUploadFile(String filePath) {
		setZulipAPIUrl("/api/v1/user_uploads");
		this.filePath = filePath;
	}

	/**
	 * Instantiates a new post upload file.
	 *
	 * @param file
	 *            The file path to be uploaded.
	 */
	public PostUploadFile(File file) {
		setZulipAPIUrl("/api/v1/user_uploads");
		this.file = file;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute(ZulipRestExecutor executor) {
		setHttpController(executor.httpController);
		HttpPost post = new HttpPost(this.httpController.getServer() + getZulipAPIUrl());
		if (file == null) {
			return performUploadRequest(filePath, post);
		} else {
			return performUploadRequest(file, post);
		}
	}

	/**
	 * Gets the file path which should be uploaded.
	 *
	 * @return the file path
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * Sets the file path which should be uploaded.
	 *
	 * @param filePath
	 *            the new file path
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * Gets the file which should be uploaded.
	 *
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * Sets the file which should be uploaded.
	 *
	 * @param file
	 *            the new file
	 */
	public void setFile(File file) {
		this.file = file;
	}

}
