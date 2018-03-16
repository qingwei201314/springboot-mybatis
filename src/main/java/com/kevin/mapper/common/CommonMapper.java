package com.kevin.mapper.common;

import org.apache.ibatis.annotations.SelectProvider;

public interface CommonMapper<T> {
	public void save(T t);
	
	public T update(T t);
	
	public void delete(Integer id);
	
	@SelectProvider(type = CommonProvider.class, method = "find")
	T find(T t);
}
