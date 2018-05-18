package com.kevin.mapper.common;

public interface CommonMapper<T> {
	public void save(T t);
	
	public T update(T t);
	
	public void delete(Integer id);
	

}
