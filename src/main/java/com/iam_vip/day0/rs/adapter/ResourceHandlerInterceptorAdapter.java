/**
 * 
 */
package com.iam_vip.day0.rs.adapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import com.iam_vip.day0.rs.c.IAPP;

/**
 * @author Colin
 */
public class ResourceHandlerInterceptorAdapter extends HandlerInterceptorAdapter implements IAPP {

	/**
	 * 
	 */
	public ResourceHandlerInterceptorAdapter() {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		// System.out.println( "RequestURI " + request.getRequestURI() );
		// System.out.println( "RequestURL " + request.getRequestURL() );

		// ** 静态资源则直接跳过
		if (handler instanceof ResourceHttpRequestHandler) {
			return true;
		}

		return super.preHandle(request, response, handler);
	}


}
