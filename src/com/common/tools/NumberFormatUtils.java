package com.common.tools;

import java.math.BigDecimal;
import java.text.NumberFormat;

import org.apache.commons.math.util.MathUtils;

public class NumberFormatUtils {

	/**
	 * 將 number 四舍五入 保留 maxScale 位小數.
	 */
	public static final double roundNumber(double number, int maxScale)
			throws IllegalArgumentException {
		if (maxScale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero!");
		}
		return MathUtils.round(number, maxScale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 將 number 四舍五入 保留 maxScale 位小數, 並格式化. 如： number=1111.0;maxScale=5;
	 * result:1,111.00000;
	 */
	public static final String formatNumber(double number, int maxScale)
			throws IllegalArgumentException {
		if (maxScale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero!");
		}
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(maxScale);
		numberFormat.setMinimumFractionDigits(maxScale);
		numberFormat.setGroupingUsed(true);
		String numberString = numberFormat.format(number);
		return numberString;
	}

	/**
	 * 將 number 四舍五入 保留 maxScale 位小數. 如﹕number=1.0;maxScale=5; result:1.00000;
	 */
	public static final String roundNumberFormat(double number, int maxScale)
			throws IllegalArgumentException {
		if (maxScale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero!");
		}
		BigDecimal bd = new BigDecimal(number);
		return bd.setScale(maxScale, BigDecimal.ROUND_HALF_UP).toString();
	}

	/**
	 * 將 number 無條件舍去 保留 maxScale 位小數.
	 */
	public static final double decimalFormat(double number, int maxScale)
			throws IllegalArgumentException {
		if (maxScale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero!");
		}
		return MathUtils.round(number, maxScale, BigDecimal.ROUND_DOWN);
	}

	/**
	 * Rounding mode to round towards positive infinity. If the BigDecimal is
	 * positive, behaves as for ROUND_UP; if negative, behaves as for ROUND_DOWN.
	 * 如﹕number=0.12;maxScale=5; result:1.00000; number=-1.12;maxScale=5;
	 * result:-1.00000;
	 */
	public static final String roundCeilingNumberFormat(double number,
			int maxScale) throws IllegalArgumentException {
		if (maxScale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero!");
		}
		BigDecimal bd = new BigDecimal(number);
		return bd.setScale(maxScale, BigDecimal.ROUND_CEILING).toString();
	}
}
