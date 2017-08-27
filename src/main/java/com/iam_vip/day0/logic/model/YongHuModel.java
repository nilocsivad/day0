/**
 * 
 */
package com.iam_vip.day0.logic.model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 手机用户表 <br />
 * Database table: day0_yong_hu <br />
 * @author Colin
 */
public class YongHuModel extends __Model {

	/// Integer uid; // 用户唯一ID INT (11) nullable: false
	/// String createAt; // 创建时间 yyyyMMddHHmmss CHAR (14) nullable: false
	/// String nickName; // 昵称 VARCHAR (32) nullable: true
	/// Integer balance; // 余额 (单位:分) INT (11) nullable: false
	/// String mphone; // 关联的手机号 VARCHAR (11) nullable: true
	/// String wechat; // 关联的微信号 VARCHAR (32) nullable: true
	/// String email; // 关联的邮箱 VARCHAR (48) nullable: true
	/// Boolean gender; // 性别 3:男 8:女 TINYINT (1) nullable: false
	/// String birthday; // 生日 yyyyMMdd VARCHAR (8) nullable: true
	/// Boolean statusVal; // 帐号状态 1:正常 2:异常 4:禁用 TINYINT (1) nullable: false

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * All fields, like colPK,colA,colB,colC...
	 */
	public static final String ALL = "uid, createAt, nickName, balance, mphone, wechat, email, gender, birthday, statusVal";
	
	/**
	 * Fields without PK, like colA,colB,colC...
	 */
	public static final String NOPK = "createAt, nickName, balance, mphone, wechat, email, gender, birthday, statusVal";


	/**
	 * 用户唯一ID <br />
	 * INT (11) <br />
	 * Integer <br />
	 * nullable: false
	 */
	public static final String KEY_UID = "uid";
	
	/**
	 * 创建时间 yyyyMMddHHmmss <br />
	 * CHAR (14) <br />
	 * String <br />
	 * nullable: false
	 */
	public static final String KEY_CREATEAT = "createAt";
	/**
	 * length of 创建时间 yyyyMMddHHmmss
	 */
	public static final int LEN_CREATEAT = 14;
	
	/**
	 * 昵称 <br />
	 * VARCHAR (32) <br />
	 * String <br />
	 * nullable: true
	 */
	public static final String KEY_NICKNAME = "nickName";
	/**
	 * length of 昵称
	 */
	public static final int LEN_NICKNAME = 32;
	
	/**
	 * 余额 (单位:分) <br />
	 * INT (11) <br />
	 * Integer <br />
	 * nullable: false
	 */
	public static final String KEY_BALANCE = "balance";
	
	/**
	 * 关联的手机号 <br />
	 * VARCHAR (11) <br />
	 * String <br />
	 * nullable: true
	 */
	public static final String KEY_MPHONE = "mphone";
	/**
	 * length of 关联的手机号
	 */
	public static final int LEN_MPHONE = 11;
	
	/**
	 * 关联的微信号 <br />
	 * VARCHAR (32) <br />
	 * String <br />
	 * nullable: true
	 */
	public static final String KEY_WECHAT = "wechat";
	/**
	 * length of 关联的微信号
	 */
	public static final int LEN_WECHAT = 32;
	
	/**
	 * 关联的邮箱 <br />
	 * VARCHAR (48) <br />
	 * String <br />
	 * nullable: true
	 */
	public static final String KEY_EMAIL = "email";
	/**
	 * length of 关联的邮箱
	 */
	public static final int LEN_EMAIL = 48;
	
	/**
	 * 性别 3:男 8:女 <br />
	 * TINYINT (1) <br />
	 * Boolean <br />
	 * nullable: false
	 */
	public static final String KEY_GENDER = "gender";
	
	/**
	 * 生日 yyyyMMdd <br />
	 * VARCHAR (8) <br />
	 * String <br />
	 * nullable: true
	 */
	public static final String KEY_BIRTHDAY = "birthday";
	/**
	 * length of 生日 yyyyMMdd
	 */
	public static final int LEN_BIRTHDAY = 8;
	
	/**
	 * 帐号状态 1:正常 2:异常 4:禁用 <br />
	 * TINYINT (1) <br />
	 * Boolean <br />
	 * nullable: false
	 */
	public static final String KEY_STATUSVAL = "statusVal";
	


	/**
	 * 
	 */
	public YongHuModel() {
	}


	/**
	 * 用户唯一ID <br />
	 * INT (11) <br />
	 * Integer <br />
	 * nullable: false
	 */
	private Integer uid; 
	/**
	 * 创建时间 yyyyMMddHHmmss <br />
	 * CHAR (14) <br />
	 * String <br />
	 * nullable: false
	 */
	private String createAt; 
	/**
	 * 昵称 <br />
	 * VARCHAR (32) <br />
	 * String <br />
	 * nullable: true
	 */
	private String nickName; 
	/**
	 * 余额 (单位:分) <br />
	 * INT (11) <br />
	 * Integer <br />
	 * nullable: false
	 */
	private Integer balance; 
	/**
	 * 关联的手机号 <br />
	 * VARCHAR (11) <br />
	 * String <br />
	 * nullable: true
	 */
	private String mphone; 
	/**
	 * 关联的微信号 <br />
	 * VARCHAR (32) <br />
	 * String <br />
	 * nullable: true
	 */
	private String wechat; 
	/**
	 * 关联的邮箱 <br />
	 * VARCHAR (48) <br />
	 * String <br />
	 * nullable: true
	 */
	private String email; 
	/**
	 * 性别 3:男 8:女 <br />
	 * TINYINT (1) <br />
	 * Boolean <br />
	 * nullable: false
	 */
	private Boolean gender; 
	/**
	 * 生日 yyyyMMdd <br />
	 * VARCHAR (8) <br />
	 * String <br />
	 * nullable: true
	 */
	private String birthday; 
	/**
	 * 帐号状态 1:正常 2:异常 4:禁用 <br />
	 * TINYINT (1) <br />
	 * Boolean <br />
	 * nullable: false
	 */
	private Boolean statusVal; 
	
	

	private static String getMethodName(String name) {
		return (name.charAt(0) + "").toUpperCase() + name.substring(1);
	}

	public static YongHuModel Make(String cols, Object... vals)
			throws NoSuchFieldException, SecurityException,
			NoSuchMethodException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		return Make(cols.split(","), vals);
	}
	
	public static YongHuModel Make(String[] fields, Object... vals)
			throws NoSuchFieldException, SecurityException,
			NoSuchMethodException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		YongHuModel instance = new YongHuModel();

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
	 * 用户唯一ID <br />
	 * INT (11) <br />
	 * Integer <br />
	 * nullable: false <br />
	 * @return the uid
	 */
	public Integer getUid() {
		return uid;
	}
	
	/**
	 * 用户唯一ID <br />
	 * INT (11) <br />
	 * Integer <br />
	 * nullable: false <br />
	 * @param uid the uid to set
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	/**
	 * 创建时间 yyyyMMddHHmmss <br />
	 * CHAR (14) <br />
	 * String <br />
	 * nullable: false <br />
	 * @return the createAt
	 */
	public String getCreateAt() {
		return createAt;
	}
	
	/**
	 * 创建时间 yyyyMMddHHmmss <br />
	 * CHAR (14) <br />
	 * String <br />
	 * nullable: false <br />
	 * @param createAt the createAt to set
	 */
	public void setCreateAt(String createAt) {
		if (createAt != null && !"".equals(createAt) && createAt.length() > LEN_CREATEAT) {
			createAt = createAt.substring(0, LEN_CREATEAT);
		}
		this.createAt = createAt;
	}
	
	/**
	 * 昵称 <br />
	 * VARCHAR (32) <br />
	 * String <br />
	 * nullable: true <br />
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}
	
	/**
	 * 昵称 <br />
	 * VARCHAR (32) <br />
	 * String <br />
	 * nullable: true <br />
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		if (nickName != null && !"".equals(nickName) && nickName.length() > LEN_NICKNAME) {
			nickName = nickName.substring(0, LEN_NICKNAME);
		}
		this.nickName = nickName;
	}
	
	/**
	 * 余额 (单位:分) <br />
	 * INT (11) <br />
	 * Integer <br />
	 * nullable: false <br />
	 * @return the balance
	 */
	public Integer getBalance() {
		return balance;
	}
	
	/**
	 * 余额 (单位:分) <br />
	 * INT (11) <br />
	 * Integer <br />
	 * nullable: false <br />
	 * @param balance the balance to set
	 */
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
	/**
	 * 关联的手机号 <br />
	 * VARCHAR (11) <br />
	 * String <br />
	 * nullable: true <br />
	 * @return the mphone
	 */
	public String getMphone() {
		return mphone;
	}
	
	/**
	 * 关联的手机号 <br />
	 * VARCHAR (11) <br />
	 * String <br />
	 * nullable: true <br />
	 * @param mphone the mphone to set
	 */
	public void setMphone(String mphone) {
		if (mphone != null && !"".equals(mphone) && mphone.length() > LEN_MPHONE) {
			mphone = mphone.substring(0, LEN_MPHONE);
		}
		this.mphone = mphone;
	}
	
	/**
	 * 关联的微信号 <br />
	 * VARCHAR (32) <br />
	 * String <br />
	 * nullable: true <br />
	 * @return the wechat
	 */
	public String getWechat() {
		return wechat;
	}
	
	/**
	 * 关联的微信号 <br />
	 * VARCHAR (32) <br />
	 * String <br />
	 * nullable: true <br />
	 * @param wechat the wechat to set
	 */
	public void setWechat(String wechat) {
		if (wechat != null && !"".equals(wechat) && wechat.length() > LEN_WECHAT) {
			wechat = wechat.substring(0, LEN_WECHAT);
		}
		this.wechat = wechat;
	}
	
	/**
	 * 关联的邮箱 <br />
	 * VARCHAR (48) <br />
	 * String <br />
	 * nullable: true <br />
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 关联的邮箱 <br />
	 * VARCHAR (48) <br />
	 * String <br />
	 * nullable: true <br />
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		if (email != null && !"".equals(email) && email.length() > LEN_EMAIL) {
			email = email.substring(0, LEN_EMAIL);
		}
		this.email = email;
	}
	
	/**
	 * 性别 3:男 8:女 <br />
	 * TINYINT (1) <br />
	 * Boolean <br />
	 * nullable: false <br />
	 * @return the gender
	 */
	public Boolean getGender() {
		return gender;
	}
	
	/**
	 * 性别 3:男 8:女 <br />
	 * TINYINT (1) <br />
	 * Boolean <br />
	 * nullable: false <br />
	 * @param gender the gender to set
	 */
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	
	/**
	 * 生日 yyyyMMdd <br />
	 * VARCHAR (8) <br />
	 * String <br />
	 * nullable: true <br />
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	
	/**
	 * 生日 yyyyMMdd <br />
	 * VARCHAR (8) <br />
	 * String <br />
	 * nullable: true <br />
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		if (birthday != null && !"".equals(birthday) && birthday.length() > LEN_BIRTHDAY) {
			birthday = birthday.substring(0, LEN_BIRTHDAY);
		}
		this.birthday = birthday;
	}
	
	/**
	 * 帐号状态 1:正常 2:异常 4:禁用 <br />
	 * TINYINT (1) <br />
	 * Boolean <br />
	 * nullable: false <br />
	 * @return the statusVal
	 */
	public Boolean getStatusVal() {
		return statusVal;
	}
	
	/**
	 * 帐号状态 1:正常 2:异常 4:禁用 <br />
	 * TINYINT (1) <br />
	 * Boolean <br />
	 * nullable: false <br />
	 * @param statusVal the statusVal to set
	 */
	public void setStatusVal(Boolean statusVal) {
		this.statusVal = statusVal;
	}
	
	
}
