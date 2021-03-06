/**
 * 
 */
package com.iam_vip.day0.rs.util;

import java.util.Random;

import org.apache.commons.codec.binary.Base64;

/**
 * @author Colin
 */
public class StringUtil {

	/**
	 * 
	 */
	private StringUtil() {
	}

	public static final String enc64(String text) {
		return Base64.encodeBase64String(text.getBytes());
	}

	public static final String decc64(String eText) {
		return new String(Base64.decodeBase64(eText));
	}

	public static String getCode(int len) {
		return (new Random().nextLong() + "").substring(1, 1 + len);
	}

	/**
	 * /// 返回去除系统无法识别的文件名称特殊字符 ///
	 */
	public static String toPath(String folder) {
		if (EmptyUtil.notEmpty(folder))
			return folder.replace(" ", "_").replace("\\", "_").replace(":", "_").replace("*", "_").replace("?", "_").replace("'", "_").replace("\"", "_").replace("<", "_").replace(">", "_").replace("|", "_").replace("!", "_").replace("@", "_").replace("#", "_").replace("$", "_").replace("%", "_").replace("^", "_").replace("&", "_").replace("(", "_").replace(")", "_").replace("`", "_").replace("~", "_").replace(";", "_").replace(",", "_").replace(".", "_").replace("=", "_").replace("+", "_");
		return folder;
	}

	/**
	 * /// 存储 HTML 标签内容 ///
	 */
	public static String toHtml(String content, String enc) {
		if (EmptyUtil.notEmpty(content))
			return content.replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;");
		return content;
	}

}
