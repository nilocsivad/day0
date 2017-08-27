package com.iam_vip.day0.database.access.layout;

import java.util.List;
import java.util.Map;

import com.iam_vip.day0.rs.ref.DataGridModel;

public interface IDAO<T> {

	void executeBatch(IExecuteBatchCallBack callback);

	public Object save(String sqlMapID, Object model);
	
	public Object saveMulti(String sqlMapID, Object obj);

	public Integer saveReturnInt(String sqlMapID, T model);

	public Long saveReturnLong(String sqlMapID, T model);

	public int update(String sqlMapID, Object obj);

	public int delete(String sqlMapID, Object obj);

	public T getOne(String sqlMapID);

	public T getOne(String sqlMapID, Object obj);

	public List<T> getList(String sqlMapID);

	public List<T> getList(String sqlMapID, Object obj);

	public Integer getCountInt(String sqlMapID, Object param);

	public Long getCountLong(String sqlMapID, Object param);

	public Map<String, Object> getPageList(String columns, String sqlMapSelectID, String sqlMapCountID, DataGridModel dgm, T model, Map<String, Object> extra);

}
