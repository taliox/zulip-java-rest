package io.taliox.zulip.calls.settings;

import java.io.File;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.calls.ZulipRestAPICall;
import io.taliox.zulip.exceptions.InvalidArgumentException;
import io.taliox.zulip.utils.ImageChecker;

public class PostCustomEmoji extends ZulipRestAPICall {

	private String filePath;
	private File file;

	public PostCustomEmoji(String filePath, String emojiName) {
		setZulipAPIUrl("/api/v1/realm/emoji/" + emojiName);

		boolean check = ImageChecker.checkIfFileIsAnImage(filePath);
		if (check) {
			this.filePath = filePath;
		} else {
			try {
				throw new InvalidArgumentException("Invalid file type. You need to upload an image as emoji.");
			} catch (InvalidArgumentException e) {
				e.printStackTrace();
			}
		}
	}

	public PostCustomEmoji(File file, String emojiName) {
		setZulipAPIUrl("/api/v1/realm/emoji/" + emojiName);

		boolean check = ImageChecker.checkIfFileIsAnImage(file);
		if (check) {
			this.file = file;
		} else {
			try {
				throw new InvalidArgumentException("Invalid file type. You need to upload an image as emoji.");
			} catch (InvalidArgumentException e) {
				e.printStackTrace();
			}
		}
	}

	public String execute() {
		HttpPost post = new HttpPost(this.httpController.getServer() + getZulipAPIUrl());
		if (file == null) {
			return performUploadRequest(filePath, post);
		} else {
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
