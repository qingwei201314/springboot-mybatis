package com.kevin.mapper.common;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;

/**
 * CRUD公用类
 * @author Kevin Zhang @Date 2018年3月20日 下午4:55:23
 */
public interface CommonMapper<T> {
	@SelectProvider(type = CommonProvider.class, method = "save")
	public void save(T t);
	
	@SelectProvider(type = CommonProvider.class, method = "delete")
	public void delete(Integer id, Class<T> t);
	
	/**
	 * 注意，更新之前, 输入参数t一定要从数据库中读出，不然很容易将其他字段置为空
	 */
	@SelectProvider(type = CommonProvider.class, method = "update")
	public void update(Integer id, Map<String,Object> map, Class<T> t);
	
	@SelectProvider(type = CommonProvider.class, method = "find")
	T findOne(T t);
	
	@SelectProvider(type = CommonProvider.class, method = "find")
	List<T> find(T t);
}
