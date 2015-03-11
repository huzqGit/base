package com.common.tools;

import java.util.Random;

public class ColorUtils {
	public static String getRandColorCode() {
		String r, g, b;
		Random random = new Random();
		r = Integer.toHexString(random.nextInt(256)).toUpperCase();
		b = Integer.toHexString(random.nextInt(256)).toUpperCase();
		String d = "";
		r = r.length() == 1 ? "0" + r : r; 
		b = b.length() == 1 ? "0" + b : b;

		return r + b;
	}
}
