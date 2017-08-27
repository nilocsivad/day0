/**
 * 
 */
package com.iam_vip.day0.logic.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iam_vip.day0.database.access.layout.IDAO;
import com.iam_vip.day0.logic.iapi.IXiaoFeiService;
import com.iam_vip.day0.logic.model.XiaoFeiModel;

/**
 * 消费记录 <br />
 * Database table: day0_xiao_fei <br />
 * @author Colin
 */
@Service
public class XiaoFeiServiceImplement extends __APIDefaultImpl<XiaoFeiModel> implements IXiaoFeiService {

	@Autowired
	private IDAO<XiaoFeiModel> __XiaoFeiDAO;

	/**
	 * 
	 */
	public XiaoFeiServiceImplement() {
	}

	@Override
	protected IDAO<XiaoFeiModel> getDAO() {
		return __XiaoFeiDAO;
	}

	@Override
	protected String getPrefixOfSqlMapID() {
		return PREFIX_OF_SQL_MAP_ID;
	}

}
