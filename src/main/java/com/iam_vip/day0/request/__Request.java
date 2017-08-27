/**
 * 
 */
package com.iam_vip.day0.request;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.iam_vip.day0.rs.c.IAPP;
import com.iam_vip.day0.rs.util.ConstUtil;
import com.iam_vip.day0.rs.util.IDUtil;
import com.iam_vip.day0.rs.util.StringUtil;

/**
 * @author Colin
 */
public class __Request implements IAPP {

	protected static final String REDIRECT = "redirect:";

	@Autowired
	ResourceBundleMessageSource messageSource;

	/**
	 * 
	 */
	public __Request() {
	}





	protected String getServerIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	protected String getMessage(HttpServletRequest request, String key) {
		return messageSource.getMessage(key, null, "---", request.getLocale());
	}
	
	protected String getMessage(HttpServletRequest request, Locale locale, String key) {
		return messageSource.getMessage(key, null, "---", locale);
	}

	protected boolean existsText(HttpServletRequest request, String find) {
		String uri = request.getRequestURI();
		return uri.indexOf(find) > 0;
	}

	protected String suffix(String file) {
		int index = file.lastIndexOf(".");
		if (index < 0) {
			return "";
		}
		return file.substring(index);
	}

	protected String storageImage(String folder, InputStream imageStream, String suffix)
			throws FileNotFoundException, IOException {

		folder = StringUtil.toPath(folder);

		/// E:\resource or /appdata/resource ///
		String folderPath = ConstUtil.getDocBase();
		File folderRes = new File(folderPath, folder);
		if (folderRes.exists() == false) {
			folderRes.mkdirs();
		}


		String fileName = String.format("%s%s", IDUtil.newFileID(), suffix).toLowerCase();
		File fileImage = new File(folderRes, fileName);

		BufferedInputStream input = new BufferedInputStream(imageStream);
		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(fileImage));
		int len = 0;
		byte[] buf = new byte[1024 * 24]; /// 24k ///
		while ((len = input.read(buf)) > 0) {
			output.write(buf, 0, len);
		}
		input.close();
		output.close();

		return folder + "/" + fileName;
	}

}
