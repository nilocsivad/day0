/**
 * 
 */
package com.iam_vip.day0.rs.util;

/**
 * /// 32位字符串唯一 ID ///
 * @author Colin <br/>
 * {@link IDUtil#serverSerializableNo} <br/>
 * {@link IDUtil#newUniqueID()} <br/>
 * {@link IDUtil#newChargeID()}
 */
public class IDUtil {

	/**
	 * /// 唯一 ID 尾部的三位标识, 对应服务器编号, 使用 36 进制编码 /// <br/>
	 * 000 001 002 ... 00F 00G 00H ... 00X 00Y 00Z 010 011 012 ... <br/>
	 * Long.parseLong("010", 36) = 36 (36进制中的010等于36) <br/>
	 * 最大编号为 36*36*36=46656 (最大支持46656台服务器生成唯一编号)
	 */
	private static String serverSerializableNo = "---";

	/**
	 * @param serverSerializableNo {@link IDUtil#serverSerializableNo}
	 */
	public IDUtil(String serverSerializableNo) {
		IDUtil.serverSerializableNo = serverSerializableNo;
	}








	/**
	 * /// 生成新唯一ID /// <br/>
	 * /// 生成唯一32位字符串编号 /// <br/>
	 * 格式: 70{14位时间戳}{三位服务器唯一标识}{13位随机数字} <br/>
	 * {服务器唯一标识} {@link IDUtil#serverSerializableNo}
	 */
	public static final synchronized String newID() {
		return newItemID("ID");
	}

	/**
	 * /// 生成新文件编号 /// <br/>
	 * /// 生成唯一32位文件字符串编号 /// <br/>
	 * 格式: 50{14位时间戳}{三位服务器唯一标识}{13位随机数字} <br/>
	 * {服务器唯一标识} {@link IDUtil#serverSerializableNo}
	 */
	public static final synchronized String newFileID() {
		return newItemID("50");
	}








	private static final synchronized String newItemID(String prefix) {
		return newItemID(prefix, 13);
	}
	
	private static final synchronized String newItemID(String prefix, int rlen) {
		String TIME = DTUtil.formatDT("yyyyMMddHHmmss");
		return String.format("%s%s%s%s", prefix, TIME, serverSerializableNo, getRandomString(rlen));
	}







	private static final String[] CODES = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	private static final int MAX = CODES.length;

	private static String getRandomString(int len) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < len; ++i)
			buf.append(CODES[(int) (Math.random() * MAX)]);
		return buf.toString();
	}





}
