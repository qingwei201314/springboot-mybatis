package com.kevin.annotation;

/**
 * 数据库中表的字段名称
 * @author Kevin Zhang @Date 2018年3月16日 下午2:51:18
 */
public @interface Column {
	//列名
	public abstract String name();
}
