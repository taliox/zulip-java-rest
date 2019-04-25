package io.taliox.zulip.calls.settings;

import java.io.File;

import org.apache.http.client.methods.HttpPost;

import io.taliox.zulip.calls.ZulipRestAPICall;
import io.taliox.zulip.exceptions.InvalidArgumentException;
import io.taliox.zulip.utils.ImageChecker;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * This endpoint is used to upload a custom emoji for use in the user's
 * organization. Access to this endpoint depends on the organization's
 * configuration.
 * 
 * @see <a href=
 *      "https://zulipchat.com/help/only-allow-admins-to-add-emoji">https://zulipchat.com/help/only-allow-admins-to-add-emoji</a>
 * 
 * @see <a href=
 *      "https://zulipchat.com/api/upload-custom-emoji">https://zulipchat.com/api/upload-custom-emoji</a>
 */
public class PostCustomEmoji extends ZulipRestAPICall {

	/** The file path to be uploaded. */
	private String filePath;

	/** The file to be uploaded. */
	private File file;

	/**
	 * The name of the new emoji. The emoji name can only contain letters, numbers,
	 * dashes, and spaces. Upper and lower case letters are treated the same, and
	 * underscores (_) are treated the same as spaces (consistent with how the Zulip
	 * UI handles emoji).
	 */
	private String emojiName;

	/**
	 * Instantiates a new post custom emoji.
	 *
	 * @param filePath
	 *            The file path to be uploaded.
	 * @param emojiName
	 *            The name of the new emoji. The emoji name can only contain
	 *            letters, numbers, dashes, and spaces. Upper and lower case letters
	 *            are treated the same, and underscores (_) are treated the same as
	 *            spaces (consistent with how the Zulip UI handles emoji).
	 */
	public PostCustomEmoji(String filePath, String emojiName) {
		setZulipAPIUrl("/api/v1/realm/emoji/" + emojiName);
		this.emojiName = emojiName;

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
	 * @param file
	 *            The file to be uploaded.
	 * @param emojiName
	 *			  The name of the new emoji. The emoji name can only contain
	 *            letters, numbers, dashes, and spaces. Upper and lower case letters
	 *            are treated the same, and underscores (_) are treated the same as
	 *            spaces (consistent with how the Zulip UI handles emoji).
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

	/*
	 * (non-Javadoc)
	 * 
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
	 * @param filePath
	 *            the new file path
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
	 * @param file
	 *            the new file
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * Gets the emoji name.
	 *
	 * @return the emoji name
	 */
	public String getEmojiName() {
		return emojiName;
	}

	/**
	 * Sets the emoji name.
	 *
	 * @param emojiName the new emoji name
	 */
	public void setEmojiName(String emojiName) {
		this.emojiName = emojiName;
	}
	
	

}
