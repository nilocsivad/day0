/**
 * 
 */
package com.iam_vip.day0.logic.model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 消费记录 <br />
 * Database table: day0_xiao_fei <br />
 * @author Colin
 */
public class XiaoFeiModel extends __Model {

	/// String lineID; // 记录ID 与 dateID 组成唯一记录ID CHAR (18) nullable: false
	/// String dateID; // 时间 yyyyMMddHHmmss 与 lineID 组成唯一记录ID CHAR (14) nullable: false
	/// Integer uid; // 关联的用户 INT (11) nullable: false
	/// Integer howMuch; // 消费/收入 金额 (单位:分) INT (11) nullable: false

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * All fields, like colPK,colA,colB,colC...
	 */
	public static final String ALL = "lineID, dateID, uid, howMuch";
	
	/**
	 * Fields without PK, like colA,colB,colC...
	 */
	public static final String NOPK = "lineID, uid, howMuch";


	/**
	 * 记录ID 与 dateID 组成唯一记录ID <br />
	 * CHAR (18) <br />
	 * String <br />
	 * nullable: false
	 */
	public static final String KEY_LINEID = "lineID";
	/**
	 * length of 记录ID 与 dateID 组成唯一记录ID
	 */
	public static final int LEN_LINEID = 18;
	
	/**
	 * 时间 yyyyMMddHHmmss 与 lineID 组成唯一记录ID <br />
	 * CHAR (14) <br />
	 * String <br />
	 * nullable: false
	 */
	public static final String KEY_DATEID = "dateID";
	/**
	 * length of 时间 yyyyMMddHHmmss 与 lineID 组成唯一记录ID
	 */
	public static final int LEN_DATEID = 14;
	
	/**
	 * 关联的用户 <br />
	 * INT (11) <br />
	 * Integer <br />
	 * nullable: false
	 */
	public static final String KEY_UID = "uid";
	
	/**
	 * 消费/收入 金额 (单位:分) <br />
	 * INT (11) <br />
	 * Integer <br />
	 * nullable: false
	 */
	public static final String KEY_HOWMUCH = "howMuch";
	


	/**
	 * 
	 */
	public XiaoFeiModel() {
	}

	/**
	 * 记录ID 与 dateID 组成唯一记录ID <br />
	 * CHAR (18) <br />
	 * String <br />
	 * nullable: false
	 */
	private String lineID; 
	/**
	 * 时间 yyyyMMddHHmmss 与 lineID 组成唯一记录ID <br />
	 * CHAR (14) <br />
	 * String <br />
	 * nullable: false
	 */
	private String dateID; 
	/**
	 * 关联的用户 <br />
	 * INT (11) <br />
	 * Integer <br />
	 * nullable: false
	 */
	private Integer uid; 
	/**
	 * 消费/收入 金额 (单位:分) <br />
	 * INT (11) <br />
	 * Integer <br />
	 * nullable: false
	 */
	private Integer howMuch; 
	
	

	private static String getMethodName(String name) {
		return (name.charAt(0) + "").toUpperCase() + name.substring(1);
	}

	public static XiaoFeiModel Make(String cols, Object... vals)
			throws NoSuchFieldException, SecurityException,
			NoSuchMethodException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		return Make(cols.split(","), vals);
	}
	
	public static XiaoFeiModel Make(String[] fields, Object... vals)
			throws NoSuchFieldException, SecurityException,
			NoSuchMethodException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		XiaoFeiModel instance = new XiaoFeiModel();

		Class<?> cls = instance.getClass();

		for (int i = 0, l = fields.length; l > i; ++i) {
			String field = fields[i].trim();
			Field fd = cls.getDeclaredField(field);
			if (fd != null) {
				Method method = cls.getDeclaredMethod(
						"set" + getMethodName(field), fd.getType());
				if (method != null) {
					method.invoke(instance, vals[i]);
				}
				// fd.setAccessible(true);
				// fd.set(instance, vals[i]);
				// fd.setAccessible(false);
			}
		}
		
		return instance;
	}
	
	
	
	/**
	 * 记录ID 与 dateID 组成唯一记录ID <br />
	 * CHAR (18) <br />
	 * String <br />
	 * nullable: false <br />
	 * @return the lineID
	 */
	public String getLineID() {
		return lineID;
	}
	
	/**
	 * 记录ID 与 dateID 组成唯一记录ID <br />
	 * CHAR (18) <br />
	 * String <br />
	 * nullable: false <br />
	 * @param lineID the lineID to set
	 */
	public void setLineID(String lineID) {
		if (lineID != null && !"".equals(lineID) && lineID.length() > LEN_LINEID) {
			lineID = lineID.substring(0, LEN_LINEID);
		}
		this.lineID = lineID;
	}
	
	/**
	 * 时间 yyyyMMddHHmmss 与 lineID 组成唯一记录ID <br />
	 * CHAR (14) <br />
	 * String <br />
	 * nullable: false <br />
	 * @return the dateID
	 */
	public String getDateID() {
		return dateID;
	}
	
	/**
	 * 时间 yyyyMMddHHmmss 与 lineID 组成唯一记录ID <br />
	 * CHAR (14) <br />
	 * String <br />
	 * nullable: false <br />
	 * @param dateID the dateID to set
	 */
	public void setDateID(String dateID) {
		if (dateID != null && !"".equals(dateID) && dateID.length() > LEN_DATEID) {
			dateID = dateID.substring(0, LEN_DATEID);
		}
		this.dateID = dateID;
	}
	
	/**
	 * 关联的用户 <br />
	 * INT (11) <br />
	 * Integer <br />
	 * nullable: false <br />
	 * @return the uid
	 */
	public Integer getUid() {
		return uid;
	}
	
	/**
	 * 关联的用户 <br />
	 * INT (11) <br />
	 * Integer <br />
	 * nullable: false <br />
	 * @param uid the uid to set
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	/**
	 * 消费/收入 金额 (单位:分) <br />
	 * INT (11) <br />
	 * Integer <br />
	 * nullable: false <br />
	 * @return the howMuch
	 */
	public Integer getHowMuch() {
		return howMuch;
	}
	
	/**
	 * 消费/收入 金额 (单位:分) <br />
	 * INT (11) <br />
	 * Integer <br />
	 * nullable: false <br />
	 * @param howMuch the howMuch to set
	 */
	public void setHowMuch(Integer howMuch) {
		this.howMuch = howMuch;
	}
	
	
}
