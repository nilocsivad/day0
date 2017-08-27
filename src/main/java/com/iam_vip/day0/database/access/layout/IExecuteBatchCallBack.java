/**
 * 
 */
package com.iam_vip.day0.database.access.layout;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapExecutor;

/**
 * @author Colin
 */
public interface IExecuteBatchCallBack {

	void doExecuteBatch(SqlMapExecutor executor) throws SQLException;

}
