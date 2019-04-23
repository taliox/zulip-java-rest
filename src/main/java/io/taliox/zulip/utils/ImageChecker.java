package io.taliox.zulip.utils;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class ImageChecker {

	public static boolean checkIfFileIsAnImage(String string) {
		boolean b = false;
		try {
			File file = new File(string);
			b = (ImageIO.read(file) != null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return b;
	}

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
