/**
 * 
 */
package com.iam_vip.day0.rs.adapter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iam_vip.day0.rs.c.IAPP;
import com.iam_vip.day0.rs.util.DTUtil;

/**
 * @author Colin
 */
public class PrivilegeHandlerInterceptorAdapter extends HandlerInterceptorAdapter implements IAPP {

	/**
	 * 
	 */
	public PrivilegeHandlerInterceptorAdapter() {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// ** 匹配到需要拦截的 URL
		if (handler instanceof HandlerMethod) {

			HandlerMethod method = (HandlerMethod) handler;
			String className = method.getBean().getClass().getName();
			String methodName = method.getMethod().getName();

			StringBuffer buf = new StringBuffer();
			// buf.append("RequestURI " + request.getRequestURI() + LINE);
			buf.append("RequestURL " + request.getRequestURL() + "\r\n");
			buf.append("Execute " + className + "." + methodName + "\r\n");

			Enumeration<String> names = request.getParameterNames();
			int iCount = 0;
			while (names.hasMoreElements()) {
				iCount++;
				String key = names.nextElement();
				String value = request.getParameter(key);
				value = value.length() > 100 ? value.substring(0, 99) : value;
				buf.append(String.format("%s --> %s \r\n", key, value));
			}
			buf.append("Parameters length is " + iCount + "\r\n");
			String userAgent = request.getHeader("User-Agent");
			buf.append("UserAgent: " + userAgent + "\r\n");
			buf.append("Request at: " + DTUtil.nowDT());
			System.out.println(buf);

			if (methodName.endsWith("_$")) { /// 后缀为 _$ 不用验证 session ///
				return true;
			}

			if (className.startsWith(MOB_PACKAGE)) {
				/// 手机请求直接通过,在代码中判断 ///
				return true;
			}

			if (className.startsWith(REQ_PACKAGE)) {
				return this.controlURL(request, response, ONLINE_REQ, "/req");
			}
			if (className.startsWith(WEB_PACKAGE)) {
				return this.controlURL(request, response, ONLINE_WEB, "/web");
			}

			return false;
		}

		return super.preHandle(request, response, handler);
	}

	/**
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	private boolean controlURL(HttpServletRequest request, HttpServletResponse response, String sessionKey,
			String toDefaultView) throws IOException {

		String contextPath = request.getContextPath() + toDefaultView;
		contextPath = contextPath.replace("//", "/");

		HttpSession httpSession = request.getSession(false);
		// ** 未登录则不通过
		if (httpSession == null) {
			System.out.println("111111111111111111111111111111111111  httpSession == null");
			response.sendRedirect(contextPath);
			return false;
		}

		// ** 判断是否登录
		Object onlineObj = httpSession.getAttribute(sessionKey);
		if (onlineObj == null) {
			System.out.println("222222222222222222222222222222222222 onlineObj == null");
			response.sendRedirect(contextPath);
			return false;
		}

		// ** 最后一次访问时间大于 30 分钟
		long lastAccessed = httpSession.getLastAccessedTime();
		if (System.currentTimeMillis() - lastAccessed > 30 * 60 * 1000) {
			System.out.println("333333333333333333333333333333333333 lastAccessed > 30 * 60 * 1000");
			response.sendRedirect(contextPath);
			return false;
		}

		return true;
	}

}
