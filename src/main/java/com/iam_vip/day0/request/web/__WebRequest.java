/**
 * 
 */
package com.iam_vip.day0.request.web;

import org.springframework.beans.factory.annotation.Autowired;

import com.iam_vip.day0.logic.iapi.IXiaoFeiService;
import com.iam_vip.day0.logic.iapi.IYongHuService;
import com.iam_vip.day0.request.__Request;

/**
 * @author Colin
 */
public class __WebRequest extends __Request {

	@Autowired
	protected IXiaoFeiService xiaoFeiService;
	@Autowired
	protected IYongHuService yongHuService;

	/**
	 * 
	 */
	public __WebRequest() {
	}

}
