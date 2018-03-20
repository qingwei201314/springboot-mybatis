package com.kevin.mapper.common;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

/**
 * CRUD公用类
 * @author Kevin Zhang @Date 2018年3月20日 下午4:55:23
 */
public interface CommonMapper<T> {
	@SelectProvider(type = CommonProvider.class, method = "save")
	public boolean save(T t);
	
	public void delete(Integer id);
	
	public T update(T t);
	
	@SelectProvider(type = CommonProvider.class, method = "find")
	T findOne(T t);
	
	@SelectProvider(type = CommonProvider.class, method = "find")
	List<T> find(T t);
}
