/**
 * 
 */
package com.iam_vip.day0.rs.util;

import java.util.HashMap;
import java.util.Map;

import cn.jiguang.commom.ClientConfig;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import cn.jpush.api.push.model.notification.PlatformNotification;

/**
 * @author Colin
 */
public class JPushUtil {

	public static final String CMD = "command";

	private static JPushClient JPUSH;

	private static String APPKEY, MASTERSECRET;
	private static boolean APNS_PRODUCTION = true;

	/**
	 * 
	 */
	private JPushUtil(String appKey, String masterSecret, Boolean apns_production) {

		if (appKey == null || masterSecret == null) {
			throw new RuntimeException("推送初使化失败, APP Key 与 密钥 有空值!");
		}

		APPKEY = appKey;
		MASTERSECRET = masterSecret;
		APNS_PRODUCTION = apns_production;

	}

	private static JPushClient get() {
		if (JPUSH == null) {
			ClientConfig config = ClientConfig.getInstance();
			config.setApnsProduction(APNS_PRODUCTION);
			JPUSH = new JPushClient(MASTERSECRET, APPKEY, null, config);
		}
		return JPUSH;
	}









	/**
	 * /// 推送 ///
	 * @param command 指令 PUSH_***
	 * @param message 显示在手机通知栏中的内容
	 * @param registrationid 设备ID
	 * @param phoneType Android/iPhone
	 * @param data 附加数据
	 * @return true:推送成功
	 */
	public boolean PushOne(String command, String message, String registrationid, String phoneType,
			Map<String, Object> data) {
		return this.PushOne(command, message, registrationid, phoneType, data, false);
	}


	/**
	 * /// 推送 ///
	 * @param command 指令 PUSH_N_xxx/PUSH_S_xxx
	 * @param message 显示在手机通知栏中的内容
	 * @param registrationid 设备ID
	 * @param phoneType Android/iPhone
	 * @param data 附加数据
	 * @param silence true:静默推送
	 * @return true:推送成功
	 */
	public boolean PushOne(String command, String message, String registrationid, String phoneType,
			Map<String, Object> data, boolean silence) {

		if (command == null || EmptyUtil.notEmpty(registrationid) == false || registrationid.equals("---")
				|| EmptyUtil.notEmpty(phoneType) == false) {
			return false;
		}


		if (data == null) {
			data = new HashMap<String, Object>(2);
		}

		if (command.trim().equals("")) {
			command = "PUSH_N_TEST";
		}

		if (data.containsKey(CMD) == false) {
			data.put(CMD, command);
		}



		/// Builder for PushPayload ///
		PushPayload.Builder pBuilder = PushPayload.newBuilder().setAudience(Audience.registrationId(registrationid));



		if (silence == true) { /// 静默消息 ///

			Message.Builder builder = Message.newBuilder();

			for (Map.Entry<String, Object> $0 : data.entrySet()) {

				Object value = $0.getValue();
				if (value == null)
					continue;

				if (value instanceof String) {
					builder.addExtra($0.getKey(), (String) value);
					continue;
				}

				if (value instanceof Number) {
					builder.addExtra($0.getKey(), (Number) value);
					continue;
				}

				if (value instanceof Boolean) {
					builder.addExtra($0.getKey(), (Boolean) value);
					continue;
				}
			}

			switch (phoneType) {
			case "Android":
			case "android":
			case "And":
			case "and":
				pBuilder.setPlatform(Platform.android());
				break;
			default:
			case "iPhone":
			case "iPhone OS":
			case "iPhoneOS":
			case "iOS":
				pBuilder.setPlatform(Platform.ios());
				break;
			}

			pBuilder.setMessage(builder.setMsgContent(message).build());

			/// end 静默消息 ///

		} else {

			PlatformNotification pn = null;
			switch (phoneType) {
			case "Android":
			case "android":
			case "And":
			case "and": {

				pBuilder.setPlatform(Platform.android());

				AndroidNotification.Builder builder = AndroidNotification.newBuilder();

				for (Map.Entry<String, Object> $0 : data.entrySet()) {

					Object value = $0.getValue();
					if (value == null)
						continue;

					if (value instanceof String) {
						builder.addExtra($0.getKey(), (String) value);
						continue;
					}

					if (value instanceof Number) {
						builder.addExtra($0.getKey(), (Number) value);
						continue;
					}

					if (value instanceof Boolean) {
						builder.addExtra($0.getKey(), (Boolean) value);
						continue;
					}
				}

				pn = builder.build();
				break;
			} /// end case "Android" ///

			default:
			case "iPhone":
			case "iPhone OS":
			case "iPhoneOS":
			case "iOS": {

				pBuilder.setPlatform(Platform.ios());

				IosNotification.Builder builder = IosNotification.newBuilder();

				for (Map.Entry<String, Object> $0 : data.entrySet()) {

					Object value = $0.getValue();
					if (value == null)
						continue;

					if (value instanceof String) {
						builder.addExtra($0.getKey(), (String) value);
						continue;
					}

					if (value instanceof Number) {
						builder.addExtra($0.getKey(), (Number) value);
						continue;
					}

					if (value instanceof Boolean) {
						builder.addExtra($0.getKey(), (Boolean) value);
						continue;
					}
				}

				pn = builder.incrBadge(1).setSound("default").build();
				break;
			} /// end case "iPhone" ///

			} /// end switch(phoneType) ///


			if (pn == null) {
				return false;
			}

			Notification notification = Notification.newBuilder().addPlatformNotification(pn).setAlert(message).build();
			pBuilder.setNotification(notification);
		}


		PushPayload payload = pBuilder.build();
		System.out.println(payload);


		try {

			PushResult result = get().sendPush(payload);
			System.out.println(result);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}



}
