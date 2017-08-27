/**
 * 
 */
package com.iam_vip.day0.request.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iam_vip.day0.logic.model.YongHuModel;
import com.iam_vip.day0.rs.util.GsonUtil;

/**
 * @author Colin
 */
@Controller
@RequestMapping(value = { "web/test" })
public final class TestWebRequest extends __WebRequest {

	/**
	 * 
	 */
	public TestWebRequest() {
	}

	@RequestMapping(value = { "response.json" })
	public void responseJson_$(String text, HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<YongHuModel> list = yongHuService.getList(YongHuModel.ALL, null);

		String json = GsonUtil.toJson(list);

		response.setContentType("application/json");
		response.getWriter().write(json);
		response.flushBuffer();

	}

}
