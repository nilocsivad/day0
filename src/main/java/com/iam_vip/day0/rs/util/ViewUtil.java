/**
 * 
 */
package com.iam_vip.day0.rs.util;

import java.util.List;
import java.util.Map;

/**
 * @author Colin
 */
public class ViewUtil {

	private static Map<String, String> FAIL_MAP;
	private static Map<String, List<String>> UNLIMIT_MAP;

	private ViewUtil(Map<String, String> failMap, Map<String, List<String>> unlimitMap) {
		FAIL_MAP = failMap;
		UNLIMIT_MAP = unlimitMap;
	}




	public static final String getRedirectView() {
		return getRedirectView(0);
	}

	public static final String getRedirectView(int key) {
		return FAIL_MAP.get("ReqFail" + key);
	}




	public static final String getWebRedirectView() {
		return getWebRedirectView(0);
	}

	public static final String getWebRedirectView(int key) {
		return FAIL_MAP.get("WebFail" + key);
	}




	public static final List<String> getUnlimitViews(String key) {
		return UNLIMIT_MAP.get(key);
	}




}
