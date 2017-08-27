/**
 * 
 */
package com.iam_vip.day0.rs.quartz.job;

import org.springframework.web.context.support.WebApplicationObjectSupport;

import com.iam_vip.day0.rs.util.DTUtil;

/**
 * /// ///
 * @author Colin
 */
public class SchedulerTaskJob2 extends WebApplicationObjectSupport {

	/**
	 * 
	 */
	public SchedulerTaskJob2() {
	}

	/**
	 * /// 定时调用的方法 ///
	 */
	public void doTask() {

		System.out.println("定时执行 >>> 2 >>> " + DTUtil.nowDT());

	}

}
