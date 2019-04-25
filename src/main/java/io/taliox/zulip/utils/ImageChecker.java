package io.taliox.zulip.utils;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The Class ImageChecker is responsible for validating whether the file to uploaded is an image.
 * This is useful when performing the upload of an emoji. 
 */
public abstract class ImageChecker {

	/**
	 * Check if file is an image.
	 *
	 * @param path The path of the image to be uploaded.
	 * @return true, if file is an image.
	 * @return false, if file is not an image.
	 */
	public static boolean checkIfFileIsAnImage(String path) {
		boolean b = false;
		try {
			File file = new File(path);
			b = (ImageIO.read(file) != null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return b;
	}

	/**
	 * Check if file is an image.
	 *
	 * @param file The File to be uploaded.
	 * @return true, if file is an image.
	 * @return false, if file is not an image.
	 */
	public static boolean checkIfFileIsAnImage(File file) {
		boolean b = false;
		try {
			b = (ImageIO.read(file) != null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return b;
	}

}
