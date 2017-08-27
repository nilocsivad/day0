/**
 * 
 */
package com.iam_vip.day0.logic.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iam_vip.day0.database.access.layout.IDAO;
import com.iam_vip.day0.logic.iapi.IYongHuService;
import com.iam_vip.day0.logic.model.YongHuModel;

/**
 * 手机用户表 <br />
 * Database table: day0_yong_hu <br />
 * @author Colin
 */
@Service
public class YongHuServiceImplement extends __APIDefaultImpl<YongHuModel> implements IYongHuService {

	@Autowired
	private IDAO<YongHuModel> __YongHuDAO;

	/**
	 * 
	 */
	public YongHuServiceImplement() {
	}

	@Override
	protected IDAO<YongHuModel> getDAO() {
		return __YongHuDAO;
	}

	@Override
	protected String getPrefixOfSqlMapID() {
		return PREFIX_OF_SQL_MAP_ID;
	}

}
