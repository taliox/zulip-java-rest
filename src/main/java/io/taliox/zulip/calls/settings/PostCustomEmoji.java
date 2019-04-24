package io.taliox.zulip.calls.settings;

import java.io.File;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.calls.ZulipRestAPICall;
import io.taliox.zulip.exceptions.InvalidArgumentException;
import io.taliox.zulip.utils.ImageChecker;

// TODO: Auto-generated Javadoc
/**
 * The Class PostCustomEmoji.
 */
public class PostCustomEmoji extends ZulipRestAPICall {

	/** The file path. */
	private String filePath;
	
	/** The file. */
	private File file;

	/**
	 * Instantiates a new post custom emoji.
	 *
	 * @param filePath the file path
	 * @param emojiName the emoji name
	 */
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

	/**
	 * Instantiates a new post custom emoji.
	 *
	 * @param file the file
	 * @param emojiName the emoji name
	 */
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

	/* (non-Javadoc)
	 * @see io.taliox.zulip.calls.Callable#execute()
	 */
	public String execute() {
		HttpPost post = new HttpPost(this.httpController.getServer() + getZulipAPIUrl());
		if (file == null) {
			return performUploadRequest(filePath, post);
		} else {
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
