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
public class SchedulerTaskJob extends WebApplicationObjectSupport {

	/**
	 * 
	 */
	public SchedulerTaskJob() {
	}

	/**
	 * /// 定时调用的方法 ///
	 */
	public void doTask() {

		System.out.println("定时执行 >>> " + DTUtil.nowDT());

	}

}
