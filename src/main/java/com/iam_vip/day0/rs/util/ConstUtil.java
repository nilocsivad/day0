/**
 * 
 */
package com.iam_vip.day0.rs.util;

import java.util.Map;

/**
 * @author Colin
 */
public class ConstUtil {

	private static Map<String, String> MAP_DATA;
	private static Map<String, Integer> NUM_MAP_DATA;

	private ConstUtil(Map<String, String> mapData, Map<String, Integer> numMapData) {
		MAP_DATA = mapData;
		NUM_MAP_DATA = numMapData;
	}








	/**
	 * /// 资源文件夹对外访问前缀,对应 Tomcat &lt;Context path="" /&gt; ///
	 */
	public static String getResourcePrefix() {
		return MAP_DATA.get("ResourcePrefix");
	}

	/**
	 * /// 服务器本地资源文件夹,对应 Tomcat &lt;Context docBase="" /&gt; ///
	 */
	public static String getDocBase() {
		return MAP_DATA.get("DocBase");
	}


	



	public static boolean isOnServer() {
		return NUM_MAP_DATA.get("OnServer") == 1;
	}





}
