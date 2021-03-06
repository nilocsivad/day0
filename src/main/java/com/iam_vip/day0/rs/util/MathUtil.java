/**
 * 
 */
package com.iam_vip.day0.rs.util;

import java.math.BigDecimal;

/**
 * @author Colin
 */
public class MathUtil {

	/**
	 * 
	 */
	public MathUtil() {
	}

	public static double round(double v, int scale) {
		if (scale < 0) {
			scale = 1;
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

}
