package com.kevin.mapper.common;

import java.lang.reflect.Field;

import org.apache.ibatis.jdbc.SQL;

/**
 * 公用crud
 * 
 * @author Kevin Zhang @Date 2018年3月15日 下午4:43:52
 */

public class CommonProvider {
	
	public static <T> String testCity(T t) throws IllegalAccessException {
		
		return new SQL() {
			{
				Class<?> entityClass = t.getClass();
				String className = entityClass.getName();
				Field[] fields =entityClass.getDeclaredFields();
				Field field = fields[0];
				field.setAccessible(true);
				Object o = field.get(t);
				SELECT("*");
				FROM(className.substring(className.lastIndexOf(".")));
				WHERE("id = " + o);
			}
		}.toString();
	}
}
